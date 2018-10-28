package com.elegantcollection.entity;

import java.io.Serializable;

/**
 * block
 * @author 
 */
public class Block implements Serializable {
    /**
     * 板块ID
     */
    private Integer blockId;

    /**
     * 板块名
     */
    private String blockName;

    /**
     * 图书ID
     */
    private Integer bookId;

    /**
     * 图书类型ID
     */
    private Integer categoryId;

    /**
     * 板块封面
     */
    private String blockIma;

    /**
     * 模块状态
     */
    private Integer blockStatus;

    private static final long serialVersionUID = 1L;

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getBlockIma() {
        return blockIma;
    }

    public void setBlockIma(String blockIma) {
        this.blockIma = blockIma;
    }

    public Integer getBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(Integer blockStatus) {
        this.blockStatus = blockStatus;
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
        Block other = (Block) that;
        return (this.getBlockId() == null ? other.getBlockId() == null : this.getBlockId().equals(other.getBlockId()))
            && (this.getBlockName() == null ? other.getBlockName() == null : this.getBlockName().equals(other.getBlockName()))
            && (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getBlockIma() == null ? other.getBlockIma() == null : this.getBlockIma().equals(other.getBlockIma()))
            && (this.getBlockStatus() == null ? other.getBlockStatus() == null : this.getBlockStatus().equals(other.getBlockStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBlockId() == null) ? 0 : getBlockId().hashCode());
        result = prime * result + ((getBlockName() == null) ? 0 : getBlockName().hashCode());
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getBlockIma() == null) ? 0 : getBlockIma().hashCode());
        result = prime * result + ((getBlockStatus() == null) ? 0 : getBlockStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", blockId=").append(blockId);
        sb.append(", blockName=").append(blockName);
        sb.append(", bookId=").append(bookId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", blockIma=").append(blockIma);
        sb.append(", blockStatus=").append(blockStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}