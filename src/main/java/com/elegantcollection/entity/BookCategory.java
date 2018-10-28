package com.elegantcollection.entity;

import java.io.Serializable;

/**
 * book_category
 * @author 
 */
public class BookCategory implements Serializable {
    /**
     * 分类ID
     */
    private Integer categoryId;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 上层分类ID
     */
    private Integer categoryUpId;

    private String redundancyField;

    private String redundancyField2;

    private static final long serialVersionUID = 1L;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryUpId() {
        return categoryUpId;
    }

    public void setCategoryUpId(Integer categoryUpId) {
        this.categoryUpId = categoryUpId;
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
        BookCategory other = (BookCategory) that;
        return (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getCategoryName() == null ? other.getCategoryName() == null : this.getCategoryName().equals(other.getCategoryName()))
            && (this.getCategoryUpId() == null ? other.getCategoryUpId() == null : this.getCategoryUpId().equals(other.getCategoryUpId()))
            && (this.getRedundancyField() == null ? other.getRedundancyField() == null : this.getRedundancyField().equals(other.getRedundancyField()))
            && (this.getRedundancyField2() == null ? other.getRedundancyField2() == null : this.getRedundancyField2().equals(other.getRedundancyField2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getCategoryName() == null) ? 0 : getCategoryName().hashCode());
        result = prime * result + ((getCategoryUpId() == null) ? 0 : getCategoryUpId().hashCode());
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
        sb.append(", categoryId=").append(categoryId);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", categoryUpId=").append(categoryUpId);
        sb.append(", redundancyField=").append(redundancyField);
        sb.append(", redundancyField2=").append(redundancyField2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}