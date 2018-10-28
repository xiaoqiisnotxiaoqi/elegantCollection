package com.elegantcollection.service.impl;


import com.elegantcollection.dao.*;
import com.elegantcollection.entity.*;
import com.elegantcollection.service.BookService;
import com.elegantcollection.util.PageModel;
import org.mybatis.generator.codegen.ibatis2.model.ExampleGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private EvaluateDao evaluateDao;
    @Autowired
    private BookImgDao bookImgDao;
    @Autowired
    private final BookDao bookDao;
    @Autowired
    private BookCategoryDao bookCategoryDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    //分页查询所有
    @Override
    public Integer countAll() {
        BookExample bookExample = new BookExample();
        return (int) bookDao.countByExample(bookExample);
    }

    @Override
    public List<BookWithBLOBs> queryAll(PageModel pageModel) {
        BookExample bookExample = new BookExample();
        bookExample.setLimit(pageModel.getPageSize());
        bookExample.setOffset((long) pageModel.getStartRecord());


        return bookDao.selectByExampleWithBLOBs(bookExample);

    }

    //    根据bookid查询所有图片
    @Override
    public List<BookImg> queryBookImgsById(Integer bookId) {
        BookImgExample bookImgExample = new BookImgExample();
        BookImgExample.Criteria criteria = bookImgExample.createCriteria();

        criteria.andBookIdEqualTo(bookId);

        return bookImgDao.selectByExample(bookImgExample);
    }

    /**
     * 根据bookID获得评论数
     *
     * @param bookId
     * @return
     */
    @Override
    public int getEvaluateCountByBookId(Integer bookId) {
        EvaluateExample evaluateExample = new EvaluateExample();
        EvaluateExample.Criteria criteria = evaluateExample.createCriteria();
        criteria.andBookIdEqualTo(bookId);
        return (int) evaluateDao.countByExample(evaluateExample);


    }

    ////    根据bookid获得所有评论(分页)
    @Override
    public List<Evaluate> getEvaluateListByBookId(Integer bookId, PageModel pageModel) {
        EvaluateExample evaluateExample = new EvaluateExample();
        EvaluateExample.Criteria criteria = evaluateExample.createCriteria();
        criteria.andBookIdEqualTo(bookId);
        evaluateExample.setLimit(pageModel.getPageSize());
        evaluateExample.setOffset((long) pageModel.getStartRecord());
        return evaluateDao.selectByExampleWithBLOBs(evaluateExample);
    }

    @Override
    public Author getAuthorByBookId(Integer bookId) {
        AuthorExample authorExample = new AuthorExample();
        AuthorExample.Criteria criteria = authorExample.createCriteria();
        criteria.andAuthorIdEqualTo(bookId);

        return authorDao.selectByExampleWithBLOBs(authorExample).get(0);
    }


    @Override
    public Book quaryBookByBookId(Integer bookId) {
        return bookDao.selectByPrimaryKey(bookId);
    }


    /**
     * 根据分类ID计数
     *
     * @return
     */
    @Override
    public long countByCategoryId(Integer categoryId) {
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        BookExample.Criteria criteria2 = bookExample.createCriteria();
        BookExample.Criteria criteria3 = bookExample.createCriteria();
        bookExample.setDistinct(true);

        criteria.andBookMainCategoryEqualTo(categoryId);
        criteria2.andBookFirstCategoryEqualTo(categoryId);
        criteria3.andBookSecondCategoryEqualTo(categoryId);

        bookExample.or(criteria2);
        bookExample.or(criteria3);
        return bookDao.countByExample(bookExample);
    }

    /**
     * 根据分类ID分页查询
     *
     * @param pageModel pagemodel对象
     * @param map       封装了查询条件
     * @return
     */
    @Override
    public List<BookWithBLOBs> queryByCategoryId(HashMap map, PageModel<Book> pageModel) {
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        BookExample.Criteria criteria2 = bookExample.createCriteria();
        BookExample.Criteria criteria3 = bookExample.createCriteria();
        bookExample.setDistinct(true);

        criteria.andBookMainCategoryEqualTo((Integer) map.get("categoryId"));
        criteria2.andBookFirstCategoryEqualTo((Integer) map.get("categoryId"));
        criteria3.andBookSecondCategoryEqualTo((Integer) map.get("categoryId"));

        bookExample.or(criteria2);
        bookExample.or(criteria3);


        return bookDao.selectByExampleWithBLOBs(bookExample);
    }


}
