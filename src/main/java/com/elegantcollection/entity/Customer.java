package com.elegantcollection.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * customer
 * @author 
 */
public class Customer implements Serializable {
    /**
     * 用户ID
     */
    private Integer custId;

    /**
     * 用户手机号(账号)
     */
    private String custPhone;

    /**
     * 用户QQ
     */
    private String custQq;

    /**
     * 用户微信
     */
    private String custWechat;

    /**
     * 用户密码
     */
    private String custPassword;

    /**
     * 用户昵称
     */
    private String custName;

    /**
     * 用户性别
     */
    private Integer custGender;

    /**
     * 用户头像
     */
    private String custProfile;

    /**
     * 用户积分
     */
    private Integer custPoints;

    /**
     * 用户邮箱
     */
    private String custMail;

    /**
     * 注册时间
     */
    private Date registerTime;

    /**
     * 账户状态
     */
    private Integer custStatus;

    /**
     * 社区状态
     */
    private Integer cummStatus;

    /**
     * 登录状态
     */
    private Integer loginStatus;

    /**
     * 冗余1
     */
    private String more1;

    /**
     * 冗余2
     */
    private String more2;

    private static final long serialVersionUID = 1L;

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustQq() {
        return custQq;
    }

    public void setCustQq(String custQq) {
        this.custQq = custQq;
    }

    public String getCustWechat() {
        return custWechat;
    }

    public void setCustWechat(String custWechat) {
        this.custWechat = custWechat;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Integer getCustGender() {
        return custGender;
    }

    public void setCustGender(Integer custGender) {
        this.custGender = custGender;
    }

    public String getCustProfile() {
        return custProfile;
    }

    public void setCustProfile(String custProfile) {
        this.custProfile = custProfile;
    }

    public Integer getCustPoints() {
        return custPoints;
    }

    public void setCustPoints(Integer custPoints) {
        this.custPoints = custPoints;
    }

    public String getCustMail() {
        return custMail;
    }

    public void setCustMail(String custMail) {
        this.custMail = custMail;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getCustStatus() {
        return custStatus;
    }

    public void setCustStatus(Integer custStatus) {
        this.custStatus = custStatus;
    }

    public Integer getCummStatus() {
        return cummStatus;
    }

    public void setCummStatus(Integer cummStatus) {
        this.cummStatus = cummStatus;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getMore1() {
        return more1;
    }

    public void setMore1(String more1) {
        this.more1 = more1;
    }

    public String getMore2() {
        return more2;
    }

    public void setMore2(String more2) {
        this.more2 = more2;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Customer other = (Customer) that;
        return (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getCustPhone() == null ? other.getCustPhone() == null : this.getCustPhone().equals(other.getCustPhone()))
            && (this.getCustQq() == null ? other.getCustQq() == null : this.getCustQq().equals(other.getCustQq()))
            && (this.getCustWechat() == null ? other.getCustWechat() == null : this.getCustWechat().equals(other.getCustWechat()))
            && (this.getCustPassword() == null ? other.getCustPassword() == null : this.getCustPassword().equals(other.getCustPassword()))
            && (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
            && (this.getCustGender() == null ? other.getCustGender() == null : this.getCustGender().equals(other.getCustGender()))
            && (this.getCustProfile() == null ? other.getCustProfile() == null : this.getCustProfile().equals(other.getCustProfile()))
            && (this.getCustPoints() == null ? other.getCustPoints() == null : this.getCustPoints().equals(other.getCustPoints()))
            && (this.getCustMail() == null ? other.getCustMail() == null : this.getCustMail().equals(other.getCustMail()))
            && (this.getRegisterTime() == null ? other.getRegisterTime() == null : this.getRegisterTime().equals(other.getRegisterTime()))
            && (this.getCustStatus() == null ? other.getCustStatus() == null : this.getCustStatus().equals(other.getCustStatus()))
            && (this.getCummStatus() == null ? other.getCummStatus() == null : this.getCummStatus().equals(other.getCummStatus()))
            && (this.getLoginStatus() == null ? other.getLoginStatus() == null : this.getLoginStatus().equals(other.getLoginStatus()))
            && (this.getMore1() == null ? other.getMore1() == null : this.getMore1().equals(other.getMore1()))
            && (this.getMore2() == null ? other.getMore2() == null : this.getMore2().equals(other.getMore2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustPhone() == null) ? 0 : getCustPhone().hashCode());
        result = prime * result + ((getCustQq() == null) ? 0 : getCustQq().hashCode());
        result = prime * result + ((getCustWechat() == null) ? 0 : getCustWechat().hashCode());
        result = prime * result + ((getCustPassword() == null) ? 0 : getCustPassword().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getCustGender() == null) ? 0 : getCustGender().hashCode());
        result = prime * result + ((getCustProfile() == null) ? 0 : getCustProfile().hashCode());
        result = prime * result + ((getCustPoints() == null) ? 0 : getCustPoints().hashCode());
        result = prime * result + ((getCustMail() == null) ? 0 : getCustMail().hashCode());
        result = prime * result + ((getRegisterTime() == null) ? 0 : getRegisterTime().hashCode());
        result = prime * result + ((getCustStatus() == null) ? 0 : getCustStatus().hashCode());
        result = prime * result + ((getCummStatus() == null) ? 0 : getCummStatus().hashCode());
        result = prime * result + ((getLoginStatus() == null) ? 0 : getLoginStatus().hashCode());
        result = prime * result + ((getMore1() == null) ? 0 : getMore1().hashCode());
        result = prime * result + ((getMore2() == null) ? 0 : getMore2().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", custId=").append(custId);
        sb.append(", custPhone=").append(custPhone);
        sb.append(", custQq=").append(custQq);
        sb.append(", custWechat=").append(custWechat);
        sb.append(", custPassword=").append(custPassword);
        sb.append(", custName=").append(custName);
        sb.append(", custGender=").append(custGender);
        sb.append(", custProfile=").append(custProfile);
        sb.append(", custPoints=").append(custPoints);
        sb.append(", custMail=").append(custMail);
        sb.append(", registerTime=").append(registerTime);
        sb.append(", custStatus=").append(custStatus);
        sb.append(", cummStatus=").append(cummStatus);
        sb.append(", loginStatus=").append(loginStatus);
        sb.append(", more1=").append(more1);
        sb.append(", more2=").append(more2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}