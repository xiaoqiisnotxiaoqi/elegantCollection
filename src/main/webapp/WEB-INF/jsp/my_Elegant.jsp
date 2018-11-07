<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rzz
  Date: 2018/10/19
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的雅志</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/logo.ico" type="img/x-ico"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/my_Elegant.css">

</head>
<body>

<jsp:include page="top.jsp" flush="true"/>
<%--<iframe src="${pageContext.request.contextPath}/top" style="width: 100%; height: 220px;border: none;--%>
<%--frameborder:0;"></iframe>--%>

<div class="mydang" id="J_muneAndContentWrap">
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
    <!--左导航栏结束-->
    <!--右侧开始-->
    <div class="my_main">
        <div id="J_userInfo">
            <div class="user_message">
                <div class="user_info">
                    <div class="user_phone">

                        <a href="${pageContext.request.contextPath}/userinfo"   target="blank">
                            <% if (request.getSession().getAttribute("customer") != null) {

                            %>
                            <img src="${pageContext.request.contextPath}/${customer.custProfile}" alt="">
                            <%}%>

                            <div class="edit_box">
                                <span class="edit">&nbsp</span>
                                <span class="edit_a" >编辑资料</span>
                            </div>
                        </a>
                        <span class="opacity_mask"  onclick="userinfo()"></span>

                    </div>
                    <a href="#" title="站内信" target="blank">
                        <div class="message no_msg">


                        </div>
                    </a>
                    <%
                        if (request.getSession().getAttribute("customer") != null) {
                    %>
                    <sapn class="user_name" id="user_Nick">${customer.custPhone}</sapn>
                    <% }%>

                </div>
                <!--头像结束-->
                <div class="safety_type">
                    <div class="vip_box">

                        <input type="hidden" id="vip_code" value="0">
                        <input type="hidden" id="ajax_status" value="">
                        <!--加载状态-->
                        <!--
                        <div id="vip_type_box_loading" class="vip_type_box123 loading" style="display:none;"></div>
                    -->
                    </div>
                    <div class="safety_level middle">
                        <p class="to_left">账户安全: <span class="level">中</span></p>
                        <p class="level_line"></p>
                        <p>

                            <% if (request.getSession().getAttribute("customer") != null) {%>
                            <a ><span class="setting">手机已设置</span></a>
                            <%}%>
                            <c:if test="${customer.custPhone ==null}">
                                <a  ><span class="setting ">邮箱未设置</span></a>
                            </c:if>

                            <c:if test="${customer.custPhone !=null}">
                                <a ><span class="setting ">邮箱已设置</span></a>
                            </c:if>

                        </p>
                    </div>
                </div>
                <!--个人信息左面结束-->

                <div class="account_message">
                    <ul>
                        <li>
                            <a class="pic jf"></a>
                            <a >积分</a>
                            <%if (request.getSession().getAttribute("customer") == null) { %>
                            <a>0</a>
                            <%}%>

                            <%if (request.getSession().getAttribute("customer") != null) { %>
                            <a >${customer.custPoints}</a>
                            <%}%>
                        </li>
                    </ul>
                </div>
            </div>
            <!--个人人信息背景结束-->
            <div id="J_myOrderWrap">
                <div class="my_order">
                    <div class="my_title">
                        <ul class="tab_list">
                            <li><a >待付款</a>

                                <span class="tip" id="tip"></span>
                            </li>
                            <li class="last"><a href="${pageContext.request.contextPath}/order_all" target="_blank">全部订单</a></li>
                        </ul>
                        <span class="title">我的订单</span>
                    </div>

                    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="order_box">
                        <tbody id="allOrder">

                        </tbody>
                    </table>


                    <div class="none_box">
                        <h3>您暂时没有未完成交易的订单，<a href="${pageContext.request.contextPath}/index" target="_blank">挑选喜欢的产品去~~</a></h3>
                    </div>


                </div>
            </div>
            <!--我的订单结束-->

        </div>
        <!--J_userInfo 结束-->

    </div>
    <!--my_main结束-->
</div>
<!--mydang结束-->
<!--右侧栏-->
<div class="sidebar_wrap" id=sidebar_warp_id style="height:763px ">
    <div class="sidebar">
        <!--右侧栏的    二维码-->
        <div class="sidebar_code2">
            <a class="code2s"></a>

        </div>
        <!--购物车-->
        <div class="sidebar_cart">
            <a href="${pageContext.request.contextPath}/custCart">
                <span></span>
                购<br>物<br>车<br>
                <em id="cartnum"></em>
            </a>
        </div>
        <!--页面回滚-->
        <div class="sidebar_link">
            <a href="#" class="back_top"></a>
        </div>
    </div>
</div>
<jsp:include page="bottom.jsp" flush="true"/>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script>
    $(function () {
        $('.back_top').click(function () {
            $('html , body').animate({scrollTop: 0}, 400);
        });
    });
    window.onload=function () {
       getOrder4all();
    }
    function userinfo() {
        window.location ="/userinfo";
    }

    var getOrder = "${pageContext.request.contextPath}/getallorder";
    var getCart ="${pageContext.request.contextPath}/cartNum";



    var xhr=null;
    function getCartNum() {
        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        } else {
            xhr = new ActiveXObject("Microsoft.XMLHTTP")
        }
        // console.log(area);
        xhr.open("GET", getCart, true);

        xhr.setRequestHeader("Content-Type","application/json;charset=utf-8");

        xhr.onreadystatechange =loadCartNum;
        xhr.send();
    }
    function loadCartNum() {
        if(xhr.readyState==4 || xhr.state ==200){
            var result =JSON.parse(xhr.responseText)
            // alert(result);
          var cartnum =   document.getElementById("cartnum");
            cartnum.innerText="";
            cartnum.innerText+=(result);
        }

    }

    var xhr=null;
    function getOrder4all() {
        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        } else {
            xhr = new ActiveXObject("Microsoft.XMLHTTP")
        }


        // console.log(area);
        xhr.open("GET", getOrder, true);

        xhr.setRequestHeader("Content-Type","application/json;charset=utf-8");

        xhr.onreadystatechange =loadOrder;
        xhr.send();

    }
    function loadOrder(){
        // console.log(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == 200) {
            var result = JSON.parse(xhr.responseText);

                    var OrderList = document.getElementById("allOrder");
                    OrderList.innerHTML = "";
                    var allOrder = result;
                    if (allOrder != null) {
                        for (var i = 0; i < allOrder.length; i++) {

                            //页面渲染
                            OrderList.innerHTML += ('<tr>' +
                                '                            <td class="tg">' +
                                '                                <div class="goode_list">' +

                                '                                    <a  title="' + allOrder[i].title + allOrder[i].bookIntro + '"' +
                                '                                    onclick="showDetail(this)"  name="'+allOrder[i].bookId+'"' +
                                '                                       target="_blank"><img src="' + allOrder[i].bookImg + '"></a>' +
                                '                                </div>' +
                                '                            </td>' +
                                '                            <td>共' + allOrder[i].quality + '件商品<br><span class="data">' + allOrder[i].orderCreateTime + '</span></td>' +
                                '                            <td><span class="price">' + allOrder[i].orderPrice + '<span>元</span></span><br>优惠金额 : ' + allOrder[i].discountAmount + '<span>元</span></td>' +
                                '                            <td>' +
                                '                                <span class="red">等待付款</span>' +
                                '                            </td>' +
                                '                            <td> <a onclick="showOrder(this)" id="OrderId" name="'+allOrder[i].orderId+'">查看</a></td>' +
                                '                        </tr>');

                        }

                       var OrderLeng=  document.getElementById("tip");
                        OrderLeng.innerHTML="";
                       OrderLeng.innerHTML+=('<strong>'+allOrder.length+'</strong>');



                        $(function () {
                            $(".none_box").css('display', 'none');

                        });

                            var OrderLeng = document.getElementById("tip");
                            OrderLeng.innerHTML = "";
                            OrderLeng.innerHTML += ('<strong>' + allOrder.length + '</strong>');

                    } else {
                        $(function () {
                            $(".none_box").css('display', 'block');


                        });
                    }
            getCartNum();
        }

    }

    function showOrder(ele){
        var OrderId =  ele.name;
        window.location = "${pageContext.request.contextPath}/showOrderDetail?orderId=" + OrderId;

    }
    function showDetail(ele) {
        var DetailId =ele.name;
        alert(DetailId);
        window.location="${pageContext.request.contextPath}/bookdetail/?bookId="+DetailId;

    }





</script>
</body>
</html>