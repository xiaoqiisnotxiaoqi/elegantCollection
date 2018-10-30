package com.elegantcollection.service.impl;

import com.elegantcollection.dao.BookOrderDao;
import com.elegantcollection.entity.BookOrder;
import com.elegantcollection.service.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookOrderServiceImpl implements BookOrderService {
    @Autowired
    private BookOrderDao bookOrderDao;

    /**
     * 根据书单id查找书单
     * @param id 书单id
     * @return 书单对象
     */
    @Override
    public BookOrder queryBookOrderById(Integer id) {
        return bookOrderDao.selectByPrimaryKey(id);
    }
}
