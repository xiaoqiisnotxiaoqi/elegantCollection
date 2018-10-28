package com.elegantcollection.service;

import com.elegantcollection.entity.ShopOrderDetail;

import java.util.HashMap;
import java.util.List;


public interface ShopOrderDetailService {
    /**
     * 查询订单详情
     * @param orderId 订单id
     * @return 订单详情与书的情况（一个订单内的所有书籍）
     */
    List<HashMap<String,Object>>  queryByOrderId(Integer orderId);

    /**
     * 添加订单
     * @param shopOrderDetail
     * @return
     */
    int add(ShopOrderDetail shopOrderDetail);
}
