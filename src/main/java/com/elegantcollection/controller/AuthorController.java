package com.elegantcollection.controller;

import com.elegantcollection.entity.Author;
import com.elegantcollection.entity.Book;
import com.elegantcollection.service.AuthorService;
import com.elegantcollection.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;

    /**
     * 显示作者信息
     * @param request
     * @return
     */
    @GetMapping("getauthor")
    public Author getAuthorByAuthorId(HttpServletRequest request){
        Integer id = (Integer) request.getSession().getAttribute("authorId");
        Author author = this.authorService.queryAuthorById(id);
        return author;
    }

    /**
     * 显示作者作品
     * @param request
     * @return
     */
    @GetMapping("getbook")
    public List<Book> getBookByAuthorId(HttpServletRequest request){
        Integer id = (Integer) request.getSession().getAttribute("authorId");
        List<Book> list = this.bookService.queryBookByAuthorId(id);
        return list;
    }
}
