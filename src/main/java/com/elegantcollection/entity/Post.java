package com.elegantcollection.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * post
 * @author 
 */
public class Post implements Serializable {
    /**
     * 发帖ID
     */
    private Integer postId;

    /**
     * 发帖标题
     */
    private String postTitle;

    /**
     * 用户ID
     */
    private Integer custId;

    /**
     * 发表时间
     */
    private Date postTime;

    /**
     * 回复数
     */
    private Integer replyCount;

    /**
     * 是否置顶
0未置顶
1置顶
     */
    private Integer isStick;

    /**
     * 发帖状态
0普通帖子
1精品帖子
2已删除
     */
    private Integer postStatus;

    /**
     * 所在的模块id
     */
    private String postPetname;

    /**
     * 是否回复
     */
    private Integer postIsreply;

    /**
     * 发帖内容
     */
    private String postText;

    private static final long serialVersionUID = 1L;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getIsStick() {
        return isStick;
    }

    public void setIsStick(Integer isStick) {
        this.isStick = isStick;
    }

    public Integer getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(Integer postStatus) {
        this.postStatus = postStatus;
    }

    public String getPostPetname() {
        return postPetname;
    }

    public void setPostPetname(String postPetname) {
        this.postPetname = postPetname;
    }

    public Integer getPostIsreply() {
        return postIsreply;
    }

    public void setPostIsreply(Integer postIsreply) {
        this.postIsreply = postIsreply;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
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
        Post other = (Post) that;
        return (this.getPostId() == null ? other.getPostId() == null : this.getPostId().equals(other.getPostId()))
            && (this.getPostTitle() == null ? other.getPostTitle() == null : this.getPostTitle().equals(other.getPostTitle()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getPostTime() == null ? other.getPostTime() == null : this.getPostTime().equals(other.getPostTime()))
            && (this.getReplyCount() == null ? other.getReplyCount() == null : this.getReplyCount().equals(other.getReplyCount()))
            && (this.getIsStick() == null ? other.getIsStick() == null : this.getIsStick().equals(other.getIsStick()))
            && (this.getPostStatus() == null ? other.getPostStatus() == null : this.getPostStatus().equals(other.getPostStatus()))
            && (this.getPostPetname() == null ? other.getPostPetname() == null : this.getPostPetname().equals(other.getPostPetname()))
            && (this.getPostIsreply() == null ? other.getPostIsreply() == null : this.getPostIsreply().equals(other.getPostIsreply()))
            && (this.getPostText() == null ? other.getPostText() == null : this.getPostText().equals(other.getPostText()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPostId() == null) ? 0 : getPostId().hashCode());
        result = prime * result + ((getPostTitle() == null) ? 0 : getPostTitle().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getPostTime() == null) ? 0 : getPostTime().hashCode());
        result = prime * result + ((getReplyCount() == null) ? 0 : getReplyCount().hashCode());
        result = prime * result + ((getIsStick() == null) ? 0 : getIsStick().hashCode());
        result = prime * result + ((getPostStatus() == null) ? 0 : getPostStatus().hashCode());
        result = prime * result + ((getPostPetname() == null) ? 0 : getPostPetname().hashCode());
        result = prime * result + ((getPostIsreply() == null) ? 0 : getPostIsreply().hashCode());
        result = prime * result + ((getPostText() == null) ? 0 : getPostText().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", postId=").append(postId);
        sb.append(", postTitle=").append(postTitle);
        sb.append(", custId=").append(custId);
        sb.append(", postTime=").append(postTime);
        sb.append(", replyCount=").append(replyCount);
        sb.append(", isStick=").append(isStick);
        sb.append(", postStatus=").append(postStatus);
        sb.append(", postPetname=").append(postPetname);
        sb.append(", postIsreply=").append(postIsreply);
        sb.append(", postText=").append(postText);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}