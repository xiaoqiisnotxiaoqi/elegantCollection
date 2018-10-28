package com.elegantcollection.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ShopOrderExample() {
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

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(Long value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(Long value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(Long value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(Long value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(Long value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<Long> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<Long> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(Long value1, Long value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(Long value1, Long value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
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

        public Criteria andOrderCreateTimeIsNull() {
            addCriterion("order_create_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIsNotNull() {
            addCriterion("order_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeEqualTo(Date value) {
            addCriterion("order_create_time =", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotEqualTo(Date value) {
            addCriterion("order_create_time <>", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeGreaterThan(Date value) {
            addCriterion("order_create_time >", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_create_time >=", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeLessThan(Date value) {
            addCriterion("order_create_time <", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_create_time <=", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIn(List<Date> values) {
            addCriterion("order_create_time in", values, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotIn(List<Date> values) {
            addCriterion("order_create_time not in", values, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeBetween(Date value1, Date value2) {
            addCriterion("order_create_time between", value1, value2, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_create_time not between", value1, value2, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNull() {
            addCriterion("order_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNotNull() {
            addCriterion("order_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceEqualTo(Float value) {
            addCriterion("order_price =", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotEqualTo(Float value) {
            addCriterion("order_price <>", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThan(Float value) {
            addCriterion("order_price >", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("order_price >=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThan(Float value) {
            addCriterion("order_price <", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThanOrEqualTo(Float value) {
            addCriterion("order_price <=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIn(List<Float> values) {
            addCriterion("order_price in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotIn(List<Float> values) {
            addCriterion("order_price not in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceBetween(Float value1, Float value2) {
            addCriterion("order_price between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotBetween(Float value1, Float value2) {
            addCriterion("order_price not between", value1, value2, "orderPrice");
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

        public Criteria andAddressIdIsNull() {
            addCriterion("address_id is null");
            return (Criteria) this;
        }

        public Criteria andAddressIdIsNotNull() {
            addCriterion("address_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddressIdEqualTo(Integer value) {
            addCriterion("address_id =", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotEqualTo(Integer value) {
            addCriterion("address_id <>", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThan(Integer value) {
            addCriterion("address_id >", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("address_id >=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThan(Integer value) {
            addCriterion("address_id <", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThanOrEqualTo(Integer value) {
            addCriterion("address_id <=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdIn(List<Integer> values) {
            addCriterion("address_id in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotIn(List<Integer> values) {
            addCriterion("address_id not in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdBetween(Integer value1, Integer value2) {
            addCriterion("address_id between", value1, value2, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotBetween(Integer value1, Integer value2) {
            addCriterion("address_id not between", value1, value2, "addressId");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIsNull() {
            addCriterion("discount_amount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIsNotNull() {
            addCriterion("discount_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountEqualTo(String value) {
            addCriterion("discount_amount =", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotEqualTo(String value) {
            addCriterion("discount_amount <>", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountGreaterThan(String value) {
            addCriterion("discount_amount >", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountGreaterThanOrEqualTo(String value) {
            addCriterion("discount_amount >=", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountLessThan(String value) {
            addCriterion("discount_amount <", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountLessThanOrEqualTo(String value) {
            addCriterion("discount_amount <=", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountLike(String value) {
            addCriterion("discount_amount like", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotLike(String value) {
            addCriterion("discount_amount not like", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIn(List<String> values) {
            addCriterion("discount_amount in", values, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotIn(List<String> values) {
            addCriterion("discount_amount not in", values, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountBetween(String value1, String value2) {
            addCriterion("discount_amount between", value1, value2, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotBetween(String value1, String value2) {
            addCriterion("discount_amount not between", value1, value2, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNull() {
            addCriterion("payment_time is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNotNull() {
            addCriterion("payment_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeEqualTo(Date value) {
            addCriterion("payment_time =", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotEqualTo(Date value) {
            addCriterion("payment_time <>", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThan(Date value) {
            addCriterion("payment_time >", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("payment_time >=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThan(Date value) {
            addCriterion("payment_time <", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThanOrEqualTo(Date value) {
            addCriterion("payment_time <=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIn(List<Date> values) {
            addCriterion("payment_time in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotIn(List<Date> values) {
            addCriterion("payment_time not in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeBetween(Date value1, Date value2) {
            addCriterion("payment_time between", value1, value2, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotBetween(Date value1, Date value2) {
            addCriterion("payment_time not between", value1, value2, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andOutlibraryTimeIsNull() {
            addCriterion("outlibrary_time is null");
            return (Criteria) this;
        }

        public Criteria andOutlibraryTimeIsNotNull() {
            addCriterion("outlibrary_time is not null");
            return (Criteria) this;
        }

        public Criteria andOutlibraryTimeEqualTo(Date value) {
            addCriterion("outlibrary_time =", value, "outlibraryTime");
            return (Criteria) this;
        }

        public Criteria andOutlibraryTimeNotEqualTo(Date value) {
            addCriterion("outlibrary_time <>", value, "outlibraryTime");
            return (Criteria) this;
        }

        public Criteria andOutlibraryTimeGreaterThan(Date value) {
            addCriterion("outlibrary_time >", value, "outlibraryTime");
            return (Criteria) this;
        }

        public Criteria andOutlibraryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("outlibrary_time >=", value, "outlibraryTime");
            return (Criteria) this;
        }

        public Criteria andOutlibraryTimeLessThan(Date value) {
            addCriterion("outlibrary_time <", value, "outlibraryTime");
            return (Criteria) this;
        }

        public Criteria andOutlibraryTimeLessThanOrEqualTo(Date value) {
            addCriterion("outlibrary_time <=", value, "outlibraryTime");
            return (Criteria) this;
        }

        public Criteria andOutlibraryTimeIn(List<Date> values) {
            addCriterion("outlibrary_time in", values, "outlibraryTime");
            return (Criteria) this;
        }

        public Criteria andOutlibraryTimeNotIn(List<Date> values) {
            addCriterion("outlibrary_time not in", values, "outlibraryTime");
            return (Criteria) this;
        }

        public Criteria andOutlibraryTimeBetween(Date value1, Date value2) {
            addCriterion("outlibrary_time between", value1, value2, "outlibraryTime");
            return (Criteria) this;
        }

        public Criteria andOutlibraryTimeNotBetween(Date value1, Date value2) {
            addCriterion("outlibrary_time not between", value1, value2, "outlibraryTime");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyIdIsNull() {
            addCriterion("courier_company_id is null");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyIdIsNotNull() {
            addCriterion("courier_company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyIdEqualTo(String value) {
            addCriterion("courier_company_id =", value, "courierCompanyId");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyIdNotEqualTo(String value) {
            addCriterion("courier_company_id <>", value, "courierCompanyId");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyIdGreaterThan(String value) {
            addCriterion("courier_company_id >", value, "courierCompanyId");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("courier_company_id >=", value, "courierCompanyId");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyIdLessThan(String value) {
            addCriterion("courier_company_id <", value, "courierCompanyId");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("courier_company_id <=", value, "courierCompanyId");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyIdLike(String value) {
            addCriterion("courier_company_id like", value, "courierCompanyId");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyIdNotLike(String value) {
            addCriterion("courier_company_id not like", value, "courierCompanyId");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyIdIn(List<String> values) {
            addCriterion("courier_company_id in", values, "courierCompanyId");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyIdNotIn(List<String> values) {
            addCriterion("courier_company_id not in", values, "courierCompanyId");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyIdBetween(String value1, String value2) {
            addCriterion("courier_company_id between", value1, value2, "courierCompanyId");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyIdNotBetween(String value1, String value2) {
            addCriterion("courier_company_id not between", value1, value2, "courierCompanyId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdIsNull() {
            addCriterion("logistics_id is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdIsNotNull() {
            addCriterion("logistics_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdEqualTo(String value) {
            addCriterion("logistics_id =", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotEqualTo(String value) {
            addCriterion("logistics_id <>", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdGreaterThan(String value) {
            addCriterion("logistics_id >", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_id >=", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdLessThan(String value) {
            addCriterion("logistics_id <", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdLessThanOrEqualTo(String value) {
            addCriterion("logistics_id <=", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdLike(String value) {
            addCriterion("logistics_id like", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotLike(String value) {
            addCriterion("logistics_id not like", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdIn(List<String> values) {
            addCriterion("logistics_id in", values, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotIn(List<String> values) {
            addCriterion("logistics_id not in", values, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdBetween(String value1, String value2) {
            addCriterion("logistics_id between", value1, value2, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotBetween(String value1, String value2) {
            addCriterion("logistics_id not between", value1, value2, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andExpectationTimeIsNull() {
            addCriterion("expectation_time is null");
            return (Criteria) this;
        }

        public Criteria andExpectationTimeIsNotNull() {
            addCriterion("expectation_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpectationTimeEqualTo(Date value) {
            addCriterion("expectation_time =", value, "expectationTime");
            return (Criteria) this;
        }

        public Criteria andExpectationTimeNotEqualTo(Date value) {
            addCriterion("expectation_time <>", value, "expectationTime");
            return (Criteria) this;
        }

        public Criteria andExpectationTimeGreaterThan(Date value) {
            addCriterion("expectation_time >", value, "expectationTime");
            return (Criteria) this;
        }

        public Criteria andExpectationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expectation_time >=", value, "expectationTime");
            return (Criteria) this;
        }

        public Criteria andExpectationTimeLessThan(Date value) {
            addCriterion("expectation_time <", value, "expectationTime");
            return (Criteria) this;
        }

        public Criteria andExpectationTimeLessThanOrEqualTo(Date value) {
            addCriterion("expectation_time <=", value, "expectationTime");
            return (Criteria) this;
        }

        public Criteria andExpectationTimeIn(List<Date> values) {
            addCriterion("expectation_time in", values, "expectationTime");
            return (Criteria) this;
        }

        public Criteria andExpectationTimeNotIn(List<Date> values) {
            addCriterion("expectation_time not in", values, "expectationTime");
            return (Criteria) this;
        }

        public Criteria andExpectationTimeBetween(Date value1, Date value2) {
            addCriterion("expectation_time between", value1, value2, "expectationTime");
            return (Criteria) this;
        }

        public Criteria andExpectationTimeNotBetween(Date value1, Date value2) {
            addCriterion("expectation_time not between", value1, value2, "expectationTime");
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