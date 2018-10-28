package com.elegantcollection.entity;

import java.util.ArrayList;
import java.util.List;

public class BookCategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public BookCategoryExample() {
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

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNull() {
            addCriterion("category_name is null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNotNull() {
            addCriterion("category_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameEqualTo(String value) {
            addCriterion("category_name =", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotEqualTo(String value) {
            addCriterion("category_name <>", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThan(String value) {
            addCriterion("category_name >", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThan(String value) {
            addCriterion("category_name <", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLike(String value) {
            addCriterion("category_name like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotLike(String value) {
            addCriterion("category_name not like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIn(List<String> values) {
            addCriterion("category_name in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotIn(List<String> values) {
            addCriterion("category_name not in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryUpIdIsNull() {
            addCriterion("category_up_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryUpIdIsNotNull() {
            addCriterion("category_up_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryUpIdEqualTo(Integer value) {
            addCriterion("category_up_id =", value, "categoryUpId");
            return (Criteria) this;
        }

        public Criteria andCategoryUpIdNotEqualTo(Integer value) {
            addCriterion("category_up_id <>", value, "categoryUpId");
            return (Criteria) this;
        }

        public Criteria andCategoryUpIdGreaterThan(Integer value) {
            addCriterion("category_up_id >", value, "categoryUpId");
            return (Criteria) this;
        }

        public Criteria andCategoryUpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_up_id >=", value, "categoryUpId");
            return (Criteria) this;
        }

        public Criteria andCategoryUpIdLessThan(Integer value) {
            addCriterion("category_up_id <", value, "categoryUpId");
            return (Criteria) this;
        }

        public Criteria andCategoryUpIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_up_id <=", value, "categoryUpId");
            return (Criteria) this;
        }

        public Criteria andCategoryUpIdIn(List<Integer> values) {
            addCriterion("category_up_id in", values, "categoryUpId");
            return (Criteria) this;
        }

        public Criteria andCategoryUpIdNotIn(List<Integer> values) {
            addCriterion("category_up_id not in", values, "categoryUpId");
            return (Criteria) this;
        }

        public Criteria andCategoryUpIdBetween(Integer value1, Integer value2) {
            addCriterion("category_up_id between", value1, value2, "categoryUpId");
            return (Criteria) this;
        }

        public Criteria andCategoryUpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_up_id not between", value1, value2, "categoryUpId");
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