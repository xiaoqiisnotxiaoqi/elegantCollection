package com.elegantcollection.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * login
 * @author 
 */
public class Login implements Serializable {
    /**
     * 登录ID
     */
    private Integer loginId;

    /**
     * 用户ID
     */
    private Integer custId;

    /**
     * 登陆时间
     */
    private Date loginTime;

    /**
     * IP地址
     */
    private String loginIp;

    /**
     * 登录状态
     */
    private Integer loginStatus;

    /**
     * 冗余字段
     */
    private String loginPetname;

    /**
     * 冗余字段
     */
    private Integer loginException;

    private static final long serialVersionUID = 1L;

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getLoginPetname() {
        return loginPetname;
    }

    public void setLoginPetname(String loginPetname) {
        this.loginPetname = loginPetname;
    }

    public Integer getLoginException() {
        return loginException;
    }

    public void setLoginException(Integer loginException) {
        this.loginException = loginException;
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
        Login other = (Login) that;
        return (this.getLoginId() == null ? other.getLoginId() == null : this.getLoginId().equals(other.getLoginId()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getLoginTime() == null ? other.getLoginTime() == null : this.getLoginTime().equals(other.getLoginTime()))
            && (this.getLoginIp() == null ? other.getLoginIp() == null : this.getLoginIp().equals(other.getLoginIp()))
            && (this.getLoginStatus() == null ? other.getLoginStatus() == null : this.getLoginStatus().equals(other.getLoginStatus()))
            && (this.getLoginPetname() == null ? other.getLoginPetname() == null : this.getLoginPetname().equals(other.getLoginPetname()))
            && (this.getLoginException() == null ? other.getLoginException() == null : this.getLoginException().equals(other.getLoginException()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLoginId() == null) ? 0 : getLoginId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getLoginTime() == null) ? 0 : getLoginTime().hashCode());
        result = prime * result + ((getLoginIp() == null) ? 0 : getLoginIp().hashCode());
        result = prime * result + ((getLoginStatus() == null) ? 0 : getLoginStatus().hashCode());
        result = prime * result + ((getLoginPetname() == null) ? 0 : getLoginPetname().hashCode());
        result = prime * result + ((getLoginException() == null) ? 0 : getLoginException().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", loginId=").append(loginId);
        sb.append(", custId=").append(custId);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", loginIp=").append(loginIp);
        sb.append(", loginStatus=").append(loginStatus);
        sb.append(", loginPetname=").append(loginPetname);
        sb.append(", loginException=").append(loginException);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}