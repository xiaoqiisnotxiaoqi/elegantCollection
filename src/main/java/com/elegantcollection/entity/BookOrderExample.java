package com.elegantcollection.entity;

import java.util.ArrayList;
import java.util.List;

public class BookOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public BookOrderExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderTitleIsNull() {
            addCriterion("order_title is null");
            return (Criteria) this;
        }

        public Criteria andOrderTitleIsNotNull() {
            addCriterion("order_title is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTitleEqualTo(String value) {
            addCriterion("order_title =", value, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleNotEqualTo(String value) {
            addCriterion("order_title <>", value, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleGreaterThan(String value) {
            addCriterion("order_title >", value, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleGreaterThanOrEqualTo(String value) {
            addCriterion("order_title >=", value, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleLessThan(String value) {
            addCriterion("order_title <", value, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleLessThanOrEqualTo(String value) {
            addCriterion("order_title <=", value, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleLike(String value) {
            addCriterion("order_title like", value, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleNotLike(String value) {
            addCriterion("order_title not like", value, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleIn(List<String> values) {
            addCriterion("order_title in", values, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleNotIn(List<String> values) {
            addCriterion("order_title not in", values, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleBetween(String value1, String value2) {
            addCriterion("order_title between", value1, value2, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleNotBetween(String value1, String value2) {
            addCriterion("order_title not between", value1, value2, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderImgIsNull() {
            addCriterion("order_img is null");
            return (Criteria) this;
        }

        public Criteria andOrderImgIsNotNull() {
            addCriterion("order_img is not null");
            return (Criteria) this;
        }

        public Criteria andOrderImgEqualTo(String value) {
            addCriterion("order_img =", value, "orderImg");
            return (Criteria) this;
        }

        public Criteria andOrderImgNotEqualTo(String value) {
            addCriterion("order_img <>", value, "orderImg");
            return (Criteria) this;
        }

        public Criteria andOrderImgGreaterThan(String value) {
            addCriterion("order_img >", value, "orderImg");
            return (Criteria) this;
        }

        public Criteria andOrderImgGreaterThanOrEqualTo(String value) {
            addCriterion("order_img >=", value, "orderImg");
            return (Criteria) this;
        }

        public Criteria andOrderImgLessThan(String value) {
            addCriterion("order_img <", value, "orderImg");
            return (Criteria) this;
        }

        public Criteria andOrderImgLessThanOrEqualTo(String value) {
            addCriterion("order_img <=", value, "orderImg");
            return (Criteria) this;
        }

        public Criteria andOrderImgLike(String value) {
            addCriterion("order_img like", value, "orderImg");
            return (Criteria) this;
        }

        public Criteria andOrderImgNotLike(String value) {
            addCriterion("order_img not like", value, "orderImg");
            return (Criteria) this;
        }

        public Criteria andOrderImgIn(List<String> values) {
            addCriterion("order_img in", values, "orderImg");
            return (Criteria) this;
        }

        public Criteria andOrderImgNotIn(List<String> values) {
            addCriterion("order_img not in", values, "orderImg");
            return (Criteria) this;
        }

        public Criteria andOrderImgBetween(String value1, String value2) {
            addCriterion("order_img between", value1, value2, "orderImg");
            return (Criteria) this;
        }

        public Criteria andOrderImgNotBetween(String value1, String value2) {
            addCriterion("order_img not between", value1, value2, "orderImg");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Integer value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Integer value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Integer value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Integer value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Integer> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Integer> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
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