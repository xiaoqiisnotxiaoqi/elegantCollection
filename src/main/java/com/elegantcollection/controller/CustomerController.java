package com.elegantcollection.controller;

import com.elegantcollection.entity.Book;
import com.elegantcollection.entity.Customer;
import com.elegantcollection.entity.Evaluate;
import com.elegantcollection.service.BookService;
import com.elegantcollection.service.CustomerService;
import com.elegantcollection.service.EvaluateService;
import com.elegantcollection.util.CodeUtil;
import com.elegantcollection.util.PageModel;
import com.elegantcollection.util.RandomNumberGeneration;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class CustomerController {
    private final Producer captchaProducer;
    private final CustomerService customerService;
    @Autowired
    private EvaluateService evaluateService;

    @Autowired
    private BookService bookService;

    @Autowired
    public CustomerController(CustomerService customerService, Producer captchaProducer) {
        this.customerService = customerService;
        this.captchaProducer = captchaProducer;
    }


    /**
     * 用户登录
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

        if (customerList.size() == 0) {
            return "fail";
        } else {
            request.getSession().setAttribute("customer", customerList.get(0));
            //返回用户昵称
            return customerList.get(0).getCustName();
        }
    }

    /**
     * 用户注册
     *
     * @param phone     用户填写的手机号
     * @param password  用户填写的密码
     * @param imgCode   用户输入的图片验证码
     * @param phoneCode 用户输入的图片验证码
     * @return 用户信息填写成功, 返回""success" ,否则返回"fail"
     */
    @PostMapping("/singIn")
    public String customerRegister(String phone, String password, String imgCode, String phoneCode, HttpServletRequest request) {
        //验证图片验证码是否正确
        if (!CodeUtil.checkVerifyCode(request, imgCode)) {
            return "图片验证码错误";
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
        String name;
        do {
            name = RandomNumberGeneration.getRandomString(10);
            System.out.println(name);
        } while (customerService.queryNumByCustName(name) != 0);

        //添加用户昵称
        customer.setCustName(name);
        //添加用户头像
        customer.setCustProfile("images/custProfile.img");
        customerService.addCustomer(customer);
        //根据用户id 得到包含用户id的用户对象
        Customer newCustomer = customerService.quaryCustomerByCustName(name);
        newCustomer.setCustName("");
        //将用户对象存入session中
        request.getSession().setAttribute("customer", newCustomer);
        return "success";
    }

    /**
     * 用户注销(退出登录)
     *
     * @param request 用户的请求信息
     * @return success(退出成功)
     */
    @DeleteMapping("loginOut")
    public String loginOut(HttpServletRequest request) {
        System.out.println("用户退出中");
        HttpSession session = request.getSession();
        session.removeAttribute("customer");
        return "success";
    }

    /**
     * 用于生成 验证码图片 并以字节流返回
     *
     * @param request  请求信息
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


    @GetMapping("/phoneIsRegistered")
    public String phoneNumberIsRegistered(String phone) {
        List list = customerService.queryCustomerByPhone(phone);
        if (list.size() == 0) {
            return "success";
        } else {
            return "手机号码已被占用";
        }
    }


    /**
     * 查询我的评价
     *
     * @param pageCode 当前页码
     * @param request  用来获取session
     * @return 查询结果, 包含pagemodel booklist
     */
    @GetMapping("getMyEvaluate")
    public HashMap myEvaluate(Integer pageCode, HttpServletRequest request) {
        HashMap map = new HashMap();
        PageModel pageModel = new PageModel();
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        if (pageCode == null) {
            pageModel.setCurrentPageCode(1);
        } else {
            pageModel.setCurrentPageCode(pageCode);
        }
        System.out.println("当前是第" + pageModel.getCurrentPageCode() + "页");
        pageModel.setTotalRecord(evaluateService.countByCustomerId(customer.getCustId()));
        System.out.println("共有 " + evaluateService.countByCustomerId(customer.getCustId()) + " 条记录");
        pageModel.setTotalPages(pageModel.getTotalRecord() % pageModel.getPageSize() == 0 ? pageModel.getTotalRecord() / pageModel.getPageSize() : pageModel.getTotalRecord() / pageModel.getPageSize() + 1);
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());

        List<Evaluate> evaluateList = evaluateService.queryEvaluateByPage(pageModel, customer.getCustId());
        List<Book> bookList = new ArrayList<>();
        for (Evaluate e : evaluateList) {
            Book book = bookService.quaryBookByBookId(e.getBookId());
            bookList.add(book);
        }

        pageModel.setModelList(evaluateService.queryEvaluateByPage(pageModel, customer.getCustId()));


        map.put("pageModel", pageModel);
        map.put("bookList", bookList);
        return map;
    }


}
