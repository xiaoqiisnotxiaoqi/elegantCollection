package com.elegantcollection.entity;

import java.io.Serializable;

/**
 * discount_detail
 * @author 
 */
public class DiscountDetail extends DiscountDetailKey implements Serializable {
    /**
     * 优惠细节状态
     */
    private Integer detailStatus;

    /**
     * 冗余1
     */
    private String more1;

    /**
     * 冗余2
     */
    private String more2;

    private static final long serialVersionUID = 1L;

    public Integer getDetailStatus() {
        return detailStatus;
    }

    public void setDetailStatus(Integer detailStatus) {
        this.detailStatus = detailStatus;
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
        DiscountDetail other = (DiscountDetail) that;
        return (this.getDiscountId() == null ? other.getDiscountId() == null : this.getDiscountId().equals(other.getDiscountId()))
            && (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
            && (this.getDetailStatus() == null ? other.getDetailStatus() == null : this.getDetailStatus().equals(other.getDetailStatus()))
            && (this.getMore1() == null ? other.getMore1() == null : this.getMore1().equals(other.getMore1()))
            && (this.getMore2() == null ? other.getMore2() == null : this.getMore2().equals(other.getMore2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDiscountId() == null) ? 0 : getDiscountId().hashCode());
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        result = prime * result + ((getDetailStatus() == null) ? 0 : getDetailStatus().hashCode());
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
        sb.append(", detailStatus=").append(detailStatus);
        sb.append(", more1=").append(more1);
        sb.append(", more2=").append(more2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}