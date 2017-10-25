package com.ideal.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ideal.dao.SecurityCodeDao;
import com.ideal.dao.UserInfoDao;
import com.ideal.enums.Method;
import com.ideal.pojo.LoginResult;
import com.ideal.pojo.SecurityCode;
import com.ideal.pojo.UserInfo;
import com.ideal.service.LoginService;
import com.ideal.utils.HttpUtils;
import com.ideal.utils.RandomNumUtil;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Administrator on 2017/10/8.
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private SecurityCodeDao sendSecurityCodeDao;


    /**
     * 一键登录
     *
     * @param id               用户ID
     * @param phoneNumber      用于接收验证码的手机号
     * @param userSecurityCode 用户输入的验证码
     * @return
     */
    @Override
    public LoginResult login(Integer id, String phoneNumber, String userSecurityCode) {
        LoginResult result = new LoginResult();
        //1、先判断验证码是否正确
        String securityCode = sendSecurityCodeDao.getSecurityCode(phoneNumber);
        userSecurityCode = userSecurityCode.trim();
        //用户输入验证码必须与发送的验证码相同
        if (userSecurityCode.equals(securityCode)) {
            //2.判断该手机号是否注册
            int isExist = userInfoDao.isExist(phoneNumber);
            UserInfo userInfo = new UserInfo();
            Date currentDate = new Date();
            //未注册
            if (isExist == 0) {
                //3、设置相应的token
                long currentTime = System.currentTimeMillis();
                String newToken = UUID.randomUUID() + "_" + currentTime;
                userInfo.setPhoneNumber(Integer.valueOf(phoneNumber));
                userInfo.setSecurityCode(Integer.valueOf(userSecurityCode));
                userInfo.setToken(newToken);
                userInfo.setLoginTime(currentDate);
                int num = userInfoDao.insertSelective(userInfo);
                if (num == 1) {
                    //注册成功
                    result.setCode(0000);
//                    result.setToken(token);
                    result.setMessage("登录成功");
                    return result;
                }
            }
            //已经注册，直接登录，并且更新登录时间、验证码
            else {
                userInfo.setPhoneNumber(Integer.valueOf(phoneNumber));
                userInfo.setSecurityCode(Integer.valueOf(userSecurityCode));
                userInfo.setLoginTime(currentDate);
                userInfo.setModifyId(id);
                userInfo.setModifyTime(currentDate);
                userInfo.setModifyItem("登录时间更新");
                result.setCode(0000);
                result.setMessage("登录成功");
            }
        } else {
            //验证码不正确
            result.setCode(5555);
            result.setMessage("验证码不正确");
            return result;
        }
        return result;
    }

    private Logger logger = Logger.getLogger(getClass());

    private final static int QUANTITY = 4; //生成4位数的验证码
    private final static String ERRORKEY = "errorMessage";  //返回错误的key
    private final static String HOST = "http://sms.market.alicloudapi.com"; //API域名从控制台获取
    private final static String APP_CODE = "cf9a88e60f224407b2674e48dbcb5ae2"; //AppCode从控制台获取
    //    private final static String APP_KEY = "24644156"; //AppKey从控制台获取
//    private final static String APP_SECRET = "40ab4442dd9fe98493d2c14d325f8c10";//AppSecret从控制台获取
    private final static String SIGN_NAME = "签名名称"; // 签名名称从控制台获取，必须是审核通过的
    private final static String TEMPLATE_CODE = "模板CODE"; //模板CODE从控制台获取，必须是审核通过的
    //自定义参与签名Header前缀（可选,默认只有"X-Ca-"开头的参与到Header签名）
    private final static List<String> CUSTOM_HEADERS_TO_SIGN_PREFIX = new ArrayList<String>();


    /**
     * 发送验证码
     *
     * @param phoneNumber
     * @return
     */
    @Override
    public Map<String, String> sendSecurityCode(String phoneNumber) {
        // 产生随机的认证码
        String securityCode = RandomNumUtil.getFourRandom(QUANTITY);
        Map<String, String> bodymap = sendMsg(phoneNumber, securityCode);
//        0：成功；1：失败
        char isSuccess;
        if ("false".equals(bodymap.get("success"))) {
            //当传入的参数不合法时，返回有错误说明
            logger.info(bodymap.get("message"));
            isSuccess = 1;
        } else {
            //成功返回map，对应的key分别为：message、success等
            logger.info(JSON.toJSONString(bodymap));
            isSuccess = 0;
            Calendar.getInstance().add(Calendar.MINUTE, 0);
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    // task to run goes here
                    System.out.println("Hello !!");
                }
            };
        }
        SecurityCode sc = new SecurityCode();
        sc.setPhoneNum(phoneNumber);
        sc.setSecurityCode(securityCode);
        sc.setIsSuccess(isSuccess);
        sc.setReturnMessage(JSON.toJSONString(bodymap));
        //保存验证码
        sendSecurityCodeDao.insertSelective(sc);
        return bodymap;
    }

    /**
     * @param phoneNumber  目标手机号，多个手机号可以逗号分隔;
     * @param securityCode 短信模板中的变量，数字必须转换为字符串，如短信模板中变量为${no}",则参数params的值为{"no":"123456"}
     * @return
     */
    public Map<String, String> sendMsg(String phoneNumber, String securityCode) {

        String path = "/singleSendSms";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + APP_CODE);
        Map<String, String> querys = new HashMap<String, String>();
        //发送的验证码
        querys.put("ParamString", "{'no':" + securityCode + "}");
        //目标手机号
        querys.put("RecNum", phoneNumber);
        //签名名称
        querys.put("SignName", SIGN_NAME);
        // 模板CODE
        querys.put("TemplateCode", TEMPLATE_CODE);
        Map<String, String> bodymap = new HashMap<String, String>();
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doGet(HOST, path, Method.GET.toString(), headers, querys);
            logger.info("response------->" + response.toString());
            String responseEntity = EntityUtils.toString(response.getEntity());
            logger.info("response.getEntity()------->" + responseEntity);
            bodymap = ReadResponseBodyContent(responseEntity);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return bodymap;
    }

    private Map<String, String> ReadResponseBodyContent(String body) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            JSONObject jsonObject = JSON.parseObject(body);
            if (null != jsonObject) {
                for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
                    map.put(entry.getKey(), entry.getValue().toString());
                }

            }
        } catch (Exception e) {
            map.put(ERRORKEY, body);
        }
        return map;
    }
}
