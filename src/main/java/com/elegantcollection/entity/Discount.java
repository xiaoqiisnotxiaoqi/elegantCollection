package com.elegantcollection.entity;

import java.io.Serializable;

/**
 * discount
 * @author 
 */
public class Discount implements Serializable {
    /**
     * 优惠ID
     */
    private Integer discountId;

    /**
     * 优惠名
     */
    private String discountName;

    /**
     * 优惠类型
     */
    private Integer discountType;

    /**
     * 优惠金额
     */
    private Float discountMoney;

    /**
     * 优惠状态
     */
    private Integer discountStatus;

    /**
     * 冗余1
     */
    private String more1;

    /**
     * 冗余2
     */
    private String more2;

    private static final long serialVersionUID = 1L;

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public Float getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(Float discountMoney) {
        this.discountMoney = discountMoney;
    }

    public Integer getDiscountStatus() {
        return discountStatus;
    }

    public void setDiscountStatus(Integer discountStatus) {
        this.discountStatus = discountStatus;
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
        Discount other = (Discount) that;
        return (this.getDiscountId() == null ? other.getDiscountId() == null : this.getDiscountId().equals(other.getDiscountId()))
            && (this.getDiscountName() == null ? other.getDiscountName() == null : this.getDiscountName().equals(other.getDiscountName()))
            && (this.getDiscountType() == null ? other.getDiscountType() == null : this.getDiscountType().equals(other.getDiscountType()))
            && (this.getDiscountMoney() == null ? other.getDiscountMoney() == null : this.getDiscountMoney().equals(other.getDiscountMoney()))
            && (this.getDiscountStatus() == null ? other.getDiscountStatus() == null : this.getDiscountStatus().equals(other.getDiscountStatus()))
            && (this.getMore1() == null ? other.getMore1() == null : this.getMore1().equals(other.getMore1()))
            && (this.getMore2() == null ? other.getMore2() == null : this.getMore2().equals(other.getMore2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDiscountId() == null) ? 0 : getDiscountId().hashCode());
        result = prime * result + ((getDiscountName() == null) ? 0 : getDiscountName().hashCode());
        result = prime * result + ((getDiscountType() == null) ? 0 : getDiscountType().hashCode());
        result = prime * result + ((getDiscountMoney() == null) ? 0 : getDiscountMoney().hashCode());
        result = prime * result + ((getDiscountStatus() == null) ? 0 : getDiscountStatus().hashCode());
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
        sb.append(", discountId=").append(discountId);
        sb.append(", discountName=").append(discountName);
        sb.append(", discountType=").append(discountType);
        sb.append(", discountMoney=").append(discountMoney);
        sb.append(", discountStatus=").append(discountStatus);
        sb.append(", more1=").append(more1);
        sb.append(", more2=").append(more2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}