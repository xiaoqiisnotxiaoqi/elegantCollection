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

    @Override
    public Author queryAuthorById(Integer authorId) {
        AuthorExample authorExample = new AuthorExample();
        authorExample.createCriteria().andAuthorIdEqualTo(authorId);
        return authorDao.selectByExample(authorExample).get(0);
    }
}
