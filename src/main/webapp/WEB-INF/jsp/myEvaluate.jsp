<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/18/018
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的评价</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myEvaluate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/my_Elegant.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/user_info.js"></script>
</head>
<body>
<%--引入头部--%>
<jsp:include page="top.jsp"/>


<!--个人信息开始操作-->
<div class="main_frame" style="width: 1000px">
    <!--左侧栏开始-->
    <div class="my_left">
        <div class="my_menu">

            <h3 class="my_menu-title"><a href="${pageContext.request.contextPath}/myelegant">我的雅志</a></h3>
            <div class="dl">
                <!--导航栏开始-->


                <ul>我的交易</ul>
                <li><a href="${pageContext.request.contextPath}/order_all">我的订单</a></li>
                <ul>我的钱包</ul>
                <!--<li><a href="#">我的余额</a></li>-->
                <li><a href="${pageContext.request.contextPath}/myelegant">我的积分</a></li>
                <ul>售后服务</ul>
                <li><a href="#">申请/查询退换货</a></li>

                <ul>个人中心</ul>
                <li><a href="${pageContext.request.contextPath}/userinfo">个人信息</a></li>

                <li><a href="${pageContext.request.contextPath}/myaddress">收货地址</a></li>
                <ul>我的消息</ul>
                <li><a href="${pageContext.request.contextPath}/postReply">消息查看</a></li>
                <!--<li><a href="#">发帖记录</a></li>-->
                <li><a href="${pageContext.request.contextPath}/myEvaluate">评论/晒单</a></li>

            </div>
            <!--导航栏结束-->
        </div>
    </div>
    <!--左侧结束-->
    <!--右侧开始-->
    <div class="account_right" id="your_position" style="float: right">
        <div class="archives_title">
            <h2>
                我的评价
            </h2>
        </div>
        <div id="evaluate-title">
            <ul>
                <li>商品图片</li>
                <li>商品名称</li>
                <span id="neirong-title">评价内容</span>
                <li>操作</li>
            </ul>


        </div>
        <ul id="evaluateul">
            <li class="eval-li"></li>
            <li class="eval-li"></li>
            <li class="eval-li"></li>
            <li class="eval-li"></li>
            <li class="eval-li"></li>

        </ul>
        <%--分页--%>
        <div id="pagination" class="pagination">
            <ul>
                <li value="1" onclick="page(this)">首页</li>
                <li value="" id="shangye" onclick="page(this)">&lt;</li>
                <li value="1" class="active" id="currentPage">1</li>
                <li value="" id="xiaye" onclick="page(this)">&gt;</li>
                <li value="" id="last" onclick="page(this)">尾页</li>
                <li class="totalPage"><span>跳转到</span><input type="number" value="1" id="pageinput"/><span>页</span></li>
                <li onclick="page(this)" id="pageBtn">跳转</li>
                <li class="totalPage">共&nbsp;<span id="totalPages"></span>&nbsp;页</li>

                <li class="totalPage">每页&nbsp;<span id="pageSize"></span>&nbsp;条</li>
                <li class="totalPage">合计&nbsp;<span id="totalRecord"></span>&nbsp;条记录</li>
            </ul>
        </div>
    </div>


</div>
<%--引用底部--%>
<jsp:include page="bottom.jsp"/>
<script src="${pageContext.request.contextPath}/js/myEvaluate.js"></script>

</body>

</html>
