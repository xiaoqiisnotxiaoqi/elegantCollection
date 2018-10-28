package com.elegantcollection.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * book
 * @author 
 */
public class Book implements Serializable {
    /**
     * 图书ID
     */
    private Integer bookId;

    /**
     * 图书名称
     */
    private String bookName;

    /**
     * 作者ID
     */
    private Integer authorId;

    /**
     * 出版社名称
     */
    private String publishingName;

    /**
     * ISBN码
     */
    private Long bookIsbn;

    /**
     * 版次
     */
    private String bookEdition;

    /**
     * 页数
     */
    private Integer bookPagination;

    /**
     * 开本
     */
    private Integer bookSize;

    /**
     * 出版时间
     */
    private Date bookTime;

    /**
     * 字数
     */
    private Integer bookWordCount;

    /**
     * 标价
     */
    private Float bookMarkedPrice;

    /**
     * 售价
     */
    private Float bookSellingPrice;

    /**
     * 库存
     */
    private Integer bookStock;

    /**
     * 状态
     */
    private Integer bookStatus;

    /**
     * 总销量
     */
    private Integer bookSalesTotal;

    /**
     * 上月销量
     */
    private Integer bookSalesLastMonth;

    /**
     * 当前月销量
     */
    private Integer bookSalesVolumo;

    /**
     * 图书图片
     */
    private String bookImg;

    /**
     * 主类别
     */
    private Integer bookMainCategory;

    /**
     * 分类别1
     */
    private Integer bookFirstCategory;

    /**
     * 分类别2
     */
    private Integer bookSecondCategory;

    /**
     * 包装
     */
    private String bookPacking;

    /**
     * 译者id
     */
    private Integer translatorId;

    /**
     * 语种
     */
    private String bookLanguage;

    /**
     * 折扣信息(组合优惠)
     */
    private String redundancyField;

    /**
     * 折扣信息(满减)
     */
    private String redundancyField2;

    private static final long serialVersionUID = 1L;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getPublishingName() {
        return publishingName;
    }

    public void setPublishingName(String publishingName) {
        this.publishingName = publishingName;
    }

    public Long getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(Long bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(String bookEdition) {
        this.bookEdition = bookEdition;
    }

    public Integer getBookPagination() {
        return bookPagination;
    }

    public void setBookPagination(Integer bookPagination) {
        this.bookPagination = bookPagination;
    }

    public Integer getBookSize() {
        return bookSize;
    }

    public void setBookSize(Integer bookSize) {
        this.bookSize = bookSize;
    }

    public Date getBookTime() {
        return bookTime;
    }

    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }

    public Integer getBookWordCount() {
        return bookWordCount;
    }

    public void setBookWordCount(Integer bookWordCount) {
        this.bookWordCount = bookWordCount;
    }

    public Float getBookMarkedPrice() {
        return bookMarkedPrice;
    }

    public void setBookMarkedPrice(Float bookMarkedPrice) {
        this.bookMarkedPrice = bookMarkedPrice;
    }

    public Float getBookSellingPrice() {
        return bookSellingPrice;
    }

    public void setBookSellingPrice(Float bookSellingPrice) {
        this.bookSellingPrice = bookSellingPrice;
    }

    public Integer getBookStock() {
        return bookStock;
    }

    public void setBookStock(Integer bookStock) {
        this.bookStock = bookStock;
    }

    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Integer getBookSalesTotal() {
        return bookSalesTotal;
    }

    public void setBookSalesTotal(Integer bookSalesTotal) {
        this.bookSalesTotal = bookSalesTotal;
    }

    public Integer getBookSalesLastMonth() {
        return bookSalesLastMonth;
    }

    public void setBookSalesLastMonth(Integer bookSalesLastMonth) {
        this.bookSalesLastMonth = bookSalesLastMonth;
    }

    public Integer getBookSalesVolumo() {
        return bookSalesVolumo;
    }

    public void setBookSalesVolumo(Integer bookSalesVolumo) {
        this.bookSalesVolumo = bookSalesVolumo;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public Integer getBookMainCategory() {
        return bookMainCategory;
    }

    public void setBookMainCategory(Integer bookMainCategory) {
        this.bookMainCategory = bookMainCategory;
    }

    public Integer getBookFirstCategory() {
        return bookFirstCategory;
    }

    public void setBookFirstCategory(Integer bookFirstCategory) {
        this.bookFirstCategory = bookFirstCategory;
    }

    public Integer getBookSecondCategory() {
        return bookSecondCategory;
    }

    public void setBookSecondCategory(Integer bookSecondCategory) {
        this.bookSecondCategory = bookSecondCategory;
    }

    public String getBookPacking() {
        return bookPacking;
    }

    public void setBookPacking(String bookPacking) {
        this.bookPacking = bookPacking;
    }

    public Integer getTranslatorId() {
        return translatorId;
    }

    public void setTranslatorId(Integer translatorId) {
        this.translatorId = translatorId;
    }

    public String getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage;
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
        Book other = (Book) that;
        return (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
            && (this.getBookName() == null ? other.getBookName() == null : this.getBookName().equals(other.getBookName()))
            && (this.getAuthorId() == null ? other.getAuthorId() == null : this.getAuthorId().equals(other.getAuthorId()))
            && (this.getPublishingName() == null ? other.getPublishingName() == null : this.getPublishingName().equals(other.getPublishingName()))
            && (this.getBookIsbn() == null ? other.getBookIsbn() == null : this.getBookIsbn().equals(other.getBookIsbn()))
            && (this.getBookEdition() == null ? other.getBookEdition() == null : this.getBookEdition().equals(other.getBookEdition()))
            && (this.getBookPagination() == null ? other.getBookPagination() == null : this.getBookPagination().equals(other.getBookPagination()))
            && (this.getBookSize() == null ? other.getBookSize() == null : this.getBookSize().equals(other.getBookSize()))
            && (this.getBookTime() == null ? other.getBookTime() == null : this.getBookTime().equals(other.getBookTime()))
            && (this.getBookWordCount() == null ? other.getBookWordCount() == null : this.getBookWordCount().equals(other.getBookWordCount()))
            && (this.getBookMarkedPrice() == null ? other.getBookMarkedPrice() == null : this.getBookMarkedPrice().equals(other.getBookMarkedPrice()))
            && (this.getBookSellingPrice() == null ? other.getBookSellingPrice() == null : this.getBookSellingPrice().equals(other.getBookSellingPrice()))
            && (this.getBookStock() == null ? other.getBookStock() == null : this.getBookStock().equals(other.getBookStock()))
            && (this.getBookStatus() == null ? other.getBookStatus() == null : this.getBookStatus().equals(other.getBookStatus()))
            && (this.getBookSalesTotal() == null ? other.getBookSalesTotal() == null : this.getBookSalesTotal().equals(other.getBookSalesTotal()))
            && (this.getBookSalesLastMonth() == null ? other.getBookSalesLastMonth() == null : this.getBookSalesLastMonth().equals(other.getBookSalesLastMonth()))
            && (this.getBookSalesVolumo() == null ? other.getBookSalesVolumo() == null : this.getBookSalesVolumo().equals(other.getBookSalesVolumo()))
            && (this.getBookImg() == null ? other.getBookImg() == null : this.getBookImg().equals(other.getBookImg()))
            && (this.getBookMainCategory() == null ? other.getBookMainCategory() == null : this.getBookMainCategory().equals(other.getBookMainCategory()))
            && (this.getBookFirstCategory() == null ? other.getBookFirstCategory() == null : this.getBookFirstCategory().equals(other.getBookFirstCategory()))
            && (this.getBookSecondCategory() == null ? other.getBookSecondCategory() == null : this.getBookSecondCategory().equals(other.getBookSecondCategory()))
            && (this.getBookPacking() == null ? other.getBookPacking() == null : this.getBookPacking().equals(other.getBookPacking()))
            && (this.getTranslatorId() == null ? other.getTranslatorId() == null : this.getTranslatorId().equals(other.getTranslatorId()))
            && (this.getBookLanguage() == null ? other.getBookLanguage() == null : this.getBookLanguage().equals(other.getBookLanguage()))
            && (this.getRedundancyField() == null ? other.getRedundancyField() == null : this.getRedundancyField().equals(other.getRedundancyField()))
            && (this.getRedundancyField2() == null ? other.getRedundancyField2() == null : this.getRedundancyField2().equals(other.getRedundancyField2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        result = prime * result + ((getBookName() == null) ? 0 : getBookName().hashCode());
        result = prime * result + ((getAuthorId() == null) ? 0 : getAuthorId().hashCode());
        result = prime * result + ((getPublishingName() == null) ? 0 : getPublishingName().hashCode());
        result = prime * result + ((getBookIsbn() == null) ? 0 : getBookIsbn().hashCode());
        result = prime * result + ((getBookEdition() == null) ? 0 : getBookEdition().hashCode());
        result = prime * result + ((getBookPagination() == null) ? 0 : getBookPagination().hashCode());
        result = prime * result + ((getBookSize() == null) ? 0 : getBookSize().hashCode());
        result = prime * result + ((getBookTime() == null) ? 0 : getBookTime().hashCode());
        result = prime * result + ((getBookWordCount() == null) ? 0 : getBookWordCount().hashCode());
        result = prime * result + ((getBookMarkedPrice() == null) ? 0 : getBookMarkedPrice().hashCode());
        result = prime * result + ((getBookSellingPrice() == null) ? 0 : getBookSellingPrice().hashCode());
        result = prime * result + ((getBookStock() == null) ? 0 : getBookStock().hashCode());
        result = prime * result + ((getBookStatus() == null) ? 0 : getBookStatus().hashCode());
        result = prime * result + ((getBookSalesTotal() == null) ? 0 : getBookSalesTotal().hashCode());
        result = prime * result + ((getBookSalesLastMonth() == null) ? 0 : getBookSalesLastMonth().hashCode());
        result = prime * result + ((getBookSalesVolumo() == null) ? 0 : getBookSalesVolumo().hashCode());
        result = prime * result + ((getBookImg() == null) ? 0 : getBookImg().hashCode());
        result = prime * result + ((getBookMainCategory() == null) ? 0 : getBookMainCategory().hashCode());
        result = prime * result + ((getBookFirstCategory() == null) ? 0 : getBookFirstCategory().hashCode());
        result = prime * result + ((getBookSecondCategory() == null) ? 0 : getBookSecondCategory().hashCode());
        result = prime * result + ((getBookPacking() == null) ? 0 : getBookPacking().hashCode());
        result = prime * result + ((getTranslatorId() == null) ? 0 : getTranslatorId().hashCode());
        result = prime * result + ((getBookLanguage() == null) ? 0 : getBookLanguage().hashCode());
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
        sb.append(", bookId=").append(bookId);
        sb.append(", bookName=").append(bookName);
        sb.append(", authorId=").append(authorId);
        sb.append(", publishingName=").append(publishingName);
        sb.append(", bookIsbn=").append(bookIsbn);
        sb.append(", bookEdition=").append(bookEdition);
        sb.append(", bookPagination=").append(bookPagination);
        sb.append(", bookSize=").append(bookSize);
        sb.append(", bookTime=").append(bookTime);
        sb.append(", bookWordCount=").append(bookWordCount);
        sb.append(", bookMarkedPrice=").append(bookMarkedPrice);
        sb.append(", bookSellingPrice=").append(bookSellingPrice);
        sb.append(", bookStock=").append(bookStock);
        sb.append(", bookStatus=").append(bookStatus);
        sb.append(", bookSalesTotal=").append(bookSalesTotal);
        sb.append(", bookSalesLastMonth=").append(bookSalesLastMonth);
        sb.append(", bookSalesVolumo=").append(bookSalesVolumo);
        sb.append(", bookImg=").append(bookImg);
        sb.append(", bookMainCategory=").append(bookMainCategory);
        sb.append(", bookFirstCategory=").append(bookFirstCategory);
        sb.append(", bookSecondCategory=").append(bookSecondCategory);
        sb.append(", bookPacking=").append(bookPacking);
        sb.append(", translatorId=").append(translatorId);
        sb.append(", bookLanguage=").append(bookLanguage);
        sb.append(", redundancyField=").append(redundancyField);
        sb.append(", redundancyField2=").append(redundancyField2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}