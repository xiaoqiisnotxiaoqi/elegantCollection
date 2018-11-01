<%--
  Created by IntelliJ IDEA.
  User: hei91laugh
  Date: 2018/10/18
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="../../css/order_all.css">
    <title>Title</title>
</head>
<body>

<div class="info-body">
    <div class="order-show-top">
        <ul class="order-state-list">
            <li class="order-state-filter">
                <a href="#" onclick="refreshByPage(1)">全部订单<img src=""></a>
            </li>
            <li class="order-state-filter">
                <a href="#" onclick="refreshByState(0,0,1)">待付款<img src=""></a>
            </li>
            <li class="order-state-filter">
                <a href="#" onclick="refreshByState(1,0,1)">待收货<img src=""></a>
            </li>
            <li class="order-state-filter">
                <a href="#" onclick="refreshByState(3,0,1)">待评价<img src=""></a>
            </li>
            <li class="order-Recycling">
                <a href="#" onclick="refreshByState(4,0,1)">订单回收站<img src=""></a>
            </li>
        </ul>
        <div class="search">
            <input type="text" class="search-txt" id="search-txt" placeholder="图书名/订单编号">
            <a class="search-button" id="search-button" href="#"><img src="../images/search-icon.png"></a>
        </div>
    </div>

    <table class="order-tb">
        <thead>
        <tr>
            <th>
                <select class="order-time-filter" id="order-time-filter">

                </select>
            </th>
            <th colspan="1">
                <span class="order-detail-tip">订单详情</span>
            </th>
            <th>
                <span class="consignee-tooltip-tip">收货人</span>
            </th>
            <th>
                <span class="amount-tip">金额</span>
            </th>
            <th>
                <span class="order-state-tip">状态</span>
            </th>
            <th>
                <span class="order-operate-tip">操作</span>
            </th>
        </tr>
        </thead>
        <tbody id="order-date"></tbody>
        <tfoot id="order-page">

        </tfoot>
    </table>
</div>
<script src="../../js/order_all.js"></script>
</body>
</html>
