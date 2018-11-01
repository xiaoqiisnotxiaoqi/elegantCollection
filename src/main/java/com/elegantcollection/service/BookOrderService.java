package com.elegantcollection.service;

import com.elegantcollection.entity.BookOrder;

public interface BookOrderService {
    /**
     * 根据书单id查找书单
     * @param id 书单id
     * @return 书单对象
     */
    BookOrder queryBookOrderById(Integer id);
}
