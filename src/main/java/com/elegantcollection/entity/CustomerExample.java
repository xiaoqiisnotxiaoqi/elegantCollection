package com.elegantcollection.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public CustomerExample() {
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

        public Criteria andCustPhoneIsNull() {
            addCriterion("cust_phone is null");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIsNotNull() {
            addCriterion("cust_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCustPhoneEqualTo(String value) {
            addCriterion("cust_phone =", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotEqualTo(String value) {
            addCriterion("cust_phone <>", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneGreaterThan(String value) {
            addCriterion("cust_phone >", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("cust_phone >=", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLessThan(String value) {
            addCriterion("cust_phone <", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLessThanOrEqualTo(String value) {
            addCriterion("cust_phone <=", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLike(String value) {
            addCriterion("cust_phone like", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotLike(String value) {
            addCriterion("cust_phone not like", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIn(List<String> values) {
            addCriterion("cust_phone in", values, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotIn(List<String> values) {
            addCriterion("cust_phone not in", values, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneBetween(String value1, String value2) {
            addCriterion("cust_phone between", value1, value2, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotBetween(String value1, String value2) {
            addCriterion("cust_phone not between", value1, value2, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustQqIsNull() {
            addCriterion("cust_qq is null");
            return (Criteria) this;
        }

        public Criteria andCustQqIsNotNull() {
            addCriterion("cust_qq is not null");
            return (Criteria) this;
        }

        public Criteria andCustQqEqualTo(String value) {
            addCriterion("cust_qq =", value, "custQq");
            return (Criteria) this;
        }

        public Criteria andCustQqNotEqualTo(String value) {
            addCriterion("cust_qq <>", value, "custQq");
            return (Criteria) this;
        }

        public Criteria andCustQqGreaterThan(String value) {
            addCriterion("cust_qq >", value, "custQq");
            return (Criteria) this;
        }

        public Criteria andCustQqGreaterThanOrEqualTo(String value) {
            addCriterion("cust_qq >=", value, "custQq");
            return (Criteria) this;
        }

        public Criteria andCustQqLessThan(String value) {
            addCriterion("cust_qq <", value, "custQq");
            return (Criteria) this;
        }

        public Criteria andCustQqLessThanOrEqualTo(String value) {
            addCriterion("cust_qq <=", value, "custQq");
            return (Criteria) this;
        }

        public Criteria andCustQqLike(String value) {
            addCriterion("cust_qq like", value, "custQq");
            return (Criteria) this;
        }

        public Criteria andCustQqNotLike(String value) {
            addCriterion("cust_qq not like", value, "custQq");
            return (Criteria) this;
        }

        public Criteria andCustQqIn(List<String> values) {
            addCriterion("cust_qq in", values, "custQq");
            return (Criteria) this;
        }

        public Criteria andCustQqNotIn(List<String> values) {
            addCriterion("cust_qq not in", values, "custQq");
            return (Criteria) this;
        }

        public Criteria andCustQqBetween(String value1, String value2) {
            addCriterion("cust_qq between", value1, value2, "custQq");
            return (Criteria) this;
        }

        public Criteria andCustQqNotBetween(String value1, String value2) {
            addCriterion("cust_qq not between", value1, value2, "custQq");
            return (Criteria) this;
        }

        public Criteria andCustWechatIsNull() {
            addCriterion("cust_wechat is null");
            return (Criteria) this;
        }

        public Criteria andCustWechatIsNotNull() {
            addCriterion("cust_wechat is not null");
            return (Criteria) this;
        }

        public Criteria andCustWechatEqualTo(String value) {
            addCriterion("cust_wechat =", value, "custWechat");
            return (Criteria) this;
        }

        public Criteria andCustWechatNotEqualTo(String value) {
            addCriterion("cust_wechat <>", value, "custWechat");
            return (Criteria) this;
        }

        public Criteria andCustWechatGreaterThan(String value) {
            addCriterion("cust_wechat >", value, "custWechat");
            return (Criteria) this;
        }

        public Criteria andCustWechatGreaterThanOrEqualTo(String value) {
            addCriterion("cust_wechat >=", value, "custWechat");
            return (Criteria) this;
        }

        public Criteria andCustWechatLessThan(String value) {
            addCriterion("cust_wechat <", value, "custWechat");
            return (Criteria) this;
        }

        public Criteria andCustWechatLessThanOrEqualTo(String value) {
            addCriterion("cust_wechat <=", value, "custWechat");
            return (Criteria) this;
        }

        public Criteria andCustWechatLike(String value) {
            addCriterion("cust_wechat like", value, "custWechat");
            return (Criteria) this;
        }

        public Criteria andCustWechatNotLike(String value) {
            addCriterion("cust_wechat not like", value, "custWechat");
            return (Criteria) this;
        }

        public Criteria andCustWechatIn(List<String> values) {
            addCriterion("cust_wechat in", values, "custWechat");
            return (Criteria) this;
        }

        public Criteria andCustWechatNotIn(List<String> values) {
            addCriterion("cust_wechat not in", values, "custWechat");
            return (Criteria) this;
        }

        public Criteria andCustWechatBetween(String value1, String value2) {
            addCriterion("cust_wechat between", value1, value2, "custWechat");
            return (Criteria) this;
        }

        public Criteria andCustWechatNotBetween(String value1, String value2) {
            addCriterion("cust_wechat not between", value1, value2, "custWechat");
            return (Criteria) this;
        }

        public Criteria andCustPasswordIsNull() {
            addCriterion("cust_password is null");
            return (Criteria) this;
        }

        public Criteria andCustPasswordIsNotNull() {
            addCriterion("cust_password is not null");
            return (Criteria) this;
        }

        public Criteria andCustPasswordEqualTo(String value) {
            addCriterion("cust_password =", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordNotEqualTo(String value) {
            addCriterion("cust_password <>", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordGreaterThan(String value) {
            addCriterion("cust_password >", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("cust_password >=", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordLessThan(String value) {
            addCriterion("cust_password <", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordLessThanOrEqualTo(String value) {
            addCriterion("cust_password <=", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordLike(String value) {
            addCriterion("cust_password like", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordNotLike(String value) {
            addCriterion("cust_password not like", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordIn(List<String> values) {
            addCriterion("cust_password in", values, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordNotIn(List<String> values) {
            addCriterion("cust_password not in", values, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordBetween(String value1, String value2) {
            addCriterion("cust_password between", value1, value2, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordNotBetween(String value1, String value2) {
            addCriterion("cust_password not between", value1, value2, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNull() {
            addCriterion("cust_name is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("cust_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("cust_name =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("cust_name <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("cust_name >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("cust_name >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("cust_name <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("cust_name <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("cust_name like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("cust_name not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("cust_name in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("cust_name not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("cust_name between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("cust_name not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustGenderIsNull() {
            addCriterion("cust_gender is null");
            return (Criteria) this;
        }

        public Criteria andCustGenderIsNotNull() {
            addCriterion("cust_gender is not null");
            return (Criteria) this;
        }

        public Criteria andCustGenderEqualTo(Integer value) {
            addCriterion("cust_gender =", value, "custGender");
            return (Criteria) this;
        }

        public Criteria andCustGenderNotEqualTo(Integer value) {
            addCriterion("cust_gender <>", value, "custGender");
            return (Criteria) this;
        }

        public Criteria andCustGenderGreaterThan(Integer value) {
            addCriterion("cust_gender >", value, "custGender");
            return (Criteria) this;
        }

        public Criteria andCustGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("cust_gender >=", value, "custGender");
            return (Criteria) this;
        }

        public Criteria andCustGenderLessThan(Integer value) {
            addCriterion("cust_gender <", value, "custGender");
            return (Criteria) this;
        }

        public Criteria andCustGenderLessThanOrEqualTo(Integer value) {
            addCriterion("cust_gender <=", value, "custGender");
            return (Criteria) this;
        }

        public Criteria andCustGenderIn(List<Integer> values) {
            addCriterion("cust_gender in", values, "custGender");
            return (Criteria) this;
        }

        public Criteria andCustGenderNotIn(List<Integer> values) {
            addCriterion("cust_gender not in", values, "custGender");
            return (Criteria) this;
        }

        public Criteria andCustGenderBetween(Integer value1, Integer value2) {
            addCriterion("cust_gender between", value1, value2, "custGender");
            return (Criteria) this;
        }

        public Criteria andCustGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("cust_gender not between", value1, value2, "custGender");
            return (Criteria) this;
        }

        public Criteria andCustProfileIsNull() {
            addCriterion("cust_profile is null");
            return (Criteria) this;
        }

        public Criteria andCustProfileIsNotNull() {
            addCriterion("cust_profile is not null");
            return (Criteria) this;
        }

        public Criteria andCustProfileEqualTo(String value) {
            addCriterion("cust_profile =", value, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileNotEqualTo(String value) {
            addCriterion("cust_profile <>", value, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileGreaterThan(String value) {
            addCriterion("cust_profile >", value, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileGreaterThanOrEqualTo(String value) {
            addCriterion("cust_profile >=", value, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileLessThan(String value) {
            addCriterion("cust_profile <", value, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileLessThanOrEqualTo(String value) {
            addCriterion("cust_profile <=", value, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileLike(String value) {
            addCriterion("cust_profile like", value, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileNotLike(String value) {
            addCriterion("cust_profile not like", value, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileIn(List<String> values) {
            addCriterion("cust_profile in", values, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileNotIn(List<String> values) {
            addCriterion("cust_profile not in", values, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileBetween(String value1, String value2) {
            addCriterion("cust_profile between", value1, value2, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileNotBetween(String value1, String value2) {
            addCriterion("cust_profile not between", value1, value2, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustPointsIsNull() {
            addCriterion("cust_points is null");
            return (Criteria) this;
        }

        public Criteria andCustPointsIsNotNull() {
            addCriterion("cust_points is not null");
            return (Criteria) this;
        }

        public Criteria andCustPointsEqualTo(Integer value) {
            addCriterion("cust_points =", value, "custPoints");
            return (Criteria) this;
        }

        public Criteria andCustPointsNotEqualTo(Integer value) {
            addCriterion("cust_points <>", value, "custPoints");
            return (Criteria) this;
        }

        public Criteria andCustPointsGreaterThan(Integer value) {
            addCriterion("cust_points >", value, "custPoints");
            return (Criteria) this;
        }

        public Criteria andCustPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("cust_points >=", value, "custPoints");
            return (Criteria) this;
        }

        public Criteria andCustPointsLessThan(Integer value) {
            addCriterion("cust_points <", value, "custPoints");
            return (Criteria) this;
        }

        public Criteria andCustPointsLessThanOrEqualTo(Integer value) {
            addCriterion("cust_points <=", value, "custPoints");
            return (Criteria) this;
        }

        public Criteria andCustPointsIn(List<Integer> values) {
            addCriterion("cust_points in", values, "custPoints");
            return (Criteria) this;
        }

        public Criteria andCustPointsNotIn(List<Integer> values) {
            addCriterion("cust_points not in", values, "custPoints");
            return (Criteria) this;
        }

        public Criteria andCustPointsBetween(Integer value1, Integer value2) {
            addCriterion("cust_points between", value1, value2, "custPoints");
            return (Criteria) this;
        }

        public Criteria andCustPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("cust_points not between", value1, value2, "custPoints");
            return (Criteria) this;
        }

        public Criteria andCustMailIsNull() {
            addCriterion("cust_mail is null");
            return (Criteria) this;
        }

        public Criteria andCustMailIsNotNull() {
            addCriterion("cust_mail is not null");
            return (Criteria) this;
        }

        public Criteria andCustMailEqualTo(String value) {
            addCriterion("cust_mail =", value, "custMail");
            return (Criteria) this;
        }

        public Criteria andCustMailNotEqualTo(String value) {
            addCriterion("cust_mail <>", value, "custMail");
            return (Criteria) this;
        }

        public Criteria andCustMailGreaterThan(String value) {
            addCriterion("cust_mail >", value, "custMail");
            return (Criteria) this;
        }

        public Criteria andCustMailGreaterThanOrEqualTo(String value) {
            addCriterion("cust_mail >=", value, "custMail");
            return (Criteria) this;
        }

        public Criteria andCustMailLessThan(String value) {
            addCriterion("cust_mail <", value, "custMail");
            return (Criteria) this;
        }

        public Criteria andCustMailLessThanOrEqualTo(String value) {
            addCriterion("cust_mail <=", value, "custMail");
            return (Criteria) this;
        }

        public Criteria andCustMailLike(String value) {
            addCriterion("cust_mail like", value, "custMail");
            return (Criteria) this;
        }

        public Criteria andCustMailNotLike(String value) {
            addCriterion("cust_mail not like", value, "custMail");
            return (Criteria) this;
        }

        public Criteria andCustMailIn(List<String> values) {
            addCriterion("cust_mail in", values, "custMail");
            return (Criteria) this;
        }

        public Criteria andCustMailNotIn(List<String> values) {
            addCriterion("cust_mail not in", values, "custMail");
            return (Criteria) this;
        }

        public Criteria andCustMailBetween(String value1, String value2) {
            addCriterion("cust_mail between", value1, value2, "custMail");
            return (Criteria) this;
        }

        public Criteria andCustMailNotBetween(String value1, String value2) {
            addCriterion("cust_mail not between", value1, value2, "custMail");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNull() {
            addCriterion("register_time is null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNotNull() {
            addCriterion("register_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeEqualTo(Date value) {
            addCriterionForJDBCDate("register_time =", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("register_time <>", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("register_time >", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("register_time >=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThan(Date value) {
            addCriterionForJDBCDate("register_time <", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("register_time <=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIn(List<Date> values) {
            addCriterionForJDBCDate("register_time in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("register_time not in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("register_time between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("register_time not between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andCustStatusIsNull() {
            addCriterion("cust_status is null");
            return (Criteria) this;
        }

        public Criteria andCustStatusIsNotNull() {
            addCriterion("cust_status is not null");
            return (Criteria) this;
        }

        public Criteria andCustStatusEqualTo(Integer value) {
            addCriterion("cust_status =", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusNotEqualTo(Integer value) {
            addCriterion("cust_status <>", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusGreaterThan(Integer value) {
            addCriterion("cust_status >", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("cust_status >=", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusLessThan(Integer value) {
            addCriterion("cust_status <", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusLessThanOrEqualTo(Integer value) {
            addCriterion("cust_status <=", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusIn(List<Integer> values) {
            addCriterion("cust_status in", values, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusNotIn(List<Integer> values) {
            addCriterion("cust_status not in", values, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusBetween(Integer value1, Integer value2) {
            addCriterion("cust_status between", value1, value2, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("cust_status not between", value1, value2, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCummStatusIsNull() {
            addCriterion("cumm_status is null");
            return (Criteria) this;
        }

        public Criteria andCummStatusIsNotNull() {
            addCriterion("cumm_status is not null");
            return (Criteria) this;
        }

        public Criteria andCummStatusEqualTo(Integer value) {
            addCriterion("cumm_status =", value, "cummStatus");
            return (Criteria) this;
        }

        public Criteria andCummStatusNotEqualTo(Integer value) {
            addCriterion("cumm_status <>", value, "cummStatus");
            return (Criteria) this;
        }

        public Criteria andCummStatusGreaterThan(Integer value) {
            addCriterion("cumm_status >", value, "cummStatus");
            return (Criteria) this;
        }

        public Criteria andCummStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("cumm_status >=", value, "cummStatus");
            return (Criteria) this;
        }

        public Criteria andCummStatusLessThan(Integer value) {
            addCriterion("cumm_status <", value, "cummStatus");
            return (Criteria) this;
        }

        public Criteria andCummStatusLessThanOrEqualTo(Integer value) {
            addCriterion("cumm_status <=", value, "cummStatus");
            return (Criteria) this;
        }

        public Criteria andCummStatusIn(List<Integer> values) {
            addCriterion("cumm_status in", values, "cummStatus");
            return (Criteria) this;
        }

        public Criteria andCummStatusNotIn(List<Integer> values) {
            addCriterion("cumm_status not in", values, "cummStatus");
            return (Criteria) this;
        }

        public Criteria andCummStatusBetween(Integer value1, Integer value2) {
            addCriterion("cumm_status between", value1, value2, "cummStatus");
            return (Criteria) this;
        }

        public Criteria andCummStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("cumm_status not between", value1, value2, "cummStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusIsNull() {
            addCriterion("login_status is null");
            return (Criteria) this;
        }

        public Criteria andLoginStatusIsNotNull() {
            addCriterion("login_status is not null");
            return (Criteria) this;
        }

        public Criteria andLoginStatusEqualTo(Integer value) {
            addCriterion("login_status =", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusNotEqualTo(Integer value) {
            addCriterion("login_status <>", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusGreaterThan(Integer value) {
            addCriterion("login_status >", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_status >=", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusLessThan(Integer value) {
            addCriterion("login_status <", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusLessThanOrEqualTo(Integer value) {
            addCriterion("login_status <=", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusIn(List<Integer> values) {
            addCriterion("login_status in", values, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusNotIn(List<Integer> values) {
            addCriterion("login_status not in", values, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusBetween(Integer value1, Integer value2) {
            addCriterion("login_status between", value1, value2, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("login_status not between", value1, value2, "loginStatus");
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