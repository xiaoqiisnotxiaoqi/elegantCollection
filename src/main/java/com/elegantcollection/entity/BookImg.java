package com.elegantcollection.entity;

import java.io.Serializable;

/**
 * book_img
 * @author 
 */
public class BookImg extends BookImgKey implements Serializable {
    private String imgAddress;

    private String redundancyField;

    private String redundancyField2;

    private static final long serialVersionUID = 1L;

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
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
        BookImg other = (BookImg) that;
        return (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
            && (this.getImgId() == null ? other.getImgId() == null : this.getImgId().equals(other.getImgId()))
            && (this.getImgAddress() == null ? other.getImgAddress() == null : this.getImgAddress().equals(other.getImgAddress()))
            && (this.getRedundancyField() == null ? other.getRedundancyField() == null : this.getRedundancyField().equals(other.getRedundancyField()))
            && (this.getRedundancyField2() == null ? other.getRedundancyField2() == null : this.getRedundancyField2().equals(other.getRedundancyField2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        result = prime * result + ((getImgId() == null) ? 0 : getImgId().hashCode());
        result = prime * result + ((getImgAddress() == null) ? 0 : getImgAddress().hashCode());
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
        sb.append(", imgAddress=").append(imgAddress);
        sb.append(", redundancyField=").append(redundancyField);
        sb.append(", redundancyField2=").append(redundancyField2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}