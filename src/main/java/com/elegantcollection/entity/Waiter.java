package com.elegantcollection.entity;

import java.io.Serializable;

/**
 * waiter
 * @author 
 */
public class Waiter implements Serializable {
    /**
     * 客服ID
     */
    private Integer waiterId;

    /**
     * 客服账户
     */
    private String waiterNumber;

    /**
     * 客服密码
     */
    private String waiterPassword;

    /**
     * 客服昵称
     */
    private String waiterName;

    /**
     * 冗余字段1
     */
    private String redundancyField;

    /**
     * 冗余字段1
     */
    private String redundancyField2;

    private static final long serialVersionUID = 1L;

    public Integer getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(Integer waiterId) {
        this.waiterId = waiterId;
    }

    public String getWaiterNumber() {
        return waiterNumber;
    }

    public void setWaiterNumber(String waiterNumber) {
        this.waiterNumber = waiterNumber;
    }

    public String getWaiterPassword() {
        return waiterPassword;
    }

    public void setWaiterPassword(String waiterPassword) {
        this.waiterPassword = waiterPassword;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public String getRedundancyField() {
        return redundancyField;
    }

    public void setRedundancyField(String redundancyField) {
        this.redundancyField = redundancyField;
    }

    public String getRedundancyField2() {
        return redundancyField2;
    }

    public void setRedundancyField2(String redundancyField2) {
        this.redundancyField2 = redundancyField2;
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
        Waiter other = (Waiter) that;
        return (this.getWaiterId() == null ? other.getWaiterId() == null : this.getWaiterId().equals(other.getWaiterId()))
            && (this.getWaiterNumber() == null ? other.getWaiterNumber() == null : this.getWaiterNumber().equals(other.getWaiterNumber()))
            && (this.getWaiterPassword() == null ? other.getWaiterPassword() == null : this.getWaiterPassword().equals(other.getWaiterPassword()))
            && (this.getWaiterName() == null ? other.getWaiterName() == null : this.getWaiterName().equals(other.getWaiterName()))
            && (this.getRedundancyField() == null ? other.getRedundancyField() == null : this.getRedundancyField().equals(other.getRedundancyField()))
            && (this.getRedundancyField2() == null ? other.getRedundancyField2() == null : this.getRedundancyField2().equals(other.getRedundancyField2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWaiterId() == null) ? 0 : getWaiterId().hashCode());
        result = prime * result + ((getWaiterNumber() == null) ? 0 : getWaiterNumber().hashCode());
        result = prime * result + ((getWaiterPassword() == null) ? 0 : getWaiterPassword().hashCode());
        result = prime * result + ((getWaiterName() == null) ? 0 : getWaiterName().hashCode());
        result = prime * result + ((getRedundancyField() == null) ? 0 : getRedundancyField().hashCode());
        result = prime * result + ((getRedundancyField2() == null) ? 0 : getRedundancyField2().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", waiterId=").append(waiterId);
        sb.append(", waiterNumber=").append(waiterNumber);
        sb.append(", waiterPassword=").append(waiterPassword);
        sb.append(", waiterName=").append(waiterName);
        sb.append(", redundancyField=").append(redundancyField);
        sb.append(", redundancyField2=").append(redundancyField2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}