package com.elegantcollection.service;


import com.elegantcollection.entity.*;
import com.elegantcollection.util.PageModel;
import com.elegantcollection.util.ServerResponse;

import java.util.HashMap;
import java.util.List;

public interface BookService {

    /**
     * 查询首页数据
     *
     * @return 首页需要的数据(新书上架, 书单信息, 几个排行榜, 作家推荐)
     */
    ServerResponse<HashMap> queryIndexData();

    /**
     * xml文件版本的多条件动态分页查询
     *
     * @param conditions 封装查询条件
     * @return 图书集合
     */
    ServerResponse<HashMap> sjTest(HashMap conditions);


    /**
     * 多条件动态,分页查询图书总数用于分页
     *
     * @param map 封装查询条件
     * @return 总数
     */
    Integer countByCondition(HashMap map);

    /**
     * 多条件动态,分页查询图书
     *
     * @param map 封装查询条件
     * @return 查询结果集合
     */
    List<BookWithBLOBs> queryByCondition(HashMap map);


    /**
     * 根据图书ID查询所有图片
     *
     * @param bookId 图书ID
     * @return 图片集合
     */
    List<BookImg> queryBookImgsById(Integer bookId);

    /**
     * 根据bookid查询评论数
     *
     * @param bookId 图书ID
     * @return 评论总数
     */
    int countEvaluateByBookId(Integer bookId);

    /**
     * 分页查询某本书的所有评论
     *
     * @param bookId    图书Id
     * @param pageModel PageModel对象
     * @return 该页的评论集合
     */
    List<Evaluate> queryEvaluateListByBookId(Integer bookId, PageModel pageModel);

    /**
     * 根据bookId查询出作者对象
     *
     * @param bookId 图书Id
     * @return 作者对象
     */
    Author queryAuthorByBookId(Integer bookId);

    /**
     * 根据图书id查找图书
     *
     * @param BookId 图书id
     * @return 图书对象
     */
    Book quaryBookByBookId(Integer BookId);


    /**
     * 根据分类ID查询符合的图书
     *
     * @param categoryId 分类ID
     * @return 图书集合
     */
    List<Book> queryByCategoryId(Integer categoryId);

    /**
     * 查询出展示的书单
     *
     * @return 书单集合
     */
    List<BookOrder> queryBookOrder();

    /**
     * 从图书详情页面添加图书到购物车
     *
     * @param custId    用户ID
     * @param bookId    图书ID
     * @param bookCount 图书数量
     * @return 添加结果(受影响行数)
     */
    ServerResponse<Integer> add2Cart(Integer custId, Integer bookId, Integer bookCount);

    /**
     * 根据作者id查询书籍
     *
     * @param authorId 作者id
     * @return 书集合
     */
    public List<Book> queryBookByAuthorId(Integer authorId);

    /**
     * 根据总销量降序查书
     *
     * @param pageModel
     * @return
     */
    public PageModel<Book> queryBookByBookSalesTotal(PageModel<Book> pageModel);

    /**
     * 根据上月销量降序查书
     *
     * @param pageModel
     * @return
     */
    public PageModel<Book> queryBookByBookSalesLastMonth(PageModel<Book> pageModel);

    /**
     * 根据上月销量和类别降序查书
     *
     * @param categoryId 类别id
     * @param pageModel
     * @return
     */
    public PageModel<Book> queryBookByBookSalesLastMonthAndBookCategory(Integer categoryId, PageModel<Book> pageModel);


    /**
     * 计数
     *
     * @return
     */
    public Integer queryCountAll();

    /**
     * 单一类别计数
     *
     * @param categoryId 类别id
     * @return
     */
    public Integer queryCountOne(Integer categoryId);
}
