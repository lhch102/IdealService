package com.ideal.rest;

import com.ideal.pojo.LoginResult;
import com.ideal.service.LoginService;

import javax.annotation.Resource;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * 用户相关接口
 */
@Singleton
@Path("/user")
public class UserService {

    @Resource
    private LoginService loginService;

    /**
     * 一键登录
     * @param id
     * @param phoneNumber
     * @param userSecurityCode
     * @return
     */
    @GET
    @Path("/login")
    //返回给client为json类型（application/json）
    @Produces(MediaType.APPLICATION_JSON)
    public LoginResult login(@DefaultValue("") @QueryParam("id") Integer id, String phoneNumber, @QueryParam("userSecurityCode") String userSecurityCode) {
        return loginService.login(id, phoneNumber, userSecurityCode);
    }

    /**
     * 发送验证码接口
     *
     * @param phoneNumber
     * @return
     */
    @GET
    @Path("/sendSecurityCode/{phoneNumber}")
    //指定处理请求的提交内容类型
    @Consumes(MediaType.TEXT_XML)
    //指定返回的内容类型，返回给client为json类型（application/json）
    @Produces(MediaType.APPLICATION_JSON)
    public boolean sendSecurityCode(@PathParam("phoneNumber") String phoneNumber) {
        return loginService.sendSecurityCode(phoneNumber);
    }

}
