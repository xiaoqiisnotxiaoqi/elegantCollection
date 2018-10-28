package com.elegantcollection.entity;

import java.io.Serializable;

/**
 * discount_detail
 * @author 
 */
public class DiscountDetailKey implements Serializable {
    /**
     * 优惠ID
     */
    private Integer discountId;

    /**
     * 图书ID
     */
    private Integer bookId;

    private static final long serialVersionUID = 1L;

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
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
        DiscountDetailKey other = (DiscountDetailKey) that;
        return (this.getDiscountId() == null ? other.getDiscountId() == null : this.getDiscountId().equals(other.getDiscountId()))
            && (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDiscountId() == null) ? 0 : getDiscountId().hashCode());
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", discountId=").append(discountId);
        sb.append(", bookId=").append(bookId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}