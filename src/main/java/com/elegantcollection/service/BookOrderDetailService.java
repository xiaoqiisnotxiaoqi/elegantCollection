package com.elegantcollection.service;


import java.util.List;

public interface BookOrderDetailService {
    /**
     * 根据书单id获取书单详细
     * @param id 书单id
     * @return 书单详细集合
     */
    List<Integer> queryBookIdByOrderId(Integer id);
}
