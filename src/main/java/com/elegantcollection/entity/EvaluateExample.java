package com.elegantcollection.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EvaluateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public EvaluateExample() {
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

        public Criteria andEvaluateIdIsNull() {
            addCriterion("evaluate_id is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdIsNotNull() {
            addCriterion("evaluate_id is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdEqualTo(Integer value) {
            addCriterion("evaluate_id =", value, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdNotEqualTo(Integer value) {
            addCriterion("evaluate_id <>", value, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdGreaterThan(Integer value) {
            addCriterion("evaluate_id >", value, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluate_id >=", value, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdLessThan(Integer value) {
            addCriterion("evaluate_id <", value, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdLessThanOrEqualTo(Integer value) {
            addCriterion("evaluate_id <=", value, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdIn(List<Integer> values) {
            addCriterion("evaluate_id in", values, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdNotIn(List<Integer> values) {
            addCriterion("evaluate_id not in", values, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_id between", value1, value2, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_id not between", value1, value2, "evaluateId");
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

        public Criteria andEvaluateImgIsNull() {
            addCriterion("evaluate_img is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateImgIsNotNull() {
            addCriterion("evaluate_img is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateImgEqualTo(String value) {
            addCriterion("evaluate_img =", value, "evaluateImg");
            return (Criteria) this;
        }

        public Criteria andEvaluateImgNotEqualTo(String value) {
            addCriterion("evaluate_img <>", value, "evaluateImg");
            return (Criteria) this;
        }

        public Criteria andEvaluateImgGreaterThan(String value) {
            addCriterion("evaluate_img >", value, "evaluateImg");
            return (Criteria) this;
        }

        public Criteria andEvaluateImgGreaterThanOrEqualTo(String value) {
            addCriterion("evaluate_img >=", value, "evaluateImg");
            return (Criteria) this;
        }

        public Criteria andEvaluateImgLessThan(String value) {
            addCriterion("evaluate_img <", value, "evaluateImg");
            return (Criteria) this;
        }

        public Criteria andEvaluateImgLessThanOrEqualTo(String value) {
            addCriterion("evaluate_img <=", value, "evaluateImg");
            return (Criteria) this;
        }

        public Criteria andEvaluateImgLike(String value) {
            addCriterion("evaluate_img like", value, "evaluateImg");
            return (Criteria) this;
        }

        public Criteria andEvaluateImgNotLike(String value) {
            addCriterion("evaluate_img not like", value, "evaluateImg");
            return (Criteria) this;
        }

        public Criteria andEvaluateImgIn(List<String> values) {
            addCriterion("evaluate_img in", values, "evaluateImg");
            return (Criteria) this;
        }

        public Criteria andEvaluateImgNotIn(List<String> values) {
            addCriterion("evaluate_img not in", values, "evaluateImg");
            return (Criteria) this;
        }

        public Criteria andEvaluateImgBetween(String value1, String value2) {
            addCriterion("evaluate_img between", value1, value2, "evaluateImg");
            return (Criteria) this;
        }

        public Criteria andEvaluateImgNotBetween(String value1, String value2) {
            addCriterion("evaluate_img not between", value1, value2, "evaluateImg");
            return (Criteria) this;
        }

        public Criteria andDescribeScoreIsNull() {
            addCriterion("describe_score is null");
            return (Criteria) this;
        }

        public Criteria andDescribeScoreIsNotNull() {
            addCriterion("describe_score is not null");
            return (Criteria) this;
        }

        public Criteria andDescribeScoreEqualTo(Integer value) {
            addCriterion("describe_score =", value, "describeScore");
            return (Criteria) this;
        }

        public Criteria andDescribeScoreNotEqualTo(Integer value) {
            addCriterion("describe_score <>", value, "describeScore");
            return (Criteria) this;
        }

        public Criteria andDescribeScoreGreaterThan(Integer value) {
            addCriterion("describe_score >", value, "describeScore");
            return (Criteria) this;
        }

        public Criteria andDescribeScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("describe_score >=", value, "describeScore");
            return (Criteria) this;
        }

        public Criteria andDescribeScoreLessThan(Integer value) {
            addCriterion("describe_score <", value, "describeScore");
            return (Criteria) this;
        }

        public Criteria andDescribeScoreLessThanOrEqualTo(Integer value) {
            addCriterion("describe_score <=", value, "describeScore");
            return (Criteria) this;
        }

        public Criteria andDescribeScoreIn(List<Integer> values) {
            addCriterion("describe_score in", values, "describeScore");
            return (Criteria) this;
        }

        public Criteria andDescribeScoreNotIn(List<Integer> values) {
            addCriterion("describe_score not in", values, "describeScore");
            return (Criteria) this;
        }

        public Criteria andDescribeScoreBetween(Integer value1, Integer value2) {
            addCriterion("describe_score between", value1, value2, "describeScore");
            return (Criteria) this;
        }

        public Criteria andDescribeScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("describe_score not between", value1, value2, "describeScore");
            return (Criteria) this;
        }

        public Criteria andLogisticsScoreIsNull() {
            addCriterion("logistics_score is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsScoreIsNotNull() {
            addCriterion("logistics_score is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsScoreEqualTo(Integer value) {
            addCriterion("logistics_score =", value, "logisticsScore");
            return (Criteria) this;
        }

        public Criteria andLogisticsScoreNotEqualTo(Integer value) {
            addCriterion("logistics_score <>", value, "logisticsScore");
            return (Criteria) this;
        }

        public Criteria andLogisticsScoreGreaterThan(Integer value) {
            addCriterion("logistics_score >", value, "logisticsScore");
            return (Criteria) this;
        }

        public Criteria andLogisticsScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("logistics_score >=", value, "logisticsScore");
            return (Criteria) this;
        }

        public Criteria andLogisticsScoreLessThan(Integer value) {
            addCriterion("logistics_score <", value, "logisticsScore");
            return (Criteria) this;
        }

        public Criteria andLogisticsScoreLessThanOrEqualTo(Integer value) {
            addCriterion("logistics_score <=", value, "logisticsScore");
            return (Criteria) this;
        }

        public Criteria andLogisticsScoreIn(List<Integer> values) {
            addCriterion("logistics_score in", values, "logisticsScore");
            return (Criteria) this;
        }

        public Criteria andLogisticsScoreNotIn(List<Integer> values) {
            addCriterion("logistics_score not in", values, "logisticsScore");
            return (Criteria) this;
        }

        public Criteria andLogisticsScoreBetween(Integer value1, Integer value2) {
            addCriterion("logistics_score between", value1, value2, "logisticsScore");
            return (Criteria) this;
        }

        public Criteria andLogisticsScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("logistics_score not between", value1, value2, "logisticsScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreIsNull() {
            addCriterion("service_score is null");
            return (Criteria) this;
        }

        public Criteria andServiceScoreIsNotNull() {
            addCriterion("service_score is not null");
            return (Criteria) this;
        }

        public Criteria andServiceScoreEqualTo(Integer value) {
            addCriterion("service_score =", value, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreNotEqualTo(Integer value) {
            addCriterion("service_score <>", value, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreGreaterThan(Integer value) {
            addCriterion("service_score >", value, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_score >=", value, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreLessThan(Integer value) {
            addCriterion("service_score <", value, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreLessThanOrEqualTo(Integer value) {
            addCriterion("service_score <=", value, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreIn(List<Integer> values) {
            addCriterion("service_score in", values, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreNotIn(List<Integer> values) {
            addCriterion("service_score not in", values, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreBetween(Integer value1, Integer value2) {
            addCriterion("service_score between", value1, value2, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("service_score not between", value1, value2, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeIsNull() {
            addCriterion("evaluate_time is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeIsNotNull() {
            addCriterion("evaluate_time is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("evaluate_time =", value, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("evaluate_time <>", value, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("evaluate_time >", value, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("evaluate_time >=", value, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeLessThan(Date value) {
            addCriterionForJDBCDate("evaluate_time <", value, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("evaluate_time <=", value, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("evaluate_time in", values, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("evaluate_time not in", values, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("evaluate_time between", value1, value2, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("evaluate_time not between", value1, value2, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousIsNull() {
            addCriterion("is_anonymous is null");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousIsNotNull() {
            addCriterion("is_anonymous is not null");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousEqualTo(Integer value) {
            addCriterion("is_anonymous =", value, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousNotEqualTo(Integer value) {
            addCriterion("is_anonymous <>", value, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousGreaterThan(Integer value) {
            addCriterion("is_anonymous >", value, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_anonymous >=", value, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousLessThan(Integer value) {
            addCriterion("is_anonymous <", value, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousLessThanOrEqualTo(Integer value) {
            addCriterion("is_anonymous <=", value, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousIn(List<Integer> values) {
            addCriterion("is_anonymous in", values, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousNotIn(List<Integer> values) {
            addCriterion("is_anonymous not in", values, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousBetween(Integer value1, Integer value2) {
            addCriterion("is_anonymous between", value1, value2, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousNotBetween(Integer value1, Integer value2) {
            addCriterion("is_anonymous not between", value1, value2, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusIsNull() {
            addCriterion("evaluate_status is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusIsNotNull() {
            addCriterion("evaluate_status is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusEqualTo(Integer value) {
            addCriterion("evaluate_status =", value, "evaluateStatus");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusNotEqualTo(Integer value) {
            addCriterion("evaluate_status <>", value, "evaluateStatus");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusGreaterThan(Integer value) {
            addCriterion("evaluate_status >", value, "evaluateStatus");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluate_status >=", value, "evaluateStatus");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusLessThan(Integer value) {
            addCriterion("evaluate_status <", value, "evaluateStatus");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusLessThanOrEqualTo(Integer value) {
            addCriterion("evaluate_status <=", value, "evaluateStatus");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusIn(List<Integer> values) {
            addCriterion("evaluate_status in", values, "evaluateStatus");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusNotIn(List<Integer> values) {
            addCriterion("evaluate_status not in", values, "evaluateStatus");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_status between", value1, value2, "evaluateStatus");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_status not between", value1, value2, "evaluateStatus");
            return (Criteria) this;
        }

        public Criteria andEvaluateAnonymousIsNull() {
            addCriterion("evaluate_anonymous is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateAnonymousIsNotNull() {
            addCriterion("evaluate_anonymous is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateAnonymousEqualTo(Integer value) {
            addCriterion("evaluate_anonymous =", value, "evaluateAnonymous");
            return (Criteria) this;
        }

        public Criteria andEvaluateAnonymousNotEqualTo(Integer value) {
            addCriterion("evaluate_anonymous <>", value, "evaluateAnonymous");
            return (Criteria) this;
        }

        public Criteria andEvaluateAnonymousGreaterThan(Integer value) {
            addCriterion("evaluate_anonymous >", value, "evaluateAnonymous");
            return (Criteria) this;
        }

        public Criteria andEvaluateAnonymousGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluate_anonymous >=", value, "evaluateAnonymous");
            return (Criteria) this;
        }

        public Criteria andEvaluateAnonymousLessThan(Integer value) {
            addCriterion("evaluate_anonymous <", value, "evaluateAnonymous");
            return (Criteria) this;
        }

        public Criteria andEvaluateAnonymousLessThanOrEqualTo(Integer value) {
            addCriterion("evaluate_anonymous <=", value, "evaluateAnonymous");
            return (Criteria) this;
        }

        public Criteria andEvaluateAnonymousIn(List<Integer> values) {
            addCriterion("evaluate_anonymous in", values, "evaluateAnonymous");
            return (Criteria) this;
        }

        public Criteria andEvaluateAnonymousNotIn(List<Integer> values) {
            addCriterion("evaluate_anonymous not in", values, "evaluateAnonymous");
            return (Criteria) this;
        }

        public Criteria andEvaluateAnonymousBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_anonymous between", value1, value2, "evaluateAnonymous");
            return (Criteria) this;
        }

        public Criteria andEvaluateAnonymousNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_anonymous not between", value1, value2, "evaluateAnonymous");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsimageIsNull() {
            addCriterion("evaluate_isimage is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsimageIsNotNull() {
            addCriterion("evaluate_isimage is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsimageEqualTo(Integer value) {
            addCriterion("evaluate_isimage =", value, "evaluateIsimage");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsimageNotEqualTo(Integer value) {
            addCriterion("evaluate_isimage <>", value, "evaluateIsimage");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsimageGreaterThan(Integer value) {
            addCriterion("evaluate_isimage >", value, "evaluateIsimage");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsimageGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluate_isimage >=", value, "evaluateIsimage");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsimageLessThan(Integer value) {
            addCriterion("evaluate_isimage <", value, "evaluateIsimage");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsimageLessThanOrEqualTo(Integer value) {
            addCriterion("evaluate_isimage <=", value, "evaluateIsimage");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsimageIn(List<Integer> values) {
            addCriterion("evaluate_isimage in", values, "evaluateIsimage");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsimageNotIn(List<Integer> values) {
            addCriterion("evaluate_isimage not in", values, "evaluateIsimage");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsimageBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_isimage between", value1, value2, "evaluateIsimage");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsimageNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_isimage not between", value1, value2, "evaluateIsimage");
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