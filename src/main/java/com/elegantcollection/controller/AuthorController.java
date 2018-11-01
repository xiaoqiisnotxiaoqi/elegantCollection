package com.elegantcollection.controller;

import com.elegantcollection.entity.Author;
import com.elegantcollection.entity.Book;
import com.elegantcollection.service.AuthorService;
import com.elegantcollection.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param authorId 作者id
     * @return 作者对象
     */
    @GetMapping("getauthor")
    public Author getAuthorByAuthorId(Integer authorId){
        Integer id = authorId;
        Author author = this.authorService.queryAuthorById(id);
        return author;
    }

    /**
     * 显示作者作品
     * @param authorId 作者id
     * @return 该作者作品集合
     */
    @GetMapping("getbook")
    public List<Book> getBookByAuthorId(Integer authorId){
        Integer id = authorId;
        List<Book> list = this.bookService.queryBookByAuthorId(id);
        return list;
    }
}
