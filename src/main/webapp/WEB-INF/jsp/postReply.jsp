<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\10\20 0020
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/my_Elegant.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/personalCenter_messageView.css">
</head>
<body>
<div class="mydang" id="J_muneAndContentWrap">
    <div class="my_left">
        <div class="my_menu">

            <h3 class="my_menu-title"><a href="#">我的雅志</a></h3>
            <div class="dl">
                <!--导航栏开始-->

                <ul>我的交易</ul>
                <li><a href="#">我的订单</a></li>
                <li><a href="#">电子节</a></li>
                <li><a href="#">我的账单</a></li>
                <ul>我的钱包</ul>
                <li><a href="#">我的礼券</a></li>
                <li><a href="#">我的余额</a></li>
                <li><a href="#">我的积分</a></li>
                <ul>售后服务</ul>
                <li><a href="#">申请/查询退换货</a></li>
                <li><a href="#">补开发票</a></li>
                <ul>个人中心</ul>
                <li><a href="#">个人信息</a></li>
                <li><a href="#">安全中心</a></li>
                <li><a href="#">收货地址</a></li>
                <li><a href="#">邮件/短信订阅</a></li>
                <ul>社区</ul>
                <li><a href="javaScript:void(0);" onclick="renderingPostReply()">消息中心</a></li>
                <li><a href="#">提问/回答</a></li>
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

                        <a href="#" target="blank">
                            <img src="${pageContext.request.contextPath}/images/header_o.jpg" alt="">

                            <div class="edit_box">
                                <span class="edit">&nbsp</span>
                                <span class="edit_a">编辑资料</span>
                            </div>
                        </a>
                        <span class="opacity_mask"></span>

                    </div>
                    <a href="#" title="站内信" target="blank">
                        <div class="message no_msg">
                            <span>0</span>

                        </div>
                    </a>
                    <sapn class="user_name" id="user_Nick">17751124276</sapn>

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
                            <a href="#" target="_blank"><span class="setting">手机已设置</span></a>
                            <a href="#" target="_blank"><span class="setting ">邮箱未设置</span></a>
                        </p>
                    </div>
                </div>
                <!--个人信息左面结束-->

                <div class="account_message">
                    <ul>

                        <li>
                            <a class="pic ye" href="#" target="_blank" id="pic1"></a>
                            <a href="#" target="_blank">余额</a>
                            <a href="#" target="_blank">0</a>
                        </li>
                        <li>
                            <a class="pic lq" href="#" target="_blank"></a>
                            <a href="#" target="_blank">礼券</a>

                            <a href="#" target="_blank">0张</a>
                        </li>
                        <li>
                            <a class="pic jf" href="#" target="_blank"></a>
                            <a href="#" target="_blank">积分</a>
                            <a href="#" target="_blank">0</a>
                            <span class="price_show">(价值￥0)</span>
                        </li>
                    </ul>
                </div>
            </div>
            <!--个人人信息背景结束-->
            <div id="input-text">

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
            <a href="#" target="_blank">
                <span></span>
                购<br>物<br>车<br>
                <em>0</em>
            </a>
        </div>
        <!--页面回滚-->
        <div class="sidebar_link">
            <a href="#" class="back_top"></a>
        </div>
    </div>
</div>

<!- 黑色遮罩层 z 999 ->
<section class="cust-black" id="cust-black-ded"></section>
<section class="cust-deleve" id="cust-deleve">
    <p class="title">删除宝贝<span class="closeModel" onclick="closeDed()">X</span></p>
    <p>您确认要删除该宝贝吗？</p>
    <div class="opBtn"><a href="javascript:void(0);" onclick="deleteTheMessage()" class="dialog-sure">确定</a><a href="javascript:void(0);" onclick="closeDed()" class="dialog-close">关闭</a></div>
</section>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script>
    $(function () {
        $('.back_top').click(function () {
            $('html , body').animate({scrollTop: 0}, 400);
        });
    });
</script>
<script src="${pageContext.request.contextPath}/js/personalCenter_messageView.js"></script>
</body>
</html>
