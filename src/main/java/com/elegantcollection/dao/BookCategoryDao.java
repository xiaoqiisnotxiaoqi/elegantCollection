package com.elegantcollection.dao;

import com.elegantcollection.entity.BookCategory;
import com.elegantcollection.entity.BookCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface BookCategoryDao {
    long countByExample(BookCategoryExample example);

    int deleteByExample(BookCategoryExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(BookCategory record);

    int insertSelective(BookCategory record);

    List<BookCategory> selectByExample(BookCategoryExample example);

    BookCategory selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") BookCategory record, @Param("example") BookCategoryExample example);

    int updateByExample(@Param("record") BookCategory record, @Param("example") BookCategoryExample example);

    int updateByPrimaryKeySelective(BookCategory record);

    int updateByPrimaryKey(BookCategory record);
}