<%@ page import="java.util.Date" %><%--
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bookdetail.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

</head>
<body>
<%--引入头部--%>
<jsp:include page="top.jsp"/>


<input type="hidden" value="" id="bookId">
<div id="main-box">
    <!--分类导航1-->
    <div id="category-nav">
        <a href="">图书</a>
        <span class="">></span>
        <a href="" id="nav-bookcategory">分类</a>
        <span class="">></span>
        <a href="nav-bookname" id="nav-bookname">书名</a>
    </div>
    <!--主区域-->
    <div id="main-area">
        <!--商品图片区域-->
        <div id="pic-area">
            <div id="main-pic-box">
                <img src=""/>
            </div>
            <div id="book-imgs-box">
            </div>
        </div>
        <!--买书区域-->
        <div id="info-area">
            <!--书名-->
            <div id="name-info">

            </div>
            <!--出版信息-->
            <div id="publish-info">
                <span class="publish-spans" id="author">作者:<a href=""></a></span>
                <span class="publish-spans" id="chubanshe">出版社:</span>
                <span class="publish-spans" id="publish-time">出版时间:</span><br>
                <span class="publish-spans">在<a id="info-cateName">xxx</a>分类排行第 1 位</span>
                <span class="publish-spans" id="pinglunshu"><a href=""></a>条评论 </span>
            </div>
            <!--价格区域-->
            <div id="price-area">
                <span id="price-title">活动价</span><br>
                <span id="sale-icon-price">
                <span class="money-icon">¥</span>
                <span id="sale-price">0.00</span>
                <span id="discount">(x.xx折)</span>

                <span id="mark-icon-price">定价
                  <span class="money-icon">¥</span>
                <span id="mark-price">0.00</span>
                </span>
            </span>
            </div>
            <div id="cuxiao-info">
                <div></div>
                <span class="info-title">促销</span>

                <div id="cuxiao-right">
                    <div id="manjian">
                        <span class="youhui-title">满减优惠</span>
                        <span class="youhui-detail" id="manjian-money">满xx元立减xx元</span>
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
                <span class="towhere">江苏省苏州市</span>
                <span>有货</span>
            </div>
            <div id="service">
                <span class="info-title">服务</span>
                <span class="">
由雅致藏书发货，并提供售后服务。 今日17:00前完成下单，预计11月20日（周二）可送达</span>
            </div>
            <!--添加按钮等-->
            <div id="num-box">
                <div id="num-botton">
                    <input id="booknum" type="number" value="1">
                    <button class="num-buttons" onclick=add()>+
                    </button>
                    <button class="num-buttons" onclick=minus()>-
                    </button>
                </div>
                <button id="addtocart" onclick="add2Cart()">加入购物车</button>
                <button id="buynow" onclick="buyNow()">立即购买</button>
            </div>
            <!--加入购物车按钮-->

        </div>
        <!--详情区域-->


    </div>
    <div id="book-intro">
        <div id="details">
            <span class="detail-options" id="detailBtn" onclick="javascript:detailorpingjia(this)">商品详情</span>
            <span class="detail-options" id="pingjiaBtn" onclick="javascript:detailorpingjia(this)">商品评价</span>
            <input type="hidden" name="" id="currentPageCode"/>
        </div>
        <div id="pingjiabox">
            <ul id="pingjia-ul">
                <li class="pingjias">
                    <div class="customerInfo">
                        <img src=" " class="profile"/>
                        <span class="evaluater">用户名</span>
                    </div>
                    <div class="evaldiv">
                        <p>
                            测试评论</p>
                    </div>
                    <div class="eval-score">
                        <span class="score">9.0</span>
                        <span class="evaluatetime">xxxx年xx月xx日</span>
                    </div>
                </li>


            </ul>
            <%--分页--%>
            <div id="pagination" class="pagination">
                <ul>
                    <li value="1" onclick="page(this)">首页</li>
                    <li value="" id="shangye" onclick="page(this)">&lt;</li>
                    <li value="" class="active" id="currentPage"></li>
                    <li value="" id="xiaye" onclick="page(this)">&gt;</li>
                    <li value="" id="last" onclick="page(this)">尾页</li>
                    <li class="totalPage"><span>跳转到</span><input type="number" value="1" id="pageinput"/><span>页</span>
                    </li>
                    <li onclick="page(this)" id="pageBtn">跳转</li>
                    <li class="totalPage">共&nbsp;<span id="totalPages"></span>&nbsp;页</li>

                    <li class="totalPage">每页&nbsp;<span id="pageSize"></span>&nbsp;条</li>
                    <li class="totalPage">合计&nbsp;<span id="totalRecord"></span>&nbsp;条记录</li>
                </ul>
            </div>
        </div>

        <div id="detailbox">
            <div id="details2">
                <span class="detail-infos">开 本：<span id="kaiben"></span>开</span>
                <span class="detail-infos">纸 张：胶版纸</span>
                <span class="detail-infos">包 装：<span id="baozhuang"></span></span>
                <span class="detail-infos">国际标准书号ISBN：<span id="isbn"></span></span>
                <span class="detail-infos">所属分类：<span id="detail-category"></span></span>
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
</div>

<%--引用底部--%>
<jsp:include page="bottom.jsp"/>
<%--引用js--%>
<script src="${pageContext.request.contextPath}/js/bookdetail.js"></script>
</body>
</html>
