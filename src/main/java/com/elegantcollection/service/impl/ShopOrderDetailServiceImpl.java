package com.elegantcollection.service.impl;

import com.elegantcollection.dao.ShopOrderDetailDao;
import com.elegantcollection.entity.ShopOrderDetail;
import com.elegantcollection.service.ShopOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ShopOrderDetailServiceImpl implements ShopOrderDetailService {
    private static ShopOrderDetailDao shopOrderDetailDao;

    @Autowired
    public ShopOrderDetailServiceImpl(ShopOrderDetailDao shopOrderDetailDao) {
        this.shopOrderDetailDao = shopOrderDetailDao;
    }


    @Override
    public List<HashMap<String, Object>> queryByOrderId(Integer orderId) {
        List<HashMap<String, Object>> mapList = shopOrderDetailDao.selectByOrderId4Detail(orderId);
        return mapList;
    }

    @Override
    public int add(ShopOrderDetail shopOrderDetail) {
        return shopOrderDetailDao.insertSelective(shopOrderDetail);
    }
}
