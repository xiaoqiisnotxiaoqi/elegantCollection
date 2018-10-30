package com.elegantcollection.service.impl;

import com.elegantcollection.dao.AuthorDao;
import com.elegantcollection.entity.Author;
import com.elegantcollection.entity.AuthorExample;
import com.elegantcollection.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorDao authorDao;

    /**
     * 根据ID查询作者
     *
     * @param authorId 作者id
     * @return 作者对象
     */
    @Override
    public Author queryAuthorById(Integer authorId) {
        return authorDao.selectByPrimaryKey(authorId);
    }
}
