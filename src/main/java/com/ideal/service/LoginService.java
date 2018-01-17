package com.ideal.service;

import com.ideal.pojo.LoginResult;

import java.util.Map;

/**
 * 用户登录相关逻辑
 * Created by Administrator on 2017/10/6.
 */
public interface LoginService {

    /**
     * 一键登录
     * @param id               用户ID
     * @param phoneNumber      用于接收验证码的手机号
     * @param userSecurityCode 用户输入的验证码
     * @return
     */
    public LoginResult login(Integer id, String phoneNumber, String userSecurityCode);

    /**
     * 发送验证码
     * @param phoneNumber
     * @return
     */
    public Map<String, String> sendSecurityCode(String phoneNumber);

}
