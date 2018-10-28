package com.elegantcollection.dao;

import com.elegantcollection.entity.Author;
import com.elegantcollection.entity.AuthorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface AuthorDao {
    long countByExample(AuthorExample example);

    int deleteByExample(AuthorExample example);

    int deleteByPrimaryKey(Integer authorId);

    int insert(Author record);

    int insertSelective(Author record);

    List<Author> selectByExampleWithBLOBs(AuthorExample example);

    List<Author> selectByExample(AuthorExample example);

    Author selectByPrimaryKey(Integer authorId);

    int updateByExampleSelective(@Param("record") Author record, @Param("example") AuthorExample example);

    int updateByExampleWithBLOBs(@Param("record") Author record, @Param("example") AuthorExample example);

    int updateByExample(@Param("record") Author record, @Param("example") AuthorExample example);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKeyWithBLOBs(Author record);

    int updateByPrimaryKey(Author record);
}