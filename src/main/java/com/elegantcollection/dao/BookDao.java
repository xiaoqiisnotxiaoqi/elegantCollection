package com.elegantcollection.dao;

import com.elegantcollection.entity.Book;
import com.elegantcollection.entity.BookExample;
import com.elegantcollection.entity.BookWithBLOBs;

import java.util.List;

import com.elegantcollection.util.PageModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Component
public interface BookDao {
    long countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(Integer bookId);

    int insert(BookWithBLOBs record);

    int insertSelective(BookWithBLOBs record);

    List<BookWithBLOBs> selectByExampleWithBLOBs(BookExample example);

    List<Book> selectByExample(BookExample example);

    BookWithBLOBs selectByPrimaryKey(Integer bookId);

    List<Book> selectBookByAuthorId(Integer authorId);

    List<Book> selectBookByBookSalesTotal(PageModel<Book> pageModel);

    List<Book> selectBookByBookSalesLastMonth(PageModel<Book> pageModel);

    List<Book> selectBookByBookSalesLastMonthAndBookCategory(Integer categoryId,PageModel<Book> pageModel);

    Integer selectCountAll();

    Integer selectCountOne(Integer categoryId);

    int updateByExampleSelective(@Param("record") BookWithBLOBs record, @Param("example") BookExample example);

    int updateByExampleWithBLOBs(@Param("record") BookWithBLOBs record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(BookWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BookWithBLOBs record);

    int updateByPrimaryKey(Book record);
}