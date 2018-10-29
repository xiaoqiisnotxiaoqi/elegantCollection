package com.elegantcollection.service;

import com.elegantcollection.entity.BookCategory;

import java.util.List;

public interface BookCategoryService {
    /**
     * 根据关键字模糊查询出符合的分类集合
     *
     * @param keyWord 关键字
     * @return 分类集合
     */
    List<BookCategory> queryByKeyWord(String keyWord);


    /**
     * 根据分类ID查询该分类所有的子分类
     *
     * @param categoryId 分类Id
     * @return 子分类集合
     */
    List<BookCategory> queryChildById(Integer categoryId);


    /**
     * 根据分类ID查询分类对象
     *
     * @param categoryId 分类ID
     * @return 分类对象
     */
    BookCategory queryCategoryById(Integer categoryId);

}
