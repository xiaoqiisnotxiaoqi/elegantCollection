package com.elegantcollection.dao;

import com.elegantcollection.entity.ShopOrderDetail;
import com.elegantcollection.entity.ShopOrderDetailExample;
import com.elegantcollection.entity.ShopOrderDetailKey;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopOrderDetailDao {
    long countByExample(ShopOrderDetailExample example);

    int deleteByExample(ShopOrderDetailExample example);

    int deleteByPrimaryKey(ShopOrderDetailKey key);

    int insert(ShopOrderDetail record);

    int insertSelective(ShopOrderDetail record);

    List<ShopOrderDetail> selectByExample(ShopOrderDetailExample example);

    ShopOrderDetail selectByPrimaryKey(ShopOrderDetailKey key);

    int updateByExampleSelective(@Param("record") ShopOrderDetail record, @Param("example") ShopOrderDetailExample example);

    int updateByExample(@Param("record") ShopOrderDetail record, @Param("example") ShopOrderDetailExample example);

    int updateByPrimaryKeySelective(ShopOrderDetail record);

    int updateByPrimaryKey(ShopOrderDetail record);

    List<HashMap<String,Object>> selectByOrderId4Detail(Integer value);
}