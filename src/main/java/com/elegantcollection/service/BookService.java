package com.elegantcollection.service;


import com.elegantcollection.entity.*;
import com.elegantcollection.util.PageModel;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.List;

public interface BookService {

    //    分页查询所有图书
    Integer countAll();

    List<BookWithBLOBs> queryAll(PageModel pageModel);

    //根据bookid查询所有img
    List<BookImg> queryBookImgsById(Integer bookId);

    //    根据bookid获得所有评论
    int getEvaluateCountByBookId(Integer bookId);

    List<Evaluate> getEvaluateListByBookId(Integer bookId, PageModel pageModel);

//    根据bookID获得作者对象
    Author getAuthorByBookId(Integer bookId);

    /**
     * 根据图书id查找图书
     *
     * @param BookId 图书id
     * @return 图书对象
     */
    Book quaryBookByBookId(Integer BookId);

    long countByCategoryId(Integer categoryId);

    List<BookWithBLOBs> queryByCategoryId(HashMap map, PageModel<Book> pageModel);

}
