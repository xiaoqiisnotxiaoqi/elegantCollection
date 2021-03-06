package com.elegantcollection.controller;

import com.elegantcollection.entity.Book;
import com.elegantcollection.entity.BookCategory;
import com.elegantcollection.service.BookCategoryService;
import com.elegantcollection.service.BookService;
import com.elegantcollection.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("category")
public class BookCategoryController {
    @Autowired
    private BookCategoryService bookCategoryService;
    @Autowired
    private BookService bookService;

    /**
     * 加载二级分类
     * @return 二级类别集合
     */
    @GetMapping("getcategory")
    public List<BookCategory> getCategoryByNull() {
        List<BookCategory> list = this.bookCategoryService.queryBookCategoryByUpIdNull();
        return list;
    }

    /**
     * 根据总销量降序显示书籍
     * @param 页码
     * @return
     */
    @GetMapping("getbooktotal")
    public PageModel<Book> getBookByTotal(Integer page){
        Integer pagecode = page;
        PageModel<Book> pageModel = new PageModel<>();
        if (pagecode == null) {
            pageModel.setCurrentPageCode(1);
        } else {
            pageModel.setCurrentPageCode(pagecode);
        }
        pageModel.setPageSize(10);
        pageModel.setTotalRecord(this.bookService.queryCountAll());
        pageModel.setTotalPages(pageModel.getTotalRecord() % pageModel.getPageSize() == 0 ? pageModel.getTotalRecord()
                / pageModel.getPageSize() : pageModel.getTotalRecord() / pageModel.getPageSize() + 1);
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());
        pageModel = this.bookService.queryBookByBookSalesTotal(pageModel);
        return pageModel;
    }

    /**
     * 根据上月销量降序显示书籍
     * @param page 页码
     * @return
     */
    @GetMapping("getbooklastmonth")
    public PageModel<Book> getBookByLastMonth(Integer page){
        Integer pagecode = page;
        PageModel<Book> pageModel = new PageModel<>();
        if (pagecode == null) {
            pageModel.setCurrentPageCode(1);
        } else {
            pageModel.setCurrentPageCode(pagecode);
        }
        pageModel.setPageSize(10);
        pageModel.setTotalRecord(this.bookService.queryCountAll());
        pageModel.setTotalPages(pageModel.getTotalRecord() % pageModel.getPageSize() == 0 ? pageModel.getTotalRecord()
                / pageModel.getPageSize() : pageModel.getTotalRecord() / pageModel.getPageSize() + 1);
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());
        pageModel = this.bookService.queryBookByBookSalesLastMonth(pageModel);
        return pageModel;
    }

    /**
     * 根据上月销量和类别降序显示书籍
     * @param categoryId 类别id
     * @param page 页码
     * @return
     */
    @GetMapping("getbooklastmonthcategory")
    public PageModel<Book> getBookByLastMonthCategory(Integer categoryId,Integer page){
        Integer id = categoryId;
        Integer pagecode = page;
        PageModel<Book> pageModel = new PageModel<>();
        if (pagecode == null) {
            pageModel.setCurrentPageCode(1);
        } else {
            pageModel.setCurrentPageCode(pagecode);
        }
        pageModel.setPageSize(10);
        pageModel.setTotalRecord(this.bookService.queryCountOne(id));
        pageModel.setTotalPages(pageModel.getTotalRecord() % pageModel.getPageSize() == 0 ? pageModel.getTotalRecord()
                / pageModel.getPageSize() : pageModel.getTotalRecord() / pageModel.getPageSize() + 1);
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());
        pageModel = this.bookService.queryBookByBookSalesLastMonthAndBookCategory(id, pageModel);
        return pageModel;
    }
}
