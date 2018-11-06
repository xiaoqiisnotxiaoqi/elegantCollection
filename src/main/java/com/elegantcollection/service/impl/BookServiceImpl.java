package com.elegantcollection.service.impl;


import com.elegantcollection.dao.*;
import com.elegantcollection.entity.*;
import com.elegantcollection.service.BookService;
import com.elegantcollection.util.PageModel;
import com.elegantcollection.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    private CartDao cartDao;
    @Autowired
    private BlockDao blockDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    /**
     * 查询首页需要的数据
     *
     * @return
     */
    @Override
    public ServerResponse<HashMap> queryIndexData() {
//        查询新书上架:16本书
        BookExample bookExample = new BookExample();
        bookExample.setOrderByClause("book_time desc");
        bookExample.setOffset(0l);
        bookExample.setLimit(16);
        List<Book> bookList0 = bookDao.selectByExample(bookExample);
//        查询16本书的作者
        List<Author> newBookAuthors = new ArrayList();
        for (Book book : bookList0) {
            newBookAuthors.add(authorDao.selectByPrimaryKey(book.getAuthorId()));
        }

//        查询总排行前十
        HashMap condition1 = new HashMap();
        condition1.put("orderBy", "book_sales_total desc");
        List<Book> bookList1 = bookDao.selectIndexData(condition1);
//        查询文艺分类排行前十
        HashMap condition2 = new HashMap();
        condition2.put("categoryId", 10008);
        condition2.put("orderBy", "book_sales_total desc");
        List<Book> bookList2 = bookDao.selectIndexData(condition2);

//        查询人文社科排行前十
        HashMap condition3 = new HashMap();
        condition3.put("categoryId", 10013);
        condition3.put("orderBy", "book_sales_total desc");
        List<Book> bookList3 = bookDao.selectIndexData(condition3);
//        查询生活排行前十
        HashMap condition4 = new HashMap();
        condition4.put("categoryId", 10022);
        condition4.put("orderBy", "book_sales_total desc");
        List<Book> bookList4 = bookDao.selectIndexData(condition4);

//      获取科技排行
        HashMap condition5 = new HashMap();
        condition5.put("categortId", 10028);
        condition5.put("orderBy", "book_sales_total desc");
        List<Book> bookList5 = bookDao.selectIndexData(condition5);

//        获取三个书单
        List<BookOrder> bookOrders = queryBookOrder();


//        获取前十的作者
        AuthorExample authorExample = new AuthorExample();
        authorExample.setOffset(0l);
        authorExample.setLimit(10);
        List<Author> authorList = authorDao.selectByExampleWithBLOBs(authorExample);
//        获取排行第一的作者的(前四本)作品
        BookExample bookExample1 = new BookExample();
        bookExample1.createCriteria().andAuthorIdEqualTo(authorList.get(0).getAuthorId());
        bookExample1.setOffset(0l);
        bookExample1.setLimit(4);
        List<Book> anthorBookList = bookDao.selectByExample(bookExample1);

        HashMap result = new HashMap();
        result.put("bookList0", bookList0);
        result.put("newBookAuthors", newBookAuthors);
        result.put("bookList1", bookList1);
        result.put("bookList2", bookList2);
        result.put("bookList3", bookList3);
        result.put("bookList4", bookList4);
        result.put("bookList5", bookList5);
        result.put("bookOrders", bookOrders);
        result.put("authorList", authorList);
        result.put("anthorBookList", anthorBookList);
        return ServerResponse.createBySuccess("查询首页数据成功", result);
    }

    /**
     * xml文件版本的多条件动态分页查询
     *
     * @param conditions 封装查询条件
     * @return 封装了图书集合, 分页信息
     */
    @Override
    public ServerResponse<HashMap> sjTest(HashMap conditions) {
        HashMap result = new HashMap();

//        设置分页信息
        PageModel pageModel = new PageModel();
        if (conditions.get("pageCode") == null) {
            pageModel.setCurrentPageCode(1);
        } else {
            pageModel.setCurrentPageCode((Integer) conditions.get("pageCode"));
        }
        pageModel.setPageSize(15);
        pageModel.setTotalRecord(bookDao.testCount(conditions));
        pageModel.setTotalPages(pageModel.getTotalRecord() % pageModel.getPageSize() == 0 ? pageModel.getTotalRecord() / pageModel.getPageSize() : pageModel.getTotalRecord() / pageModel.getPageSize() + 1);
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());
        conditions.put("pageModel", pageModel);

        List<BookWithBLOBs> bookList = bookDao.test(conditions);
        pageModel.setModelList(bookList);

        result.put("pageModel", pageModel);

        List<Map<Integer, Integer>> evaluateCountList = new ArrayList<>();
        for (BookWithBLOBs book : bookList) {
            evaluateCountList.add(evaluateDao.selectEvaluateCountByBookId(book.getBookId()));
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + evaluateCountList);


//        根据分类ID查询子分类
        Integer categoryId = (Integer) conditions.get("categoryId");
        if (categoryId == null) {
            categoryId = 10034;
        }
        BookCategoryExample bookCategoryExample = new BookCategoryExample();
        bookCategoryExample.createCriteria().andCategoryUpIdEqualTo(categoryId);
        List<BookCategory> childCategoryList = bookCategoryDao.selectByExample(bookCategoryExample);
        result.put("childCategoryList", childCategoryList);


        return ServerResponse.createBySuccess("查询成功", result);


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
        criteria.andRedundancyFieldEqualTo("1");
        return bookImgDao.selectByExample(bookImgExample);
    }

    /**
     * 查询出商品详情图片
     *
     * @param bookId
     * @return
     */
    @Override
    public List<BookImg> queryBookDetailImgsById(Integer bookId) {
        BookImgExample bookImgExample = new BookImgExample();
        BookImgExample.Criteria criteria = bookImgExample.createCriteria();

        criteria.andBookIdEqualTo(bookId);
        criteria.andRedundancyFieldEqualTo("2");
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

    @Override
    public BookWithBLOBs queryBybookIntro(Integer BookId) {
        return bookDao.selectByPrimaryKey(BookId);
    }

    @Override
    public Block queryBlockByBookId(Integer bookId) {
        return blockDao.selectBlockByBookId(bookId);
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

    /**
     * 从详情页添添加到购物车
     *
     * @param custId    用户ID
     * @param bookId    图书ID
     * @param bookCount 图书数量
     * @return 受影响行数
     */
    @Override
    public ServerResponse<Integer> add2Cart(Integer custId, Integer bookId, Integer bookCount) {
        CartExample cartExample = new CartExample();
//        先查询购物车里是否已经存在
        cartExample.createCriteria().andCustIdEqualTo(custId).andBookIdEqualTo(bookId);
        List<Cart> carts = cartDao.selectByExample(cartExample);
        if (carts.size() != 0) {
            return ServerResponse.createByError("购物车中已存在!");
        } else {
//            添加操作
            Cart cart = new Cart(null, custId, bookId, bookCount, new Date(), 0, null, null);
            Integer rows = cartDao.insert(cart);
            if (rows == 1) {
                return ServerResponse.createBySuccess("添加成功!", rows);
            } else {
                return ServerResponse.createByError("添加失败");
            }
        }
    }

    /**
     * 根据作者id查询书籍
     *
     * @param authorId 作者id
     * @return 书集合
     */
    @Override
    public List<Book> queryBookByAuthorId(Integer authorId) {
        return bookDao.selectBookByAuthorId(authorId);
    }

    /**
     * 根据总销量降序查书
     *
     * @param pageModel
     * @return
     */
    @Override
    public PageModel<Book> queryBookByBookSalesTotal(PageModel<Book> pageModel) {
        List<Book> list = bookDao.selectBookByBookSalesTotal(pageModel);
        pageModel.setModelList(list);
        return pageModel;
    }

    /**
     * 根据上月销量降序查书
     *
     * @param pageModel
     * @return
     */
    @Override
    public PageModel<Book> queryBookByBookSalesLastMonth(PageModel<Book> pageModel) {
        List<Book> list = this.bookDao.selectBookByBookSalesLastMonth(pageModel);
        pageModel.setModelList(list);
        return pageModel;
    }

    /**
     * 根据上月销量和类别降序查书
     *
     * @param categoryId 类别id
     * @param pageModel
     * @return
     */
    @Override
    public PageModel<Book> queryBookByBookSalesLastMonthAndBookCategory(Integer categoryId, PageModel<Book> pageModel) {
        Map<String, Object> args = new HashMap<>();
        args.put("categoryId", categoryId);
        args.put("startRecord", pageModel.getStartRecord());
        args.put("pageSize", pageModel.getPageSize());
        List<Book> list = this.bookDao.selectBookByBookSalesLastMonthAndBookCategory(args);
        pageModel.setModelList(list);
        return pageModel;
    }

    /**
     * 计数
     *
     * @return
     */
    @Override
    public Integer queryCountAll() {
        return bookDao.selectCountAll();
    }

    /**
     * 单一类别计数
     *
     * @param categoryId 类别id
     * @return
     */
    @Override
    public Integer queryCountOne(Integer categoryId) {
        return bookDao.selectCountOne(categoryId);
    }
}
