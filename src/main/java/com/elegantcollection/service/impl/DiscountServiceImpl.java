package com.elegantcollection.service.impl;

import com.elegantcollection.dao.DiscountDao;
import com.elegantcollection.dao.DiscountDetailDao;
import com.elegantcollection.entity.Discount;
import com.elegantcollection.entity.DiscountDetail;
import com.elegantcollection.entity.DiscountDetailExample;
import com.elegantcollection.entity.DiscountExample;
import com.elegantcollection.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiscountServiceImpl implements DiscountService {
    private final DiscountDao discountDao;
    private final DiscountDetailDao discountDetailDao;

    @Autowired
    public DiscountServiceImpl(DiscountDao discountDao, DiscountDetailDao discountDetailDao) {
        this.discountDao = discountDao;
        this.discountDetailDao = discountDetailDao;
    }



    @Override
    public Discount quertDiscountByDiscountId(Integer discountId) {
        DiscountExample discountExample = new DiscountExample();
        discountExample.createCriteria().andDiscountIdEqualTo(discountId);
        if(discountDao.selectByExample(discountExample).size() != 0){
            return discountDao.selectByExample(discountExample).get(0);
        }else {
            return null;
        }

    }

    @Override
    public DiscountDetail quereDiscountDetailByDiscountId(Integer discountId) {
        DiscountDetailExample discountDetailExample = new DiscountDetailExample();
        discountDetailExample.createCriteria().andDiscountIdEqualTo(discountId);
        return  discountDetailDao.selectByExample(discountDetailExample).get(0);
    }
}
