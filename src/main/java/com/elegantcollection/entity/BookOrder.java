package com.elegantcollection.entity;

import java.io.Serializable;

/**
 * book_order
 * @author 
 */
public class BookOrder implements Serializable {
    /**
     * 书单ID
     */
    private Integer orderId;

    /**
     * 书单标题
     */
    private String orderTitle;

    /**
     * 书单图片
     */
    private String orderImg;

    /**
     * 书单状态
     */
    private Integer orderStatus;

    private String redundancyField;

    private String redundancyField2;

    /**
     * 书单描述
     */
    private String orderIntro;

    private static final long serialVersionUID = 1L;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    public String getOrderImg() {
        return orderImg;
    }

    public void setOrderImg(String orderImg) {
        this.orderImg = orderImg;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
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

    public String getOrderIntro() {
        return orderIntro;
    }

    public void setOrderIntro(String orderIntro) {
        this.orderIntro = orderIntro;
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
        BookOrder other = (BookOrder) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getOrderTitle() == null ? other.getOrderTitle() == null : this.getOrderTitle().equals(other.getOrderTitle()))
            && (this.getOrderImg() == null ? other.getOrderImg() == null : this.getOrderImg().equals(other.getOrderImg()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getRedundancyField() == null ? other.getRedundancyField() == null : this.getRedundancyField().equals(other.getRedundancyField()))
            && (this.getRedundancyField2() == null ? other.getRedundancyField2() == null : this.getRedundancyField2().equals(other.getRedundancyField2()))
            && (this.getOrderIntro() == null ? other.getOrderIntro() == null : this.getOrderIntro().equals(other.getOrderIntro()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getOrderTitle() == null) ? 0 : getOrderTitle().hashCode());
        result = prime * result + ((getOrderImg() == null) ? 0 : getOrderImg().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getRedundancyField() == null) ? 0 : getRedundancyField().hashCode());
        result = prime * result + ((getRedundancyField2() == null) ? 0 : getRedundancyField2().hashCode());
        result = prime * result + ((getOrderIntro() == null) ? 0 : getOrderIntro().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", orderTitle=").append(orderTitle);
        sb.append(", orderImg=").append(orderImg);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", redundancyField=").append(redundancyField);
        sb.append(", redundancyField2=").append(redundancyField2);
        sb.append(", orderIntro=").append(orderIntro);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}