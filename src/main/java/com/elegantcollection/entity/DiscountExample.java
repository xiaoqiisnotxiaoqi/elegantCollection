package com.elegantcollection.entity;

import java.util.ArrayList;
import java.util.List;

public class DiscountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public DiscountExample() {
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

        public Criteria andDiscountIdIsNull() {
            addCriterion("discount_id is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIdIsNotNull() {
            addCriterion("discount_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountIdEqualTo(Integer value) {
            addCriterion("discount_id =", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdNotEqualTo(Integer value) {
            addCriterion("discount_id <>", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdGreaterThan(Integer value) {
            addCriterion("discount_id >", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("discount_id >=", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdLessThan(Integer value) {
            addCriterion("discount_id <", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdLessThanOrEqualTo(Integer value) {
            addCriterion("discount_id <=", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdIn(List<Integer> values) {
            addCriterion("discount_id in", values, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdNotIn(List<Integer> values) {
            addCriterion("discount_id not in", values, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdBetween(Integer value1, Integer value2) {
            addCriterion("discount_id between", value1, value2, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("discount_id not between", value1, value2, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountNameIsNull() {
            addCriterion("discount_name is null");
            return (Criteria) this;
        }

        public Criteria andDiscountNameIsNotNull() {
            addCriterion("discount_name is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountNameEqualTo(String value) {
            addCriterion("discount_name =", value, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameNotEqualTo(String value) {
            addCriterion("discount_name <>", value, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameGreaterThan(String value) {
            addCriterion("discount_name >", value, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameGreaterThanOrEqualTo(String value) {
            addCriterion("discount_name >=", value, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameLessThan(String value) {
            addCriterion("discount_name <", value, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameLessThanOrEqualTo(String value) {
            addCriterion("discount_name <=", value, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameLike(String value) {
            addCriterion("discount_name like", value, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameNotLike(String value) {
            addCriterion("discount_name not like", value, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameIn(List<String> values) {
            addCriterion("discount_name in", values, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameNotIn(List<String> values) {
            addCriterion("discount_name not in", values, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameBetween(String value1, String value2) {
            addCriterion("discount_name between", value1, value2, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameNotBetween(String value1, String value2) {
            addCriterion("discount_name not between", value1, value2, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIsNull() {
            addCriterion("discount_type is null");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIsNotNull() {
            addCriterion("discount_type is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeEqualTo(Integer value) {
            addCriterion("discount_type =", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotEqualTo(Integer value) {
            addCriterion("discount_type <>", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeGreaterThan(Integer value) {
            addCriterion("discount_type >", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("discount_type >=", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeLessThan(Integer value) {
            addCriterion("discount_type <", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeLessThanOrEqualTo(Integer value) {
            addCriterion("discount_type <=", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIn(List<Integer> values) {
            addCriterion("discount_type in", values, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotIn(List<Integer> values) {
            addCriterion("discount_type not in", values, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeBetween(Integer value1, Integer value2) {
            addCriterion("discount_type between", value1, value2, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("discount_type not between", value1, value2, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyIsNull() {
            addCriterion("discount_money is null");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyIsNotNull() {
            addCriterion("discount_money is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyEqualTo(Float value) {
            addCriterion("discount_money =", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyNotEqualTo(Float value) {
            addCriterion("discount_money <>", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyGreaterThan(Float value) {
            addCriterion("discount_money >", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("discount_money >=", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyLessThan(Float value) {
            addCriterion("discount_money <", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyLessThanOrEqualTo(Float value) {
            addCriterion("discount_money <=", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyIn(List<Float> values) {
            addCriterion("discount_money in", values, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyNotIn(List<Float> values) {
            addCriterion("discount_money not in", values, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyBetween(Float value1, Float value2) {
            addCriterion("discount_money between", value1, value2, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyNotBetween(Float value1, Float value2) {
            addCriterion("discount_money not between", value1, value2, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountStatusIsNull() {
            addCriterion("discount_status is null");
            return (Criteria) this;
        }

        public Criteria andDiscountStatusIsNotNull() {
            addCriterion("discount_status is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountStatusEqualTo(Integer value) {
            addCriterion("discount_status =", value, "discountStatus");
            return (Criteria) this;
        }

        public Criteria andDiscountStatusNotEqualTo(Integer value) {
            addCriterion("discount_status <>", value, "discountStatus");
            return (Criteria) this;
        }

        public Criteria andDiscountStatusGreaterThan(Integer value) {
            addCriterion("discount_status >", value, "discountStatus");
            return (Criteria) this;
        }

        public Criteria andDiscountStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("discount_status >=", value, "discountStatus");
            return (Criteria) this;
        }

        public Criteria andDiscountStatusLessThan(Integer value) {
            addCriterion("discount_status <", value, "discountStatus");
            return (Criteria) this;
        }

        public Criteria andDiscountStatusLessThanOrEqualTo(Integer value) {
            addCriterion("discount_status <=", value, "discountStatus");
            return (Criteria) this;
        }

        public Criteria andDiscountStatusIn(List<Integer> values) {
            addCriterion("discount_status in", values, "discountStatus");
            return (Criteria) this;
        }

        public Criteria andDiscountStatusNotIn(List<Integer> values) {
            addCriterion("discount_status not in", values, "discountStatus");
            return (Criteria) this;
        }

        public Criteria andDiscountStatusBetween(Integer value1, Integer value2) {
            addCriterion("discount_status between", value1, value2, "discountStatus");
            return (Criteria) this;
        }

        public Criteria andDiscountStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("discount_status not between", value1, value2, "discountStatus");
            return (Criteria) this;
        }

        public Criteria andMore1IsNull() {
            addCriterion("more1 is null");
            return (Criteria) this;
        }

        public Criteria andMore1IsNotNull() {
            addCriterion("more1 is not null");
            return (Criteria) this;
        }

        public Criteria andMore1EqualTo(String value) {
            addCriterion("more1 =", value, "more1");
            return (Criteria) this;
        }

        public Criteria andMore1NotEqualTo(String value) {
            addCriterion("more1 <>", value, "more1");
            return (Criteria) this;
        }

        public Criteria andMore1GreaterThan(String value) {
            addCriterion("more1 >", value, "more1");
            return (Criteria) this;
        }

        public Criteria andMore1GreaterThanOrEqualTo(String value) {
            addCriterion("more1 >=", value, "more1");
            return (Criteria) this;
        }

        public Criteria andMore1LessThan(String value) {
            addCriterion("more1 <", value, "more1");
            return (Criteria) this;
        }

        public Criteria andMore1LessThanOrEqualTo(String value) {
            addCriterion("more1 <=", value, "more1");
            return (Criteria) this;
        }

        public Criteria andMore1Like(String value) {
            addCriterion("more1 like", value, "more1");
            return (Criteria) this;
        }

        public Criteria andMore1NotLike(String value) {
            addCriterion("more1 not like", value, "more1");
            return (Criteria) this;
        }

        public Criteria andMore1In(List<String> values) {
            addCriterion("more1 in", values, "more1");
            return (Criteria) this;
        }

        public Criteria andMore1NotIn(List<String> values) {
            addCriterion("more1 not in", values, "more1");
            return (Criteria) this;
        }

        public Criteria andMore1Between(String value1, String value2) {
            addCriterion("more1 between", value1, value2, "more1");
            return (Criteria) this;
        }

        public Criteria andMore1NotBetween(String value1, String value2) {
            addCriterion("more1 not between", value1, value2, "more1");
            return (Criteria) this;
        }

        public Criteria andMore2IsNull() {
            addCriterion("more2 is null");
            return (Criteria) this;
        }

        public Criteria andMore2IsNotNull() {
            addCriterion("more2 is not null");
            return (Criteria) this;
        }

        public Criteria andMore2EqualTo(String value) {
            addCriterion("more2 =", value, "more2");
            return (Criteria) this;
        }

        public Criteria andMore2NotEqualTo(String value) {
            addCriterion("more2 <>", value, "more2");
            return (Criteria) this;
        }

        public Criteria andMore2GreaterThan(String value) {
            addCriterion("more2 >", value, "more2");
            return (Criteria) this;
        }

        public Criteria andMore2GreaterThanOrEqualTo(String value) {
            addCriterion("more2 >=", value, "more2");
            return (Criteria) this;
        }

        public Criteria andMore2LessThan(String value) {
            addCriterion("more2 <", value, "more2");
            return (Criteria) this;
        }

        public Criteria andMore2LessThanOrEqualTo(String value) {
            addCriterion("more2 <=", value, "more2");
            return (Criteria) this;
        }

        public Criteria andMore2Like(String value) {
            addCriterion("more2 like", value, "more2");
            return (Criteria) this;
        }

        public Criteria andMore2NotLike(String value) {
            addCriterion("more2 not like", value, "more2");
            return (Criteria) this;
        }

        public Criteria andMore2In(List<String> values) {
            addCriterion("more2 in", values, "more2");
            return (Criteria) this;
        }

        public Criteria andMore2NotIn(List<String> values) {
            addCriterion("more2 not in", values, "more2");
            return (Criteria) this;
        }

        public Criteria andMore2Between(String value1, String value2) {
            addCriterion("more2 between", value1, value2, "more2");
            return (Criteria) this;
        }

        public Criteria andMore2NotBetween(String value1, String value2) {
            addCriterion("more2 not between", value1, value2, "more2");
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