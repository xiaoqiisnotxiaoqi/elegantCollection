package com.elegantcollection.controller;

import com.elegantcollection.entity.*;
import com.elegantcollection.service.*;
import com.elegantcollection.util.CodeUtil;
import com.elegantcollection.util.RandomNumberGeneration;
import com.elegantcollection.util.SmsVerification;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("all")
@RestController
public class CustomerController {
    private final Producer captchaProducer;
    private final CustomerService customerService;
    @Autowired
    private EvaluateService evaluateService;
    @Autowired
    private ShopOrderDetailService shopOrderDetailService;
    @Autowired
    private ShopOrderService shopOrderService;


    @Autowired
    private BookService bookService;

    @Autowired
    public CustomerController(CustomerService customerService, Producer captchaProducer) {
        this.customerService = customerService;
        this.captchaProducer = captchaProducer;
    }


    /**
     * 用户登录(用户名登录)
     *
     * @param custName 用户输入的用户名
     * @param pwd      用户输入的密码
     * @param request  请求信息
     * @return 用户登录成功, 返回用户名(没有设置用户名, 则返回手机号) 否则返回"fail"
     */
    @PostMapping("/login")
    public String customerLogin(String custName, String pwd, HttpServletRequest request) {
        System.out.println(custName);
        System.out.println(pwd);
        List<Customer> customerList;
        //判断用户输入的用户名为手机号,还是邮箱号
        if (custName.contains("@")) {
            customerList = customerService.quaryCustomerByEmail(custName, pwd);
        } else {
            customerList = customerService.quaryCustomerByPhone(custName, pwd);
        }

        if (customerList.size() == 0){
            return "用户名或密码错误";
        }else {
            request.getSession().setAttribute("customer",customerList.get(0));
            return  "success";
        }
    }


    /**
     * 用户登录(手机短信登录)
     * @param phone 用户手机号
     * @param securityCode 手机验证码
     * @param request 用户请求信息
     * @return 是否登录成功
     */
    @PostMapping("/textLogin")
    public String textLogin(String phone,Integer securityCode, HttpServletRequest request){
        int cellPhoneVerificatioCode = (Integer) request.getSession().getAttribute("cellPhoneVerificatioCode");
        if (cellPhoneVerificatioCode == securityCode){
            List<Customer> list = customerService.queryCustomerByPhone(phone);
            if (list.size() == 0) {
                return "该手机号未注册";
            }
            request.getSession().setAttribute("customer",list.get(0));
        }
        return "success";
    }

    /**
     * 向用户发送手机号
     * @param phone 用户手机号码
     * @param num 当前业务 (登录:1 ; 注册 : 2  找回密码 : 3)
     * @return 短信发送是否成功
     */
    @PostMapping("/sendText")
    public Map<String,String> SendText(String phone,Integer num,HttpServletRequest request){
        Map<String,String> map = new HashMap<>();
        int tplId;
        if (num == 1){
            //登录
            tplId = 110405;
        }else if(num == 2){
            //注册时 发送的短信模板
            tplId = 110406;
        }else if (num == 3){
            //修改密码是,所用的模板id
            tplId = 110407;
        }else{
            return null;
        }
        //生成由四位数字组成的随机数 并存入session 中
        int a = RandomNumberGeneration.randomNumber();
        request.getSession().setAttribute("cellPhoneVerificatioCode",a);
        //十五分钟后 删除 该 验证码
        removeAttrbute(request.getSession(),"cellPhoneVerificatioCode");


        String tplValue = "#code#=" + a;
        //发送验证码
        SmsVerification.getRequest2(phone,tplId,tplValue);

        map.put("result","success");
        return map;
    }


    /**
     * 用户注册
     * @param phone 用户填写的手机号
     * @param password 用户填写的密码
     * @param imgCode 用户输入的图片验证码
     * @param phoneCode 用户输入的图片验证码
     * @return 用户信息填写成功,返回""success" ,否则返回"fail"
     */
    @PostMapping("/singIn")
    public String customerRegister(String phone,String password,String imgCode,Integer phoneCode,HttpServletRequest request){
        //验证图片验证码是否正确
        if(!CodeUtil.checkVerifyCode(request,imgCode)){
            return "图片验证码错误";
        }else if (phoneCode != (int) request.getSession().getAttribute("cellPhoneVerificatioCode")){
            return "短信验证码错误";
        }
        Customer customer = new Customer();
        //用户密码
        customer.setCustPassword(password);
        //用户手机号
        customer.setCustPhone(phone);
        //用户注册时间
        customer.setRegisterTime(new Date());
        //用户账号状态(1:正常)
        customer.setCustStatus(1);
        //用户的书评区状态
        customer.setCummStatus(1);
        //用户的登录状态(1:登录)
        customer.setLoginStatus(1);
        //用户的积分
        customer.setCustPoints(0);
        //生成用户昵称
        String name ;
        do{
            name = RandomNumberGeneration.getRandomString(10);
            System.out.println(name);
        }while (customerService.queryNumByCustName(name) != 0);

        //添加用户昵称
        customer.setCustName(name);
        //添加用户头像
        customer.setCustProfile("images/custProfile.img");
        customerService.addCustomer(customer);
        //根据用户id 得到包含用户id的用户对象
        Customer newCustomer = customerService.quaryCustomerByCustName(name);
        newCustomer.setCustName("");
        //将用户对象存入session中
        request.getSession().setAttribute("customer",newCustomer);
        return "success";
    }

    /**
     * 用户注销(退出登录)
     * @param request 用户的请求信息
     * @return success(退出成功)
     */
    @DeleteMapping("loginOut")
    public String loginOut(HttpServletRequest request){
        System.out.println("用户退出中");
        HttpSession session = request.getSession();
        session.removeAttribute("customer");
        return "success";
    }

    /**
     * 用于生成 验证码图片 并以字节流返回
     * @param request 请求信息
     * @param response 返回的信息
     * @throws Exception 抛出的异常
     */
    @RequestMapping("/kaptcha")
    public void getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        //生成验证码
        String capText = captchaProducer.createText();
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        //向客户端写出
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }


    /**
     * 检查手机号是否被注册过
     * @param phone 要注册的手机号
     * @return 检查结果(未被注册:success  已注册:"该手机号已被注册")
     */
    @GetMapping("/phoneIsRegistered")
    public String phoneNumberIsRegistered(String phone){
        List list = customerService.queryCustomerByPhone(phone);
        if (list.size() == 0){
            return "success";
        }else{
            return "手机号码已被占用";
        }
    }



    /**
     * 设置15分钟后删除session中的验证码
     * @param session
     * @param attrName
     */
    private void removeAttrbute(final HttpSession session, final String attrName) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // 删除session中存的验证码
                session.removeAttribute(attrName);
                timer.cancel();
            }
        }, 15 * 60 * 1000);
    }

    /**
     *  从前那端或的信息保存到数据库里
     * @param customer 传入一个 customer对象
     * @param request   服务器请求
     * @param response   服务器做出相应
     * @return   方法返回String
     * @throws ServletException /500/400 错误 ruquest 回应的时候未能处理的错误异常
     * @throws IOException  抛出异常
     */

    @PostMapping("/updatainfo")
    public ModelAndView updatByCustNameAndGender(Customer customer, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Customer c = (Customer) request.getSession().getAttribute("customer");
        ModelAndView mav = new ModelAndView();
        System.out.println(customer);
        if (c == null) {
            request.setAttribute("messsage", "请先登录");
            mav.setViewName("top");
            return mav;

        } else {
            c.setCustName(customer.getCustName());
            c.setCustGender(customer.getCustGender());
            customerService.updataCustNameAndCustGender(c);
            System.out.println(c);
            mav.setViewName("user_info");

            return mav;

        }

    }

    /**
     * 从前端获得头像以地址的方式存到数据库里
     * @param custProfile  头像的地址
     * @param request  服务器请求
     * @param response  服务器做出的回应
     *   @return 函数返回一个String 类型的值
     * @throws ServletException  /500/400 错误 ruquest 回应的时候未能处理的错误异常
     * @throws IOException 抛出异常
     */


    @PostMapping("/saveHead")
    public String saveHead(String custProfile, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String p2  = request.getSession().getServletContext().getRealPath("/");

        System.out.println(custProfile);//用来测试用的的 看看传进来的参数



        Customer c = (Customer) request.getSession().getAttribute("customer");


        if (c == null) {
            return "";
        } else {
            c.setCustProfile(custProfile);
            customerService.updataCustProfile(c);

        }
        return  c.getCustProfile();
    }

    /**
     *  从前端页面获得头像
     * @param request 向服务器请求
     * @param response 服务器做出回应
     * @return 返回类型
     */
    @PostMapping("getprofile")
    public String getCustprofile(HttpServletRequest request,HttpServletResponse response){
        Customer c = (Customer) request.getSession().getAttribute("customer");
        if (c == null) {
            return "";
        }else {
            return c.getCustProfile();
        }

    }

    /**
     * 根据用户的登录Id查询到订单
     * @param request 服务请求
     * @param response 服务响应
     * @return 返回订单集合
     * @throws ServletException 服务器异常
     * @throws IOException 异常
     */
    @GetMapping("getallorder")
    public List<Map<String, Object>> getaddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer c = (Customer) request.getSession().getAttribute("customer");

        // n+1 问题
        List<ShopOrder> orders = shopOrderService.queryByOreder(c.getCustId(),0);
        List<Map<String, Object>>  resp= new ArrayList<>();
        Map<String, Object> item;
        for (ShopOrder order:orders) {
            item = new HashMap<>();

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
              String  res = simpleDateFormat.format(order.getOrderCreateTime());


            item.put("orderCreateTime", res);



             double orderPrice = order.getOrderPrice();
            item.put("orderPrice", order.getOrderPrice());
            item.put("orderStatus", order.getOrderStatus());
            HashMap<String,Object> firstDetail = shopOrderDetailService.queryByOrderId(order.getOrderId()).get(0);
            int quality = (int)firstDetail.get("quality");
            item.put("quality", quality);
            int bookId =(int)firstDetail.get("bookId");

            BookWithBLOBs book = bookService.queryBybookIntro(bookId);
            item.put("bookIntro",book.getBookIntro());


            int orderId = (int) firstDetail.get("orderId");
            System.out.println("orderId======================================================>"+orderId);

            ShopOrder shopOrder  = shopOrderService.queryByOrderId(orderId);
            item.put("discountAmount",shopOrder.getDiscountAmount());

            item.put("bookImg",firstDetail.get("bookImg"));
            String title =(String) firstDetail.get("bookName");
            if (quality>1){
                title+="等商品";
            }
            item.put("title", title);
            resp.add(item);
        }
        return resp;
    }
}
