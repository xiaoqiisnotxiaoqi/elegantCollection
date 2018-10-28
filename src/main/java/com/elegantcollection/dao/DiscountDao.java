package com.elegantcollection.dao;

import com.elegantcollection.entity.Discount;
import com.elegantcollection.entity.DiscountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface DiscountDao {
    long countByExample(DiscountExample example);

    int deleteByExample(DiscountExample example);

    int insert(Discount record);

    int insertSelective(Discount record);

    List<Discount> selectByExample(DiscountExample example);

    int updateByExampleSelective(@Param("record") Discount record, @Param("example") DiscountExample example);

    int updateByExample(@Param("record") Discount record, @Param("example") DiscountExample example);
}