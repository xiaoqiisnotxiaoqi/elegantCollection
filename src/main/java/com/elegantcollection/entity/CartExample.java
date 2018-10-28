package com.elegantcollection.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CartExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public CartExample() {
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

        public Criteria andCartIdIsNull() {
            addCriterion("cart_id is null");
            return (Criteria) this;
        }

        public Criteria andCartIdIsNotNull() {
            addCriterion("cart_id is not null");
            return (Criteria) this;
        }

        public Criteria andCartIdEqualTo(Integer value) {
            addCriterion("cart_id =", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotEqualTo(Integer value) {
            addCriterion("cart_id <>", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdGreaterThan(Integer value) {
            addCriterion("cart_id >", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cart_id >=", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdLessThan(Integer value) {
            addCriterion("cart_id <", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdLessThanOrEqualTo(Integer value) {
            addCriterion("cart_id <=", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdIn(List<Integer> values) {
            addCriterion("cart_id in", values, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotIn(List<Integer> values) {
            addCriterion("cart_id not in", values, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdBetween(Integer value1, Integer value2) {
            addCriterion("cart_id between", value1, value2, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cart_id not between", value1, value2, "cartId");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("cust_id is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("cust_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(Integer value) {
            addCriterion("cust_id =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(Integer value) {
            addCriterion("cust_id <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(Integer value) {
            addCriterion("cust_id >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cust_id >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(Integer value) {
            addCriterion("cust_id <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(Integer value) {
            addCriterion("cust_id <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<Integer> values) {
            addCriterion("cust_id in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<Integer> values) {
            addCriterion("cust_id not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(Integer value1, Integer value2) {
            addCriterion("cust_id between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cust_id not between", value1, value2, "custId");
            return (Criteria) this;
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

        public Criteria andQualityIsNull() {
            addCriterion("quality is null");
            return (Criteria) this;
        }

        public Criteria andQualityIsNotNull() {
            addCriterion("quality is not null");
            return (Criteria) this;
        }

        public Criteria andQualityEqualTo(Integer value) {
            addCriterion("quality =", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotEqualTo(Integer value) {
            addCriterion("quality <>", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThan(Integer value) {
            addCriterion("quality >", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quality >=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThan(Integer value) {
            addCriterion("quality <", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThanOrEqualTo(Integer value) {
            addCriterion("quality <=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityIn(List<Integer> values) {
            addCriterion("quality in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotIn(List<Integer> values) {
            addCriterion("quality not in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityBetween(Integer value1, Integer value2) {
            addCriterion("quality between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotBetween(Integer value1, Integer value2) {
            addCriterion("quality not between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterionForJDBCDate("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterionForJDBCDate("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterionForJDBCDate("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andCartStatusIsNull() {
            addCriterion("cart_status is null");
            return (Criteria) this;
        }

        public Criteria andCartStatusIsNotNull() {
            addCriterion("cart_status is not null");
            return (Criteria) this;
        }

        public Criteria andCartStatusEqualTo(Integer value) {
            addCriterion("cart_status =", value, "cartStatus");
            return (Criteria) this;
        }

        public Criteria andCartStatusNotEqualTo(Integer value) {
            addCriterion("cart_status <>", value, "cartStatus");
            return (Criteria) this;
        }

        public Criteria andCartStatusGreaterThan(Integer value) {
            addCriterion("cart_status >", value, "cartStatus");
            return (Criteria) this;
        }

        public Criteria andCartStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("cart_status >=", value, "cartStatus");
            return (Criteria) this;
        }

        public Criteria andCartStatusLessThan(Integer value) {
            addCriterion("cart_status <", value, "cartStatus");
            return (Criteria) this;
        }

        public Criteria andCartStatusLessThanOrEqualTo(Integer value) {
            addCriterion("cart_status <=", value, "cartStatus");
            return (Criteria) this;
        }

        public Criteria andCartStatusIn(List<Integer> values) {
            addCriterion("cart_status in", values, "cartStatus");
            return (Criteria) this;
        }

        public Criteria andCartStatusNotIn(List<Integer> values) {
            addCriterion("cart_status not in", values, "cartStatus");
            return (Criteria) this;
        }

        public Criteria andCartStatusBetween(Integer value1, Integer value2) {
            addCriterion("cart_status between", value1, value2, "cartStatus");
            return (Criteria) this;
        }

        public Criteria andCartStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("cart_status not between", value1, value2, "cartStatus");
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