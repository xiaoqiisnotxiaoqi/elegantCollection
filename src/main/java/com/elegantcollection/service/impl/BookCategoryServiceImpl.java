package com.elegantcollection.service.impl;

import com.elegantcollection.dao.BookCategoryDao;
import com.elegantcollection.entity.BookCategory;
import com.elegantcollection.entity.BookCategoryExample;
import com.elegantcollection.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    @Autowired
    private BookCategoryDao bookCategoryDao;


    /**
     * 根据关键字模糊查询出所有的名称符合的分类
     *
     * @param keyWord 关键字
     * @return 分类集合
     */
    @Override
    public List<BookCategory> queryByKeyWord(String keyWord) {
        BookCategoryExample bookCategoryExample = new BookCategoryExample();
        BookCategoryExample.Criteria criteria = bookCategoryExample.createCriteria();

        criteria.andCategoryNameLike("%" + keyWord + "%");
        bookCategoryExample.setDistinct(true);
        return bookCategoryDao.selectByExample(bookCategoryExample);
    }

    /**
     * 根据分类Id查询出所有的子分类
     *
     * @param categoryId 分类Id
     * @return 子分类集合
     */
    @Override
    public List<BookCategory> queryChildById(Integer categoryId) {
        BookCategoryExample bookCategoryExample = new BookCategoryExample();
        BookCategoryExample.Criteria criteria = bookCategoryExample.createCriteria();

        criteria.andCategoryUpIdEqualTo(categoryId);

        return bookCategoryDao.selectByExample(bookCategoryExample);
    }

    /**
     * 根据ID查询出分类对象
     *
     * @param categoryId 分类ID
     * @return 分类对象
     */
    @Override
    public BookCategory queryCategoryById(Integer categoryId) {
        BookCategoryExample bookCategoryExample = new BookCategoryExample();
        BookCategoryExample.Criteria criteria = bookCategoryExample.createCriteria();

        criteria.andCategoryIdEqualTo(categoryId);
        return bookCategoryDao.selectByExample(bookCategoryExample).get(0);
    }
}
