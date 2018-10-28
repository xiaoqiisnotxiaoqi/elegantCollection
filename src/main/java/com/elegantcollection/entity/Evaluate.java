package com.elegantcollection.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * evaluate
 * @author 
 */
public class Evaluate implements Serializable {
    /**
     * 评价ID
     */
    private Integer evaluateId;

    /**
     * 图书ID
     */
    private Integer bookId;

    /**
     * 用户ID
     */
    private Integer custId;

    /**
     * 评价图片
     */
    private String evaluateImg;

    /**
     * 描述评分
     */
    private Integer describeScore;

    /**
     * 物流评分
     */
    private Integer logisticsScore;

    /**
     * 服务评分
     */
    private Integer serviceScore;

    /**
     * 评价时间
     */
    private Date evaluateTime;

    /**
     * 是否评价
     */
    private Integer isAnonymous;

    /**
     * 评价状态
     */
    private Integer evaluateStatus;

    /**
     * 冗余字段
     */
    private Integer evaluateAnonymous;

    /**
     * 冗余字段
     */
    private Integer evaluateIsimage;

    /**
     * 评价内容
     */
    private String evaluateText;

    private static final long serialVersionUID = 1L;

    public Integer getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Integer evaluateId) {
        this.evaluateId = evaluateId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getEvaluateImg() {
        return evaluateImg;
    }

    public void setEvaluateImg(String evaluateImg) {
        this.evaluateImg = evaluateImg;
    }

    public Integer getDescribeScore() {
        return describeScore;
    }

    public void setDescribeScore(Integer describeScore) {
        this.describeScore = describeScore;
    }

    public Integer getLogisticsScore() {
        return logisticsScore;
    }

    public void setLogisticsScore(Integer logisticsScore) {
        this.logisticsScore = logisticsScore;
    }

    public Integer getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(Integer serviceScore) {
        this.serviceScore = serviceScore;
    }

    public Date getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(Date evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    public Integer getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(Integer isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public Integer getEvaluateStatus() {
        return evaluateStatus;
    }

    public void setEvaluateStatus(Integer evaluateStatus) {
        this.evaluateStatus = evaluateStatus;
    }

    public Integer getEvaluateAnonymous() {
        return evaluateAnonymous;
    }

    public void setEvaluateAnonymous(Integer evaluateAnonymous) {
        this.evaluateAnonymous = evaluateAnonymous;
    }

    public Integer getEvaluateIsimage() {
        return evaluateIsimage;
    }

    public void setEvaluateIsimage(Integer evaluateIsimage) {
        this.evaluateIsimage = evaluateIsimage;
    }

    public String getEvaluateText() {
        return evaluateText;
    }

    public void setEvaluateText(String evaluateText) {
        this.evaluateText = evaluateText;
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
        Evaluate other = (Evaluate) that;
        return (this.getEvaluateId() == null ? other.getEvaluateId() == null : this.getEvaluateId().equals(other.getEvaluateId()))
            && (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getEvaluateImg() == null ? other.getEvaluateImg() == null : this.getEvaluateImg().equals(other.getEvaluateImg()))
            && (this.getDescribeScore() == null ? other.getDescribeScore() == null : this.getDescribeScore().equals(other.getDescribeScore()))
            && (this.getLogisticsScore() == null ? other.getLogisticsScore() == null : this.getLogisticsScore().equals(other.getLogisticsScore()))
            && (this.getServiceScore() == null ? other.getServiceScore() == null : this.getServiceScore().equals(other.getServiceScore()))
            && (this.getEvaluateTime() == null ? other.getEvaluateTime() == null : this.getEvaluateTime().equals(other.getEvaluateTime()))
            && (this.getIsAnonymous() == null ? other.getIsAnonymous() == null : this.getIsAnonymous().equals(other.getIsAnonymous()))
            && (this.getEvaluateStatus() == null ? other.getEvaluateStatus() == null : this.getEvaluateStatus().equals(other.getEvaluateStatus()))
            && (this.getEvaluateAnonymous() == null ? other.getEvaluateAnonymous() == null : this.getEvaluateAnonymous().equals(other.getEvaluateAnonymous()))
            && (this.getEvaluateIsimage() == null ? other.getEvaluateIsimage() == null : this.getEvaluateIsimage().equals(other.getEvaluateIsimage()))
            && (this.getEvaluateText() == null ? other.getEvaluateText() == null : this.getEvaluateText().equals(other.getEvaluateText()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEvaluateId() == null) ? 0 : getEvaluateId().hashCode());
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getEvaluateImg() == null) ? 0 : getEvaluateImg().hashCode());
        result = prime * result + ((getDescribeScore() == null) ? 0 : getDescribeScore().hashCode());
        result = prime * result + ((getLogisticsScore() == null) ? 0 : getLogisticsScore().hashCode());
        result = prime * result + ((getServiceScore() == null) ? 0 : getServiceScore().hashCode());
        result = prime * result + ((getEvaluateTime() == null) ? 0 : getEvaluateTime().hashCode());
        result = prime * result + ((getIsAnonymous() == null) ? 0 : getIsAnonymous().hashCode());
        result = prime * result + ((getEvaluateStatus() == null) ? 0 : getEvaluateStatus().hashCode());
        result = prime * result + ((getEvaluateAnonymous() == null) ? 0 : getEvaluateAnonymous().hashCode());
        result = prime * result + ((getEvaluateIsimage() == null) ? 0 : getEvaluateIsimage().hashCode());
        result = prime * result + ((getEvaluateText() == null) ? 0 : getEvaluateText().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", evaluateId=").append(evaluateId);
        sb.append(", bookId=").append(bookId);
        sb.append(", custId=").append(custId);
        sb.append(", evaluateImg=").append(evaluateImg);
        sb.append(", describeScore=").append(describeScore);
        sb.append(", logisticsScore=").append(logisticsScore);
        sb.append(", serviceScore=").append(serviceScore);
        sb.append(", evaluateTime=").append(evaluateTime);
        sb.append(", isAnonymous=").append(isAnonymous);
        sb.append(", evaluateStatus=").append(evaluateStatus);
        sb.append(", evaluateAnonymous=").append(evaluateAnonymous);
        sb.append(", evaluateIsimage=").append(evaluateIsimage);
        sb.append(", evaluateText=").append(evaluateText);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}