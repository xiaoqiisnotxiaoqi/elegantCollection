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

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("category")
public class BookCategoryController {
    @Autowired
    private BookCategoryService bookCategoryService;
    @Autowired
    private BookService bookService;

    /**
     * 加载一级分类
     * @return 一级类别集合
     */
    @GetMapping("getcategory")
    public List<BookCategory> getCategoryByNull(){
        List<BookCategory> list = this.bookCategoryService.queryBookCategoryByUpIdNull();
        return list;
    }

    /**
     * 根据总销量降序显示书籍
     * @param pagecode 分页对象
     * @return
     */
    @GetMapping("getbooktotal")
    public PageModel<Book> getBookByTotal(HttpServletRequest request){
        Integer pagecode = (Integer) request.getSession().getAttribute("page");
        PageModel<Book> pageModel = new PageModel<>();
        if(pagecode == null){
            pageModel.setCurrentPageCode(1);
        }else {
            pageModel.setCurrentPageCode(pagecode);
        }
        pageModel.setTotalRecord(this.bookService.queryCountAll());
        pageModel.setTotalPages(pageModel.getTotalRecord() % pageModel.getPageSize() == 0 ? pageModel.getTotalRecord()
                / pageModel.getPageSize() : pageModel.getTotalRecord() / pageModel.getPageSize() + 1);
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());
        pageModel = this.bookService.queryBookByBookSalesTotal(pageModel);
        return pageModel;
    }

    @GetMapping("getbooktotal/page/{page}")
    public PageModel<Book> getByPage(HttpServletRequest request){
        return getBookByTotal(request);
    }

    /**
     * 根据上月销量降序显示书籍
     * @param pagecode 分页对象
     * @return
     */
    @GetMapping("getbooklastmonth")
    public PageModel<Book> getBookByLastMonth(HttpServletRequest request){
        Integer pagecode = (Integer) request.getSession().getAttribute("page");
        PageModel<Book> pageModel = new PageModel<>();
        if(pagecode == null){
            pageModel.setCurrentPageCode(1);
        }else {
            pageModel.setCurrentPageCode(pagecode);
        }
        pageModel.setTotalRecord(this.bookService.queryCountAll());
        pageModel.setTotalPages(pageModel.getTotalRecord() % pageModel.getPageSize() == 0 ? pageModel.getTotalRecord()
                / pageModel.getPageSize() : pageModel.getTotalRecord() / pageModel.getPageSize() + 1);
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());
        pageModel = this.bookService.queryBookByBookSalesLastMonth(pageModel);
        return pageModel;
    }

    @GetMapping("getbooklastmonth/page/{page}")
    public PageModel<Book> getByPage2(HttpServletRequest request){
        return getBookByLastMonth(request);
    }

    /**
     * 根据上月销量和类别降序显示书籍
     * @param id 类别id
     * @param pagecode 分页对象
     * @return
     */
    @GetMapping("getbooklastmonthcategory")
    public PageModel<Book> getBookByLastMonthCategory(HttpServletRequest request){
        Integer id = (Integer) request.getSession().getAttribute("categoryId");
        Integer pagecode = (Integer) request.getSession().getAttribute("page");
        PageModel<Book> pageModel = new PageModel<>();
        if(pagecode == null){
            pageModel.setCurrentPageCode(1);
        }else {
            pageModel.setCurrentPageCode(pagecode);
        }
        pageModel.setTotalRecord(this.bookService.queryCountOne(id));
        pageModel.setTotalPages(pageModel.getTotalRecord() % pageModel.getPageSize() == 0 ? pageModel.getTotalRecord()
                / pageModel.getPageSize() : pageModel.getTotalRecord() / pageModel.getPageSize() + 1);
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());
        pageModel = this.bookService.queryBookByBookSalesLastMonthAndBookCategory(id,pageModel);
        return pageModel;
    }

    @GetMapping("getbooklastmonthcategory/page/{page}")
    public PageModel<Book> getByPage3(HttpServletRequest request){
        return getBookByLastMonthCategory(request);
    }
}
