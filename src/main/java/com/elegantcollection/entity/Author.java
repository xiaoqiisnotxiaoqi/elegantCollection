package com.elegantcollection.entity;

import java.io.Serializable;

/**
 * author
 * @author 
 */
public class Author implements Serializable {
    /**
     * 作者ID
     */
    private Integer authorId;

    /**
     * 作者姓名
     */
    private String authorName;

    /**
     * 作者图片
     */
    private String authorImg;

    /**
     * 作者国籍
     */
    private String authorCountry;

    /**
     * 作者简介
     */
    private String authorIntro;

    private static final long serialVersionUID = 1L;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorImg() {
        return authorImg;
    }

    public void setAuthorImg(String authorImg) {
        this.authorImg = authorImg;
    }

    public String getAuthorCountry() {
        return authorCountry;
    }

    public void setAuthorCountry(String authorCountry) {
        this.authorCountry = authorCountry;
    }

    public String getAuthorIntro() {
        return authorIntro;
    }

    public void setAuthorIntro(String authorIntro) {
        this.authorIntro = authorIntro;
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
        Author other = (Author) that;
        return (this.getAuthorId() == null ? other.getAuthorId() == null : this.getAuthorId().equals(other.getAuthorId()))
            && (this.getAuthorName() == null ? other.getAuthorName() == null : this.getAuthorName().equals(other.getAuthorName()))
            && (this.getAuthorImg() == null ? other.getAuthorImg() == null : this.getAuthorImg().equals(other.getAuthorImg()))
            && (this.getAuthorCountry() == null ? other.getAuthorCountry() == null : this.getAuthorCountry().equals(other.getAuthorCountry()))
            && (this.getAuthorIntro() == null ? other.getAuthorIntro() == null : this.getAuthorIntro().equals(other.getAuthorIntro()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAuthorId() == null) ? 0 : getAuthorId().hashCode());
        result = prime * result + ((getAuthorName() == null) ? 0 : getAuthorName().hashCode());
        result = prime * result + ((getAuthorImg() == null) ? 0 : getAuthorImg().hashCode());
        result = prime * result + ((getAuthorCountry() == null) ? 0 : getAuthorCountry().hashCode());
        result = prime * result + ((getAuthorIntro() == null) ? 0 : getAuthorIntro().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", authorId=").append(authorId);
        sb.append(", authorName=").append(authorName);
        sb.append(", authorImg=").append(authorImg);
        sb.append(", authorCountry=").append(authorCountry);
        sb.append(", authorIntro=").append(authorIntro);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}