package com.elegantcollection.service;

import com.elegantcollection.entity.Cart;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


public interface CartService {

    /**
     * 根据用户id 查找该用户的购物车
     * @param custId 用户id
     * @return 用户购物车 商品集合
     */
    List<Cart>  quaryCartByCustId(Integer custId);

    /**
     * 根据用户的id  分页查找该用户购物车中的书籍
     * @param custId 用户的id
     * @param pageSize 每页显示的购物车数据数量
     * @param startRecord 本页开始显示数据的信息的位置(从第几条开始显示)
     * @return 第x页用户购物车集合
     */
    List<Cart> quaryCartByPage(Integer custId,Integer pageSize,Integer startRecord);


    /**
     * 根据用户id 图书id 删除购物车中的一种图书
     * @param bookId 要删除的图书id
     * @param custId 用户的id
     * @return 数据库受影响行数
     */
    Integer removeByBookId(String bookId,Integer custId);


}
