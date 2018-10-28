package com.elegantcollection.service;

import com.elegantcollection.entity.BookCategory;

import java.util.List;

public interface BookCategoryService {
    //    根据关键字返回分类集合
    List<BookCategory> queryByKeyWord(String keyWord);



}
