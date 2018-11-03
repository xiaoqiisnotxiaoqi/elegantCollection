package com.elegantcollection.service;

import com.elegantcollection.entity.ShopOrder;
import com.elegantcollection.util.PageModel;

import java.util.Date;
import java.util.List;


public interface ShopOrderService {


    /**
     * 添加订单（支付提交订单：订单创建时间为订单提交时间）
     *
     * @param shopOrder 订单
     * @return 添加情况
     */
    int add(ShopOrder shopOrder);


    /**
     * 删除订单（改变状态）
     *
     * @param orderId 订单id
     * @return
     */
    int removeByOrderId(Integer orderId);

    /**
     * 完全删除订单（改变状态）
     *
     * @param orderId 订单id
     * @return
     */
    int delByOrderId(Integer orderId);

    /**
     * 修改订单
     *
     * @param shopOrder 订单
     * @return
     */
    int alter(ShopOrder shopOrder);

    /**
     * 订单状态修改（状态后移）
     *
     * @param orderId 订单id
     * @return
     */
    int alterStatus(Integer orderId);

    /**
     * 根据订单id获取订单
     *
     * @param orderId 订单编号
     * @return
     */
    ShopOrder queryByOrderId(Integer orderId);

    /**
     * 根据订单编号获取订单
     *
     * @param orderNumber 订单编号
     * @return 影响行数
     */
    Integer queryByOrderNumber(Long orderNumber);

    /**
     * 查询相应分页的订单
     *
     * @param pageModel 分页模型
     * @return 订单列表
     */
    List<ShopOrder> queryByPage(Integer custId, PageModel<ShopOrder> pageModel);

    /**
     * 分页记录总数
     *
     * @return 结果数
     */
    Integer queryByPage4Size(Integer custId);

    /**
     * 根据状态,创建时间查询订单（待付款0，待发货1，待收货2，待评价3，已删除4,完全删除5）
     *
     * @param orderStatus 订单状态
     * @return 订单列表
     */
    List<ShopOrder> queryByState(Integer custId, Integer orderStatus, String timeState, PageModel<ShopOrder> pageModel);


    /**
     * 状态，创建时间分页记录总数
     *
     * @return 结果数
     */
    Integer queryByState4Size(Integer custId, Integer orderStatus, String createTime);

    /**
     * 根据输入订单编号查询订单
     *
     * @param orderNumber 订单编号
     * @return 订单列表
     */
    List<ShopOrder> queryByOrderNumber(Integer custId, String orderNumber, PageModel<ShopOrder> pageModel);


    /**
     * 根据图书名查询订单
     *
     * @param custId 用户ID，bookName 图书名
     * @return 订单列表
     */
    List<ShopOrder> queryByBookName(Integer custId, String bookName, PageModel<ShopOrder> pageModel);

    /**
     * 图书名分页记录总数
     *
     * @return 结果数
     */
    Integer queryByBookName4Size(Integer custId, String bookName);

    /**
     * 根据用户Id查询所有订单
     * @param custId  用户Id
     * @return 订单集合
     *
     */
    List<ShopOrder> queryByOreder(Integer custId,Integer orderStatus);
}
