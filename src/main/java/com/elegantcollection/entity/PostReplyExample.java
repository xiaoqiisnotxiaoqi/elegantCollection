package com.elegantcollection.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostReplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public PostReplyExample() {
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

        public Criteria andReplyIdIsNull() {
            addCriterion("reply_id is null");
            return (Criteria) this;
        }

        public Criteria andReplyIdIsNotNull() {
            addCriterion("reply_id is not null");
            return (Criteria) this;
        }

        public Criteria andReplyIdEqualTo(Integer value) {
            addCriterion("reply_id =", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotEqualTo(Integer value) {
            addCriterion("reply_id <>", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdGreaterThan(Integer value) {
            addCriterion("reply_id >", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_id >=", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdLessThan(Integer value) {
            addCriterion("reply_id <", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("reply_id <=", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdIn(List<Integer> values) {
            addCriterion("reply_id in", values, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotIn(List<Integer> values) {
            addCriterion("reply_id not in", values, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdBetween(Integer value1, Integer value2) {
            addCriterion("reply_id between", value1, value2, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_id not between", value1, value2, "replyId");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNull() {
            addCriterion("post_id is null");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNotNull() {
            addCriterion("post_id is not null");
            return (Criteria) this;
        }

        public Criteria andPostIdEqualTo(Integer value) {
            addCriterion("post_id =", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotEqualTo(Integer value) {
            addCriterion("post_id <>", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThan(Integer value) {
            addCriterion("post_id >", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("post_id >=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThan(Integer value) {
            addCriterion("post_id <", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThanOrEqualTo(Integer value) {
            addCriterion("post_id <=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdIn(List<Integer> values) {
            addCriterion("post_id in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotIn(List<Integer> values) {
            addCriterion("post_id not in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdBetween(Integer value1, Integer value2) {
            addCriterion("post_id between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotBetween(Integer value1, Integer value2) {
            addCriterion("post_id not between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andByReplyIdIsNull() {
            addCriterion("by_reply_id is null");
            return (Criteria) this;
        }

        public Criteria andByReplyIdIsNotNull() {
            addCriterion("by_reply_id is not null");
            return (Criteria) this;
        }

        public Criteria andByReplyIdEqualTo(Integer value) {
            addCriterion("by_reply_id =", value, "byReplyId");
            return (Criteria) this;
        }

        public Criteria andByReplyIdNotEqualTo(Integer value) {
            addCriterion("by_reply_id <>", value, "byReplyId");
            return (Criteria) this;
        }

        public Criteria andByReplyIdGreaterThan(Integer value) {
            addCriterion("by_reply_id >", value, "byReplyId");
            return (Criteria) this;
        }

        public Criteria andByReplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("by_reply_id >=", value, "byReplyId");
            return (Criteria) this;
        }

        public Criteria andByReplyIdLessThan(Integer value) {
            addCriterion("by_reply_id <", value, "byReplyId");
            return (Criteria) this;
        }

        public Criteria andByReplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("by_reply_id <=", value, "byReplyId");
            return (Criteria) this;
        }

        public Criteria andByReplyIdIn(List<Integer> values) {
            addCriterion("by_reply_id in", values, "byReplyId");
            return (Criteria) this;
        }

        public Criteria andByReplyIdNotIn(List<Integer> values) {
            addCriterion("by_reply_id not in", values, "byReplyId");
            return (Criteria) this;
        }

        public Criteria andByReplyIdBetween(Integer value1, Integer value2) {
            addCriterion("by_reply_id between", value1, value2, "byReplyId");
            return (Criteria) this;
        }

        public Criteria andByReplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("by_reply_id not between", value1, value2, "byReplyId");
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

        public Criteria andByReadIsNull() {
            addCriterion("by_read is null");
            return (Criteria) this;
        }

        public Criteria andByReadIsNotNull() {
            addCriterion("by_read is not null");
            return (Criteria) this;
        }

        public Criteria andByReadEqualTo(String value) {
            addCriterion("by_read =", value, "byRead");
            return (Criteria) this;
        }

        public Criteria andByReadNotEqualTo(String value) {
            addCriterion("by_read <>", value, "byRead");
            return (Criteria) this;
        }

        public Criteria andByReadGreaterThan(String value) {
            addCriterion("by_read >", value, "byRead");
            return (Criteria) this;
        }

        public Criteria andByReadGreaterThanOrEqualTo(String value) {
            addCriterion("by_read >=", value, "byRead");
            return (Criteria) this;
        }

        public Criteria andByReadLessThan(String value) {
            addCriterion("by_read <", value, "byRead");
            return (Criteria) this;
        }

        public Criteria andByReadLessThanOrEqualTo(String value) {
            addCriterion("by_read <=", value, "byRead");
            return (Criteria) this;
        }

        public Criteria andByReadLike(String value) {
            addCriterion("by_read like", value, "byRead");
            return (Criteria) this;
        }

        public Criteria andByReadNotLike(String value) {
            addCriterion("by_read not like", value, "byRead");
            return (Criteria) this;
        }

        public Criteria andByReadIn(List<String> values) {
            addCriterion("by_read in", values, "byRead");
            return (Criteria) this;
        }

        public Criteria andByReadNotIn(List<String> values) {
            addCriterion("by_read not in", values, "byRead");
            return (Criteria) this;
        }

        public Criteria andByReadBetween(String value1, String value2) {
            addCriterion("by_read between", value1, value2, "byRead");
            return (Criteria) this;
        }

        public Criteria andByReadNotBetween(String value1, String value2) {
            addCriterion("by_read not between", value1, value2, "byRead");
            return (Criteria) this;
        }

        public Criteria andReplyTextIsNull() {
            addCriterion("reply_text is null");
            return (Criteria) this;
        }

        public Criteria andReplyTextIsNotNull() {
            addCriterion("reply_text is not null");
            return (Criteria) this;
        }

        public Criteria andReplyTextEqualTo(String value) {
            addCriterion("reply_text =", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextNotEqualTo(String value) {
            addCriterion("reply_text <>", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextGreaterThan(String value) {
            addCriterion("reply_text >", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextGreaterThanOrEqualTo(String value) {
            addCriterion("reply_text >=", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextLessThan(String value) {
            addCriterion("reply_text <", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextLessThanOrEqualTo(String value) {
            addCriterion("reply_text <=", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextLike(String value) {
            addCriterion("reply_text like", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextNotLike(String value) {
            addCriterion("reply_text not like", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextIn(List<String> values) {
            addCriterion("reply_text in", values, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextNotIn(List<String> values) {
            addCriterion("reply_text not in", values, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextBetween(String value1, String value2) {
            addCriterion("reply_text between", value1, value2, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextNotBetween(String value1, String value2) {
            addCriterion("reply_text not between", value1, value2, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIsNull() {
            addCriterion("reply_time is null");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIsNotNull() {
            addCriterion("reply_time is not null");
            return (Criteria) this;
        }

        public Criteria andReplyTimeEqualTo(Date value) {
            addCriterion("reply_time =", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotEqualTo(Date value) {
            addCriterion("reply_time <>", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeGreaterThan(Date value) {
            addCriterion("reply_time >", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reply_time >=", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeLessThan(Date value) {
            addCriterion("reply_time <", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("reply_time <=", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIn(List<Date> values) {
            addCriterion("reply_time in", values, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotIn(List<Date> values) {
            addCriterion("reply_time not in", values, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeBetween(Date value1, Date value2) {
            addCriterion("reply_time between", value1, value2, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("reply_time not between", value1, value2, "replyTime");
            return (Criteria) this;
        }

        public Criteria andIsReplyIdIsNull() {
            addCriterion("is_reply_id is null");
            return (Criteria) this;
        }

        public Criteria andIsReplyIdIsNotNull() {
            addCriterion("is_reply_id is not null");
            return (Criteria) this;
        }

        public Criteria andIsReplyIdEqualTo(Integer value) {
            addCriterion("is_reply_id =", value, "isReplyId");
            return (Criteria) this;
        }

        public Criteria andIsReplyIdNotEqualTo(Integer value) {
            addCriterion("is_reply_id <>", value, "isReplyId");
            return (Criteria) this;
        }

        public Criteria andIsReplyIdGreaterThan(Integer value) {
            addCriterion("is_reply_id >", value, "isReplyId");
            return (Criteria) this;
        }

        public Criteria andIsReplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_reply_id >=", value, "isReplyId");
            return (Criteria) this;
        }

        public Criteria andIsReplyIdLessThan(Integer value) {
            addCriterion("is_reply_id <", value, "isReplyId");
            return (Criteria) this;
        }

        public Criteria andIsReplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("is_reply_id <=", value, "isReplyId");
            return (Criteria) this;
        }

        public Criteria andIsReplyIdIn(List<Integer> values) {
            addCriterion("is_reply_id in", values, "isReplyId");
            return (Criteria) this;
        }

        public Criteria andIsReplyIdNotIn(List<Integer> values) {
            addCriterion("is_reply_id not in", values, "isReplyId");
            return (Criteria) this;
        }

        public Criteria andIsReplyIdBetween(Integer value1, Integer value2) {
            addCriterion("is_reply_id between", value1, value2, "isReplyId");
            return (Criteria) this;
        }

        public Criteria andIsReplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("is_reply_id not between", value1, value2, "isReplyId");
            return (Criteria) this;
        }

        public Criteria andReplyStatusIsNull() {
            addCriterion("reply_status is null");
            return (Criteria) this;
        }

        public Criteria andReplyStatusIsNotNull() {
            addCriterion("reply_status is not null");
            return (Criteria) this;
        }

        public Criteria andReplyStatusEqualTo(Integer value) {
            addCriterion("reply_status =", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusNotEqualTo(Integer value) {
            addCriterion("reply_status <>", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusGreaterThan(Integer value) {
            addCriterion("reply_status >", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_status >=", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusLessThan(Integer value) {
            addCriterion("reply_status <", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusLessThanOrEqualTo(Integer value) {
            addCriterion("reply_status <=", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusIn(List<Integer> values) {
            addCriterion("reply_status in", values, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusNotIn(List<Integer> values) {
            addCriterion("reply_status not in", values, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusBetween(Integer value1, Integer value2) {
            addCriterion("reply_status between", value1, value2, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_status not between", value1, value2, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andRedundancyField1IsNull() {
            addCriterion("redundancy_field1 is null");
            return (Criteria) this;
        }

        public Criteria andRedundancyField1IsNotNull() {
            addCriterion("redundancy_field1 is not null");
            return (Criteria) this;
        }

        public Criteria andRedundancyField1EqualTo(String value) {
            addCriterion("redundancy_field1 =", value, "redundancyField1");
            return (Criteria) this;
        }

        public Criteria andRedundancyField1NotEqualTo(String value) {
            addCriterion("redundancy_field1 <>", value, "redundancyField1");
            return (Criteria) this;
        }

        public Criteria andRedundancyField1GreaterThan(String value) {
            addCriterion("redundancy_field1 >", value, "redundancyField1");
            return (Criteria) this;
        }

        public Criteria andRedundancyField1GreaterThanOrEqualTo(String value) {
            addCriterion("redundancy_field1 >=", value, "redundancyField1");
            return (Criteria) this;
        }

        public Criteria andRedundancyField1LessThan(String value) {
            addCriterion("redundancy_field1 <", value, "redundancyField1");
            return (Criteria) this;
        }

        public Criteria andRedundancyField1LessThanOrEqualTo(String value) {
            addCriterion("redundancy_field1 <=", value, "redundancyField1");
            return (Criteria) this;
        }

        public Criteria andRedundancyField1Like(String value) {
            addCriterion("redundancy_field1 like", value, "redundancyField1");
            return (Criteria) this;
        }

        public Criteria andRedundancyField1NotLike(String value) {
            addCriterion("redundancy_field1 not like", value, "redundancyField1");
            return (Criteria) this;
        }

        public Criteria andRedundancyField1In(List<String> values) {
            addCriterion("redundancy_field1 in", values, "redundancyField1");
            return (Criteria) this;
        }

        public Criteria andRedundancyField1NotIn(List<String> values) {
            addCriterion("redundancy_field1 not in", values, "redundancyField1");
            return (Criteria) this;
        }

        public Criteria andRedundancyField1Between(String value1, String value2) {
            addCriterion("redundancy_field1 between", value1, value2, "redundancyField1");
            return (Criteria) this;
        }

        public Criteria andRedundancyField1NotBetween(String value1, String value2) {
            addCriterion("redundancy_field1 not between", value1, value2, "redundancyField1");
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