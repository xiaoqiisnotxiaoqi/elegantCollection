package com.elegantcollection.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * message
 * @author 
 */
public class Message implements Serializable {
    /**
     * 消息ID
     */
    private Integer messageId;

    /**
     * 发信人id
     */
    private Integer senderId;

    /**
     * 收信人id
     */
    private Integer recipientsId;

    /**
     * 消息类型
     */
    private Integer messageType;

    /**
     * 消息时间
     */
    private Date messageTime;

    /**
     * 读取状态
     */
    private Integer readStatus;

    /**
     * 消息图片
     */
    private String messageImg;

    /**
     * 消息状态
     */
    private Integer messageStatus;

    /**
     * 冗余字段
     */
    private Integer messageIsimage;

    /**
     * 冗余字段
     */
    private Integer messageWithdraw;

    /**
     * 消息内容
     */
    private String messageText;

    private static final long serialVersionUID = 1L;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getRecipientsId() {
        return recipientsId;
    }

    public void setRecipientsId(Integer recipientsId) {
        this.recipientsId = recipientsId;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public Integer getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }

    public String getMessageImg() {
        return messageImg;
    }

    public void setMessageImg(String messageImg) {
        this.messageImg = messageImg;
    }

    public Integer getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(Integer messageStatus) {
        this.messageStatus = messageStatus;
    }

    public Integer getMessageIsimage() {
        return messageIsimage;
    }

    public void setMessageIsimage(Integer messageIsimage) {
        this.messageIsimage = messageIsimage;
    }

    public Integer getMessageWithdraw() {
        return messageWithdraw;
    }

    public void setMessageWithdraw(Integer messageWithdraw) {
        this.messageWithdraw = messageWithdraw;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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
        Message other = (Message) that;
        return (this.getMessageId() == null ? other.getMessageId() == null : this.getMessageId().equals(other.getMessageId()))
            && (this.getSenderId() == null ? other.getSenderId() == null : this.getSenderId().equals(other.getSenderId()))
            && (this.getRecipientsId() == null ? other.getRecipientsId() == null : this.getRecipientsId().equals(other.getRecipientsId()))
            && (this.getMessageType() == null ? other.getMessageType() == null : this.getMessageType().equals(other.getMessageType()))
            && (this.getMessageTime() == null ? other.getMessageTime() == null : this.getMessageTime().equals(other.getMessageTime()))
            && (this.getReadStatus() == null ? other.getReadStatus() == null : this.getReadStatus().equals(other.getReadStatus()))
            && (this.getMessageImg() == null ? other.getMessageImg() == null : this.getMessageImg().equals(other.getMessageImg()))
            && (this.getMessageStatus() == null ? other.getMessageStatus() == null : this.getMessageStatus().equals(other.getMessageStatus()))
            && (this.getMessageIsimage() == null ? other.getMessageIsimage() == null : this.getMessageIsimage().equals(other.getMessageIsimage()))
            && (this.getMessageWithdraw() == null ? other.getMessageWithdraw() == null : this.getMessageWithdraw().equals(other.getMessageWithdraw()))
            && (this.getMessageText() == null ? other.getMessageText() == null : this.getMessageText().equals(other.getMessageText()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMessageId() == null) ? 0 : getMessageId().hashCode());
        result = prime * result + ((getSenderId() == null) ? 0 : getSenderId().hashCode());
        result = prime * result + ((getRecipientsId() == null) ? 0 : getRecipientsId().hashCode());
        result = prime * result + ((getMessageType() == null) ? 0 : getMessageType().hashCode());
        result = prime * result + ((getMessageTime() == null) ? 0 : getMessageTime().hashCode());
        result = prime * result + ((getReadStatus() == null) ? 0 : getReadStatus().hashCode());
        result = prime * result + ((getMessageImg() == null) ? 0 : getMessageImg().hashCode());
        result = prime * result + ((getMessageStatus() == null) ? 0 : getMessageStatus().hashCode());
        result = prime * result + ((getMessageIsimage() == null) ? 0 : getMessageIsimage().hashCode());
        result = prime * result + ((getMessageWithdraw() == null) ? 0 : getMessageWithdraw().hashCode());
        result = prime * result + ((getMessageText() == null) ? 0 : getMessageText().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", messageId=").append(messageId);
        sb.append(", senderId=").append(senderId);
        sb.append(", recipientsId=").append(recipientsId);
        sb.append(", messageType=").append(messageType);
        sb.append(", messageTime=").append(messageTime);
        sb.append(", readStatus=").append(readStatus);
        sb.append(", messageImg=").append(messageImg);
        sb.append(", messageStatus=").append(messageStatus);
        sb.append(", messageIsimage=").append(messageIsimage);
        sb.append(", messageWithdraw=").append(messageWithdraw);
        sb.append(", messageText=").append(messageText);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}