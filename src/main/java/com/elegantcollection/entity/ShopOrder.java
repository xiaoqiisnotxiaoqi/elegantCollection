package com.elegantcollection.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * shop_order
 * @author 
 */
public class ShopOrder implements Serializable {
    /**
     * 订单ID
     */
    private Integer orderId;

    /**
     * 订单编号
     */
    private Long orderNumber;

    /**
     * 用户ID
     */
    private Integer custId;

    /**
     * 订单创建时间（订单提交时间）
     */
    private Date orderCreateTime;

    /**
     * 订单总价
     */
    private Float orderPrice;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 评价状态
     */
    private Integer evaluateStatus;

    /**
     * 收货地址id
     */
    private Integer addressId;

    /**
     * 冗余字段2
     */
    private String redundancyField2;

    /**
     * 付款时间
     */
    private Date paymentTime;

    /**
     * 出库时间
     */
    private Date outlibraryTime;

    /**
     * 快递公司编码
     */
    private String courierCompanyId;

    /**
     * 物流编号
     */
    private String logisticsId;

    /**
     * 期望配送时间
     */
    private Date expectationTime;

    private static final long serialVersionUID = 1L;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Float orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getEvaluateStatus() {
        return evaluateStatus;
    }

    public void setEvaluateStatus(Integer evaluateStatus) {
        this.evaluateStatus = evaluateStatus;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getRedundancyField2() {
        return redundancyField2;
    }

    public void setRedundancyField2(String redundancyField2) {
        this.redundancyField2 = redundancyField2;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getOutlibraryTime() {
        return outlibraryTime;
    }

    public void setOutlibraryTime(Date outlibraryTime) {
        this.outlibraryTime = outlibraryTime;
    }

    public String getCourierCompanyId() {
        return courierCompanyId;
    }

    public void setCourierCompanyId(String courierCompanyId) {
        this.courierCompanyId = courierCompanyId;
    }

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }

    public Date getExpectationTime() {
        return expectationTime;
    }

    public void setExpectationTime(Date expectationTime) {
        this.expectationTime = expectationTime;
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
        ShopOrder other = (ShopOrder) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getOrderCreateTime() == null ? other.getOrderCreateTime() == null : this.getOrderCreateTime().equals(other.getOrderCreateTime()))
            && (this.getOrderPrice() == null ? other.getOrderPrice() == null : this.getOrderPrice().equals(other.getOrderPrice()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getEvaluateStatus() == null ? other.getEvaluateStatus() == null : this.getEvaluateStatus().equals(other.getEvaluateStatus()))
            && (this.getAddressId() == null ? other.getAddressId() == null : this.getAddressId().equals(other.getAddressId()))
            && (this.getRedundancyField2() == null ? other.getRedundancyField2() == null : this.getRedundancyField2().equals(other.getRedundancyField2()))
            && (this.getPaymentTime() == null ? other.getPaymentTime() == null : this.getPaymentTime().equals(other.getPaymentTime()))
            && (this.getOutlibraryTime() == null ? other.getOutlibraryTime() == null : this.getOutlibraryTime().equals(other.getOutlibraryTime()))
            && (this.getCourierCompanyId() == null ? other.getCourierCompanyId() == null : this.getCourierCompanyId().equals(other.getCourierCompanyId()))
            && (this.getLogisticsId() == null ? other.getLogisticsId() == null : this.getLogisticsId().equals(other.getLogisticsId()))
            && (this.getExpectationTime() == null ? other.getExpectationTime() == null : this.getExpectationTime().equals(other.getExpectationTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getOrderCreateTime() == null) ? 0 : getOrderCreateTime().hashCode());
        result = prime * result + ((getOrderPrice() == null) ? 0 : getOrderPrice().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getEvaluateStatus() == null) ? 0 : getEvaluateStatus().hashCode());
        result = prime * result + ((getAddressId() == null) ? 0 : getAddressId().hashCode());
        result = prime * result + ((getRedundancyField2() == null) ? 0 : getRedundancyField2().hashCode());
        result = prime * result + ((getPaymentTime() == null) ? 0 : getPaymentTime().hashCode());
        result = prime * result + ((getOutlibraryTime() == null) ? 0 : getOutlibraryTime().hashCode());
        result = prime * result + ((getCourierCompanyId() == null) ? 0 : getCourierCompanyId().hashCode());
        result = prime * result + ((getLogisticsId() == null) ? 0 : getLogisticsId().hashCode());
        result = prime * result + ((getExpectationTime() == null) ? 0 : getExpectationTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", custId=").append(custId);
        sb.append(", orderCreateTime=").append(orderCreateTime);
        sb.append(", orderPrice=").append(orderPrice);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", evaluateStatus=").append(evaluateStatus);
        sb.append(", addressId=").append(addressId);
        sb.append(", redundancyField2=").append(redundancyField2);
        sb.append(", paymentTime=").append(paymentTime);
        sb.append(", outlibraryTime=").append(outlibraryTime);
        sb.append(", courierCompanyId=").append(courierCompanyId);
        sb.append(", logisticsId=").append(logisticsId);
        sb.append(", expectationTime=").append(expectationTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}