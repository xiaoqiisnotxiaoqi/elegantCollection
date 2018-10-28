package com.elegantcollection.entity;

import java.io.Serializable;

/**
 * book
 * @author 
 */
public class BookWithBLOBs extends Book implements Serializable {
    /**
     * 图书简介
     */
    private String bookIntro;

    /**
     * 目录
     */
    private String bookCatalog;

    /**
     * 精彩书篇
     */
    private String bookWonderful;

    /**
     * 媒体评价
     */
    private String bookMediaEvaluation;

    private static final long serialVersionUID = 1L;

    public String getBookIntro() {
        return bookIntro;
    }

    public void setBookIntro(String bookIntro) {
        this.bookIntro = bookIntro;
    }

    public String getBookCatalog() {
        return bookCatalog;
    }

    public void setBookCatalog(String bookCatalog) {
        this.bookCatalog = bookCatalog;
    }

    public String getBookWonderful() {
        return bookWonderful;
    }

    public void setBookWonderful(String bookWonderful) {
        this.bookWonderful = bookWonderful;
    }

    public String getBookMediaEvaluation() {
        return bookMediaEvaluation;
    }

    public void setBookMediaEvaluation(String bookMediaEvaluation) {
        this.bookMediaEvaluation = bookMediaEvaluation;
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
        BookWithBLOBs other = (BookWithBLOBs) that;
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
            && (this.getRedundancyField2() == null ? other.getRedundancyField2() == null : this.getRedundancyField2().equals(other.getRedundancyField2()))
            && (this.getBookIntro() == null ? other.getBookIntro() == null : this.getBookIntro().equals(other.getBookIntro()))
            && (this.getBookCatalog() == null ? other.getBookCatalog() == null : this.getBookCatalog().equals(other.getBookCatalog()))
            && (this.getBookWonderful() == null ? other.getBookWonderful() == null : this.getBookWonderful().equals(other.getBookWonderful()))
            && (this.getBookMediaEvaluation() == null ? other.getBookMediaEvaluation() == null : this.getBookMediaEvaluation().equals(other.getBookMediaEvaluation()));
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
        result = prime * result + ((getBookIntro() == null) ? 0 : getBookIntro().hashCode());
        result = prime * result + ((getBookCatalog() == null) ? 0 : getBookCatalog().hashCode());
        result = prime * result + ((getBookWonderful() == null) ? 0 : getBookWonderful().hashCode());
        result = prime * result + ((getBookMediaEvaluation() == null) ? 0 : getBookMediaEvaluation().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bookIntro=").append(bookIntro);
        sb.append(", bookCatalog=").append(bookCatalog);
        sb.append(", bookWonderful=").append(bookWonderful);
        sb.append(", bookMediaEvaluation=").append(bookMediaEvaluation);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}