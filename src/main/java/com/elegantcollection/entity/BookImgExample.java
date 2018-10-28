package com.elegantcollection.entity;

import java.util.ArrayList;
import java.util.List;

public class BookImgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public BookImgExample() {
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

        public Criteria andImgIdIsNull() {
            addCriterion("img_id is null");
            return (Criteria) this;
        }

        public Criteria andImgIdIsNotNull() {
            addCriterion("img_id is not null");
            return (Criteria) this;
        }

        public Criteria andImgIdEqualTo(Integer value) {
            addCriterion("img_id =", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotEqualTo(Integer value) {
            addCriterion("img_id <>", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdGreaterThan(Integer value) {
            addCriterion("img_id >", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("img_id >=", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLessThan(Integer value) {
            addCriterion("img_id <", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLessThanOrEqualTo(Integer value) {
            addCriterion("img_id <=", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdIn(List<Integer> values) {
            addCriterion("img_id in", values, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotIn(List<Integer> values) {
            addCriterion("img_id not in", values, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdBetween(Integer value1, Integer value2) {
            addCriterion("img_id between", value1, value2, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("img_id not between", value1, value2, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgAddressIsNull() {
            addCriterion("img_address is null");
            return (Criteria) this;
        }

        public Criteria andImgAddressIsNotNull() {
            addCriterion("img_address is not null");
            return (Criteria) this;
        }

        public Criteria andImgAddressEqualTo(String value) {
            addCriterion("img_address =", value, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressNotEqualTo(String value) {
            addCriterion("img_address <>", value, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressGreaterThan(String value) {
            addCriterion("img_address >", value, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressGreaterThanOrEqualTo(String value) {
            addCriterion("img_address >=", value, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressLessThan(String value) {
            addCriterion("img_address <", value, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressLessThanOrEqualTo(String value) {
            addCriterion("img_address <=", value, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressLike(String value) {
            addCriterion("img_address like", value, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressNotLike(String value) {
            addCriterion("img_address not like", value, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressIn(List<String> values) {
            addCriterion("img_address in", values, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressNotIn(List<String> values) {
            addCriterion("img_address not in", values, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressBetween(String value1, String value2) {
            addCriterion("img_address between", value1, value2, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressNotBetween(String value1, String value2) {
            addCriterion("img_address not between", value1, value2, "imgAddress");
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