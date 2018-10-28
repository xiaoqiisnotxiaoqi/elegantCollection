package com.elegantcollection.dao;

import com.elegantcollection.entity.ShopOrder;
import com.elegantcollection.entity.ShopOrderExample;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopOrderDao {
    long countByExample(ShopOrderExample example);

    int deleteByExample(ShopOrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(ShopOrder record);

    int insertSelective(ShopOrder record);

    List<ShopOrder> selectByExample(ShopOrderExample example);

    ShopOrder selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") ShopOrder record, @Param("example") ShopOrderExample example);

    int updateByExample(@Param("record") ShopOrder record, @Param("example") ShopOrderExample example);

    int updateByPrimaryKeySelective(ShopOrder record);

    int updateByPrimaryKey(ShopOrder record);

    List<ShopOrder> selectByBookName(HashMap<String, Object> conditions);

    List<ShopOrder>selectByBookName4Size(HashMap<String, Object> conditions);
}