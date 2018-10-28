<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/17/017
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书详情</title>
    <link rel="stylesheet" href="../../css/bookdetail.css">


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
<div id="main-box">
    <!--分类导航1-->
    <div id="category-nav">
        <a href="nav-book"><%=request.getSession().getAttribute("bookId") %>
        </a>
        <span class="">></span>
        <a href="">分类1</a>
        <span class="">></span>
        <a href="">分类2</a>
        <span class="">></span>
        <a href="nav-bookname">书名</a>
    </div>
    <!--主区域-->
    <div id="main-area">
        <!--商品图片区域-->
        <div id="pic-area">
            <div id="main-pic-box">
                <img src="11"/>
            </div>
            <div id="book-imgs-box">
                <div class="other-pic"><img onmouseover=changePic(this) src=" 123123"></div>
                <div class="other-pic">其他图片</div>
                <div class="other-pic">其他图片</div>
            </div>

        </div>
        <!--买书区域-->
        <div id="info-area">
            <!--书名-->
            <div id="name-info">
                此处是书名
            </div>
            <!--出版信息-->
            <div id="publish-info">
                <span class="publish-spans" id="author">作者:<a href="">南派三叔</a></span>
                <span class="publish-spans" id="chubanshe">出版社:上海文化出版社</span>
                <span class="publish-spans" id="publish-time">出版时间:xxxx年xx月</span><br>
                <span class="publish-spans">在<a>xxx</a>分类排行第 xx 位</span>
                <span class="publish-spans" id="pinglunshu"><a href="">xxxxx</a>条评论 </span>
            </div>
            <!--价格区域-->
            <div id="price-area">
                <span id="price-title">活动价</span><br>
                <span id="sale-icon-price">
                <span class="money-icon">¥</span>
                <span id="sale-price">22.50</span>
                <span id="discount">(x.xx折)</span>

                <span id="mark-icon-price">定价
                  <span class="money-icon">¥</span>
                <span id="mark-price">55.00</span>
                </span>
            </span>
            </div>
            <div id="cuxiao-info">
                <div></div>
                <span class="info-title">促销</span>

                <div id="cuxiao-right">
                    <div id="manjian">
                        <span class="youhui-title">满减优惠</span>
                        <span CLASS="youhui-detail">满xx元立减xx元</span>
                    </div>
                    <div id="zuhe">
                        <span class="youhui-title">组合优惠</span>
                        <span class="youhui-detail">同时购买以下商品更加优惠!</span>
                        <div id="zuhe-box">
                            <div class="zuhe-detail"><a href=" ">
                                <div class="zuhe-picbox">组合图片1</div>
                            </a>
                                <span class="zuhe-info">组合书名2组合书名2组合书名2</span>
                                <span class="zuhe-price">¥22.5</span>
                            </div>
                            <div class="zuhe-detail"><a href=" ">
                                <div class="zuhe-picbox">组合图片1</div>
                            </a>
                                <span class="zuhe-info">组合书名2组合书名2组合书名2</span>
                                <span class="zuhe-price">¥22.5</span>
                            </div>
                            <div class="zuhe-detail"><a href=" ">
                                <div class="zuhe-picbox">组合图片1</div>
                            </a>
                                <span class="zuhe-info">组合书名2组合书名2组合书名2</span>
                                <span class="zuhe-price">¥22.5</span>
                            </div>
                        </div>

                    </div>

                </div>

            </div>
            <div id="send-to">
                <span class="info-title">配送至</span>
                <span class="towhere">xx省xx市xx县xx镇</span>
                <span>有货</span>
            </div>
            <div id="service">
                <span class="info-title">服务</span>
                <span class="">
由“饶镇镇”发货，并提供售后服务。 明日00:45前完成下单，预计10月10日（周三）可送达</span>
            </div>
            <!--添加按钮等-->
            <div id="num-box">
                <div id="num-botton">
                    <input id="booknum" type="text">
                    <button class="num-buttons">+</button>
                    <button class="num-buttons">-</button>
                </div>
                <button id="addtocart">加入购物车</button>
                <button id="buynow">立即购买</button>
            </div>
            <!--加入购物车按钮-->

        </div>
        <!--详情区域-->


    </div>
    <div id="book-intro">
        <div id="details">
            <span class="detail-options">商品详情</span>
            <span class="detail-options">商品评价</span></div>
        <div id="details2">
            <span class="detail-infos">开 本：32开</span>
            <span class="detail-infos">纸 张：胶版纸</span>
            <span class="detail-infos">包 装：平装</span>
            <span class="detail-infos">国际标准书号ISBN：9787510843891</span>
            <span class="detail-infos">所属分类：
图书>xx>xx</span>
        </div>
        <div id="book-imgs">详情图片</div>

        <!--内容简介-->
        <div class="details-1">
            <div class="title">
                <span>内容简介</span>
            </div>
            <p id="neirong"></p>
        </div>
        <div class="details-1">
            <div class="title">
                <span>作者简介</span>
            </div>
            <p id="zuozhe"></p>
        </div>
        <div class="details-1">
            <div class="title">
                <span>目录</span>
            </div>
            <p id="mulu"></p>
        </div>
        <div class="details-1">
            <div class="title">
                <span>精彩书篇</span>
            </div>
            <p id="jingcai"></p>
        </div>
        <div class="details-1">
            <div class="title">
                <span>媒体评价</span>
            </div>
            <p id="meiti"></p>
        </div>
    </div>

</div>
<script src="../../js/bookdetail.js">

</script>
</body>
</html>
