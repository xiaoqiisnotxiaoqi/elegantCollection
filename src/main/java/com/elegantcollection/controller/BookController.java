package com.elegantcollection.controller;

import com.elegantcollection.entity.*;
import com.elegantcollection.service.BookCategoryService;
import com.elegantcollection.service.BookService;
import com.elegantcollection.service.CustomerService;
import com.elegantcollection.service.DiscountService;
import com.elegantcollection.util.PageModel;
import com.elegantcollection.util.ServerResponse;
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
    @Autowired
    private CustomerService customerService;

    /**
     * 获取首页需要的信息
     *
     * @return 结果
     */
    @GetMapping("index")
    public ServerResponse<HashMap> index() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!查询首页数据!!!!!!!!!!!!!!!!!!!");
        return bookService.queryIndexData();
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
//        查询出评论的用户信息
        List<Customer> customers = new ArrayList<>();
        for (Evaluate e : (List<Evaluate>) (pageModel.getModelList())) {
            Customer customer = customerService.quaryCustomerById(e.getCustId());
            customers.add(customer);
        }
        map.put("evaluateCustomers", customers);
//        查询出该书的作者名
        map.put("author", bookService.queryAuthorByBookId(bookId));
//        查询满减优惠
        if (book.getRedundancyField2() != null) {
            map.put("manjian", discountService.queryManjianByDiscountId(Integer.parseInt(book.getRedundancyField2())));
        } else {
            map.put("manjian", null);
        }
//        查询版块
        Block block = bookService.queryBlockByBookId(bookId);
        map.put("blockId", block.getBlockId());

        //        查询组合优惠
        List<Book> zuheBooks = new ArrayList<>();

        if (book.getRedundancyField() != null && book.getRedundancyField() != "") {
            for (String s : book.getRedundancyField().split(" ")) {
                System.out.println(s);
                Book zuheBook = bookService.quaryBookByBookId(Integer.parseInt(s));
                zuheBooks.add(zuheBook);
            }
        }


        map.put("zuheBooks", zuheBooks);
        return map;
    }


    /**
     * 从图书详情添加商品到购物车
     *
     * @param bookId  图书ID
     * @param count   数量
     * @param request 获取用户ID
     * @return 受影响行数
     */
    @GetMapping("add2Cart")
    public ServerResponse add2Cart(Integer bookId, Integer count, HttpServletRequest request) {
        Integer custId = ((Customer) request.getSession().getAttribute("customer")).getCustId();
        ServerResponse serverResponse = bookService.add2Cart(custId, bookId, count);
        return serverResponse;
    }

    /**
     * xml文件版本的多条件动态分页查询
     *
     * @param keyWord      查询的关键字
     * @param bookStatus   是否'只看有货'
     * @param bookLanguage 语言
     * @param minPrice     最小价格
     * @param maxPrice     最大价格
     * @param categoryId   分类ID
     * @param pageCode     当前页码
     * @param orderBy      排序条件
     * @param isDiscount   是否'只看优惠'
     * @param zhekou       折扣(0.5/0.6/0.7...)
     * @param request      用来获取session
     * @return 图书集合
     */
    @GetMapping("test")
    public ServerResponse sjTest(String keyWord, Integer bookStatus, String bookLanguage, Float minPrice,
                                 Float maxPrice, Integer categoryId, Integer pageCode, String orderBy,
                                 Integer isDiscount, Float zhekou, HttpServletRequest request) {
//      封装查询条件
        HashMap conditions = new HashMap();
        conditions.put("keyWord", keyWord);
        conditions.put("bookStatus", bookStatus);
        conditions.put("bookLanguage", bookLanguage);
        conditions.put("minPrice", minPrice);
        conditions.put("maxPrice", maxPrice);
        conditions.put("categoryId", categoryId);
        conditions.put("pageCode", pageCode);
        conditions.put("orderBy", orderBy);
        conditions.put("isDiscount", isDiscount);
        conditions.put("zhekou", zhekou);

//        返回结果
        return bookService.sjTest(conditions);
    }

}


