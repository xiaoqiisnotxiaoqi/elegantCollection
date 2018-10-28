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





    @Override
    public List<BookCategory> queryByKeyWord(String keyWord) {
        BookCategoryExample bookCategoryExample = new BookCategoryExample();
        BookCategoryExample.Criteria criteria = bookCategoryExample.createCriteria();

        criteria.andCategoryNameLike("%" + keyWord + "%");

        return bookCategoryDao.selectByExample(bookCategoryExample);
    }
}
