<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\10\17 0017
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>购物车</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/carts.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css">
    <script src="${pageContext.request.contextPath}/js/top.js"></script>
</head>
<body onload="toCart()">

<jsp:include page="top.jsp"/>


<section class="cartMain">
    <div class="cartMain_hd">
        <ul class="order_lists cartTop">
            <li class="list_chk">
                <!--所有商品全选-->
                <input type="checkbox" id="all" class="whole_check" onclick="checkboxAll()">
                <label for="all"></label>
                全选
            </li>
            <li class="list_con">商品信息</li>
            <li class="list_info">商品参数</li>
            <li class="list_price">单价</li>
            <li class="list_amount">数量</li>
            <li class="list_sum">金额</li>
            <li class="list_op">操作</li>
        </ul>
    </div>

    <div class="cartBox">
        <div class="order_content" id="input_cart">

        </div>
    </div>

    <!--底部-->
    <div class="bar-wrapper">
        <div class="bar-right">
            <div class="piece">已选商品<strong class="piece_num">0</strong>件</div>
            <div class="discount-price">
                <span>组合优惠折扣:</span><span id="price1"></span>
                <span>满减优惠折扣:</span><span id="price2"></span>
            </div>
            <div class="totalMoney">共计: <strong class="total_text">0.00</strong></div>
            <div class="calBtn"  onclick="settleAccount()"><a href="javascript:void(0);" id="settle-account">结算</a></div>
        </div>
    </div>

    <div class="page" id="page">

    </div>


</section>
<section class="model_bg" id="model_bg"></section>
<section class="my_model" id="my_model">
    <p class="title">删除宝贝<span class="closeModel" onclick="closeThis()">X</span></p>
    <p>您确认要删除该宝贝吗？</p>
    <div class="opBtn"><a href="javascript:void(0);" onclick="deleteBook()" class="dialog-sure">确定</a><a href="javascript:void(0);" onclick="closeThis()" class="dialog-close">关闭</a></div>
</section>
<%--引入尾部--%>
<jsp:include page="bottom.jsp"/>
<script src="${pageContext.request.contextPath}/js/myCarts.js"></script>
</body>
</html>
