<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/17/017
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有图书</title>
    <link rel="stylesheet" href="../../css/allbooks.css">

</head>
<body>

<!--广告1-->
<a href="">
    <div id="ad-top-box">
        <div id="ad-top">
            <img src="../../images/广告图001.jpg"/>
        </div>
    </div>
</a>

<div id="main-area">
    <div id="fenji-nav-box">
        <a href="" class="a">图书 </a>
        <span class="sp">></span>
        <a href="" class="a">分类1 </a> <span class="sp">></span>

        <a href="" class="a"> 分类2</a>
    </div>
    <div id="filtrate-box">
        <ul id="filtrate-list">
            <li class="li">
                <span class="li-title">子分类</span>
                <a class="li-options">子分类1</a>
                <a class="li-options">子分类2</a>
                <a class="li-options">子分类3</a>
                <a class="li-options">子分类4</a>
            </li>

            <li class="li">
                <span class="li-title">价格</span>
                <a class="li-options">0-9</a>
                <a class="li-options">9-19</a>
                <a class="li-options">19-29</a>
                <a class="li-options">29-49</a>
                <a class="li-options">49以上</a>
            </li>
            <li class="li">
                <span class="li-title">语言</span>
                <a class="li-options">中文</a>
                <a class="li-options">英文</a>
                <a class="li-options">日文</a>
                <a class="li-options">其他语言</a>

            </li>
            <li class="li">
                <span class="li-title">折扣</span>
                <a class="li-options">3折以下</a>
                <a class="li-options">5折以下</a>
                <a class="li-options">7折以下</a>
                <a class="li-options">9折以下</a>

            </li>


        </ul>

    </div>
    <div id="orderby-box">
        <ul class="orderby-ul">
            <li class="orderby-li"><a href=" " class="sort-box-a">综合排序<span class="icon"></span></a></li>
            <li class="orderby-li">销量</li>
            <li class="orderby-li">好评</li>
            <li class="orderby-li">出版时间</li>

            <li class="orderby-li" style="width: 180px">
                价格
                <input type="text" class="orderby-input"><span> -</span>
                <input type="text" class="orderby-input">
                <button id="price-btn">确定</button>
            </li>
        </ul>
        <ul class="orderby-ul">
            <li class="options"><a href=" " class="on">只看有货</a></li>
            <li class="options"><a href=" " class="on">打折</a></li>
            <li class="options"><a href=" " class="on">组合优惠</a></li>
        </ul>
    </div>
    <%--图书区域--%>
    <ul id="books-box">


    </ul>

    <!--右侧广告-->
    <div id="right-adv">右侧广告区域</div>
</div>
</div>

<%--加载js--%>
<script src="../../js/allbooks.js"></script>
</body>
</html>
