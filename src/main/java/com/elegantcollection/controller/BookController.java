package com.elegantcollection.controller;

import com.elegantcollection.entity.*;
import com.elegantcollection.service.BookCategoryService;
import com.elegantcollection.service.BookService;
import com.elegantcollection.service.DiscountService;
import com.elegantcollection.util.PageModel;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookCategoryService bookCategoryService;
    @Autowired
    private DiscountService discountService;

    /**
     * 获取首页需要的信息
     *
     * @return 结果
     */
    @GetMapping("index")
    public HashMap index() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!查询首页数据!!!!!!!!!!!!!!!!!!!");
//        用来设置查询前十条
        PageModel pageModel = new PageModel();
        pageModel.setPageSize(16);
        pageModel.setCurrentPageCode(1);
        pageModel.setStartRecord(0);
        //获取新书上架(上架时间排序,前16本)
        HashMap condition0 = new HashMap();
        condition0.put("orderBy", "book_sales_total desc");
        condition0.put("pageModel", pageModel);
        List<BookWithBLOBs> bookList0 = bookService.queryByCondition(condition0);

//        获取排行
//        获取总排行
        HashMap condition1 = new HashMap();
        condition1.put("orderBy", "book_sales_total desc");
        condition1.put("pageModel", pageModel);
        List<BookWithBLOBs> bookList1 = bookService.queryByCondition(condition1);
//        获取文艺分类排行
        HashMap condition2 = new HashMap();
        condition2.put("categortId", 10008);
        condition2.put("orderBy", "book_sales_total desc");
        condition2.put("pageModel", pageModel);
        List<BookWithBLOBs> bookList2 = bookService.queryByCondition(condition2);
//      获取人文社科排行
        HashMap condition3 = new HashMap();
        condition3.put("categortId", 10013);
        condition3.put("orderBy", "book_sales_total desc");
        condition3.put("pageModel", pageModel);
        List<BookWithBLOBs> bookList3 = bookService.queryByCondition(condition3);
//      获取生活排行
        HashMap condition4 = new HashMap();
        condition4.put("categortId", 10022);
        condition4.put("orderBy", "book_sales_total desc");
        condition4.put("pageModel", pageModel);
        List<BookWithBLOBs> bookList4 = bookService.queryByCondition(condition4);
//      获取科技排行
        HashMap condition5 = new HashMap();
        condition5.put("categortId", 10028);
        condition5.put("orderBy", "book_sales_total desc");
        condition5.put("pageModel", pageModel);
        List<BookWithBLOBs> bookList5 = bookService.queryByCondition(condition5);
//      获取前三个书单
        List<BookOrder> bookOrders = bookService.queryBookOrder();

        //获取推荐作家


        HashMap result = new HashMap();
        result.put("bookList0", bookList1);
        result.put("bookList1", bookList1);
        result.put("bookList2", bookList1);
        result.put("bookList3", bookList1);
        result.put("bookList4", bookList1);
        result.put("bookList5", bookList1);
        result.put("bookOrders", bookOrders);
        return result;
    }


    /**
     * 获得图书详情信息
     *
     * @param pageCode 当前页码
     * @param request  用来获取session中存放的bookid
     * @return 结果, 包括图书对象, 作者对象, 评论列表等信息
     */
    @GetMapping("detail")
    public HashMap getDetailById(Integer pageCode, HttpServletRequest request) {
        Integer bookId = (Integer) request.getSession().getAttribute("bookId");
        HashMap map = new HashMap();
        System.out.println("根据ID :" + bookId + " 查询book");

        if (bookId == -1) {
            bookId = null;
        }
//        查询出book对象
        Book book = bookService.quaryBookByBookId(bookId);
        map.put("book", book);
//        查询出所有图片
        map.put("bookImgList", bookService.queryBookImgsById(bookId));
//        查询出主分类信息
        map.put("mainCategory", bookCategoryService.queryCategoryById(bookService.quaryBookByBookId(bookId).getBookMainCategory()));
        PageModel pageModel = new PageModel();
        if (pageCode == null || pageCode < 1) {
            pageModel.setCurrentPageCode(1);
        } else {
            pageModel.setCurrentPageCode(pageCode);
        }
        System.out.println("当前是第" + pageModel.getCurrentPageCode() + "页评论");
        pageModel.setTotalRecord(bookService.countEvaluateByBookId(bookId));
        System.out.println("共有 " + bookService.countEvaluateByBookId(bookId) + " 条评论");
        pageModel.setTotalPages(pageModel.getTotalRecord() % pageModel.getPageSize() == 0 ? pageModel.getTotalRecord() / pageModel.getPageSize() : pageModel.getTotalRecord() / pageModel.getPageSize() + 1);
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());
        pageModel.setModelList(bookService.queryEvaluateListByBookId(bookId, pageModel));
//        分页查询出所有评论
        map.put("evaluatePageModel", pageModel);


//        查询出该书的作者名
        map.put("author", bookService.queryAuthorByBookId(bookId));
//        查询满减优惠
        if (book.getRedundancyField2() != null) {
            map.put("manjian", discountService.queryManjianByDiscountId(Integer.parseInt(book.getRedundancyField2())));
        } else {
            map.put("manjian", null);
        }
        return map;
    }

    /**
     * 多条件动态分页查询
     *
     * @param keyWord      关键字
     * @param bookStatus   是否'只看有货'
     * @param bookLanguage 语言
     * @param minPrice     最小价格
     * @param maxPrice     最大价格
     * @param categoryId   分类Id
     * @param pageCode     当前页码
     * @param orderBy      根据xx排序
     * @return 结果, 包括图书列表, 子分类列表, 页码信息等
     */
    @GetMapping("search")
    public HashMap test(String keyWord, Integer bookStatus, String bookLanguage, Float minPrice,
                        Float maxPrice, Integer categoryId, Integer pageCode, String orderBy,
                        Integer isDiscount) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~调用test");
        System.out.println("接收到的参数:keyWord=" + keyWord + ",bookStatus=" + bookStatus + ",bookLanguage=" + bookLanguage + ",minPrice=" + minPrice + ",maxPrice=" + maxPrice + ",categoryID=" + categoryId + ",orderBy=" + orderBy + ",isDiscount=" + isDiscount + ",pageCode=" + pageCode);
//        此集合表示封装查询图书要用到的所有参数
        HashMap conditions = new HashMap();

//        此集合表示在图书表中查询在此id集合中的图书,此集合可以通过各种其他查询获取
        if (categoryId != null || (keyWord != null && keyWord != "")) {
            List<Integer> bookIdList = new ArrayList<>();
//            根据图书分类Id查询
            if (categoryId != null) {
                List<Book> bookList = bookService.queryByCategoryId(categoryId);
                if (bookList != null) {
                    for (Book book : bookList) {
                        bookIdList.add(book.getBookId());
                    }
                }
            }
//            根据keyword在分类表中查询,返回分类Id集合,再根据分类Id查询出所有图书Id
            if (keyWord != null && keyWord != "") {
//                根据关键字查询出的BookCategory集合
                List<BookCategory> bookCategoryList = bookCategoryService.queryByKeyWord(keyWord);
//                遍历BookCategory集合,查询出每个BookCategory的categoryId
                if (bookCategoryList != null) {
//                    每个BookCategory的categoryId集合
                    List<Integer> bookCategoryIdList = new ArrayList<>();
                    for (BookCategory bookCategory : bookCategoryList) {
                        bookCategoryIdList.add(bookCategory.getCategoryId());
                    }
//                    遍历categoryId集合,查询出每个categoryId对应的图书集合,并遍历图书集合,把图书Id放入BookIdList
                    for (Integer bookCategoryId : bookCategoryIdList) {
                        List<Book> bookList = bookService.queryByCategoryId(categoryId);
                        if (bookList != null) {
                            for (Book book : bookList) {
                                bookIdList.add(book.getBookId());
                            }
                        }
                    }
                }


            }
            if (!bookIdList.isEmpty())
                conditions.put("bookIdList", bookIdList);
            System.out.println("---------------------------------根据分类Id和关键字在在分类表查询到的图书id集合:" + bookIdList);
        }
        conditions.put("keyWord", keyWord);
        conditions.put("bookStatus", bookStatus);
        conditions.put("bookLanguage", bookLanguage);
        conditions.put("minPrice", minPrice);
        conditions.put("maxPrice", maxPrice);
        conditions.put("categoryId", categoryId);
        conditions.put("pageCode", pageCode);
        conditions.put("orderBy", orderBy);
        conditions.put("isDiscount", isDiscount);
//        封装分页信息
        PageModel pageModel = new PageModel();
        if (pageCode == null || pageCode < 1) {
            pageModel.setCurrentPageCode(1);
        } else {
            pageModel.setCurrentPageCode(pageCode);
        }
        System.out.println("当前页码" + pageModel.getCurrentPageCode());
        pageModel.setPageSize(15);
        pageModel.setTotalRecord(bookService.countByCondition(conditions));
        pageModel.setTotalPages(pageModel.getTotalRecord() % pageModel.getPageSize() == 0 ? pageModel.getTotalRecord() / pageModel.getPageSize() : pageModel.getTotalRecord() / pageModel.getPageSize() + 1);
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());
        conditions.put("pageModel", pageModel);

        List<BookWithBLOBs> books = bookService.queryByCondition(conditions);
        pageModel.setModelList(books);


//        此map封装要返回的数据,包括子分类信息,条件查询到的结果集
        HashMap result = new HashMap();
        //根据参数分类Id  查询所有子分类,在页面上显示
        if (categoryId != null) {
            List<BookCategory> categories = bookCategoryService.queryChildById(categoryId);
            result.put("childCategories", categories);
        }
        result.put("pageModel", pageModel);
        return result;
    }


}


