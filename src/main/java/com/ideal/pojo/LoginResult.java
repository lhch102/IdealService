package com.ideal.pojo;

/**
 * 登录返回类型
 */
public class LoginResult {

    //返回状态码
    private int code;
    //用户token
    private String token;
    //	返回消息
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
