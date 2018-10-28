package com.elegantcollection.service;


import com.elegantcollection.entity.Discount;
import com.elegantcollection.entity.DiscountDetail;


public interface DiscountService {


    /**
     * 根据优惠id 查询该优惠的详情
     * @param discountId 优惠的id
     * @return 该优惠的详情
     */
    Discount quertDiscountByDiscountId(Integer discountId);


    /**
     * 根据优惠的id 查询该优惠对应的详情的详细内容
     * @param discountId 优惠id
     * @return 优惠详情的详细内容
     */
    DiscountDetail quereDiscountDetailByDiscountId(Integer discountId);



}
