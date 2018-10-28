package com.elegantcollection.controller;


import com.elegantcollection.entity.ShopOrder;
import com.elegantcollection.entity.ShopOrderDetail;
import com.elegantcollection.service.AddressService;
import com.elegantcollection.service.ShopOrderDetailService;
import com.elegantcollection.service.ShopOrderService;
import com.elegantcollection.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("order")
public class ShopOrderController {

    private final ShopOrderService shopOrderService;
    private final ShopOrderDetailService shopOrderDetailService;
    private final AddressService addressService;
    PageModel<ShopOrder> pageModel = new PageModel<>();


    @Autowired
    public ShopOrderController(ShopOrderService shopOrderService, ShopOrderDetailService shopOrderDetailService, AddressService addressService) {
        this.shopOrderService = shopOrderService;
        this.shopOrderDetailService = shopOrderDetailService;
        this.addressService = addressService;
    }

    /**
     * @param request 用户id，（订单创建时间：转入支付页面时）
     * @param
     * @return
     */
    @PutMapping("add")
    public String add(HttpServletRequest request) {
        Integer custId = 10001; //(Integer) request.getSession().getAttribute("custId");
        Long orderNumber = orderNumberGenerate(custId);
        ShopOrder shopOrder = new ShopOrder();
        shopOrder.setCustId(custId);
        shopOrder.setOrderNumber(orderNumber);
        shopOrder.setOrderCreateTime(new Date());
        if (shopOrderService.add(shopOrder) == 1) {
            Integer orderId = shopOrderService.queryOrderId(orderNumber);
            List<HashMap<String, Object>> booklist = (List) request.getSession().getAttribute("booklist");
            ShopOrderDetail shopOrderDetail = new ShopOrderDetail();
            for (HashMap<String, Object> b : booklist) {
                shopOrderDetail.setOrderId(orderId);
                shopOrderDetail.setBookId((Integer) b.get("bookId"));
                shopOrderDetailService.add(shopOrderDetail);
            }
            //查询收货人信息
            return "success";
        } else
            return "fail";

    }

    /**
     * 删除订单（可找回）
     *
     * @param request
     * @param orderId
     * @return
     */
    @GetMapping("removeByOrderId")
    public String removeByOrderId(HttpServletRequest request, Integer orderId) {
        if (shopOrderService.removeByOrderId(orderId) == 1)
            return "success";
        else
            return "fail";
    }

    /**
     * 完全删除订单（不可找回）
     *
     * @param request
     * @param orderId
     * @return
     */
    @GetMapping("delByOrderId")
    public String delByOrderId(HttpServletRequest request, Integer orderId) {
        if (shopOrderService.removeByOrderId(orderId) == 1)
            return "success";
        else
            return "fail";
    }


    /**
     * 订单完善
     *
     * @param request 收货地址id，付款时间，期望配送时间
     * @param orderId
     * @return
     */
    @PostMapping("alter")
    public String prefectOrder(HttpServletRequest request, Integer orderId, Integer addressId, Date expectationTime) {
        ShopOrder shopOrder = new ShopOrder();
        shopOrder.setOrderId(orderId);
        shopOrder.setAddressId(addressId);
        shopOrder.setExpectationTime(expectationTime);
        if (shopOrderService.alter(shopOrder) == 1)
            return "success";
        else
            return "fail";
    }

    /**
     * 修改状态
     *
     * @param request
     * @param orderId
     * @return
     */
    @GetMapping("alterStatus")
    public String alterStatus(HttpServletRequest request, Integer orderId) {
        if (shopOrderService.alterStatus(orderId) == 1)
            return "success";
        else
            return "fail";
    }

    /**
     * 查询所有
     *
     * @param request
     * @param currentPageCode
     * @return
     */
    @GetMapping("queryAll")
    public PageModel<Object> queryAll(HttpServletRequest request, Integer currentPageCode) {
        Integer custId = 10001; //(Integer) request.getSession().getAttribute("custId");
        //初始化pageModel
        initializePageModel(currentPageCode);
        //获取订单数量
        Integer size = shopOrderService.queryByPage4Size(custId);
        pageModel.setTotalRecord(size);
        //获取订单页数
        initializeTotalPages(size);
        System.out.println(pageModel);
        List<ShopOrder> shopOrderList = shopOrderService.queryByPage(custId, pageModel);
        return getOrderDetail(shopOrderList, pageModel.getStartRecord());
    }


    /**
     * 状态查询
     *
     * @param request
     * @param orderStatus
     * @param currentPageCode
     * @return
     */
    @GetMapping("queryByState")
    public PageModel<Object> queryByState(HttpServletRequest request, Integer orderStatus,String timeState, Integer currentPageCode) {
        Integer custId = 10001; //(Integer) request.getSession().getAttribute("custId");
        initializePageModel(currentPageCode);
        Integer size = shopOrderService.queryByState4Size(custId, orderStatus,timeState);
        pageModel.setTotalRecord(size);
        initializeTotalPages(size);
        List<ShopOrder> shopOrderList = shopOrderService.queryByState(custId, orderStatus,timeState, pageModel);
        return getOrderDetail(shopOrderList, pageModel.getStartRecord());
    }


    /**
     * 条件查询
     *
     * @param request
     * @param condition
     * @param currentPageCode
     * @return
     */
    @GetMapping("queryByCondition")
    public PageModel<Object> queryByCondition(HttpServletRequest request, String condition, Integer currentPageCode) {
        PageModel<Object> result = queryByOrderNumber(request, condition, currentPageCode);
        if (result.getModelList() == null) {
            result = queryByBookName(request, condition, currentPageCode);
        }
        return result;
    }

    public PageModel<Object> queryByOrderNumber(HttpServletRequest request, String orderNumber, Integer currentPageCode) {
        Integer custId = 10001; //(Integer) request.getSession().getAttribute("custId");
        initializePageModel(currentPageCode);
        pageModel.setTotalPages(1);
        pageModel.setStartRecord(0);
        List<ShopOrder> shopOrderList = shopOrderService.queryByOrderNumber(custId, orderNumber, pageModel);
        return getOrderDetail(shopOrderList, pageModel.getStartRecord());
    }


    public PageModel<Object> queryByBookName(HttpServletRequest request, String bookName, Integer currentPageCode) {
        Integer custId = 10001; //(Integer) request.getSession().getAttribute("custId");
        initializePageModel(currentPageCode);
        Integer size = shopOrderService.queryByBookName4Size(custId, bookName);
        pageModel.setTotalRecord(size);
        initializeTotalPages(size);
        List<ShopOrder> shopOrderList = shopOrderService.queryByBookName(custId, bookName, pageModel);
        return getOrderDetail(shopOrderList, pageModel.getStartRecord());
    }

    @GetMapping("queryOrderDetail")
    public HashMap<String, Object> queryOrderDetail(HttpServletRequest request, Integer orderId) {
        return shopOrderDetailService.queryByOrderId(orderId).get(0);
    }

    /**
     * 初始化pageModel
     *
     * @param currentPageCode
     */
    private void initializePageModel(Integer currentPageCode) {
        if (currentPageCode == null) {
            currentPageCode = 1;
        }
        pageModel = new PageModel<>();
        pageModel.setCurrentPageCode(currentPageCode);
    }

    /**
     * 初始化页数,开始记录条数
     *
     * @param size
     */
    private void initializeTotalPages(Integer size) {
        if (size % pageModel.getPageSize() != 0) {
            pageModel.setTotalPages(size / pageModel.getPageSize() + 1);
        } else {
            pageModel.setTotalPages(size / pageModel.getPageSize());
        }
        System.out.println(pageModel.getTotalPages());
        System.out.println(size);
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());
    }


    /**
     * 获取订单列表详细信息
     *
     * @param shopOrderList
     * @return
     */
    private PageModel<Object> getOrderDetail(List<ShopOrder> shopOrderList, Integer currentPageCode) {
        PageModel<Object> pageModel0 = new PageModel<>();
        List<Object> hashMapList = new ArrayList<>();
        HashMap<String, Object> hashMap;
        if (shopOrderList != null) {
            for (ShopOrder shopOrder : shopOrderList) {
                List<HashMap<String, Object>> shopOrderDetailList = shopOrderDetailService.queryByOrderId(shopOrder.getOrderId());
                String consigneeName = addressService.queryByAddressId(shopOrder.getAddressId()).get(0).getConsigneeName();
                hashMap = new HashMap<>();
                hashMap.put("shopOrderDetailList", shopOrderDetailList);
                hashMap.put("shopOrder", shopOrder);
                hashMap.put("consigneeName", consigneeName);
                hashMapList.add(hashMap);
            }
        } else {
            hashMapList = null;
        }
        pageModel0.setModelList(hashMapList);
        pageModel0.setTotalRecord(pageModel.getTotalRecord());
        pageModel0.setTotalPages(pageModel.getTotalPages());
        pageModel0.setCurrentPageCode(pageModel.getCurrentPageCode());
        pageModel0.setStartRecord(pageModel.getStartRecord());
        return pageModel0;
    }

    /**
     * 订单编号生成
     *
     * @param custId
     * @return
     */
    private Long orderNumberGenerate(Integer custId) {
        return Long.valueOf(String.valueOf(custId) + String.valueOf(new Date().getTime()));
    }
}
