package com.elegantcollection.entity;

import java.util.ArrayList;
import java.util.List;

public class WaiterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public WaiterExample() {
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

        public Criteria andWaiterIdIsNull() {
            addCriterion("waiter_id is null");
            return (Criteria) this;
        }

        public Criteria andWaiterIdIsNotNull() {
            addCriterion("waiter_id is not null");
            return (Criteria) this;
        }

        public Criteria andWaiterIdEqualTo(Integer value) {
            addCriterion("waiter_id =", value, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterIdNotEqualTo(Integer value) {
            addCriterion("waiter_id <>", value, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterIdGreaterThan(Integer value) {
            addCriterion("waiter_id >", value, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("waiter_id >=", value, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterIdLessThan(Integer value) {
            addCriterion("waiter_id <", value, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterIdLessThanOrEqualTo(Integer value) {
            addCriterion("waiter_id <=", value, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterIdIn(List<Integer> values) {
            addCriterion("waiter_id in", values, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterIdNotIn(List<Integer> values) {
            addCriterion("waiter_id not in", values, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterIdBetween(Integer value1, Integer value2) {
            addCriterion("waiter_id between", value1, value2, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("waiter_id not between", value1, value2, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterNumberIsNull() {
            addCriterion("waiter_number is null");
            return (Criteria) this;
        }

        public Criteria andWaiterNumberIsNotNull() {
            addCriterion("waiter_number is not null");
            return (Criteria) this;
        }

        public Criteria andWaiterNumberEqualTo(String value) {
            addCriterion("waiter_number =", value, "waiterNumber");
            return (Criteria) this;
        }

        public Criteria andWaiterNumberNotEqualTo(String value) {
            addCriterion("waiter_number <>", value, "waiterNumber");
            return (Criteria) this;
        }

        public Criteria andWaiterNumberGreaterThan(String value) {
            addCriterion("waiter_number >", value, "waiterNumber");
            return (Criteria) this;
        }

        public Criteria andWaiterNumberGreaterThanOrEqualTo(String value) {
            addCriterion("waiter_number >=", value, "waiterNumber");
            return (Criteria) this;
        }

        public Criteria andWaiterNumberLessThan(String value) {
            addCriterion("waiter_number <", value, "waiterNumber");
            return (Criteria) this;
        }

        public Criteria andWaiterNumberLessThanOrEqualTo(String value) {
            addCriterion("waiter_number <=", value, "waiterNumber");
            return (Criteria) this;
        }

        public Criteria andWaiterNumberLike(String value) {
            addCriterion("waiter_number like", value, "waiterNumber");
            return (Criteria) this;
        }

        public Criteria andWaiterNumberNotLike(String value) {
            addCriterion("waiter_number not like", value, "waiterNumber");
            return (Criteria) this;
        }

        public Criteria andWaiterNumberIn(List<String> values) {
            addCriterion("waiter_number in", values, "waiterNumber");
            return (Criteria) this;
        }

        public Criteria andWaiterNumberNotIn(List<String> values) {
            addCriterion("waiter_number not in", values, "waiterNumber");
            return (Criteria) this;
        }

        public Criteria andWaiterNumberBetween(String value1, String value2) {
            addCriterion("waiter_number between", value1, value2, "waiterNumber");
            return (Criteria) this;
        }

        public Criteria andWaiterNumberNotBetween(String value1, String value2) {
            addCriterion("waiter_number not between", value1, value2, "waiterNumber");
            return (Criteria) this;
        }

        public Criteria andWaiterPasswordIsNull() {
            addCriterion("waiter_password is null");
            return (Criteria) this;
        }

        public Criteria andWaiterPasswordIsNotNull() {
            addCriterion("waiter_password is not null");
            return (Criteria) this;
        }

        public Criteria andWaiterPasswordEqualTo(String value) {
            addCriterion("waiter_password =", value, "waiterPassword");
            return (Criteria) this;
        }

        public Criteria andWaiterPasswordNotEqualTo(String value) {
            addCriterion("waiter_password <>", value, "waiterPassword");
            return (Criteria) this;
        }

        public Criteria andWaiterPasswordGreaterThan(String value) {
            addCriterion("waiter_password >", value, "waiterPassword");
            return (Criteria) this;
        }

        public Criteria andWaiterPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("waiter_password >=", value, "waiterPassword");
            return (Criteria) this;
        }

        public Criteria andWaiterPasswordLessThan(String value) {
            addCriterion("waiter_password <", value, "waiterPassword");
            return (Criteria) this;
        }

        public Criteria andWaiterPasswordLessThanOrEqualTo(String value) {
            addCriterion("waiter_password <=", value, "waiterPassword");
            return (Criteria) this;
        }

        public Criteria andWaiterPasswordLike(String value) {
            addCriterion("waiter_password like", value, "waiterPassword");
            return (Criteria) this;
        }

        public Criteria andWaiterPasswordNotLike(String value) {
            addCriterion("waiter_password not like", value, "waiterPassword");
            return (Criteria) this;
        }

        public Criteria andWaiterPasswordIn(List<String> values) {
            addCriterion("waiter_password in", values, "waiterPassword");
            return (Criteria) this;
        }

        public Criteria andWaiterPasswordNotIn(List<String> values) {
            addCriterion("waiter_password not in", values, "waiterPassword");
            return (Criteria) this;
        }

        public Criteria andWaiterPasswordBetween(String value1, String value2) {
            addCriterion("waiter_password between", value1, value2, "waiterPassword");
            return (Criteria) this;
        }

        public Criteria andWaiterPasswordNotBetween(String value1, String value2) {
            addCriterion("waiter_password not between", value1, value2, "waiterPassword");
            return (Criteria) this;
        }

        public Criteria andWaiterNameIsNull() {
            addCriterion("waiter_name is null");
            return (Criteria) this;
        }

        public Criteria andWaiterNameIsNotNull() {
            addCriterion("waiter_name is not null");
            return (Criteria) this;
        }

        public Criteria andWaiterNameEqualTo(String value) {
            addCriterion("waiter_name =", value, "waiterName");
            return (Criteria) this;
        }

        public Criteria andWaiterNameNotEqualTo(String value) {
            addCriterion("waiter_name <>", value, "waiterName");
            return (Criteria) this;
        }

        public Criteria andWaiterNameGreaterThan(String value) {
            addCriterion("waiter_name >", value, "waiterName");
            return (Criteria) this;
        }

        public Criteria andWaiterNameGreaterThanOrEqualTo(String value) {
            addCriterion("waiter_name >=", value, "waiterName");
            return (Criteria) this;
        }

        public Criteria andWaiterNameLessThan(String value) {
            addCriterion("waiter_name <", value, "waiterName");
            return (Criteria) this;
        }

        public Criteria andWaiterNameLessThanOrEqualTo(String value) {
            addCriterion("waiter_name <=", value, "waiterName");
            return (Criteria) this;
        }

        public Criteria andWaiterNameLike(String value) {
            addCriterion("waiter_name like", value, "waiterName");
            return (Criteria) this;
        }

        public Criteria andWaiterNameNotLike(String value) {
            addCriterion("waiter_name not like", value, "waiterName");
            return (Criteria) this;
        }

        public Criteria andWaiterNameIn(List<String> values) {
            addCriterion("waiter_name in", values, "waiterName");
            return (Criteria) this;
        }

        public Criteria andWaiterNameNotIn(List<String> values) {
            addCriterion("waiter_name not in", values, "waiterName");
            return (Criteria) this;
        }

        public Criteria andWaiterNameBetween(String value1, String value2) {
            addCriterion("waiter_name between", value1, value2, "waiterName");
            return (Criteria) this;
        }

        public Criteria andWaiterNameNotBetween(String value1, String value2) {
            addCriterion("waiter_name not between", value1, value2, "waiterName");
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