package com.elegantcollection.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public BookExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andBookIdIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(Integer value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(Integer value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(Integer value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(Integer value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<Integer> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<Integer> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(Integer value1, Integer value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("book_name is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("book_name =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("book_name <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("book_name >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("book_name >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("book_name <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("book_name <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("book_name like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("book_name not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("book_name in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("book_name not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("book_name between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("book_name not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNull() {
            addCriterion("author_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNotNull() {
            addCriterion("author_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdEqualTo(Integer value) {
            addCriterion("author_id =", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotEqualTo(Integer value) {
            addCriterion("author_id <>", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThan(Integer value) {
            addCriterion("author_id >", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("author_id >=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThan(Integer value) {
            addCriterion("author_id <", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThanOrEqualTo(Integer value) {
            addCriterion("author_id <=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIn(List<Integer> values) {
            addCriterion("author_id in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotIn(List<Integer> values) {
            addCriterion("author_id not in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdBetween(Integer value1, Integer value2) {
            addCriterion("author_id between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("author_id not between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andPublishingNameIsNull() {
            addCriterion("publishing_name is null");
            return (Criteria) this;
        }

        public Criteria andPublishingNameIsNotNull() {
            addCriterion("publishing_name is not null");
            return (Criteria) this;
        }

        public Criteria andPublishingNameEqualTo(String value) {
            addCriterion("publishing_name =", value, "publishingName");
            return (Criteria) this;
        }

        public Criteria andPublishingNameNotEqualTo(String value) {
            addCriterion("publishing_name <>", value, "publishingName");
            return (Criteria) this;
        }

        public Criteria andPublishingNameGreaterThan(String value) {
            addCriterion("publishing_name >", value, "publishingName");
            return (Criteria) this;
        }

        public Criteria andPublishingNameGreaterThanOrEqualTo(String value) {
            addCriterion("publishing_name >=", value, "publishingName");
            return (Criteria) this;
        }

        public Criteria andPublishingNameLessThan(String value) {
            addCriterion("publishing_name <", value, "publishingName");
            return (Criteria) this;
        }

        public Criteria andPublishingNameLessThanOrEqualTo(String value) {
            addCriterion("publishing_name <=", value, "publishingName");
            return (Criteria) this;
        }

        public Criteria andPublishingNameLike(String value) {
            addCriterion("publishing_name like", value, "publishingName");
            return (Criteria) this;
        }

        public Criteria andPublishingNameNotLike(String value) {
            addCriterion("publishing_name not like", value, "publishingName");
            return (Criteria) this;
        }

        public Criteria andPublishingNameIn(List<String> values) {
            addCriterion("publishing_name in", values, "publishingName");
            return (Criteria) this;
        }

        public Criteria andPublishingNameNotIn(List<String> values) {
            addCriterion("publishing_name not in", values, "publishingName");
            return (Criteria) this;
        }

        public Criteria andPublishingNameBetween(String value1, String value2) {
            addCriterion("publishing_name between", value1, value2, "publishingName");
            return (Criteria) this;
        }

        public Criteria andPublishingNameNotBetween(String value1, String value2) {
            addCriterion("publishing_name not between", value1, value2, "publishingName");
            return (Criteria) this;
        }

        public Criteria andBookIsbnIsNull() {
            addCriterion("book_isbn is null");
            return (Criteria) this;
        }

        public Criteria andBookIsbnIsNotNull() {
            addCriterion("book_isbn is not null");
            return (Criteria) this;
        }

        public Criteria andBookIsbnEqualTo(Long value) {
            addCriterion("book_isbn =", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnNotEqualTo(Long value) {
            addCriterion("book_isbn <>", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnGreaterThan(Long value) {
            addCriterion("book_isbn >", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnGreaterThanOrEqualTo(Long value) {
            addCriterion("book_isbn >=", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnLessThan(Long value) {
            addCriterion("book_isbn <", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnLessThanOrEqualTo(Long value) {
            addCriterion("book_isbn <=", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnIn(List<Long> values) {
            addCriterion("book_isbn in", values, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnNotIn(List<Long> values) {
            addCriterion("book_isbn not in", values, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnBetween(Long value1, Long value2) {
            addCriterion("book_isbn between", value1, value2, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnNotBetween(Long value1, Long value2) {
            addCriterion("book_isbn not between", value1, value2, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookEditionIsNull() {
            addCriterion("book_edition is null");
            return (Criteria) this;
        }

        public Criteria andBookEditionIsNotNull() {
            addCriterion("book_edition is not null");
            return (Criteria) this;
        }

        public Criteria andBookEditionEqualTo(String value) {
            addCriterion("book_edition =", value, "bookEdition");
            return (Criteria) this;
        }

        public Criteria andBookEditionNotEqualTo(String value) {
            addCriterion("book_edition <>", value, "bookEdition");
            return (Criteria) this;
        }

        public Criteria andBookEditionGreaterThan(String value) {
            addCriterion("book_edition >", value, "bookEdition");
            return (Criteria) this;
        }

        public Criteria andBookEditionGreaterThanOrEqualTo(String value) {
            addCriterion("book_edition >=", value, "bookEdition");
            return (Criteria) this;
        }

        public Criteria andBookEditionLessThan(String value) {
            addCriterion("book_edition <", value, "bookEdition");
            return (Criteria) this;
        }

        public Criteria andBookEditionLessThanOrEqualTo(String value) {
            addCriterion("book_edition <=", value, "bookEdition");
            return (Criteria) this;
        }

        public Criteria andBookEditionLike(String value) {
            addCriterion("book_edition like", value, "bookEdition");
            return (Criteria) this;
        }

        public Criteria andBookEditionNotLike(String value) {
            addCriterion("book_edition not like", value, "bookEdition");
            return (Criteria) this;
        }

        public Criteria andBookEditionIn(List<String> values) {
            addCriterion("book_edition in", values, "bookEdition");
            return (Criteria) this;
        }

        public Criteria andBookEditionNotIn(List<String> values) {
            addCriterion("book_edition not in", values, "bookEdition");
            return (Criteria) this;
        }

        public Criteria andBookEditionBetween(String value1, String value2) {
            addCriterion("book_edition between", value1, value2, "bookEdition");
            return (Criteria) this;
        }

        public Criteria andBookEditionNotBetween(String value1, String value2) {
            addCriterion("book_edition not between", value1, value2, "bookEdition");
            return (Criteria) this;
        }

        public Criteria andBookPaginationIsNull() {
            addCriterion("book_pagination is null");
            return (Criteria) this;
        }

        public Criteria andBookPaginationIsNotNull() {
            addCriterion("book_pagination is not null");
            return (Criteria) this;
        }

        public Criteria andBookPaginationEqualTo(Integer value) {
            addCriterion("book_pagination =", value, "bookPagination");
            return (Criteria) this;
        }

        public Criteria andBookPaginationNotEqualTo(Integer value) {
            addCriterion("book_pagination <>", value, "bookPagination");
            return (Criteria) this;
        }

        public Criteria andBookPaginationGreaterThan(Integer value) {
            addCriterion("book_pagination >", value, "bookPagination");
            return (Criteria) this;
        }

        public Criteria andBookPaginationGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_pagination >=", value, "bookPagination");
            return (Criteria) this;
        }

        public Criteria andBookPaginationLessThan(Integer value) {
            addCriterion("book_pagination <", value, "bookPagination");
            return (Criteria) this;
        }

        public Criteria andBookPaginationLessThanOrEqualTo(Integer value) {
            addCriterion("book_pagination <=", value, "bookPagination");
            return (Criteria) this;
        }

        public Criteria andBookPaginationIn(List<Integer> values) {
            addCriterion("book_pagination in", values, "bookPagination");
            return (Criteria) this;
        }

        public Criteria andBookPaginationNotIn(List<Integer> values) {
            addCriterion("book_pagination not in", values, "bookPagination");
            return (Criteria) this;
        }

        public Criteria andBookPaginationBetween(Integer value1, Integer value2) {
            addCriterion("book_pagination between", value1, value2, "bookPagination");
            return (Criteria) this;
        }

        public Criteria andBookPaginationNotBetween(Integer value1, Integer value2) {
            addCriterion("book_pagination not between", value1, value2, "bookPagination");
            return (Criteria) this;
        }

        public Criteria andBookSizeIsNull() {
            addCriterion("book_size is null");
            return (Criteria) this;
        }

        public Criteria andBookSizeIsNotNull() {
            addCriterion("book_size is not null");
            return (Criteria) this;
        }

        public Criteria andBookSizeEqualTo(Integer value) {
            addCriterion("book_size =", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeNotEqualTo(Integer value) {
            addCriterion("book_size <>", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeGreaterThan(Integer value) {
            addCriterion("book_size >", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_size >=", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeLessThan(Integer value) {
            addCriterion("book_size <", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeLessThanOrEqualTo(Integer value) {
            addCriterion("book_size <=", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeIn(List<Integer> values) {
            addCriterion("book_size in", values, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeNotIn(List<Integer> values) {
            addCriterion("book_size not in", values, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeBetween(Integer value1, Integer value2) {
            addCriterion("book_size between", value1, value2, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("book_size not between", value1, value2, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookTimeIsNull() {
            addCriterion("book_time is null");
            return (Criteria) this;
        }

        public Criteria andBookTimeIsNotNull() {
            addCriterion("book_time is not null");
            return (Criteria) this;
        }

        public Criteria andBookTimeEqualTo(Date value) {
            addCriterionForJDBCDate("book_time =", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("book_time <>", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("book_time >", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("book_time >=", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeLessThan(Date value) {
            addCriterionForJDBCDate("book_time <", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("book_time <=", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeIn(List<Date> values) {
            addCriterionForJDBCDate("book_time in", values, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("book_time not in", values, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("book_time between", value1, value2, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("book_time not between", value1, value2, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookWordCountIsNull() {
            addCriterion("book_word_count is null");
            return (Criteria) this;
        }

        public Criteria andBookWordCountIsNotNull() {
            addCriterion("book_word_count is not null");
            return (Criteria) this;
        }

        public Criteria andBookWordCountEqualTo(Integer value) {
            addCriterion("book_word_count =", value, "bookWordCount");
            return (Criteria) this;
        }

        public Criteria andBookWordCountNotEqualTo(Integer value) {
            addCriterion("book_word_count <>", value, "bookWordCount");
            return (Criteria) this;
        }

        public Criteria andBookWordCountGreaterThan(Integer value) {
            addCriterion("book_word_count >", value, "bookWordCount");
            return (Criteria) this;
        }

        public Criteria andBookWordCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_word_count >=", value, "bookWordCount");
            return (Criteria) this;
        }

        public Criteria andBookWordCountLessThan(Integer value) {
            addCriterion("book_word_count <", value, "bookWordCount");
            return (Criteria) this;
        }

        public Criteria andBookWordCountLessThanOrEqualTo(Integer value) {
            addCriterion("book_word_count <=", value, "bookWordCount");
            return (Criteria) this;
        }

        public Criteria andBookWordCountIn(List<Integer> values) {
            addCriterion("book_word_count in", values, "bookWordCount");
            return (Criteria) this;
        }

        public Criteria andBookWordCountNotIn(List<Integer> values) {
            addCriterion("book_word_count not in", values, "bookWordCount");
            return (Criteria) this;
        }

        public Criteria andBookWordCountBetween(Integer value1, Integer value2) {
            addCriterion("book_word_count between", value1, value2, "bookWordCount");
            return (Criteria) this;
        }

        public Criteria andBookWordCountNotBetween(Integer value1, Integer value2) {
            addCriterion("book_word_count not between", value1, value2, "bookWordCount");
            return (Criteria) this;
        }

        public Criteria andBookMarkedPriceIsNull() {
            addCriterion("book_marked_price is null");
            return (Criteria) this;
        }

        public Criteria andBookMarkedPriceIsNotNull() {
            addCriterion("book_marked_price is not null");
            return (Criteria) this;
        }

        public Criteria andBookMarkedPriceEqualTo(Float value) {
            addCriterion("book_marked_price =", value, "bookMarkedPrice");
            return (Criteria) this;
        }

        public Criteria andBookMarkedPriceNotEqualTo(Float value) {
            addCriterion("book_marked_price <>", value, "bookMarkedPrice");
            return (Criteria) this;
        }

        public Criteria andBookMarkedPriceGreaterThan(Float value) {
            addCriterion("book_marked_price >", value, "bookMarkedPrice");
            return (Criteria) this;
        }

        public Criteria andBookMarkedPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("book_marked_price >=", value, "bookMarkedPrice");
            return (Criteria) this;
        }

        public Criteria andBookMarkedPriceLessThan(Float value) {
            addCriterion("book_marked_price <", value, "bookMarkedPrice");
            return (Criteria) this;
        }

        public Criteria andBookMarkedPriceLessThanOrEqualTo(Float value) {
            addCriterion("book_marked_price <=", value, "bookMarkedPrice");
            return (Criteria) this;
        }

        public Criteria andBookMarkedPriceIn(List<Float> values) {
            addCriterion("book_marked_price in", values, "bookMarkedPrice");
            return (Criteria) this;
        }

        public Criteria andBookMarkedPriceNotIn(List<Float> values) {
            addCriterion("book_marked_price not in", values, "bookMarkedPrice");
            return (Criteria) this;
        }

        public Criteria andBookMarkedPriceBetween(Float value1, Float value2) {
            addCriterion("book_marked_price between", value1, value2, "bookMarkedPrice");
            return (Criteria) this;
        }

        public Criteria andBookMarkedPriceNotBetween(Float value1, Float value2) {
            addCriterion("book_marked_price not between", value1, value2, "bookMarkedPrice");
            return (Criteria) this;
        }

        public Criteria andBookSellingPriceIsNull() {
            addCriterion("book_selling_price is null");
            return (Criteria) this;
        }

        public Criteria andBookSellingPriceIsNotNull() {
            addCriterion("book_selling_price is not null");
            return (Criteria) this;
        }

        public Criteria andBookSellingPriceEqualTo(Float value) {
            addCriterion("book_selling_price =", value, "bookSellingPrice");
            return (Criteria) this;
        }

        public Criteria andBookSellingPriceNotEqualTo(Float value) {
            addCriterion("book_selling_price <>", value, "bookSellingPrice");
            return (Criteria) this;
        }

        public Criteria andBookSellingPriceGreaterThan(Float value) {
            addCriterion("book_selling_price >", value, "bookSellingPrice");
            return (Criteria) this;
        }

        public Criteria andBookSellingPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("book_selling_price >=", value, "bookSellingPrice");
            return (Criteria) this;
        }

        public Criteria andBookSellingPriceLessThan(Float value) {
            addCriterion("book_selling_price <", value, "bookSellingPrice");
            return (Criteria) this;
        }

        public Criteria andBookSellingPriceLessThanOrEqualTo(Float value) {
            addCriterion("book_selling_price <=", value, "bookSellingPrice");
            return (Criteria) this;
        }

        public Criteria andBookSellingPriceIn(List<Float> values) {
            addCriterion("book_selling_price in", values, "bookSellingPrice");
            return (Criteria) this;
        }

        public Criteria andBookSellingPriceNotIn(List<Float> values) {
            addCriterion("book_selling_price not in", values, "bookSellingPrice");
            return (Criteria) this;
        }

        public Criteria andBookSellingPriceBetween(Float value1, Float value2) {
            addCriterion("book_selling_price between", value1, value2, "bookSellingPrice");
            return (Criteria) this;
        }

        public Criteria andBookSellingPriceNotBetween(Float value1, Float value2) {
            addCriterion("book_selling_price not between", value1, value2, "bookSellingPrice");
            return (Criteria) this;
        }

        public Criteria andBookStockIsNull() {
            addCriterion("book_stock is null");
            return (Criteria) this;
        }

        public Criteria andBookStockIsNotNull() {
            addCriterion("book_stock is not null");
            return (Criteria) this;
        }

        public Criteria andBookStockEqualTo(Integer value) {
            addCriterion("book_stock =", value, "bookStock");
            return (Criteria) this;
        }

        public Criteria andBookStockNotEqualTo(Integer value) {
            addCriterion("book_stock <>", value, "bookStock");
            return (Criteria) this;
        }

        public Criteria andBookStockGreaterThan(Integer value) {
            addCriterion("book_stock >", value, "bookStock");
            return (Criteria) this;
        }

        public Criteria andBookStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_stock >=", value, "bookStock");
            return (Criteria) this;
        }

        public Criteria andBookStockLessThan(Integer value) {
            addCriterion("book_stock <", value, "bookStock");
            return (Criteria) this;
        }

        public Criteria andBookStockLessThanOrEqualTo(Integer value) {
            addCriterion("book_stock <=", value, "bookStock");
            return (Criteria) this;
        }

        public Criteria andBookStockIn(List<Integer> values) {
            addCriterion("book_stock in", values, "bookStock");
            return (Criteria) this;
        }

        public Criteria andBookStockNotIn(List<Integer> values) {
            addCriterion("book_stock not in", values, "bookStock");
            return (Criteria) this;
        }

        public Criteria andBookStockBetween(Integer value1, Integer value2) {
            addCriterion("book_stock between", value1, value2, "bookStock");
            return (Criteria) this;
        }

        public Criteria andBookStockNotBetween(Integer value1, Integer value2) {
            addCriterion("book_stock not between", value1, value2, "bookStock");
            return (Criteria) this;
        }

        public Criteria andBookStatusIsNull() {
            addCriterion("book_status is null");
            return (Criteria) this;
        }

        public Criteria andBookStatusIsNotNull() {
            addCriterion("book_status is not null");
            return (Criteria) this;
        }

        public Criteria andBookStatusEqualTo(Integer value) {
            addCriterion("book_status =", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusNotEqualTo(Integer value) {
            addCriterion("book_status <>", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusGreaterThan(Integer value) {
            addCriterion("book_status >", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_status >=", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusLessThan(Integer value) {
            addCriterion("book_status <", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusLessThanOrEqualTo(Integer value) {
            addCriterion("book_status <=", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusIn(List<Integer> values) {
            addCriterion("book_status in", values, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusNotIn(List<Integer> values) {
            addCriterion("book_status not in", values, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusBetween(Integer value1, Integer value2) {
            addCriterion("book_status between", value1, value2, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("book_status not between", value1, value2, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookSalesTotalIsNull() {
            addCriterion("book_sales_total is null");
            return (Criteria) this;
        }

        public Criteria andBookSalesTotalIsNotNull() {
            addCriterion("book_sales_total is not null");
            return (Criteria) this;
        }

        public Criteria andBookSalesTotalEqualTo(Integer value) {
            addCriterion("book_sales_total =", value, "bookSalesTotal");
            return (Criteria) this;
        }

        public Criteria andBookSalesTotalNotEqualTo(Integer value) {
            addCriterion("book_sales_total <>", value, "bookSalesTotal");
            return (Criteria) this;
        }

        public Criteria andBookSalesTotalGreaterThan(Integer value) {
            addCriterion("book_sales_total >", value, "bookSalesTotal");
            return (Criteria) this;
        }

        public Criteria andBookSalesTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_sales_total >=", value, "bookSalesTotal");
            return (Criteria) this;
        }

        public Criteria andBookSalesTotalLessThan(Integer value) {
            addCriterion("book_sales_total <", value, "bookSalesTotal");
            return (Criteria) this;
        }

        public Criteria andBookSalesTotalLessThanOrEqualTo(Integer value) {
            addCriterion("book_sales_total <=", value, "bookSalesTotal");
            return (Criteria) this;
        }

        public Criteria andBookSalesTotalIn(List<Integer> values) {
            addCriterion("book_sales_total in", values, "bookSalesTotal");
            return (Criteria) this;
        }

        public Criteria andBookSalesTotalNotIn(List<Integer> values) {
            addCriterion("book_sales_total not in", values, "bookSalesTotal");
            return (Criteria) this;
        }

        public Criteria andBookSalesTotalBetween(Integer value1, Integer value2) {
            addCriterion("book_sales_total between", value1, value2, "bookSalesTotal");
            return (Criteria) this;
        }

        public Criteria andBookSalesTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("book_sales_total not between", value1, value2, "bookSalesTotal");
            return (Criteria) this;
        }

        public Criteria andBookSalesLastMonthIsNull() {
            addCriterion("book_sales_last_month is null");
            return (Criteria) this;
        }

        public Criteria andBookSalesLastMonthIsNotNull() {
            addCriterion("book_sales_last_month is not null");
            return (Criteria) this;
        }

        public Criteria andBookSalesLastMonthEqualTo(Integer value) {
            addCriterion("book_sales_last_month =", value, "bookSalesLastMonth");
            return (Criteria) this;
        }

        public Criteria andBookSalesLastMonthNotEqualTo(Integer value) {
            addCriterion("book_sales_last_month <>", value, "bookSalesLastMonth");
            return (Criteria) this;
        }

        public Criteria andBookSalesLastMonthGreaterThan(Integer value) {
            addCriterion("book_sales_last_month >", value, "bookSalesLastMonth");
            return (Criteria) this;
        }

        public Criteria andBookSalesLastMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_sales_last_month >=", value, "bookSalesLastMonth");
            return (Criteria) this;
        }

        public Criteria andBookSalesLastMonthLessThan(Integer value) {
            addCriterion("book_sales_last_month <", value, "bookSalesLastMonth");
            return (Criteria) this;
        }

        public Criteria andBookSalesLastMonthLessThanOrEqualTo(Integer value) {
            addCriterion("book_sales_last_month <=", value, "bookSalesLastMonth");
            return (Criteria) this;
        }

        public Criteria andBookSalesLastMonthIn(List<Integer> values) {
            addCriterion("book_sales_last_month in", values, "bookSalesLastMonth");
            return (Criteria) this;
        }

        public Criteria andBookSalesLastMonthNotIn(List<Integer> values) {
            addCriterion("book_sales_last_month not in", values, "bookSalesLastMonth");
            return (Criteria) this;
        }

        public Criteria andBookSalesLastMonthBetween(Integer value1, Integer value2) {
            addCriterion("book_sales_last_month between", value1, value2, "bookSalesLastMonth");
            return (Criteria) this;
        }

        public Criteria andBookSalesLastMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("book_sales_last_month not between", value1, value2, "bookSalesLastMonth");
            return (Criteria) this;
        }

        public Criteria andBookSalesVolumoIsNull() {
            addCriterion("book_sales_volumo is null");
            return (Criteria) this;
        }

        public Criteria andBookSalesVolumoIsNotNull() {
            addCriterion("book_sales_volumo is not null");
            return (Criteria) this;
        }

        public Criteria andBookSalesVolumoEqualTo(Integer value) {
            addCriterion("book_sales_volumo =", value, "bookSalesVolumo");
            return (Criteria) this;
        }

        public Criteria andBookSalesVolumoNotEqualTo(Integer value) {
            addCriterion("book_sales_volumo <>", value, "bookSalesVolumo");
            return (Criteria) this;
        }

        public Criteria andBookSalesVolumoGreaterThan(Integer value) {
            addCriterion("book_sales_volumo >", value, "bookSalesVolumo");
            return (Criteria) this;
        }

        public Criteria andBookSalesVolumoGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_sales_volumo >=", value, "bookSalesVolumo");
            return (Criteria) this;
        }

        public Criteria andBookSalesVolumoLessThan(Integer value) {
            addCriterion("book_sales_volumo <", value, "bookSalesVolumo");
            return (Criteria) this;
        }

        public Criteria andBookSalesVolumoLessThanOrEqualTo(Integer value) {
            addCriterion("book_sales_volumo <=", value, "bookSalesVolumo");
            return (Criteria) this;
        }

        public Criteria andBookSalesVolumoIn(List<Integer> values) {
            addCriterion("book_sales_volumo in", values, "bookSalesVolumo");
            return (Criteria) this;
        }

        public Criteria andBookSalesVolumoNotIn(List<Integer> values) {
            addCriterion("book_sales_volumo not in", values, "bookSalesVolumo");
            return (Criteria) this;
        }

        public Criteria andBookSalesVolumoBetween(Integer value1, Integer value2) {
            addCriterion("book_sales_volumo between", value1, value2, "bookSalesVolumo");
            return (Criteria) this;
        }

        public Criteria andBookSalesVolumoNotBetween(Integer value1, Integer value2) {
            addCriterion("book_sales_volumo not between", value1, value2, "bookSalesVolumo");
            return (Criteria) this;
        }

        public Criteria andBookImgIsNull() {
            addCriterion("book_img is null");
            return (Criteria) this;
        }

        public Criteria andBookImgIsNotNull() {
            addCriterion("book_img is not null");
            return (Criteria) this;
        }

        public Criteria andBookImgEqualTo(String value) {
            addCriterion("book_img =", value, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgNotEqualTo(String value) {
            addCriterion("book_img <>", value, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgGreaterThan(String value) {
            addCriterion("book_img >", value, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgGreaterThanOrEqualTo(String value) {
            addCriterion("book_img >=", value, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgLessThan(String value) {
            addCriterion("book_img <", value, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgLessThanOrEqualTo(String value) {
            addCriterion("book_img <=", value, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgLike(String value) {
            addCriterion("book_img like", value, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgNotLike(String value) {
            addCriterion("book_img not like", value, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgIn(List<String> values) {
            addCriterion("book_img in", values, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgNotIn(List<String> values) {
            addCriterion("book_img not in", values, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgBetween(String value1, String value2) {
            addCriterion("book_img between", value1, value2, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgNotBetween(String value1, String value2) {
            addCriterion("book_img not between", value1, value2, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookMainCategoryIsNull() {
            addCriterion("book_main_category is null");
            return (Criteria) this;
        }

        public Criteria andBookMainCategoryIsNotNull() {
            addCriterion("book_main_category is not null");
            return (Criteria) this;
        }

        public Criteria andBookMainCategoryEqualTo(Integer value) {
            addCriterion("book_main_category =", value, "bookMainCategory");
            return (Criteria) this;
        }

        public Criteria andBookMainCategoryNotEqualTo(Integer value) {
            addCriterion("book_main_category <>", value, "bookMainCategory");
            return (Criteria) this;
        }

        public Criteria andBookMainCategoryGreaterThan(Integer value) {
            addCriterion("book_main_category >", value, "bookMainCategory");
            return (Criteria) this;
        }

        public Criteria andBookMainCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_main_category >=", value, "bookMainCategory");
            return (Criteria) this;
        }

        public Criteria andBookMainCategoryLessThan(Integer value) {
            addCriterion("book_main_category <", value, "bookMainCategory");
            return (Criteria) this;
        }

        public Criteria andBookMainCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("book_main_category <=", value, "bookMainCategory");
            return (Criteria) this;
        }

        public Criteria andBookMainCategoryIn(List<Integer> values) {
            addCriterion("book_main_category in", values, "bookMainCategory");
            return (Criteria) this;
        }

        public Criteria andBookMainCategoryNotIn(List<Integer> values) {
            addCriterion("book_main_category not in", values, "bookMainCategory");
            return (Criteria) this;
        }

        public Criteria andBookMainCategoryBetween(Integer value1, Integer value2) {
            addCriterion("book_main_category between", value1, value2, "bookMainCategory");
            return (Criteria) this;
        }

        public Criteria andBookMainCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("book_main_category not between", value1, value2, "bookMainCategory");
            return (Criteria) this;
        }

        public Criteria andBookFirstCategoryIsNull() {
            addCriterion("book_first_category is null");
            return (Criteria) this;
        }

        public Criteria andBookFirstCategoryIsNotNull() {
            addCriterion("book_first_category is not null");
            return (Criteria) this;
        }

        public Criteria andBookFirstCategoryEqualTo(Integer value) {
            addCriterion("book_first_category =", value, "bookFirstCategory");
            return (Criteria) this;
        }

        public Criteria andBookFirstCategoryNotEqualTo(Integer value) {
            addCriterion("book_first_category <>", value, "bookFirstCategory");
            return (Criteria) this;
        }

        public Criteria andBookFirstCategoryGreaterThan(Integer value) {
            addCriterion("book_first_category >", value, "bookFirstCategory");
            return (Criteria) this;
        }

        public Criteria andBookFirstCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_first_category >=", value, "bookFirstCategory");
            return (Criteria) this;
        }

        public Criteria andBookFirstCategoryLessThan(Integer value) {
            addCriterion("book_first_category <", value, "bookFirstCategory");
            return (Criteria) this;
        }

        public Criteria andBookFirstCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("book_first_category <=", value, "bookFirstCategory");
            return (Criteria) this;
        }

        public Criteria andBookFirstCategoryIn(List<Integer> values) {
            addCriterion("book_first_category in", values, "bookFirstCategory");
            return (Criteria) this;
        }

        public Criteria andBookFirstCategoryNotIn(List<Integer> values) {
            addCriterion("book_first_category not in", values, "bookFirstCategory");
            return (Criteria) this;
        }

        public Criteria andBookFirstCategoryBetween(Integer value1, Integer value2) {
            addCriterion("book_first_category between", value1, value2, "bookFirstCategory");
            return (Criteria) this;
        }

        public Criteria andBookFirstCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("book_first_category not between", value1, value2, "bookFirstCategory");
            return (Criteria) this;
        }

        public Criteria andBookSecondCategoryIsNull() {
            addCriterion("book_second_category is null");
            return (Criteria) this;
        }

        public Criteria andBookSecondCategoryIsNotNull() {
            addCriterion("book_second_category is not null");
            return (Criteria) this;
        }

        public Criteria andBookSecondCategoryEqualTo(Integer value) {
            addCriterion("book_second_category =", value, "bookSecondCategory");
            return (Criteria) this;
        }

        public Criteria andBookSecondCategoryNotEqualTo(Integer value) {
            addCriterion("book_second_category <>", value, "bookSecondCategory");
            return (Criteria) this;
        }

        public Criteria andBookSecondCategoryGreaterThan(Integer value) {
            addCriterion("book_second_category >", value, "bookSecondCategory");
            return (Criteria) this;
        }

        public Criteria andBookSecondCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_second_category >=", value, "bookSecondCategory");
            return (Criteria) this;
        }

        public Criteria andBookSecondCategoryLessThan(Integer value) {
            addCriterion("book_second_category <", value, "bookSecondCategory");
            return (Criteria) this;
        }

        public Criteria andBookSecondCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("book_second_category <=", value, "bookSecondCategory");
            return (Criteria) this;
        }

        public Criteria andBookSecondCategoryIn(List<Integer> values) {
            addCriterion("book_second_category in", values, "bookSecondCategory");
            return (Criteria) this;
        }

        public Criteria andBookSecondCategoryNotIn(List<Integer> values) {
            addCriterion("book_second_category not in", values, "bookSecondCategory");
            return (Criteria) this;
        }

        public Criteria andBookSecondCategoryBetween(Integer value1, Integer value2) {
            addCriterion("book_second_category between", value1, value2, "bookSecondCategory");
            return (Criteria) this;
        }

        public Criteria andBookSecondCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("book_second_category not between", value1, value2, "bookSecondCategory");
            return (Criteria) this;
        }

        public Criteria andBookPackingIsNull() {
            addCriterion("book_packing is null");
            return (Criteria) this;
        }

        public Criteria andBookPackingIsNotNull() {
            addCriterion("book_packing is not null");
            return (Criteria) this;
        }

        public Criteria andBookPackingEqualTo(String value) {
            addCriterion("book_packing =", value, "bookPacking");
            return (Criteria) this;
        }

        public Criteria andBookPackingNotEqualTo(String value) {
            addCriterion("book_packing <>", value, "bookPacking");
            return (Criteria) this;
        }

        public Criteria andBookPackingGreaterThan(String value) {
            addCriterion("book_packing >", value, "bookPacking");
            return (Criteria) this;
        }

        public Criteria andBookPackingGreaterThanOrEqualTo(String value) {
            addCriterion("book_packing >=", value, "bookPacking");
            return (Criteria) this;
        }

        public Criteria andBookPackingLessThan(String value) {
            addCriterion("book_packing <", value, "bookPacking");
            return (Criteria) this;
        }

        public Criteria andBookPackingLessThanOrEqualTo(String value) {
            addCriterion("book_packing <=", value, "bookPacking");
            return (Criteria) this;
        }

        public Criteria andBookPackingLike(String value) {
            addCriterion("book_packing like", value, "bookPacking");
            return (Criteria) this;
        }

        public Criteria andBookPackingNotLike(String value) {
            addCriterion("book_packing not like", value, "bookPacking");
            return (Criteria) this;
        }

        public Criteria andBookPackingIn(List<String> values) {
            addCriterion("book_packing in", values, "bookPacking");
            return (Criteria) this;
        }

        public Criteria andBookPackingNotIn(List<String> values) {
            addCriterion("book_packing not in", values, "bookPacking");
            return (Criteria) this;
        }

        public Criteria andBookPackingBetween(String value1, String value2) {
            addCriterion("book_packing between", value1, value2, "bookPacking");
            return (Criteria) this;
        }

        public Criteria andBookPackingNotBetween(String value1, String value2) {
            addCriterion("book_packing not between", value1, value2, "bookPacking");
            return (Criteria) this;
        }

        public Criteria andTranslatorIdIsNull() {
            addCriterion("translator_id is null");
            return (Criteria) this;
        }

        public Criteria andTranslatorIdIsNotNull() {
            addCriterion("translator_id is not null");
            return (Criteria) this;
        }

        public Criteria andTranslatorIdEqualTo(Integer value) {
            addCriterion("translator_id =", value, "translatorId");
            return (Criteria) this;
        }

        public Criteria andTranslatorIdNotEqualTo(Integer value) {
            addCriterion("translator_id <>", value, "translatorId");
            return (Criteria) this;
        }

        public Criteria andTranslatorIdGreaterThan(Integer value) {
            addCriterion("translator_id >", value, "translatorId");
            return (Criteria) this;
        }

        public Criteria andTranslatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("translator_id >=", value, "translatorId");
            return (Criteria) this;
        }

        public Criteria andTranslatorIdLessThan(Integer value) {
            addCriterion("translator_id <", value, "translatorId");
            return (Criteria) this;
        }

        public Criteria andTranslatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("translator_id <=", value, "translatorId");
            return (Criteria) this;
        }

        public Criteria andTranslatorIdIn(List<Integer> values) {
            addCriterion("translator_id in", values, "translatorId");
            return (Criteria) this;
        }

        public Criteria andTranslatorIdNotIn(List<Integer> values) {
            addCriterion("translator_id not in", values, "translatorId");
            return (Criteria) this;
        }

        public Criteria andTranslatorIdBetween(Integer value1, Integer value2) {
            addCriterion("translator_id between", value1, value2, "translatorId");
            return (Criteria) this;
        }

        public Criteria andTranslatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("translator_id not between", value1, value2, "translatorId");
            return (Criteria) this;
        }

        public Criteria andBookLanguageIsNull() {
            addCriterion("book_language is null");
            return (Criteria) this;
        }

        public Criteria andBookLanguageIsNotNull() {
            addCriterion("book_language is not null");
            return (Criteria) this;
        }

        public Criteria andBookLanguageEqualTo(String value) {
            addCriterion("book_language =", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageNotEqualTo(String value) {
            addCriterion("book_language <>", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageGreaterThan(String value) {
            addCriterion("book_language >", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("book_language >=", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageLessThan(String value) {
            addCriterion("book_language <", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageLessThanOrEqualTo(String value) {
            addCriterion("book_language <=", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageLike(String value) {
            addCriterion("book_language like", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageNotLike(String value) {
            addCriterion("book_language not like", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageIn(List<String> values) {
            addCriterion("book_language in", values, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageNotIn(List<String> values) {
            addCriterion("book_language not in", values, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageBetween(String value1, String value2) {
            addCriterion("book_language between", value1, value2, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageNotBetween(String value1, String value2) {
            addCriterion("book_language not between", value1, value2, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andRedundancyFieldIsNull() {
            addCriterion("redundancy_field is null");
            return (Criteria) this;
        }

        public Criteria andRedundancyFieldIsNotNull() {
            addCriterion("redundancy_field is not null");
            return (Criteria) this;
        }

        public Criteria andRedundancyFieldEqualTo(String value) {
            addCriterion("redundancy_field =", value, "redundancyField");
            return (Criteria) this;
        }

        public Criteria andRedundancyFieldNotEqualTo(String value) {
            addCriterion("redundancy_field <>", value, "redundancyField");
            return (Criteria) this;
        }

        public Criteria andRedundancyFieldGreaterThan(String value) {
            addCriterion("redundancy_field >", value, "redundancyField");
            return (Criteria) this;
        }

        public Criteria andRedundancyFieldGreaterThanOrEqualTo(String value) {
            addCriterion("redundancy_field >=", value, "redundancyField");
            return (Criteria) this;
        }

        public Criteria andRedundancyFieldLessThan(String value) {
            addCriterion("redundancy_field <", value, "redundancyField");
            return (Criteria) this;
        }

        public Criteria andRedundancyFieldLessThanOrEqualTo(String value) {
            addCriterion("redundancy_field <=", value, "redundancyField");
            return (Criteria) this;
        }

        public Criteria andRedundancyFieldLike(String value) {
            addCriterion("redundancy_field like", value, "redundancyField");
            return (Criteria) this;
        }

        public Criteria andRedundancyFieldNotLike(String value) {
            addCriterion("redundancy_field not like", value, "redundancyField");
            return (Criteria) this;
        }

        public Criteria andRedundancyFieldIn(List<String> values) {
            addCriterion("redundancy_field in", values, "redundancyField");
            return (Criteria) this;
        }

        public Criteria andRedundancyFieldNotIn(List<String> values) {
            addCriterion("redundancy_field not in", values, "redundancyField");
            return (Criteria) this;
        }

        public Criteria andRedundancyFieldBetween(String value1, String value2) {
            addCriterion("redundancy_field between", value1, value2, "redundancyField");
            return (Criteria) this;
        }

        public Criteria andRedundancyFieldNotBetween(String value1, String value2) {
            addCriterion("redundancy_field not between", value1, value2, "redundancyField");
            return (Criteria) this;
        }

        public Criteria andRedundancyField2IsNull() {
            addCriterion("redundancy_field2 is null");
            return (Criteria) this;
        }

        public Criteria andRedundancyField2IsNotNull() {
            addCriterion("redundancy_field2 is not null");
            return (Criteria) this;
        }

        public Criteria andRedundancyField2EqualTo(String value) {
            addCriterion("redundancy_field2 =", value, "redundancyField2");
            return (Criteria) this;
        }

        public Criteria andRedundancyField2NotEqualTo(String value) {
            addCriterion("redundancy_field2 <>", value, "redundancyField2");
            return (Criteria) this;
        }

        public Criteria andRedundancyField2GreaterThan(String value) {
            addCriterion("redundancy_field2 >", value, "redundancyField2");
            return (Criteria) this;
        }

        public Criteria andRedundancyField2GreaterThanOrEqualTo(String value) {
            addCriterion("redundancy_field2 >=", value, "redundancyField2");
            return (Criteria) this;
        }

        public Criteria andRedundancyField2LessThan(String value) {
            addCriterion("redundancy_field2 <", value, "redundancyField2");
            return (Criteria) this;
        }

        public Criteria andRedundancyField2LessThanOrEqualTo(String value) {
            addCriterion("redundancy_field2 <=", value, "redundancyField2");
            return (Criteria) this;
        }

        public Criteria andRedundancyField2Like(String value) {
            addCriterion("redundancy_field2 like", value, "redundancyField2");
            return (Criteria) this;
        }

        public Criteria andRedundancyField2NotLike(String value) {
            addCriterion("redundancy_field2 not like", value, "redundancyField2");
            return (Criteria) this;
        }

        public Criteria andRedundancyField2In(List<String> values) {
            addCriterion("redundancy_field2 in", values, "redundancyField2");
            return (Criteria) this;
        }

        public Criteria andRedundancyField2NotIn(List<String> values) {
            addCriterion("redundancy_field2 not in", values, "redundancyField2");
            return (Criteria) this;
        }

        public Criteria andRedundancyField2Between(String value1, String value2) {
            addCriterion("redundancy_field2 between", value1, value2, "redundancyField2");
            return (Criteria) this;
        }

        public Criteria andRedundancyField2NotBetween(String value1, String value2) {
            addCriterion("redundancy_field2 not between", value1, value2, "redundancyField2");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}