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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/carts.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/top.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css">
    <script src="${pageContext.request.contextPath}/js/top.js"></script>
</head>
<body onload="toCart()">
<!--顶端导航入口-->
<div class="top-nav">

    <%
        if (request.getSession().getAttribute("customer") != null){
    %>
    <div class="has-logged">
        <span class="top-welcome">欢迎您,</span>
        <span id="customer-name" onclick="">${customer.custName}</span>
        <span class="top-logout" onclick="loginOut()">退出</span>
    </div>
    <%
        }
    %>

    <%
        if (request.getSession().getAttribute("customer") == null){
    %>
    <div class="not-login">
        <span class="top-wellcome">欢迎进入雅致藏书!</span>
        <span class="top-log"><a onclick="showDiv()" id="asd">登录</a></span>
        <span class="top-join" onclick="showRegister()">加入雅致</span>
    </div>
    <%
        }
    %>

    <span class="top-myEle" onclick="topCustEle()">我的雅致</span>
    <span class="top-cart" onclick="topCart()">购物车</span>
    <span class="top-order" onclick="myOrder()">订单</span>
    <span class="top-service" onclick="topService()">联系客服</span>
    <span id="service-news"></span>
    <span class="top-discuss" onclick="topDiscuss()">讨论区</span>
    <span id="discuss-news"></span>


    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" style="display: none;">
        <div style="display:table; width:100%; height:100%;">
            <div style="vertical-align:middle; display:table-cell;">
                <div class="modal-dialog modal-sm" style="width:540px;">
                    <div class="modal-content" style="border: none;">
                        <div class="col-left"></div>
                        <div class="col-right">
                            <div class="modal-header">
                                <button type="button" id="login_close" class="close" data-dismiss="modal"><span aria-hidden="true" onclick="stopLoginDiv()">×</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="loginModalLabel" style="font-size: 18px;">登录</h4>
                            </div>
                            <div class="modal-body">
                                <section class="box-login v5-input-txt" id="box-login">
                                    <form id="login_form" action="" method="post" autocomplete="off">
                                        <ul id="password-login">
                                            <li class="form-group"><input class="form-control" id="id_account_l" maxlength="50" name="account_l" placeholder="请输入邮箱账号/手机号" type="text"></li>
                                            <li class="form-group"><input class="form-control" id="id_password_l" name="password_l" placeholder="请输入密码" type="password"></li>
                                        </ul>
                                        <ul id="note-login" style="display:none">
                                            <li class="form-group"><input class="form-control" id="id_account_2" maxlength="50" name="account_l" placeholder="请输入手机号" type="text"></li>
                                            <li class="form-group">
                                                <input class="form-control" id="id_password_2" name="password_l" placeholder="请输入验证码" type="password">
                                                <input id="getVCode" type="button" class="send-again" value="点击发送验证码" onclick="sendCode(this)" />
                                            </li>

                                        </ul>
                                    </form>
                                    <p class="good-tips marginB10">
                                        <a id="btnForgetpsw" class="fr">忘记密码？</a>
                                        还没有账号？
                                        <a href="" target="_blank" id="btnRegister" onclick="login2Register()">立即注册</a>
                                    </p>
                                    <div class="login-box marginB10">
                                        <span id="login_btn"  class="btn btn-micv5 btn-block" onclick="login()">登录</span>
                                        <div id="login-form-tips" class="tips-error bg-danger" style="display: none;">错误提示</div>
                                    </div>


                                    <div class="threeLogin">
                                        <span onclick="loginModeConversion(this)" class="loginModeConversion">短信登录</span>
                                        <a class="nqq" href=""></a>
                                        <a class="nwx" href=""></a>
                                        <!--<a class="nwb"></a>-->
                                    </div>

                                </section>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div style="text-align:center;">
    </div>

    <div id="register" style="display: none;">
        <img src="${pageContext.request.contentType}/images/cross.png" id="register-cross" onclick="stopRegisterDiv()"/>
        <div>
            <span id="register-title">会员注册</span>
            <span id="register-having">已有账号</span>
            <a href="#" onclick="register2Login()" id="register-now">立即登录</a>
        </div>
        <div class = "register-title"></div>

        <form>
            <div class="phone">
                <span>手机号码</span>
                <input type="text" value="" id="phone" onblur="isPhone(this)"/>
                <span id="phone-span"></span>
            </div>
            <div class="password">
                <span>登录密码</span>
                <input type="password" value="" id="password" onblur="isPassword(this)" onfocus="passwordHint()"/>
                <span id="password-span"></span>
            </div>
            <div class="confirm-password">
                <span>确认密码</span>
                <input type="password" value="" id="confirm-password" onblur="samePassword(this)"/>
                <span id="confirm-password-span"></span>
            </div>
            <div class="captcha">
                <span>验证码</span>
                <input type="text" onmousemove="" value="" id="captcha" />
                <img src="${pageContext.request.contextPath}/kaptcha"/>
                <a href="#" onclick="">看不清,换一张</a>
                <span id="captcha-span"></span>
            </div>

            <div class="message-authentication-code">
                <span>短信验证码</span>
                <input type="text" onmousemove="" value="" id="message-authentication-code" />
                <input id="sms" class="sms" type="button" value="点击发送验证码" onclick="sendCode(this)" />
                <span id="message-span"></span>
            </div>

            <button onclick="registerPost()" class="register-button">确认提交</button>

        </form>

    </div>


</div>

<!--头部 居中导航部分-->
<div class="category-nav">
    <div class="img-signe"><img src="${pageContext.request.contextPath}/images/biaozhi.png"></div>
    <div class="search-box">
        <form>
            <input type="text" name="seek" value="">
            <button onclick="searchBox()">搜索</button>
            <span onclick="advancedSearch()">高级搜索</span>
        </form>
    </div>
    <div class="left-nav" >
        <div id="cart" onclick="loginOrCart()" onmouseover="onCart()" onmouseout="outCart()">
            <img src="${pageContext.request.contextPath}/images/cart-white.png" id="cart-img">
            <span id="cart-span" >购物车</span>
            <span id="cart-num"></span>
        </div>
        <div id="order-span" onclick="myOrder()">我的订单</div>
    </div>
    <div class="classify-nav">
        <ul>
            <li onclick="" onmouseover="onli(this)" onmouseout="outli(this)">首页</li>
            <li onclick="" onmouseover="onli(this)" onmouseout="outli(this)">排行</li>
            <li onclick="" onmouseover="onli(this)" onmouseout="outli(this)">书单</li>
            <li onclick="" onmouseover="onli(this)" onmouseout="outli(this)">教育</li>
            <li onclick="" onmouseover="onli(this)" onmouseout="outli(this)">小说</li>
            <li onclick="" onmouseover="onli(this)" onmouseout="outli(this)">文艺</li>
            <li onclick="" onmouseover="onli(this)" onmouseout="outli(this)">人文社会</li>
            <li onclick="" onmouseover="onli(this)" onmouseout="outli(this)">经济</li>
            <li onclick="" onmouseover="onli(this)" onmouseout="outli(this)">生活</li>
            <li onclick="" onmouseover="onli(this)" onmouseout="outli(this)">科技</li>
            <li onclick="" onmouseover="onli(this)" onmouseout="outli(this)">讨论区</li>
        </ul>
    </div>
</div>


<div style="width: 100%;height: 2px;background-color: red; margin-top: 20px"></div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/top.js"></script>




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
            <div class="calBtn"><a href="javascript:void(0);" id="settle-account">结算</a></div>
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

<script src="${pageContext.request.contextPath}/js/myCarts.js"></script>
</body>
</html>
