package com.elegantcollection.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * post_reply
 * @author 
 */
public class PostReply implements Serializable {
    /**
     * 回复ID
     */
    private Integer replyId;

    /**
     * 该回复所在帖子的id
     */
    private Integer postId;

    /**
     * 该回复回复的消息的id(评论帖子则为空)
     */
    private Integer byReplyId;

    /**
     * 用户ID
     */
    private Integer custId;

    /**
     * 回复目标ID(被回复人id)
     */
    private String byRead;

    /**
     * 回复内容
     */
    private String replyText;

    /**
     * 回复时间
     */
    private Date replyTime;

    /**
     * 是否已读
     */
    private Integer isReplyId;

    /**
     * 回复状态
     */
    private Integer replyStatus;

    /**
     * 回复楼层(用户回复帖子属于几楼,)
     */
    private String redundancyField1;

    /**
     * 冗余字段2
     */
    private String redundancyField2;

    private static final long serialVersionUID = 1L;

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getByReplyId() {
        return byReplyId;
    }

    public void setByReplyId(Integer byReplyId) {
        this.byReplyId = byReplyId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getByRead() {
        return byRead;
    }

    public void setByRead(String byRead) {
        this.byRead = byRead;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Integer getIsReplyId() {
        return isReplyId;
    }

    public void setIsReplyId(Integer isReplyId) {
        this.isReplyId = isReplyId;
    }

    public Integer getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(Integer replyStatus) {
        this.replyStatus = replyStatus;
    }

    public String getRedundancyField1() {
        return redundancyField1;
    }

    public void setRedundancyField1(String redundancyField1) {
        this.redundancyField1 = redundancyField1;
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
        PostReply other = (PostReply) that;
        return (this.getReplyId() == null ? other.getReplyId() == null : this.getReplyId().equals(other.getReplyId()))
            && (this.getPostId() == null ? other.getPostId() == null : this.getPostId().equals(other.getPostId()))
            && (this.getByReplyId() == null ? other.getByReplyId() == null : this.getByReplyId().equals(other.getByReplyId()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getByRead() == null ? other.getByRead() == null : this.getByRead().equals(other.getByRead()))
            && (this.getReplyText() == null ? other.getReplyText() == null : this.getReplyText().equals(other.getReplyText()))
            && (this.getReplyTime() == null ? other.getReplyTime() == null : this.getReplyTime().equals(other.getReplyTime()))
            && (this.getIsReplyId() == null ? other.getIsReplyId() == null : this.getIsReplyId().equals(other.getIsReplyId()))
            && (this.getReplyStatus() == null ? other.getReplyStatus() == null : this.getReplyStatus().equals(other.getReplyStatus()))
            && (this.getRedundancyField1() == null ? other.getRedundancyField1() == null : this.getRedundancyField1().equals(other.getRedundancyField1()))
            && (this.getRedundancyField2() == null ? other.getRedundancyField2() == null : this.getRedundancyField2().equals(other.getRedundancyField2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReplyId() == null) ? 0 : getReplyId().hashCode());
        result = prime * result + ((getPostId() == null) ? 0 : getPostId().hashCode());
        result = prime * result + ((getByReplyId() == null) ? 0 : getByReplyId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getByRead() == null) ? 0 : getByRead().hashCode());
        result = prime * result + ((getReplyText() == null) ? 0 : getReplyText().hashCode());
        result = prime * result + ((getReplyTime() == null) ? 0 : getReplyTime().hashCode());
        result = prime * result + ((getIsReplyId() == null) ? 0 : getIsReplyId().hashCode());
        result = prime * result + ((getReplyStatus() == null) ? 0 : getReplyStatus().hashCode());
        result = prime * result + ((getRedundancyField1() == null) ? 0 : getRedundancyField1().hashCode());
        result = prime * result + ((getRedundancyField2() == null) ? 0 : getRedundancyField2().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", replyId=").append(replyId);
        sb.append(", postId=").append(postId);
        sb.append(", byReplyId=").append(byReplyId);
        sb.append(", custId=").append(custId);
        sb.append(", byRead=").append(byRead);
        sb.append(", replyText=").append(replyText);
        sb.append(", replyTime=").append(replyTime);
        sb.append(", isReplyId=").append(isReplyId);
        sb.append(", replyStatus=").append(replyStatus);
        sb.append(", redundancyField1=").append(redundancyField1);
        sb.append(", redundancyField2=").append(redundancyField2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}