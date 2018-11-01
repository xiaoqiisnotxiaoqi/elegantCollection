package com.elegantcollection.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * cart
 *
 * @author
 */
public class Cart implements Serializable {
    /**
     * 购物车ID
     */
    private Integer cartId;

    /**
     * 用户ID
     */
    private Integer custId;

    /**
     * 图书ID
     */
    private Integer bookId;

    /**
     * 数量
     */
    private Integer quality;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 购物车状态
     */
    private Integer cartStatus;

    /**
     * 冗余1
     */
    private String more1;

    /**
     * 冗余2
     */
    private String more2;

    public Cart() {
    }

    //有参构造函数(孙健添加)
    public Cart(Integer cartId, Integer custId, Integer bookId, Integer quality, Date addTime, Integer cartStatus, String more1, String more2) {
        this.cartId = cartId;
        this.custId = custId;
        this.bookId = bookId;
        this.quality = quality;
        this.addTime = addTime;
        this.cartStatus = cartStatus;
        this.more1 = more1;
        this.more2 = more2;
    }

    private static final long serialVersionUID = 1L;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(Integer cartStatus) {
        this.cartStatus = cartStatus;
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
        Cart other = (Cart) that;
        return (this.getCartId() == null ? other.getCartId() == null : this.getCartId().equals(other.getCartId()))
                && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
                && (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
                && (this.getQuality() == null ? other.getQuality() == null : this.getQuality().equals(other.getQuality()))
                && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
                && (this.getCartStatus() == null ? other.getCartStatus() == null : this.getCartStatus().equals(other.getCartStatus()))
                && (this.getMore1() == null ? other.getMore1() == null : this.getMore1().equals(other.getMore1()))
                && (this.getMore2() == null ? other.getMore2() == null : this.getMore2().equals(other.getMore2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCartId() == null) ? 0 : getCartId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        result = prime * result + ((getQuality() == null) ? 0 : getQuality().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getCartStatus() == null) ? 0 : getCartStatus().hashCode());
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
        sb.append(", cartId=").append(cartId);
        sb.append(", custId=").append(custId);
        sb.append(", bookId=").append(bookId);
        sb.append(", quality=").append(quality);
        sb.append(", addTime=").append(addTime);
        sb.append(", cartStatus=").append(cartStatus);
        sb.append(", more1=").append(more1);
        sb.append(", more2=").append(more2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}