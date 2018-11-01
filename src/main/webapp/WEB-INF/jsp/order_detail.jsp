<%--
  Created by IntelliJ IDEA.
  User: hei91laugh
  Date: 2018/10/18
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../../css/order_detail.css">
    <title>雅致藏书--订单详情</title>
</head>
<body>
<%--引入头部--%>
<iframe src="${pageContext.request.contextPath}/top" style="width: 100%; height: 220px;border: none;frameborder:0;"></iframe>
<div class="all-body">
    <div class="info-body">
        <div class="order-process">
            <div class="order-introduction">
                <span class="order-number" id="order-number">订单号:</span>
                <span class="order-state" id="order-state">完成</span>
            </div>
            <div class="segmentation1"></div>
            <div class="order-state-show1">
                <div class="order-state-icon"><img src="../images/order-submission-b.png" class="icon"><span
                        class="order-state-info">提交订单</span></div>
                <img src="../images/order-state-segmentation-b.PNG" class="order-state-segmentation">
                <div class="order-state-icon"><img src="../images/payment-b.png" class="icon"><span
                        class="order-state-info">已付款</span></div>
                <img src="../images/order-state-segmentation-b.PNG" class="order-state-segmentation">
                <div class="order-state-icon"><img src="../images/outlibrary-b.png" class="icon"><span
                        class="order-state-info">商品出库</span>
                </div>
                <img src="../images/order-state-segmentation-b.PNG" class="order-state-segmentation">
                <div class="order-state-icon"><img src="../images/transport-b.png" class="icon"><span
                        class="order-state-info">等待收货</span>
                </div>
                <img src="../images/order-state-segmentation-b.PNG" class="order-state-segmentation">
                <div class="order-state-icon"><img src="../images/received-b.png" class="icon"><span
                        class="order-state-info">已完成</span>
                </div>
            </div>
        </div>
        <div class="logistics">
            <div class="order-introduction">
                <a href="#" class="order-img"><img id="order-img" src=""></a><span
                    class="order-post-way" id="order-post-way">送货方式：普通快递</span>
            </div>
            <div class="segmentation1"></div>
            <div class="order-state-show2" id="order-transport-show">

            </div>
        </div>
        <div class="order-information">
            <div class="order-items">
                <div class="order-item">收货人信息
                    <div class="items">
                        <div class="item">
                            <span>收货人：</span>
                            <div class="item-info" id="consignee-name">杨健</div>
                        </div>
                        <div class="item">
                            <span>地址：</span>
                            <div class="item-info" id="address-detail">黑龙江大庆市萨尔图区城区东北石油大学</div>
                        </div>
                        <div class="item">
                            <span>手机号码：</span>
                            <div class="item-info" id="consignee-phone">15776556095</div>
                        </div>
                    </div>
                </div>
                <div class="segmentation0"></div>
                <div class="order-item">配送信息
                    <div class="items">
                        <div class="item">
                            <span>配送方式：</span>
                            <div class="item-info">普通快递</div>
                        </div>
                        <div class="item">
                            <span>快递公司：</span>
                            <div class="item-info" id="courier_company"></div>
                        </div>
                    </div>
                </div>
                <div class="segmentation0"></div>
                <div class="order-item">付款信息
                    <div class="items">
                        <div class="item">
                            <span>付款方式：</span>
                            <div class="item-info">在线支付</div>
                        </div>
                        <div class="item">
                            <span>付款时间：</span>
                            <div class="item-info" id="pay-time">2017-06-03 00:40:08</div>
                        </div>
                        <div class="item">
                            <span>商品总额：</span>
                            <div class="item-info" id="total-price">¥89.00</div>
                        </div>
                        <div class="item">
                            <span>应支付金额：</span>
                            <div class="item-info" id="pay-price">¥89.00</div>
                        </div>
                        <div class="item">
                            <span>支付优惠：</span>
                            <div class="item-info" id="discount-amount">¥0.15</div>
                        </div>
                    </div>
                </div>
                <div class="segmentation0"></div>
                <div class="order-item" id="order-item">官方网址
                    <div class="items" id="items">
                        <img class="main-page" src="../images/generate.gif">
                    </div>
                </div>
            </div>
        </div>
        <div class="books-info">
            <div class="book-all">
                <div class="book-tip">图书</div>
                <div class="book-information">图书编号</div>
                <div class="book-information">价格</div>
                <div class="book-information">数量</div>
            </div>
            <div class="book-all-infos" id="book-all-infos">
            </div>
        </div>
    </div>
</div>
<script src="../../js/order_detail.js"></script>
<jsp:include page="bottom.jsp"/>
</body>
</html>
