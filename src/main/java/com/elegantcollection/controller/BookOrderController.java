package com.elegantcollection.controller;

import com.elegantcollection.entity.Book;
import com.elegantcollection.entity.BookOrder;
import com.elegantcollection.service.BookOrderDetailService;
import com.elegantcollection.service.BookOrderService;
import com.elegantcollection.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("bookorder")
public class BookOrderController {
    @Autowired
    private BookOrderService bookOrderService;
    @Autowired
    private BookOrderDetailService bookOrderDetailService;
    @Autowired
    private BookService bookService;

    /**
     * 显示书单信息
     * @param request
     * @return
     */
    @GetMapping("getbookorder")
    public BookOrder getBookOrderByBookOrderId(HttpServletRequest request){
        Integer id = (Integer) request.getSession().getAttribute("orderId");
        BookOrder bookOrder = this.bookOrderService.queryBookOrderById(id);
        return bookOrder;
    }

    /**
     * 显示书单详情
     * @param request
     * @return
     */
    @GetMapping("getbookorderdetail")
    public List<Book> getBookOrderDetailByBookOrderId(HttpServletRequest request){
        Integer id = (Integer) request.getSession().getAttribute("orderId");
        List<Integer> list = this.bookOrderDetailService.queryBookIdByOrderId(id);
        List<Book> bookList = new ArrayList<>();
        for (int i = 0;i < list.size();i ++){
            bookList.add(this.bookService.quaryBookByBookId(list.get(i)));
        }
        return bookList;
    }
}
