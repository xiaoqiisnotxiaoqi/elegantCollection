package com.elegantcollection.controller;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.elegantcollection.entity.*;
import com.elegantcollection.service.AddressService;
import com.elegantcollection.service.BookService;
import com.elegantcollection.service.ShopOrderDetailService;
import com.elegantcollection.service.ShopOrderService;
import com.elegantcollection.util.AlipayConfig;
import com.elegantcollection.util.JuheDemo;
import com.elegantcollection.util.PageModel;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;


@RestController
@RequestMapping("order")
public class ShopOrderController {

    private final ShopOrderService shopOrderService;
    private final ShopOrderDetailService shopOrderDetailService;
    private final AddressService addressService;
    private final BookService bookService;

    PageModel<ShopOrder> pageModel = new PageModel<>();


    @Autowired
    public ShopOrderController(ShopOrderService shopOrderService, ShopOrderDetailService shopOrderDetailService, AddressService addressService, BookService bookService) {
        this.shopOrderService = shopOrderService;
        this.shopOrderDetailService = shopOrderDetailService;
        this.addressService = addressService;
        this.bookService = bookService;
        pageModel.setPageSize(4);
    }

    /**
     * 添加订单（订单创建时间：转入支付页面时）
     *
     * @param request
     * @param
     * @return
     */
    @GetMapping("add")
    public HashMap<String, Object> add(HttpServletRequest request) {
        Integer custId = 10001; //(Integer) request.getSession().getAttribute("custId");

        HashMap<String, String> buyThis = new HashMap<>();
        buyThis.put("10001", "2");
        buyThis.put("10002", "5");
        buyThis.put("allprice", "223");
        buyThis.put("groupPrice", "20");
        buyThis.put("fullReductionDiscount", "100");
        request.getSession().setAttribute("buyThis", buyThis);


        //获取购物车传入session
        HashMap<String, String> map = (HashMap<String, String>) request.getSession().getAttribute("buyThis");
        //展示的bookList
        List<HashMap<String, Object>> booklist = new ArrayList<>();
        //总价
        Float allprice = Float.parseFloat(map.get("allprice"));
        //组合优惠价格
        Float groupPrice = Float.parseFloat(map.get("groupPrice"));
        //满减价格
        Float fullReductionDiscount = Float.parseFloat(map.get("fullReductionDiscount"));
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (isInteger(entry.getKey())) {
                HashMap<String, Object> bookMap = new HashMap<>();
                String bookId = entry.getKey();
                Book book = bookService.quaryBookByBookId(Integer.parseInt(bookId));
                bookMap.put("book", book);
                bookMap.put("bookNumber", Integer.parseInt(entry.getValue()));
                booklist.add(bookMap);
            }
        }


        HashMap<String, Object> objectHashMap = new HashMap<>();
        Long orderNumber = orderNumberGenerate(custId);
        objectHashMap.put("bookList", booklist);
        objectHashMap.put("allprice", allprice);
        objectHashMap.put("groupPrice", groupPrice);
        objectHashMap.put("fullReductionDiscount", fullReductionDiscount);
        objectHashMap.put("orderNumber", orderNumber);
        ShopOrder shopOrder = new ShopOrder();
        shopOrder.setCustId(custId);
        shopOrder.setOrderNumber(orderNumber);
        shopOrder.setOrderPrice(allprice - groupPrice - fullReductionDiscount);
        shopOrder.setOrderCreateTime(new Date());
        if (shopOrderService.add(shopOrder) == 1) {//添加订单
            ShopOrderDetail shopOrderDetail = new ShopOrderDetail();
            for (HashMap<String, Object> b : booklist) {//添加订单详情条目
                shopOrderDetail.setOrderId(shopOrder.getOrderId());System.out.println(shopOrder.getOrderId());
                shopOrderDetail.setBookId(((Book) b.get("book")).getBookId());
                shopOrderDetail.setQuality((Integer) b.get("bookNumber"));
                shopOrderDetailService.add(shopOrderDetail);
            }
        }
        objectHashMap.put("orderId", shopOrder.getOrderId());
        return objectHashMap;
    }

    /**
     * 获取收货人地址（）
     *
     * @return 收货人地址
     */
    @GetMapping("getAddress")
    public List<Address> getAddress() {
        Integer custId = 10001; //(Integer) request.getSession().getAttribute("custId");
        List<Address> addressList = addressService.queryByCustId(custId);
        return addressList;
    }


    /**
     * 删除订单（可找回）
     *
     * @param request request请求
     * @param orderId 订单id
     * @return 动作结果
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
     * @param request request请求
     * @param orderId 订单id
     * @return 动作结果
     */
    @GetMapping("delByOrderId")
    public String delByOrderId(HttpServletRequest request, Integer orderId) {
        if (shopOrderService.delByOrderId(orderId) == 1)
            return "success";
        else
            return "fail";
    }

    /**
     * 订单支付
     *
     * @param httpRequest
     * @param httpResponse
     * @param orderNumber
     * @param payPriceValue
     * @param bookQuantity
     * @param bookName
     * @param orderId
     * @param addressId
     * @param expectationTime
     * @param discountPriceValue
     * @throws ServletException
     * @throws IOException
     * @throws ParseException
     * @throws AlipayApiException
     */
    @GetMapping("pay")
    public void pay(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String orderNumber, Integer payPriceValue, Integer bookQuantity, String bookName, String orderId, String addressId, String expectationTime, String discountPriceValue) throws ServletException, IOException, ParseException, AlipayApiException {
        //订单完善
        ShopOrder shopOrder = new ShopOrder();
        shopOrder.setOrderId(Integer.valueOf(orderId));
        shopOrder.setAddressId(Integer.valueOf(addressId));
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date expectationDate = format.parse(expectationTime);
        shopOrder.setExpectationTime(expectationDate);
        shopOrder.setPaymentTime(new Date());
        shopOrder.setDiscountAmount(discountPriceValue);
        shopOrderService.alter(shopOrder);
        httpRequest.getSession().setAttribute("orderId", orderId);

        //支付接口
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl("http://localhost:8080/showOrderDetail0");
        //alipayRequest.setNotifyUrl("http://localhost:8080/notify");//在公共参数中设置回跳和通知地址
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\"" + orderId + "\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":" + payPriceValue + "," +
                "    \"subject\":\"雅致图书 x" + bookQuantity + "\"," +
                "    \"body\":\"" + bookName + "\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }" +
                "  }");//填充业务参数
        // System.out.println(alipayRequest.getBizContent());
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println(form);
        httpResponse.setContentType("text/html;charset=" + "utf-8");
        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    @GetMapping("alterOrder")
    public void alterOrder(HttpServletRequest httpServletRequest) throws AlipayApiException {
        Integer orderId = (Integer) httpServletRequest.getSession().getAttribute("orderId");
        String payJudge= (String) httpServletRequest.getSession().getAttribute("payJudge");
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();//创建API对应的request类
        request.setBizContent("{" +
                " \"out_trade_no\":\"" + orderId + "\"" +
                " }");//设置业务参数
        //System.out.println(request.getBizContent());
        AlipayTradeQueryResponse response = alipayClient.execute(request);//通过alipayClient调用API，获得对应的response类
        System.out.print(response.getBody());
        //根据response中的结果继续业务逻辑处理
        if (payJudge==null&&response.getTradeStatus().equals("TRADE_SUCCESS")) {
             httpServletRequest.getSession().setAttribute("payJudge","Y");
            shopOrderService.alterStatus(Integer.valueOf(orderId));
        } else {
            System.out.println("支付失败");
        }
    }


    /**
     * 修改订单状态（后台）
     *
     * @param request request请求
     * @param orderId 订单id
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
     * @param request         request请求
     * @param currentPageCode 当前页数
     * @return 订单列表的PageModel对象
     */
    @GetMapping("queryAll")
    public PageModel<Object> queryAll(HttpServletRequest request, Integer currentPageCode) {
        Integer custId = 10001;//(Integer) request.getSession().getAttribute("custId");
        //初始化pageModel
        initializePageModel(currentPageCode);
        pageModel.setPageSize(4);
        //获取订单数量
        Integer size = shopOrderService.queryByPage4Size(custId);
        pageModel.setTotalRecord(size);
        //获取订单页数
        initializeTotalPages(size);
        List<ShopOrder> shopOrderList = shopOrderService.queryByPage(custId, pageModel);
        return getOrderDetail(shopOrderList);
    }


    /**
     * 状态查询
     *
     * @param request         request请求
     * @param orderStatus     订单状态
     * @param currentPageCode 当前页数
     * @return 订单列表的PageModel对象
     */
    @GetMapping("queryByState")
    public PageModel<Object> queryByState(HttpServletRequest request, Integer orderStatus, String timeState, Integer currentPageCode) {
        Integer custId = (Integer) request.getSession().getAttribute("custId");
        initializePageModel(currentPageCode);
        pageModel.setPageSize(4);
        Integer size = shopOrderService.queryByState4Size(custId, orderStatus, timeState);
        pageModel.setTotalRecord(size);
        initializeTotalPages(size);
        List<ShopOrder> shopOrderList = shopOrderService.queryByState(custId, orderStatus, timeState, pageModel);
        return getOrderDetail(shopOrderList);
    }


    /**
     * 条件查询
     *
     * @param request         request请求
     * @param condition       当前条件（书名，订单编号）
     * @param currentPageCode 当前页码
     * @return 订单列表的PageModel对象
     */
    @GetMapping("queryByCondition")
    public PageModel<Object> queryByCondition(HttpServletRequest request, String condition, Integer currentPageCode) {
        PageModel<Object> result = queryByOrderNumber(request, condition, currentPageCode);
        if (result.getModelList() == null) {
            result = queryByBookName(request, condition, currentPageCode);
        }
        return result;
    }

    /**
     * 订单编号查询
     *
     * @param request         request请求
     * @param orderNumber     订单编号
     * @param currentPageCode 当前页数
     * @return 订单列表的PageModel对象
     */
    public PageModel<Object> queryByOrderNumber(HttpServletRequest request, String orderNumber, Integer currentPageCode) {
        Integer custId = (Integer) request.getSession().getAttribute("custId");
        initializePageModel(currentPageCode);
        pageModel.setPageSize(4);
        pageModel.setTotalPages(1);
        pageModel.setStartRecord(0);
        List<ShopOrder> shopOrderList = shopOrderService.queryByOrderNumber(custId, orderNumber, pageModel);
        return getOrderDetail(shopOrderList);
    }

    /**
     * 书名查询
     *
     * @param request         request请求
     * @param bookName        书名
     * @param currentPageCode 当前页数
     * @return 订单列表的PageModel对象
     */
    public PageModel<Object> queryByBookName(HttpServletRequest request, String bookName, Integer currentPageCode) {
        Integer custId = (Integer) request.getSession().getAttribute("custId");
        initializePageModel(currentPageCode);
        Integer size = shopOrderService.queryByBookName4Size(custId, bookName);
        pageModel.setTotalRecord(size);
        initializeTotalPages(size);
        List<ShopOrder> shopOrderList = shopOrderService.queryByBookName(custId, bookName, pageModel);
        return getOrderDetail(shopOrderList);
    }

    @GetMapping("queryOrderDetail")
    public HashMap<String, Object> queryOrderDetail(HttpServletRequest request, Integer orderId) {
        return shopOrderDetailService.queryByOrderId(orderId).get(0);
    }

    /**
     * 初始化pageModel
     *
     * @param currentPageCode 当前页数
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
     * @param size 数据总条数
     */
    private void initializeTotalPages(Integer size) {
        if (size % pageModel.getPageSize() != 0) {
            pageModel.setTotalPages(size / pageModel.getPageSize() + 1);
        } else {
            pageModel.setTotalPages(size / pageModel.getPageSize());
        }
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());
    }


    /**
     * 由订单列表获取订单详情（多个订单）
     *
     * @param shopOrderList 订单列表
     * @return 订单对应的订单详情列表的PageModel对象
     */
    private PageModel<Object> getOrderDetail(List<ShopOrder> shopOrderList) {
        PageModel<Object> pageModel0 = new PageModel<>();
        List<Object> hashMapList = new ArrayList<>();
        HashMap<String, Object> hashMap;
        if (shopOrderList != null) {
            for (ShopOrder shopOrder : shopOrderList) {
                List<HashMap<String, Object>> shopOrderDetailList = shopOrderDetailService.queryByOrderId(shopOrder.getOrderId());
                String consigneeName = addressService.queryByAddressId(shopOrder.getAddressId()).getConsigneeName();
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
     * <p>
     * 订单编号由用户id与当前时间戳的字符组合形成
     *
     * @param custId 用户id
     * @return 订单编号
     */
    private Long orderNumberGenerate(Integer custId) {
        return Long.valueOf(String.valueOf(custId) + String.valueOf(new Date().getTime()));
    }

    /*
     * 判断是否为整数
     * @param str 传入的字符串
     * @return 是整数返回true,否则返回false
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 获取单个订单的订单详情
     *
     * @param request request请求
     * @return 订单详情列表
     */
    @GetMapping("showOrderDetail")
    public HashMap showOrderDetail(HttpServletRequest request) {
        Integer orderId = (Integer) request.getSession().getAttribute("orderId");
        ShopOrder shopOrder = shopOrderService.queryByOrderId(orderId);
        List<HashMap<String, Object>> shopOrderDetailList = shopOrderDetailService.queryByOrderId(orderId);
        Address address = addressService.queryByAddressId(shopOrder.getAddressId());
        HashMap hashMap = new HashMap<>();
        hashMap.put("shopOrderDetailList", shopOrderDetailList);
        hashMap.put("shopOrder", shopOrder);
        hashMap.put("address", address);
        return hashMap;
    }

    /**
     * 物流信息请求
     *
     * @param no  快递单号
     * @param com 快递公司编号
     * @return 快递数据的JSONObject对象
     * @throws Exception
     */
    @GetMapping("getTransport")
    public JSONObject getTransport(Long no, String com) throws Exception {
        return JuheDemo.getRequest1(no, com);
    }
}
