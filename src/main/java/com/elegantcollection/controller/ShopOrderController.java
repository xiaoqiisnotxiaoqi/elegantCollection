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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    private PageModel<ShopOrder> pageModel = new PageModel<>();


    @Autowired
    public ShopOrderController(ShopOrderService shopOrderService, ShopOrderDetailService shopOrderDetailService, AddressService addressService, BookService bookService) {
        this.shopOrderService = shopOrderService;
        this.shopOrderDetailService = shopOrderDetailService;
        this.addressService = addressService;
        this.bookService = bookService;
    }

    /**
     * 添加订单（订单创建时间：转入支付页面时）
     *
     * @param request 存入用户id，购物车信息
     * @return 输出json对象
     */
    @GetMapping("add")
    public HashMap<String, Object> add(HttpServletRequest request) {
        //获取用户id
        Integer custId = ((Customer) request.getSession().getAttribute("customer")).getCustId();
        //获取购物车内信息
        HashMap<String, String> map = (HashMap<String, String>) request.getSession().getAttribute("buyThis");
        //购物车内的书籍列表
        List<HashMap<String, Object>> booklist = new ArrayList<>();
        //购物车内的书籍总价
        Float allprice = Float.parseFloat(map.get("allprice"));
        //购物车内的书籍组合优惠价格
        Float groupPrice = Float.valueOf (Math.round(Float.parseFloat(map.get("groupPrice"))*100)/100);
        //购物车内的书籍满减价格
        Float fullReductionDiscount = Float.parseFloat(map.get("fullReductionDiscount"));
        //获取详细图书信息存入图书列表booklist
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

        //构建返回json对象
        HashMap<String, Object> objectHashMap = new HashMap<>();
        //获取订单编号生成
        Long orderNumber = orderNumberGenerate(custId);
        //向json对象放入订单信息
        objectHashMap.put("bookList", booklist);
        objectHashMap.put("allprice", allprice);
        objectHashMap.put("groupPrice", groupPrice);
        objectHashMap.put("fullReductionDiscount", fullReductionDiscount);
        objectHashMap.put("orderNumber", orderNumber);
        //获取一个默认地址
        Integer addressId=addressService.queryByCustId(custId).get(0).getAddressId();
        //插入数据库的订单容器
        ShopOrder shopOrder = new ShopOrder();
        shopOrder.setCustId(custId);
        shopOrder.setOrderNumber(orderNumber);
        shopOrder.setOrderPrice(allprice - groupPrice - fullReductionDiscount);
        shopOrder.setOrderCreateTime(new Date());
        shopOrder.setAddressId(addressId);
        shopOrder.setDiscountAmount(String.valueOf(groupPrice+fullReductionDiscount));
        //添加订单
        if (shopOrderService.add(shopOrder) == 1) {
            //添加订单详情条目
            ShopOrderDetail shopOrderDetail = new ShopOrderDetail();
            for (HashMap<String, Object> b : booklist) {
                shopOrderDetail.setOrderId(shopOrder.getOrderId());
                shopOrderDetail.setBookId(((Book) b.get("book")).getBookId());
                shopOrderDetail.setQuality((Integer) b.get("bookNumber"));
                shopOrderDetailService.add(shopOrderDetail);
            }
        }
        objectHashMap.put("orderId", shopOrder.getOrderId());
        return objectHashMap;
    }//由购物车custCart.jsp跳转结算页面pay.jsp


    /**
     * 获取收货人地址
     *
     * @return 收货人地址
     */
    @GetMapping("getAddress")
    public List<Address> getAddress(HttpServletRequest request) {
        Integer custId = ((Customer) request.getSession().getAttribute("customer")).getCustId();
        List<Address> addressList = addressService.queryByCustId(custId);
        return addressList;
    }//由购物车custCart.jsp跳转结算pay.jsp页面


    /**
     * 删除订单（可找回）
     *
     * @param orderId 订单id
     * @return 动作结果
     */
    @GetMapping("removeByOrderId")
    public String removeByOrderId(Integer orderId) {
        if (shopOrderService.removeByOrderId(orderId) == 1)
            return "success";
        else
            return "fail";
    }//全部订单页面order_all.jsp操作

    /**
     * 完全删除订单（不可找回）
     *
     * @param orderId 订单id
     * @return 动作结果
     */
    @GetMapping("delByOrderId")
    public String delByOrderId(Integer orderId) {
        if (shopOrderService.delByOrderId(orderId) == 1)
            return "success";
        else
            return "fail";
    }//全部订单页面order_all.jsp操作

    /**
     * 订单完善
     *
     * @param httpRequest        存入用户id
     * @param httpResponse       输出支付宝页面
     * @param payPriceValue      支付金额
     * @param bookQuantity       图书数量
     * @param bookName           图书名称
     * @param orderId            图书id
     * @param addressId          地址id
     * @param expectationTime    期望时间
     * @param discountPriceValue 折扣金额
     * @throws IOException    输出支付宝页面，输出异常
     * @throws ParseException 期待收货时间由字符串转换为Date类型，格式转换异常
     */
    @GetMapping("perfect")
    public void perfect(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Float payPriceValue, Integer bookQuantity, String bookName, String orderId, String addressId, String expectationTime, String discountPriceValue) throws IOException, ParseException {
        //构建订单对象
        ShopOrder shopOrder = new ShopOrder();
        //放入订单完善的信息
        shopOrder.setOrderId(Integer.valueOf(orderId));
        shopOrder.setAddressId(Integer.valueOf(addressId));
        //期待收货时间格式转换
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date expectationDate = format.parse(expectationTime);
        shopOrder.setExpectationTime(expectationDate);
        shopOrder.setPaymentTime(new Date());
        shopOrder.setDiscountAmount(discountPriceValue);
        //修改订单
        shopOrderService.alter(shopOrder);
        //存入orderId，从而在支付后跳转支付详情
        httpRequest.getSession().setAttribute("orderId", orderId);
        //跳转支付宝支付功能
        pay(httpResponse, String.valueOf(payPriceValue), String.valueOf(bookQuantity), bookName, orderId);
    }//由结算页面pay.jsp进入支付宝支付方法

    /**
     * 支付宝支付功能
     *
     * @param httpResponse  输出支付宝页面
     * @param payPriceValue 支付金额
     * @param bookQuantity  图书数量
     * @param bookName      图书名称
     * @param orderId       订单ID
     * @throws IOException
     */
    @GetMapping("pay")
    public void pay(HttpServletResponse httpResponse, String payPriceValue, String bookQuantity, String bookName, String orderId) throws IOException {
        //支付接口
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        //返回客户网页
        alipayRequest.setReturnUrl("http://134.175.57.230:8080/showOrderDetail0");
        //alipayRequest.setNotifyUrl("http://localhost:8080/notify");//在公共参数中设置回跳和通知地址（无法使用）
        alipayRequest.setBizContent("{" +
                //订单id
                "    \"out_trade_no\":\"" + orderId + "\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                //支付价格
                "    \"total_amount\":" + payPriceValue + "," +
                //图书数量
                "    \"subject\":\"雅致图书 x" + bookQuantity + "\"," +
                //图书名
                "    \"body\":\"" + bookName + "\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }" +
                "  }");//填充业务参数
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

    /**
     * 完成支付后的订单状态修改
     *
     * @param httpServletRequest
     * @throws AlipayApiException
     */
    @GetMapping("finishOrder")
    public void alterOrder(HttpServletRequest httpServletRequest) throws AlipayApiException {
        Integer orderId = (Integer) httpServletRequest.getSession().getAttribute("orderId");
        //查询订单状态，如果未支付则修改状态
        Integer payJudge = shopOrderService.queryByOrderId(orderId).getOrderStatus();
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();//创建API对应的request类
        request.setBizContent("{" +
                //订单id
                " \"out_trade_no\":\"" + orderId + "\"" +
                " }");
        AlipayTradeQueryResponse response = alipayClient.execute(request);//通过alipayClient调用API，获得对应的response类
        //订单状态为未支付，支付结果为支付成功
        if (payJudge == 0 && response.getTradeStatus().equals("TRADE_SUCCESS")) {
            System.out.println("支付成功");
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
     * @param request         获取用户id
     * @param currentPageCode 当前页数
     * @return 订单列表的PageModel对象
     */
    @GetMapping("queryAll")
    public PageModel<Object> queryAll(HttpServletRequest request, Integer currentPageCode) {
        Integer custId = ((Customer) request.getSession().getAttribute("customer")).getCustId();
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
    }//全部订单页面order_all.jsp


    /**
     * 状态查询（订单状态，时间状态）
     *
     * @param request         获取用户id
     * @param orderStatus     订单状态
     * @param timeState       时间状态
     * @param currentPageCode 当前页数
     * @return 订单列表的PageModel对象
     */
    @GetMapping("queryByState")
    public PageModel<Object> queryByState(HttpServletRequest request, Integer orderStatus, String timeState, Integer currentPageCode) {
        Integer custId = ((Customer) request.getSession().getAttribute("customer")).getCustId();
        initializePageModel(currentPageCode);
        pageModel.setPageSize(4);
        Integer size = shopOrderService.queryByState4Size(custId, orderStatus, timeState);
        pageModel.setTotalRecord(size);
        initializeTotalPages(size);
        List<ShopOrder> shopOrderList = shopOrderService.queryByState(custId, orderStatus, timeState, pageModel);
        return getOrderDetail(shopOrderList);
    }//全部订单页面order_all.jsp的操作


    /**
     * 条件查询
     *
     * @param request         获取用户id
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
    }//全部订单页面order_all.jsp的操作

    /**
     * 订单编号查询
     *
     * @param request         获取用户id
     * @param orderNumber     订单编号
     * @param currentPageCode 当前页数
     * @return 订单列表的PageModel对象
     */
    public PageModel<Object> queryByOrderNumber(HttpServletRequest request, String orderNumber, Integer currentPageCode) {
        Integer custId = ((Customer) request.getSession().getAttribute("customer")).getCustId();
        initializePageModel(currentPageCode);
        //订单编号查询唯一，pageModel内信息固定
        pageModel.setPageSize(4);
        pageModel.setTotalPages(1);
        pageModel.setStartRecord(0);
        List<ShopOrder> shopOrderList = shopOrderService.queryByOrderNumber(custId, orderNumber, pageModel);
        return getOrderDetail(shopOrderList);
    }

    /**
     * 书名查询
     *
     * @param request         获取用户id
     * @param bookName        书名
     * @param currentPageCode 当前页数
     * @return 订单列表的PageModel对象
     */
    public PageModel<Object> queryByBookName(HttpServletRequest request, String bookName, Integer currentPageCode) {
        Integer custId = ((Customer) request.getSession().getAttribute("customer")).getCustId();
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
    public JSONObject getTransport(String no, String com) throws Exception {
        return JuheDemo.getRequest1(no, com);
    }
}
