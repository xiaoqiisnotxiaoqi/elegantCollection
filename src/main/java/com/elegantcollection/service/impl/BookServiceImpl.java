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
    private BookOrderDao bookOrderDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }


    /**
     * 根据条件分页查询图书(计数)
     *
     * @param map 查询条件
     * @return 数量
     */
    @Override
    public Integer countByCondition(HashMap map) {
        BookExample bookExample = new BookExample();
        BookExample.Criteria criterion1 = bookExample.createCriteria();
        BookExample.Criteria criterion2 = bookExample.createCriteria();


        //        根据bookid集合查询,查询在此集合中的图书
        if (map.get("bookIdList") != null) {

            criterion1.andBookIdIn((List<Integer>) map.get("bookIdList"));
        }

        //        根据关键字
        if (map.get("keyWord") != null && map.get("keyWord") != "")
            criterion1.andBookNameLike("%" + map.get("keyWord") + "%");


        //         只看有货(status==1 表示有货,正在出售)
        if (map.get("bookStatus") != null && map.get("bookStatus") != "")
            criterion1.andBookStatusEqualTo((Integer) map.get("bookStatus"));


        //        根据语言
        if (map.get("bookLanguage") != null && map.get("bookLanguage") != "")
            criterion1.andBookLanguageEqualTo((String) map.get("bookLanguage"));

        //        根据价格区间
        if (map.get("minPrice") != null && map.get("minPrice") != "")
            criterion1.andBookSellingPriceGreaterThan((Float) map.get("minPrice"));

        if (map.get("maxPrice") != null && map.get("maxPrice") != "")
            criterion1.andBookSellingPriceLessThan((Float) map.get("maxPrice"));
//      只看优惠
        if (map.get("isDiscount") != null && map.get("isDiscount") != "")
            criterion1.andRedundancyFieldIsNotNull();

        //        排序方式
        if (map.get("orderBy") != null && map.get("orderBy") != "")
            bookExample.setOrderByClause((String) map.get("orderBy"));

        //        去重查询
        bookExample.setDistinct(true);
        return (int) bookDao.countByExample(bookExample);
    }

    /**
     * 多条件动态分页查询图书
     *
     * @param map 封装查询条件
     * @return 图书集合
     */
    @Override
    public List<BookWithBLOBs> queryByCondition(HashMap map) {
        BookExample bookExample = new BookExample();
        BookExample.Criteria criterion1 = bookExample.createCriteria();
        BookExample.Criteria criterion2 = bookExample.createCriteria();

//        根据bookid集合查询,查询在此集合中的图书
        if (map.get("bookIdList") != null) {
            criterion1.andBookIdIn((List<Integer>) map.get("bookIdList"));
        }

        //        根据关键字
        if (map.get("keyWord") != null && map.get("keyWord") != "")
            criterion1.andBookNameLike("%" + map.get("keyWord") + "%");


        //         只看有货(status==1 表示有货,正在出售)
        if (map.get("bookStatus") != null && map.get("bookStatus") != "")
            criterion1.andBookStatusEqualTo((Integer) map.get("bookStatus"));


        //        根据语言
        if (map.get("bookLanguage") != null && map.get("bookLanguage") != "")
            criterion1.andBookLanguageEqualTo((String) map.get("bookLanguage"));


        //        根据价格区间
        if (map.get("minPrice") != null && map.get("minPrice") != "")
            criterion1.andBookSellingPriceGreaterThan((Float) map.get("minPrice"));

        if (map.get("maxPrice") != null && map.get("maxPrice") != "")
            criterion1.andBookSellingPriceLessThan((Float) map.get("maxPrice"));


        //根据pagemodel查询
        if (map.get("pageModel") != null) {
            bookExample.setLimit(((PageModel) map.get("pageModel")).getPageSize());
            bookExample.setOffset((long) ((PageModel) map.get("pageModel")).getStartRecord());
        }
//      只看满减优惠
        if (map.get("isDiscount") != null && map.get("isDiscount") != "")
            criterion1.andRedundancyFieldIsNotNull();


//        排序方式
        if (map.get("orderBy") != null && map.get("orderBy") != "")
            bookExample.setOrderByClause((String) map.get("orderBy"));
//        表示去重查询
        bookExample.setDistinct(true);

        return bookDao.selectByExampleWithBLOBs(bookExample);
    }


    /**
     * 根据bookid查询所有图片
     *
     * @param bookId 图书ID
     * @return 图片集合
     */
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
     * @param bookId 图书ID
     * @return 评论数量
     */
    @Override
    public int countEvaluateByBookId(Integer bookId) {
        EvaluateExample evaluateExample = new EvaluateExample();
        EvaluateExample.Criteria criteria = evaluateExample.createCriteria();
        criteria.andBookIdEqualTo(bookId);
        return (int) evaluateDao.countByExample(evaluateExample);
    }


    /**
     * 根据bookid获得所有评论(分页)
     *
     * @param bookId    图书Id
     * @param pageModel PageModel对象
     * @return 评论集合
     */
    @Override
    public List<Evaluate> queryEvaluateListByBookId(Integer bookId, PageModel pageModel) {
        EvaluateExample evaluateExample = new EvaluateExample();
        EvaluateExample.Criteria criteria = evaluateExample.createCriteria();
        criteria.andBookIdEqualTo(bookId);
        evaluateExample.setLimit(pageModel.getPageSize());
        evaluateExample.setOffset((long) pageModel.getStartRecord());
        return evaluateDao.selectByExampleWithBLOBs(evaluateExample);
    }


    /**
     * 根据bookID获得作者对象
     *
     * @param bookId 图书Id
     * @return 作者对象
     */
    @Override
    public Author queryAuthorByBookId(Integer bookId) {
        AuthorExample authorExample = new AuthorExample();
        AuthorExample.Criteria criteria = authorExample.createCriteria();
        criteria.andAuthorIdEqualTo(bookId);

        return authorDao.selectByExampleWithBLOBs(authorExample).size() == 0 ? null : authorDao.selectByExampleWithBLOBs(authorExample).get(0);
    }


    /**
     * 根据id查询图书
     *
     * @param bookId 图书ID
     * @return book对象
     */
    @Override
    public Book quaryBookByBookId(Integer bookId) {
        return bookDao.selectByPrimaryKey(bookId);
    }


    /**
     * 根据分类ID查询图书
     *
     * @param categoryId 分类ID
     * @return 图书集合
     */
    @Override
    public List<Book> queryByCategoryId(Integer categoryId) {
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        BookExample.Criteria criteria2 = bookExample.createCriteria();
        BookExample.Criteria criteria3 = bookExample.createCriteria();
        bookExample.setDistinct(true);
        if (categoryId != null) {
            criteria.andBookMainCategoryEqualTo(categoryId);
            criteria2.andBookFirstCategoryEqualTo(categoryId);
            criteria3.andBookSecondCategoryEqualTo(categoryId);
            bookExample.or(criteria2);
            bookExample.or(criteria3);
        }
        return bookDao.selectByExample(bookExample);
    }

    /**
     * 查询展示的书单(3条记录)
     *
     * @return 书单集合
     */
    @Override
    public List<BookOrder> queryBookOrder() {
        BookOrderExample bookOrderExample = new BookOrderExample();
        BookOrderExample.Criteria criteria = bookOrderExample.createCriteria();

        criteria.andOrderStatusEqualTo(1);
        bookOrderExample.setLimit(3);
        bookOrderExample.setOffset(0l);
        return bookOrderDao.selectByExample(bookOrderExample);
    }


}
