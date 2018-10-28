package com.elegantcollection.controller;

import com.elegantcollection.entity.Book;
import com.elegantcollection.entity.BookCategory;
import com.elegantcollection.entity.BookImg;
import com.elegantcollection.entity.BookWithBLOBs;
import com.elegantcollection.service.BookCategoryService;
import com.elegantcollection.service.BookService;
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

    /**
     * 分页查询所有图书
     *
     * @param pageCode
     * @return
     */
    @GetMapping("all")
    public PageModel<BookWithBLOBs> getAll(Integer pageCode) {
        PageModel pageModel = new PageModel<>();
        if (pageCode == null) {
            pageModel.setCurrentPageCode(1);
        } else {
            pageModel.setCurrentPageCode(pageCode);
        }
        System.out.println("当前是第" + pageModel.getCurrentPageCode() + "页");
        pageModel.setTotalRecord(bookService.countAll());
        System.out.println("共有 " + bookService.countAll() + " 条记录");
        pageModel.setTotalPages(pageModel.getTotalRecord() % pageModel.getPageSize() == 0 ? pageModel.getTotalRecord() / pageModel.getPageSize() : pageModel.getTotalRecord() / pageModel.getPageSize() + 1);
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());
        pageModel.setModelList(bookService.queryAll(pageModel));


        return pageModel;
    }


    //    根据ID获得Book对象,以及该book的所有图片,以及所有评论,作者名
    @GetMapping("detail")
    public HashMap getBookById(Integer pageCode, HttpServletRequest request) {
        Integer bookId = (Integer) request.getSession().getAttribute("bookId");
        HashMap map = new HashMap();
        System.out.println("根据ID :" + bookId + " 查询book");

        if (bookId == -1) {
            bookId = null;
        }
//        查询出book对象
        map.put("book", bookService.quaryBookByBookId(bookId));
//        查询出所有图片
        map.put("bookImgList", bookService.queryBookImgsById(bookId));
        PageModel pageModel = new PageModel();
        if (pageCode == null) {
            pageModel.setCurrentPageCode(1);
        } else {
            pageModel.setCurrentPageCode(pageCode);
        }
        System.out.println("当前是第" + pageModel.getCurrentPageCode() + "页评论");
        pageModel.setTotalRecord(bookService.getEvaluateCountByBookId(bookId));
        System.out.println("共有 " + bookService.getEvaluateCountByBookId(bookId) + " 条评论");
        pageModel.setTotalPages(pageModel.getTotalRecord() % pageModel.getPageSize() == 0 ? pageModel.getTotalRecord() / pageModel.getPageSize() : pageModel.getTotalRecord() / pageModel.getPageSize() + 1);
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());
        pageModel.setModelList(bookService.getEvaluateListByBookId(bookId, pageModel));
//        分页查询出所有评论
        map.put("evaluatePageModel", pageModel);
//        查询出该书的作者名
        map.put("author", bookService.getAuthorByBookId(bookId));
        return map;
    }

    /**
     * 分页查询所有图书
     * 每页显示记录数为10
     *
     * @param categoryId 分类id
     * @param minPrice   最小价格
     * @param maxPrice   最大价格
     * @param pageCode   当前要查询的页码
     * @param keyWord    根据关键字搜索
     * @return pagemodel对象
     */
    @PostMapping("search")
    PageModel<Book> getBookByPage(Integer categoryId, String keyWord, Integer minPrice, Integer maxPrice, Integer pageCode) {
//        现根据keyWord查询出符合的分类id集合
        List<BookCategory> bookCategoryList = bookCategoryService.queryByKeyWord("%" + keyWord + "%");
        List<Integer> bookCategoryIdList = new ArrayList();
        for (BookCategory bookCategory : bookCategoryList) {
            bookCategoryIdList.add(bookCategory.getCategoryId());
        }
        System.out.println("查询到的分类" + bookCategoryIdList);


        PageModel<Book> pageModel = new PageModel<>();
        if (pageCode == null) {
            pageModel.setCurrentPageCode(1);
        } else {
            pageModel.setCurrentPageCode(pageCode);
        }
//        设置动态查询的参数映射
        HashMap map = new HashMap<String, Object>();
        map.put("categoryId", categoryId);
        map.put("minPrice", minPrice);
        map.put("maxPrice", maxPrice);
        map.put("keyWord", keyWord);
        map.put("bookCategoryIdList", bookCategoryIdList);
//        设置分页信息
//        System.out.println("共有 " + bookService.countByExample(map) + " 条记录");
//        pageModel.setTotalRecord((int) bookService.countByExample(map));
        pageModel.setTotalPages(pageModel.getTotalRecord() % pageModel.getPageSize() == 0 ? pageModel.getTotalRecord() / pageModel.getPageSize() : pageModel.getTotalRecord() / pageModel.getPageSize() + 1);
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());

        map.put("pageModel", pageModel);
//        pageModel = this.bookService.getByPage(map);
        return pageModel;
    }

    /**
     * 根据分类ID分页查询
     *
     * @param categoryID
     * @return
     */
    @GetMapping("get1/{categoryID}")
    public PageModel<Book> getByCategoryId(@PathVariable Integer categoryID) {
        PageModel<Book> pageModel = new PageModel<>();
        HashMap map = new HashMap();
        if (categoryID == -1) {
            categoryID = null;
        }

        int count = (int) bookService.countByCategoryId(categoryID);
        System.out.println("共有 " + count + "条记录");

        pageModel.setTotalRecord(count);

        return pageModel;
    }

    @GetMapping("getImg")
    public List<BookImg> getImgsByBookId(Integer bookId) {
        System.out.println("获取到的bookId" + bookId);
        return bookService.queryBookImgsById(bookId);
    }

}


