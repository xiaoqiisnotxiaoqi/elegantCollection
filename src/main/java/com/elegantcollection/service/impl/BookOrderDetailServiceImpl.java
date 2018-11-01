package com.elegantcollection.service.impl;

import com.elegantcollection.dao.BookOrderDetailDao;
import com.elegantcollection.service.BookOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookOrderDetailServiceImpl implements BookOrderDetailService {
    @Autowired
    private BookOrderDetailDao bookOrderDetailDao;

    /**
     * 根据书单id获取书单详细
     * @param id 书单id
     * @return 书单详细集合
     */
    @Override
    public List<Integer> queryBookIdByOrderId(Integer id) {
        return bookOrderDetailDao.selectBookIdByOrderId(id);
    }
}
