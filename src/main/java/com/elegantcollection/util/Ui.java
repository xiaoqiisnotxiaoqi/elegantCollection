package com.elegantcollection.util;

import com.elegantcollection.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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

    //个人信息
    @RequestMapping("userinfo")
    public String ui3() {

        return "user_info";
    }

    //更改信息
    @RequestMapping("updatainfo")
    public String ui4() {
        return "updatainfo";
    }

    //个人中心
    @RequestMapping("myelegant")
    public String ui5() {
        return "my_Elegant";
    }

    //我的地址
    @RequestMapping("myaddress")
    public String address() {
        return "My_address";
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

    /**
     * 跳转全部订单页面
     *
     * @return
     */
    @RequestMapping("order_all")
    public String order() {
        return "order_all";
    }

    /**
     * 跳转订单详情页面（由全部订单页面跳转）
     *
     * @param orderId 订单id
     * @param request
     * @return
     */
    @RequestMapping("showOrderDetail")
    public String ui2OrderDetail(Integer orderId, HttpServletRequest request) {
        //放入订单id
        request.getSession().setAttribute("orderId", orderId);
        return "order_detail";
    }

    /**
     * 跳转订单详情页面（由支付宝支付页面跳转）
     *
     * @param out_trade_no
     * @param trade_no
     * @param request
     * @return
     */
    @RequestMapping("showOrderDetail0")
    public String ui2OrderDetail0(Integer out_trade_no, String trade_no, HttpServletRequest request) {
        request.getSession().setAttribute("orderId", out_trade_no);
        return "order_detail";
    }

    /**
     * 跳转书评区
     *
     * @return
     */
    @RequestMapping("post")
    public String post(HttpServletRequest request, Integer blockId) {
        request.getSession().setAttribute("blockId", blockId);
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


    /**
     * 跳转支付页面
     *
     * @return
     */
    @RequestMapping("pay")
    public String pay() {
        return "pay";
    }

    /**
     * 跳转到作者详情
     *
     * @return
     */
    @RequestMapping("author")
    public String uiz(HttpServletRequest request, Integer authorId) {
        request.getSession().setAttribute("authorId", authorId);
        return "author";
    }

    /**
     * 跳转到书单详情
     *
     * @return
     */
    @RequestMapping("booklist")
    public String uih(HttpServletRequest request, Integer orderId) {
        request.getSession().setAttribute("orderId", orderId);
        return "booklist";
    }

    /**
     * 跳转到榜单
     *
     * @return
     */
    @RequestMapping("ranking")
    public String uio() {
        return "ranking";
    }

    /**
     * 跳转到找回密码
     *
     * @return
     */
    @RequestMapping("findpwd")
    public String uiu() {
        return "findpwd";
    }

    /**
     * 跳转页面至 书评帖搜索结过页面
     *
     * @return
     */
    @RequestMapping("searchThrough")
    public String postSearch() {
        return "postSearch";
    }

}
