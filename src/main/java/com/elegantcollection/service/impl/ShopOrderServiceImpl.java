package com.elegantcollection.service.impl;

import com.elegantcollection.dao.ShopOrderDao;
import com.elegantcollection.entity.ShopOrder;
import com.elegantcollection.entity.ShopOrderExample;
import com.elegantcollection.service.ShopOrderService;
import com.elegantcollection.util.DateUtil;
import com.elegantcollection.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class ShopOrderServiceImpl implements ShopOrderService {
    private final ShopOrderDao shopOrderDao;

    @Autowired
    public ShopOrderServiceImpl(ShopOrderDao shopOrderDao) {
        this.shopOrderDao = shopOrderDao;
    }


    @Override
    public int add(ShopOrder shopOrder) {
        return shopOrderDao.insertSelective(shopOrder);
    }

    @Override
    public int removeByOrderId(Integer orderId) {
        ShopOrderExample shopOrderExample = new ShopOrderExample();
        shopOrderExample.createCriteria().andOrderIdEqualTo(orderId);
        ShopOrder shopOrder = new ShopOrder();
        shopOrder.setOrderId(orderId);
        shopOrder.setOrderStatus(4);
        return shopOrderDao.updateByExampleSelective(shopOrder, shopOrderExample);
    }

    @Override
    public int delByOrderId(Integer orderId) {
        ShopOrderExample shopOrderExample = new ShopOrderExample();
        shopOrderExample.createCriteria().andOrderIdEqualTo(orderId);
        ShopOrder shopOrder = new ShopOrder();
        shopOrder.setOrderStatus(5);
        return shopOrderDao.updateByExample(shopOrder, shopOrderExample);
    }

    @Override
    public int alter(ShopOrder shopOrder) {
        return shopOrderDao.updateByPrimaryKeySelective(shopOrder);
    }

    @Override
    public int alterStatus(Integer orderId) {
        Integer orderState = shopOrderDao.selectByPrimaryKey(orderId).getOrderStatus();
        ShopOrder shopOrder = new ShopOrder();
        shopOrder.setOrderId(orderId);
        shopOrder.setOrderStatus(orderState + 1);
        return shopOrderDao.updateByPrimaryKeySelective(shopOrder);
    }

    @Override
    public Integer queryOrderId(Long orderNumber) {
        ShopOrderExample shopOrderExample = new ShopOrderExample();
        shopOrderExample.createCriteria().andOrderNumberEqualTo(orderNumber);
        return shopOrderDao.selectByExample(shopOrderExample).get(0).getOrderId();
    }

    @Override
    public List<ShopOrder> queryByPage(Integer custId, PageModel<ShopOrder> pageModel) {
        ShopOrderExample shopOrderExample = new ShopOrderExample();
        shopOrderExample.setLimit(pageModel.getPageSize());
        shopOrderExample.setOffset(pageModel.getStartRecord().longValue());
        shopOrderExample.createCriteria().andCustIdEqualTo(custId).andOrderStatusBetween(0, 3);
        return shopOrderDao.selectByExample(shopOrderExample);
    }

    @Override
    public Integer queryByPage4Size(Integer custId) {
        ShopOrderExample shopOrderExample = new ShopOrderExample();
        shopOrderExample.createCriteria().andCustIdEqualTo(custId).andOrderStatusBetween(0, 3);
        return shopOrderDao.selectByExample(shopOrderExample).size();
    }

    @Override
    public List<ShopOrder> queryByState(Integer custId, Integer orderStatus, String timeState, PageModel<ShopOrder> pageModel) {
        ShopOrderExample shopOrderExample = new ShopOrderExample();
        Date startDate;
        Date endDate;
        if (timeState != null) {
            startDate = getDate(timeState, 0);
            endDate = getDate(timeState, 1);
        } else {
            startDate = new Date(0);
            endDate = new Date();
        }
        shopOrderExample.setLimit(pageModel.getPageSize());
        shopOrderExample.setOffset(pageModel.getStartRecord().longValue());
        if (orderStatus != 6)
            shopOrderExample.createCriteria().andCustIdEqualTo(custId).andOrderStatusEqualTo(orderStatus).andOrderCreateTimeBetween(startDate, endDate);
        else
            shopOrderExample.createCriteria().andCustIdEqualTo(custId).andOrderStatusBetween(0, 3).andOrderCreateTimeBetween(startDate, endDate);
        return shopOrderDao.selectByExample(shopOrderExample);
    }

    @Override
    public Integer queryByState4Size(Integer custId, Integer orderStatus, String timeState) {
        ShopOrderExample shopOrderExample = new ShopOrderExample();
        Date startDate;
        Date endDate;
        if (timeState != null) {
            startDate = getDate(timeState, 0);
            endDate = getDate(timeState, 1);
        } else {
            startDate = new Date(0);
            endDate = new Date();
        }
        if (orderStatus != 6)
            shopOrderExample.createCriteria().andCustIdEqualTo(custId).andOrderStatusEqualTo(orderStatus).andOrderCreateTimeBetween(startDate, endDate);
        else
            shopOrderExample.createCriteria().andCustIdEqualTo(custId).andOrderStatusBetween(0, 3).andOrderCreateTimeBetween(startDate, endDate);
        return shopOrderDao.selectByExample(shopOrderExample).size();
    }

    @Override
    public List<ShopOrder> queryByOrderNumber(Integer custId, String orderNumber, PageModel<ShopOrder> pageModel) {
        ShopOrderExample shopOrderExample = new ShopOrderExample();
        shopOrderExample.setLimit(pageModel.getPageSize());
        shopOrderExample.setOffset(pageModel.getStartRecord().longValue());
        Pattern pattern = Pattern.compile("[0-9]*");
        if (!pattern.matcher(orderNumber).matches()) {
            return null;
        }
        shopOrderExample.createCriteria().andCustIdEqualTo(custId).andOrderNumberEqualTo(Long.valueOf(orderNumber));
        return shopOrderDao.selectByExample(shopOrderExample);
    }


    @Override
    public List<ShopOrder> queryByBookName(Integer custId, String bookName, PageModel<ShopOrder> pageModel) {
        HashMap<String, Object> condition = new HashMap<>();
        condition.put("custId", custId);
        condition.put("bookName", bookName);
        condition.put("pageModel", pageModel);
        return shopOrderDao.selectByBookName(condition);
    }

    @Override
    public Integer queryByBookName4Size(Integer custId, String bookName) {
        HashMap<String, Object> condition = new HashMap<>();
        condition.put("custId", custId);
        condition.put("bookName", bookName);
        return shopOrderDao.selectByBookName4Size(condition).size();
    }

    private Date getDate(String timeState, Integer timeOp) {
        Date baseDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(baseDate);
        Date resultDate = null;
        if (timeOp == 0) {
            switch (timeState) {
                case "0":
                    resultDate = DateUtil.getCurrYearFirst();
                    break;
                case "1":
                    calendar.add(Calendar.YEAR, -1);
                    resultDate = DateUtil.getYearFirst(calendar.get(Calendar.YEAR));
                    break;
                case "2":
                    calendar.add(Calendar.YEAR, -2);
                    resultDate = DateUtil.getYearFirst(calendar.get(Calendar.YEAR));
                    break;
                case "3":
                    calendar.add(Calendar.YEAR, -3);
                    resultDate = DateUtil.getYearFirst(calendar.get(Calendar.YEAR));
                    break;
                case "4":
                    resultDate = new Date(0);
                    break;
            }
        } else {
            switch (timeState) {
                case "0":
                    resultDate = DateUtil.getCurrYearLast();
                    break;
                case "1":
                    calendar.add(Calendar.YEAR, -1);
                    resultDate = DateUtil.getYearLast(calendar.get(Calendar.YEAR));
                    break;
                case "2":
                    calendar.add(Calendar.YEAR, -2);
                    resultDate = DateUtil.getYearLast(calendar.get(Calendar.YEAR));
                    break;
                case "3":
                    calendar.add(Calendar.YEAR, -3);
                    resultDate = DateUtil.getYearLast(calendar.get(Calendar.YEAR));
                    break;
                case "4":
                    calendar.add(Calendar.YEAR, -4);
                    resultDate = DateUtil.getYearLast(calendar.get(Calendar.YEAR));
                    break;
            }
        }
        return resultDate;
    }

}
