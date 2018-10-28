package com.elegantcollection.dao;

import com.elegantcollection.entity.Waiter;
import com.elegantcollection.entity.WaiterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface WaiterDao {
    long countByExample(WaiterExample example);

    int deleteByExample(WaiterExample example);

    int deleteByPrimaryKey(Integer waiterId);

    int insert(Waiter record);

    int insertSelective(Waiter record);

    List<Waiter> selectByExample(WaiterExample example);

    Waiter selectByPrimaryKey(Integer waiterId);

    int updateByExampleSelective(@Param("record") Waiter record, @Param("example") WaiterExample example);

    int updateByExample(@Param("record") Waiter record, @Param("example") WaiterExample example);

    int updateByPrimaryKeySelective(Waiter record);

    int updateByPrimaryKey(Waiter record);
}