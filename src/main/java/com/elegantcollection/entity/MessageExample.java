package com.elegantcollection.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public MessageExample() {
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

        public Criteria andMessageIdIsNull() {
            addCriterion("message_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageIdIsNotNull() {
            addCriterion("message_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageIdEqualTo(Integer value) {
            addCriterion("message_id =", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotEqualTo(Integer value) {
            addCriterion("message_id <>", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThan(Integer value) {
            addCriterion("message_id >", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_id >=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThan(Integer value) {
            addCriterion("message_id <", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThanOrEqualTo(Integer value) {
            addCriterion("message_id <=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdIn(List<Integer> values) {
            addCriterion("message_id in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotIn(List<Integer> values) {
            addCriterion("message_id not in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdBetween(Integer value1, Integer value2) {
            addCriterion("message_id between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("message_id not between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andSenderIdIsNull() {
            addCriterion("sender_id is null");
            return (Criteria) this;
        }

        public Criteria andSenderIdIsNotNull() {
            addCriterion("sender_id is not null");
            return (Criteria) this;
        }

        public Criteria andSenderIdEqualTo(Integer value) {
            addCriterion("sender_id =", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdNotEqualTo(Integer value) {
            addCriterion("sender_id <>", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdGreaterThan(Integer value) {
            addCriterion("sender_id >", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sender_id >=", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdLessThan(Integer value) {
            addCriterion("sender_id <", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdLessThanOrEqualTo(Integer value) {
            addCriterion("sender_id <=", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdIn(List<Integer> values) {
            addCriterion("sender_id in", values, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdNotIn(List<Integer> values) {
            addCriterion("sender_id not in", values, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdBetween(Integer value1, Integer value2) {
            addCriterion("sender_id between", value1, value2, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sender_id not between", value1, value2, "senderId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdIsNull() {
            addCriterion("recipients_id is null");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdIsNotNull() {
            addCriterion("recipients_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdEqualTo(Integer value) {
            addCriterion("recipients_id =", value, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdNotEqualTo(Integer value) {
            addCriterion("recipients_id <>", value, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdGreaterThan(Integer value) {
            addCriterion("recipients_id >", value, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("recipients_id >=", value, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdLessThan(Integer value) {
            addCriterion("recipients_id <", value, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdLessThanOrEqualTo(Integer value) {
            addCriterion("recipients_id <=", value, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdIn(List<Integer> values) {
            addCriterion("recipients_id in", values, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdNotIn(List<Integer> values) {
            addCriterion("recipients_id not in", values, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdBetween(Integer value1, Integer value2) {
            addCriterion("recipients_id between", value1, value2, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("recipients_id not between", value1, value2, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIsNull() {
            addCriterion("message_type is null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIsNotNull() {
            addCriterion("message_type is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeEqualTo(Integer value) {
            addCriterion("message_type =", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotEqualTo(Integer value) {
            addCriterion("message_type <>", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeGreaterThan(Integer value) {
            addCriterion("message_type >", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_type >=", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeLessThan(Integer value) {
            addCriterion("message_type <", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeLessThanOrEqualTo(Integer value) {
            addCriterion("message_type <=", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIn(List<Integer> values) {
            addCriterion("message_type in", values, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotIn(List<Integer> values) {
            addCriterion("message_type not in", values, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeBetween(Integer value1, Integer value2) {
            addCriterion("message_type between", value1, value2, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("message_type not between", value1, value2, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTimeIsNull() {
            addCriterion("message_time is null");
            return (Criteria) this;
        }

        public Criteria andMessageTimeIsNotNull() {
            addCriterion("message_time is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTimeEqualTo(Date value) {
            addCriterion("message_time =", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeNotEqualTo(Date value) {
            addCriterion("message_time <>", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeGreaterThan(Date value) {
            addCriterion("message_time >", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("message_time >=", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeLessThan(Date value) {
            addCriterion("message_time <", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeLessThanOrEqualTo(Date value) {
            addCriterion("message_time <=", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeIn(List<Date> values) {
            addCriterion("message_time in", values, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeNotIn(List<Date> values) {
            addCriterion("message_time not in", values, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeBetween(Date value1, Date value2) {
            addCriterion("message_time between", value1, value2, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeNotBetween(Date value1, Date value2) {
            addCriterion("message_time not between", value1, value2, "messageTime");
            return (Criteria) this;
        }

        public Criteria andReadStatusIsNull() {
            addCriterion("read_status is null");
            return (Criteria) this;
        }

        public Criteria andReadStatusIsNotNull() {
            addCriterion("read_status is not null");
            return (Criteria) this;
        }

        public Criteria andReadStatusEqualTo(Integer value) {
            addCriterion("read_status =", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusNotEqualTo(Integer value) {
            addCriterion("read_status <>", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusGreaterThan(Integer value) {
            addCriterion("read_status >", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_status >=", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusLessThan(Integer value) {
            addCriterion("read_status <", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusLessThanOrEqualTo(Integer value) {
            addCriterion("read_status <=", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusIn(List<Integer> values) {
            addCriterion("read_status in", values, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusNotIn(List<Integer> values) {
            addCriterion("read_status not in", values, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusBetween(Integer value1, Integer value2) {
            addCriterion("read_status between", value1, value2, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("read_status not between", value1, value2, "readStatus");
            return (Criteria) this;
        }

        public Criteria andMessageImgIsNull() {
            addCriterion("message_img is null");
            return (Criteria) this;
        }

        public Criteria andMessageImgIsNotNull() {
            addCriterion("message_img is not null");
            return (Criteria) this;
        }

        public Criteria andMessageImgEqualTo(String value) {
            addCriterion("message_img =", value, "messageImg");
            return (Criteria) this;
        }

        public Criteria andMessageImgNotEqualTo(String value) {
            addCriterion("message_img <>", value, "messageImg");
            return (Criteria) this;
        }

        public Criteria andMessageImgGreaterThan(String value) {
            addCriterion("message_img >", value, "messageImg");
            return (Criteria) this;
        }

        public Criteria andMessageImgGreaterThanOrEqualTo(String value) {
            addCriterion("message_img >=", value, "messageImg");
            return (Criteria) this;
        }

        public Criteria andMessageImgLessThan(String value) {
            addCriterion("message_img <", value, "messageImg");
            return (Criteria) this;
        }

        public Criteria andMessageImgLessThanOrEqualTo(String value) {
            addCriterion("message_img <=", value, "messageImg");
            return (Criteria) this;
        }

        public Criteria andMessageImgLike(String value) {
            addCriterion("message_img like", value, "messageImg");
            return (Criteria) this;
        }

        public Criteria andMessageImgNotLike(String value) {
            addCriterion("message_img not like", value, "messageImg");
            return (Criteria) this;
        }

        public Criteria andMessageImgIn(List<String> values) {
            addCriterion("message_img in", values, "messageImg");
            return (Criteria) this;
        }

        public Criteria andMessageImgNotIn(List<String> values) {
            addCriterion("message_img not in", values, "messageImg");
            return (Criteria) this;
        }

        public Criteria andMessageImgBetween(String value1, String value2) {
            addCriterion("message_img between", value1, value2, "messageImg");
            return (Criteria) this;
        }

        public Criteria andMessageImgNotBetween(String value1, String value2) {
            addCriterion("message_img not between", value1, value2, "messageImg");
            return (Criteria) this;
        }

        public Criteria andMessageStatusIsNull() {
            addCriterion("message_status is null");
            return (Criteria) this;
        }

        public Criteria andMessageStatusIsNotNull() {
            addCriterion("message_status is not null");
            return (Criteria) this;
        }

        public Criteria andMessageStatusEqualTo(Integer value) {
            addCriterion("message_status =", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusNotEqualTo(Integer value) {
            addCriterion("message_status <>", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusGreaterThan(Integer value) {
            addCriterion("message_status >", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_status >=", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusLessThan(Integer value) {
            addCriterion("message_status <", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusLessThanOrEqualTo(Integer value) {
            addCriterion("message_status <=", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusIn(List<Integer> values) {
            addCriterion("message_status in", values, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusNotIn(List<Integer> values) {
            addCriterion("message_status not in", values, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusBetween(Integer value1, Integer value2) {
            addCriterion("message_status between", value1, value2, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("message_status not between", value1, value2, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageIsimageIsNull() {
            addCriterion("message_isimage is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsimageIsNotNull() {
            addCriterion("message_isimage is not null");
            return (Criteria) this;
        }

        public Criteria andMessageIsimageEqualTo(Integer value) {
            addCriterion("message_isimage =", value, "messageIsimage");
            return (Criteria) this;
        }

        public Criteria andMessageIsimageNotEqualTo(Integer value) {
            addCriterion("message_isimage <>", value, "messageIsimage");
            return (Criteria) this;
        }

        public Criteria andMessageIsimageGreaterThan(Integer value) {
            addCriterion("message_isimage >", value, "messageIsimage");
            return (Criteria) this;
        }

        public Criteria andMessageIsimageGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_isimage >=", value, "messageIsimage");
            return (Criteria) this;
        }

        public Criteria andMessageIsimageLessThan(Integer value) {
            addCriterion("message_isimage <", value, "messageIsimage");
            return (Criteria) this;
        }

        public Criteria andMessageIsimageLessThanOrEqualTo(Integer value) {
            addCriterion("message_isimage <=", value, "messageIsimage");
            return (Criteria) this;
        }

        public Criteria andMessageIsimageIn(List<Integer> values) {
            addCriterion("message_isimage in", values, "messageIsimage");
            return (Criteria) this;
        }

        public Criteria andMessageIsimageNotIn(List<Integer> values) {
            addCriterion("message_isimage not in", values, "messageIsimage");
            return (Criteria) this;
        }

        public Criteria andMessageIsimageBetween(Integer value1, Integer value2) {
            addCriterion("message_isimage between", value1, value2, "messageIsimage");
            return (Criteria) this;
        }

        public Criteria andMessageIsimageNotBetween(Integer value1, Integer value2) {
            addCriterion("message_isimage not between", value1, value2, "messageIsimage");
            return (Criteria) this;
        }

        public Criteria andMessageWithdrawIsNull() {
            addCriterion("message_withdraw is null");
            return (Criteria) this;
        }

        public Criteria andMessageWithdrawIsNotNull() {
            addCriterion("message_withdraw is not null");
            return (Criteria) this;
        }

        public Criteria andMessageWithdrawEqualTo(Integer value) {
            addCriterion("message_withdraw =", value, "messageWithdraw");
            return (Criteria) this;
        }

        public Criteria andMessageWithdrawNotEqualTo(Integer value) {
            addCriterion("message_withdraw <>", value, "messageWithdraw");
            return (Criteria) this;
        }

        public Criteria andMessageWithdrawGreaterThan(Integer value) {
            addCriterion("message_withdraw >", value, "messageWithdraw");
            return (Criteria) this;
        }

        public Criteria andMessageWithdrawGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_withdraw >=", value, "messageWithdraw");
            return (Criteria) this;
        }

        public Criteria andMessageWithdrawLessThan(Integer value) {
            addCriterion("message_withdraw <", value, "messageWithdraw");
            return (Criteria) this;
        }

        public Criteria andMessageWithdrawLessThanOrEqualTo(Integer value) {
            addCriterion("message_withdraw <=", value, "messageWithdraw");
            return (Criteria) this;
        }

        public Criteria andMessageWithdrawIn(List<Integer> values) {
            addCriterion("message_withdraw in", values, "messageWithdraw");
            return (Criteria) this;
        }

        public Criteria andMessageWithdrawNotIn(List<Integer> values) {
            addCriterion("message_withdraw not in", values, "messageWithdraw");
            return (Criteria) this;
        }

        public Criteria andMessageWithdrawBetween(Integer value1, Integer value2) {
            addCriterion("message_withdraw between", value1, value2, "messageWithdraw");
            return (Criteria) this;
        }

        public Criteria andMessageWithdrawNotBetween(Integer value1, Integer value2) {
            addCriterion("message_withdraw not between", value1, value2, "messageWithdraw");
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