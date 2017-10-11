package com.ideal.dao;

import com.ideal.pojo.UserInfo;

public interface UserInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    /**
     * 保存用户信息
     * @param record
     * @return
     */
    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    /**
     * 查询用户是否存在
     * @param phoneNumber
     * @return
     */
    public int isExist(String phoneNumber);

}