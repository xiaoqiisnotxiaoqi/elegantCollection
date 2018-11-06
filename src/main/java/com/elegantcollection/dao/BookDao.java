package com.elegantcollection.dao;

import com.elegantcollection.entity.Book;
import com.elegantcollection.entity.BookExample;
import com.elegantcollection.entity.BookWithBLOBs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.elegantcollection.util.PageModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Component
public interface BookDao {

    /**
     * 自定义查询首页数据
     *
     * @param map 查询条件(包含排序依据,分类ID)
     * @return 图书集合
     */
    List<Book> selectIndexData(HashMap map);


    /**
     * 自定义多条件动态分页查询-分页计数
     *
     * @param map 查询条件
     * @return 数量
     */
    int testCount(HashMap map);

    /**
     * 自定义多条件动态分页查询
     *
     * @param map 封装查询条件
     * @return 图书集合
     */
    List<BookWithBLOBs> test(HashMap map);

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

    List<Book> selectBookByBookSalesLastMonthAndBookCategory(Map<String, Object> map);

    Integer selectCountAll();

    Integer selectCountOne(Integer categoryId);

    int updateByExampleSelective(@Param("record") BookWithBLOBs record, @Param("example") BookExample example);

    int updateByExampleWithBLOBs(@Param("record") BookWithBLOBs record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(BookWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BookWithBLOBs record);

    int updateByPrimaryKey(Book record);
}