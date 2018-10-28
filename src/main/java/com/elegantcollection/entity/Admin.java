package com.elegantcollection.entity;

import java.io.Serializable;

/**
 * admin
 * @author 
 */
public class Admin implements Serializable {
    /**
     * 管理员ID
     */
    private Integer adminId;

    /**
     * 管理员账号
     */
    private String adminNumber;

    /**
     * 管理员密码
     */
    private String adminPassword;

    /**
     * 管理员昵称
     */
    private String adminName;

    /**
     * 管理员权限
     */
    private Integer adminPower;

    private static final long serialVersionUID = 1L;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminNumber() {
        return adminNumber;
    }

    public void setAdminNumber(String adminNumber) {
        this.adminNumber = adminNumber;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Integer getAdminPower() {
        return adminPower;
    }

    public void setAdminPower(Integer adminPower) {
        this.adminPower = adminPower;
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
        Admin other = (Admin) that;
        return (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
            && (this.getAdminNumber() == null ? other.getAdminNumber() == null : this.getAdminNumber().equals(other.getAdminNumber()))
            && (this.getAdminPassword() == null ? other.getAdminPassword() == null : this.getAdminPassword().equals(other.getAdminPassword()))
            && (this.getAdminName() == null ? other.getAdminName() == null : this.getAdminName().equals(other.getAdminName()))
            && (this.getAdminPower() == null ? other.getAdminPower() == null : this.getAdminPower().equals(other.getAdminPower()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getAdminNumber() == null) ? 0 : getAdminNumber().hashCode());
        result = prime * result + ((getAdminPassword() == null) ? 0 : getAdminPassword().hashCode());
        result = prime * result + ((getAdminName() == null) ? 0 : getAdminName().hashCode());
        result = prime * result + ((getAdminPower() == null) ? 0 : getAdminPower().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminId=").append(adminId);
        sb.append(", adminNumber=").append(adminNumber);
        sb.append(", adminPassword=").append(adminPassword);
        sb.append(", adminName=").append(adminName);
        sb.append(", adminPower=").append(adminPower);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}