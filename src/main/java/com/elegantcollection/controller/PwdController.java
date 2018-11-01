package com.elegantcollection.controller;

import com.elegantcollection.entity.Customer;
import com.elegantcollection.service.CustomerService;
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

    /**
     * 根据手机号查看用户是否存在
     * @param custPhone 手机号
     * @return
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

    @GetMapping("phonepwd")
    public Boolean updatePwdByPhone(String custPhone,String custPassword){
        int n = this.customerService.alterByPhone(custPhone,custPassword);
        if (n == 1){
            return true;
        }else {
            return false;
        }
    }

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
}
