package com.elegantcollection.service.impl;

import com.elegantcollection.dao.CartDao;
import com.elegantcollection.entity.Cart;
import com.elegantcollection.entity.CartExample;
import com.elegantcollection.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CartServiceImpl implements CartService {
    private final CartDao cartDao;

    @Autowired
    public CartServiceImpl(CartDao cartDao) {
        this.cartDao = cartDao;
    }



    @Override
    public List<Cart> quaryCartByCustId(Integer custId) {
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andCustIdEqualTo(custId);
        return cartDao.selectByExample(cartExample);


    }

    @Override
    public List<Cart> quaryCartByPage(Integer custId,Integer pageSize,Integer startRecord) {
        CartExample cartExample = new CartExample();
        cartExample.setLimit(pageSize);
        cartExample.setOffset(startRecord.longValue());
        cartExample.createCriteria().andCustIdEqualTo(custId);
        return  cartDao.selectByExample(cartExample);
    }

    @Override
    public Integer removeByBookId(String bookId, Integer custId) {
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andBookIdEqualTo(Integer.valueOf(bookId)).andCustIdEqualTo(custId);
        return cartDao.deleteByExample(cartExample);
    }
}
