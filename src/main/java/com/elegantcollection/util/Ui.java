package com.elegantcollection.util;

import com.elegantcollection.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class Ui {
    //    跳转首页
    @RequestMapping("index")
    public String index() {
        return "index";
    }

    //跳转图书列表
    @RequestMapping("allbooks")
    public String ui1() {
        System.out.println("★★★★★★★★★★★★★★★★--跳转到allbooks--★★★★★★★★★★★★★★★");
        return "allbooks";

    }

    //    测试
    @RequestMapping("my")
    public String ui6() {
        return "My_address";

    }

    @RequestMapping("top")
    public String ui2() {

        return "top";
    }

    @RequestMapping("userinfo")
    public String ui3() {

        return "user_info";
    }

    @RequestMapping("updatainfo")
    public String ui4() {
        return "updatainfo";
    }

    @RequestMapping("myelegant")
    public String ui5() {
        return "my_Elegant";
    }

    //    跳转图书详情
    @RequestMapping("bookdetail")
    public String ui3(Integer bookId, HttpServletRequest request) {
        System.out.println("跳转到detail页面");
//        把用户点击的图书Id加入到session中
        request.getSession().setAttribute("bookId", bookId);
        System.out.println("session中的bookId:" + request.getSession().getAttribute("bookId"));
        return "bookdetail";
    }

    @RequestMapping("order_all")
    public String order() {
        return "order_all";
    }


    @RequestMapping("showOrderDetail")
    public String ui2OrderDetail(Integer orderId, HttpServletRequest request) {
        request.getSession().setAttribute("orderId", orderId);
        return "order_detail";
    }

    @RequestMapping("showOrderDetail0")
    public String ui2OrderDetail0(Integer out_trade_no, String trade_no, HttpServletRequest request) {

        request.getSession().setAttribute("orderId", out_trade_no);
        return "order_detail";
    }

    @RequestMapping("post")
    public String post() {
        return "post";
    }

    //跳转我的评价
    @RequestMapping("myEvaluate")
    public String ui4(HttpServletRequest request) {
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        System.out.println("当前session中的customer" + customer);
        return "myEvaluate";
    }

    @RequestMapping("custCart")
    public String custCart() {
        return "custCart";
    }


    @RequestMapping("postReply")
    public String custPostReply() {
        return "postReply";
    }

    @RequestMapping("review")
    public String review(HttpServletRequest request, Integer postId) {
        request.getSession().setAttribute("postId", postId);
        return "reviewTheDetails";
    }

    @RequestMapping("butNow")
    public String butNow(@RequestParam Map<String, String> map, HttpServletRequest request) {
        request.getSession().setAttribute("buyThis", map);
        return "pay";
    }

    @RequestMapping("author")
    public String uiz(){
        return "author";
    }

    @RequestMapping("booklist")
    public String uih(){
        return "booklist";
    }

    @RequestMapping("ranking")
    public String uio(){
        return "ranking";
    }

    @RequestMapping("findpwd")
    public String uiu(){
        return "findpwd";
    }

    /**
     * 跳转页面至 书评帖搜索结过页面
     * @return
     */
    @RequestMapping("searchThrough")
    public String postSearch(){
        return "postSearch";
    }

}
