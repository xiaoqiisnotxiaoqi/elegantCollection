package com.elegantcollection.entity;

import java.io.Serializable;

/**
 * shop_order_detail
 * @author 
 */
public class ShopOrderDetail extends ShopOrderDetailKey implements Serializable {
    /**
     * 数量
     */
    private Integer quality;

    /**
     * 冗余字段1
     */
    private String redundancyField;

    /**
     * 冗余字段2
     */
    private String redundancyField2;

    private static final long serialVersionUID = 1L;

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
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
        ShopOrderDetail other = (ShopOrderDetail) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
            && (this.getQuality() == null ? other.getQuality() == null : this.getQuality().equals(other.getQuality()))
            && (this.getRedundancyField() == null ? other.getRedundancyField() == null : this.getRedundancyField().equals(other.getRedundancyField()))
            && (this.getRedundancyField2() == null ? other.getRedundancyField2() == null : this.getRedundancyField2().equals(other.getRedundancyField2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        result = prime * result + ((getQuality() == null) ? 0 : getQuality().hashCode());
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
        sb.append(", quality=").append(quality);
        sb.append(", redundancyField=").append(redundancyField);
        sb.append(", redundancyField2=").append(redundancyField2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}