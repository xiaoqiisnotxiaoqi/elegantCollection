package com.elegantcollection.service;

import com.elegantcollection.entity.Author;

public interface AuthorService {

    /**
     * 根据作者id 查询该作者详情
     * @param authorId 作者id
     * @return 作者对象
     */
    Author queryAuthorById(Integer authorId);


}
