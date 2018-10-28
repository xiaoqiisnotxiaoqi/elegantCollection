<%--
  Created by IntelliJ IDEA.
  User: hei91laugh
  Date: 2018/10/23
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>雅致藏书--订单结算页</title>
    <link rel="stylesheet" href="../../css/pay.css">
</head>
<body>
<div class="order-preview">
    <div class="address-options">
        <span class="preview-tip">收货人选择</span>
        <ul id="address-options">
        </ul>
    </div>
    <div class="block-segmentation1"></div>

    <div class="block-segmentation2"></div>
    <div class="payment-ways">
        <span class="preview-tip">支付方式</span>
        <div class="payment-option">支付宝</div>
    </div>
    <div class="block-segmentation2"></div>
    <div class="book-list">
        <span class="preview-tip">送货清单</span>
        <div class="transport" id="transport">
            <div class="list-tip">配送</div>
            <input type="date" class="transport-date" name="transport-date"/>
            <div class="block-segmentation2"></div>
            <span>自签收后7天内退货，15天内换货，可享1次上门取件服务</span>
            <div class="block-segmentation2"></div>
            <span id="book-weight">总重量：1.5kg</span>
        </div>
        <div class="order-simple-info" id="order-simple-info">
            <div class="list-tip">书籍信息</div>


        </div>

    </div>
    <div class="block-segmentation3"></div>
    <div>
        <div class="price-block">
            <span class="dif-price" id="total-price"></span>
            <span class="dif-price-info">总商品金额：</span>
        </div>
        <div class="price-block">
            <span class="dif-price" id="discount-price">￥ </span>
            <span class="dif-price-info">优惠金额：</span>
        </div>
        <div class="price-block">
            <span class="dif-price">￥ 0.00</span>
            <span class="dif-price-info">运费：</span>
        </div>
    </div>

</div>
<div class="block-segmentation3"></div>
<div class="total-price-block">
    <span class="total-price" id="pay-price"></span>
    <span class="total-price-info">应付总额：</span>
</div>

<input type="button" class="pay-button" id="pay-button" value="提交订单">
<script src="../../js/pay.js"></script>
</body>
</html>
</html>
