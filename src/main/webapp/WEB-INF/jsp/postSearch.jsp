<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\11\1 0001
  Time: 1:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>帖子搜索页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/postSearch.css">
</head>
<body  onload="postSearchDetial()">
<div class="review-div">
    <div class="review-nav-div">
        <ul class="review-nav-ul">

            <%
                if (request.getSession().getAttribute("customer") != null){
            %>
            <li>欢迎您:</li>
            <li>${customer.custName}</li>
            <li onclick="loginOut()">退出</li>
            <%
                }
            %>
            <%
                if (request.getSession().getAttribute("customer") == null){
            %>
            <li>欢迎进入雅致书评:</li>
            <li>登录</li>
            <li>注册</li>
            <%
                }
            %>

            <li>进入商城首页</li>
            <li>书评区主页</li>
            <li><a style="color: black" target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=954566097&site=qq&menu=yes">联系客服</a></li>
        </ul>
    </div>
</div>

<div class="search">
    <img src="${pageContext.request.contextPath}/images/review.png">
    <div>
        <form>
            <input type="text" name="search-box">
            <input type="button" name="" value="书评区搜索" onclick="blockSearch(this)">
            <input type="button" name="" value="书评帖搜索" onclick="TotalStationSearch(this)">
        </form>
    </div>
</div>


<div class="postlist-context" id="postlist-context" style="width: 100% ; background-color: #dceffe;min-height: 450px">
    <ul id="resoule" style="list-style: none;padding: 0;background-color: #ffffff;width: 980px;min-height: 200px;margin: 0 auto">
    </ul>
</div>


<script src="${pageContext.request.contextPath}/js/reviewTheDetails.js"></script>
</body>
</html>
