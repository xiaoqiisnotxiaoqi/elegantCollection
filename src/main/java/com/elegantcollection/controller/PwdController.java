package com.elegantcollection.controller;

import com.elegantcollection.entity.Customer;
import com.elegantcollection.service.BookService;
import com.elegantcollection.service.CustomerService;
import com.elegantcollection.util.ServerResponse;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("find")
public class PwdController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BookService bookService;

    /**
     * 根据手机号查看用户是否存在
     * @param custPhone 手机号
     * @return 是否存在
     */
    @GetMapping("phonething")
    public Boolean getCustomerByPhone(String custPhone){
        String phone = custPhone;
        Customer customer = this.customerService.queryByPhone(phone);
        if (customer != null){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 根据手机号更改密码
     * @param custPhone 手机号
     * @param custPassword 密码
     * @return 是否更改成功
     */
    @GetMapping("phonepwd")
    public Boolean updatePwdByPhone(String custPhone,String custPassword){
        int n = this.customerService.alterByPhone(custPhone,custPassword);
        if (n == 1){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 判断短信验证码是否正确
     * @param mage 输入的短信验证码
     * @param request 发送出的短信验证码
     * @return 是否正确
     */
    @GetMapping("message")
    public Boolean getMess(Integer mage, HttpServletRequest request){
        HttpSession session = request.getSession();
        int ssa = (int) session.getAttribute("cellPhoneVerificatioCode");
        if (mage == ssa){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 添加到购物车
     * @param bookId 书id
     * @param bookCount 书数量
     * @param request 用户id
     * @return 是否添加成功
     */
    @GetMapping("cart")
    public ServerResponse<Integer> toCart(Integer bookId, Integer bookCount, HttpServletRequest request){
        Integer custId = (Integer) request.getSession().getAttribute("custId");
        ServerResponse<Integer> sri = this.bookService.add2Cart(custId,bookId,bookCount);
        return sri;
    }
}
