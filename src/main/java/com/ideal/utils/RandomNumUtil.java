package com.ideal.utils;

import java.util.Random;

/**
 * 生成随机验证码工具类
 * Created by Administrator on 2017/10/2.
 */
public class RandomNumUtil {

    /**
     * 生成4位随机验证码
     * @param quantity 生成几位数的验证码
     * @return 随机数
     */
    public static String getFourRandom(int quantity) {
        // 定义验证码的字符表
        String str = "0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < quantity; i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        return sb.toString();
    }


}
