package com.elegantcollection.dao;

import com.elegantcollection.entity.Block;
import com.elegantcollection.entity.BlockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface BlockDao {
    long countByExample(BlockExample example);

    int deleteByExample(BlockExample example);

    int deleteByPrimaryKey(Integer blockId);

    int insert(Block record);

    int insertSelective(Block record);

    List<Block> selectByExample(BlockExample example);

    Block selectByPrimaryKey(Integer blockId);

    int updateByExampleSelective(@Param("record") Block record, @Param("example") BlockExample example);

    int updateByExample(@Param("record") Block record, @Param("example") BlockExample example);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);
}