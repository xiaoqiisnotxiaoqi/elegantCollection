package com.elegantcollection.dao;

import com.elegantcollection.entity.Book;
import com.elegantcollection.entity.BookExample;
import com.elegantcollection.entity.BookWithBLOBs;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Component
public interface BookDao {
    int testCount(HashMap map);

    List<BookWithBLOBs> test(HashMap map);

    long countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(Integer bookId);

    int insert(BookWithBLOBs record);

    int insertSelective(BookWithBLOBs record);

    List<BookWithBLOBs> selectByExampleWithBLOBs(BookExample example);

    List<Book> selectByExample(BookExample example);

    BookWithBLOBs selectByPrimaryKey(Integer bookId);

    int updateByExampleSelective(@Param("record") BookWithBLOBs record, @Param("example") BookExample example);

    int updateByExampleWithBLOBs(@Param("record") BookWithBLOBs record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(BookWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BookWithBLOBs record);

    int updateByPrimaryKey(Book record);
}