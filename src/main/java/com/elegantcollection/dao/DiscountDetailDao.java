package com.elegantcollection.dao;

import com.elegantcollection.entity.DiscountDetail;
import com.elegantcollection.entity.DiscountDetailExample;
import com.elegantcollection.entity.DiscountDetailKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface DiscountDetailDao {
    long countByExample(DiscountDetailExample example);

    int deleteByExample(DiscountDetailExample example);

    int deleteByPrimaryKey(DiscountDetailKey key);

    int insert(DiscountDetail record);

    int insertSelective(DiscountDetail record);

    List<DiscountDetail> selectByExample(DiscountDetailExample example);

    DiscountDetail selectByPrimaryKey(DiscountDetailKey key);

    int updateByExampleSelective(@Param("record") DiscountDetail record, @Param("example") DiscountDetailExample example);

    int updateByExample(@Param("record") DiscountDetail record, @Param("example") DiscountDetailExample example);

    int updateByPrimaryKeySelective(DiscountDetail record);

    int updateByPrimaryKey(DiscountDetail record);
}