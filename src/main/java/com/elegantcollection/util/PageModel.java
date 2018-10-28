package com.elegantcollection.util;

import java.util.List;
import java.util.Objects;

public class PageModel<T>{
    /**
     * 每页显示记录数
     */
    private Integer pageSize = 4;
    /**
     * 总记录数
     */
    private Integer totalRecord ;
    /**
     *  总页数
     */
    private Integer totalPages;
    /**
     * 当前页码
     */
    private Integer currentPageCode;
    /**
     *  从第几条记录开始显示
     */
    private Integer startRecord;
    /**
     * 到第几条记录结束显示
     */
    private Integer endRecord;
    /**
     * 当前页显示记录对象集合
     */
    private List<T> modelList;

    public PageModel() {
    }

    public PageModel(Integer pageSize, Integer totalRecord, Integer totalPages,
                     Integer currentPageCode,
                     Integer startRecord, Integer endRecord, List<T> modelList) {
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        this.totalPages = totalPages;
        this.currentPageCode = currentPageCode;
        this.startRecord = startRecord;
        this.endRecord = endRecord;
        this.modelList = modelList;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getCurrentPageCode() {
        return currentPageCode;
    }

    public void setCurrentPageCode(Integer currentPageCode) {
        this.currentPageCode = currentPageCode;
    }

    public Integer getStartRecord() {
        return startRecord;
    }

    public void setStartRecord(Integer startRecord) {
        this.startRecord = startRecord;
    }

    public Integer getEndRecord() {
        return endRecord;
    }

    public void setEndRecord(Integer endRecord) {
        this.endRecord = endRecord;
    }

    public List<T> getModelList() {
        return modelList;
    }

    public void setModelList(List<T> modelList) {
        this.modelList = modelList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageModel<?> pageModel = (PageModel<?>) o;
        return Objects.equals(pageSize, pageModel.pageSize) &&
                Objects.equals(totalRecord, pageModel.totalRecord) &&
                Objects.equals(totalPages, pageModel.totalPages) &&
                Objects.equals(currentPageCode, pageModel.currentPageCode) &&
                Objects.equals(startRecord, pageModel.startRecord) &&
                Objects.equals(endRecord, pageModel.endRecord) &&
                Objects.equals(modelList, pageModel.modelList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pageSize, totalRecord, totalPages, currentPageCode, startRecord, endRecord, modelList);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"pageSize\":")
                .append(pageSize);
        sb.append(",\"totalRecord\":")
                .append(totalRecord);
        sb.append(",\"totalPages\":")
                .append(totalPages);
        sb.append(",\"currentPageCode\":")
                .append(currentPageCode);
        sb.append(",\"startRecord\":")
                .append(startRecord);
        sb.append(",\"endRecord\":")
                .append(endRecord);
        sb.append(",\"modelList\":")
                .append(modelList);
        sb.append('}');
        return sb.toString();
    }
}
