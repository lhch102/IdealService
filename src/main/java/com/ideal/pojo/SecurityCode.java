package com.ideal.pojo;

import java.util.Date;

/**
 * 手机号验证码表实体
 * @author
 */
public class SecurityCode {

    private Integer id;

    private String phoneNum;

    private String securityCode;

    private String returnMessage;

    private String businessType;

    /**
     * 是否成功;0：成功；1：失败
     */
    private char isSuccess;

    /**
     * 验证码是否有效；0：无效；1：有效
     */
    private char isEffective;

    private Integer createId;

    private Date createTime;

    private Integer modifyId;

    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode == null ? null : securityCode.trim();
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage == null ? null : returnMessage.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public char getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(char isSuccess) {
        this.isSuccess = isSuccess;
    }

    public char getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(char isEffective) {
        this.isEffective = isEffective;
    }
}