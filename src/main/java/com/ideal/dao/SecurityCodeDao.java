package com.ideal.dao;

import com.ideal.pojo.SecurityCode;

public interface SecurityCodeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SecurityCode record);

    /**
     * 保存验证码
     * @param record
     * @return
     */
    int insertSelective(SecurityCode record);

    SecurityCode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SecurityCode record);

    int updateByPrimaryKey(SecurityCode record);

    /**
     * 通过手机号查询手机号验证码
     * @param phoneNum
     */
    public String getSecurityCode(String phoneNum);
}