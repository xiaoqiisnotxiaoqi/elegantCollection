package com.elegantcollection.dao;

import com.elegantcollection.entity.Evaluate;
import com.elegantcollection.entity.EvaluateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface EvaluateDao {
    long countByExample(EvaluateExample example);

    int deleteByExample(EvaluateExample example);

    int deleteByPrimaryKey(Integer evaluateId);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    List<Evaluate> selectByExampleWithBLOBs(EvaluateExample example);

    List<Evaluate> selectByExample(EvaluateExample example);

    Evaluate selectByPrimaryKey(Integer evaluateId);

    int updateByExampleSelective(@Param("record") Evaluate record, @Param("example") EvaluateExample example);

    int updateByExampleWithBLOBs(@Param("record") Evaluate record, @Param("example") EvaluateExample example);

    int updateByExample(@Param("record") Evaluate record, @Param("example") EvaluateExample example);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKeyWithBLOBs(Evaluate record);

    int updateByPrimaryKey(Evaluate record);
}