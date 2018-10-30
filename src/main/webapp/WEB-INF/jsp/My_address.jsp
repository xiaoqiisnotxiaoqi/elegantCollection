<%--
  Created by IntelliJ IDEA.
  User: rzz
  Date: 2018/10/29
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>地址本</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/my_Elegant.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/My_address.css" type="text/css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/myaddress.js"></script>


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
                <ul>我的钱包</ul>
                <li><a href="#">我的礼券</a></li>
                <!--<li><a href="#">我的余额</a></li>-->
                <li><a href="#">我的积分</a></li>
                <ul>售后服务</ul>
                <li><a href="#">申请/查询退换货</a></li>
                <li><a href="#">补开发票</a></li>
                <ul>个人中心</ul>
                <li><a href="#">个人信息</a></li>

                <li><a href="#">收货地址</a></li>
                <ul>安全中心</ul>
                <li><a href="#">登录密码</a></li>
                <li><a href="#">邮箱验证</a></li>
                <li><a href="#">手机绑定</a></li>
                <ul>我的消息</ul>
                <li><a href="#">消息查看</a></li>
                <!--<li><a href="#">发帖记录</a></li>-->
                <li><a href="#">评论/晒单</a></li>
                <li><a href="#">提问/回答</a></li>
            </div>
            <!--导航栏结束-->
        </div>
    </div>
    <!--左导航栏结束-->


    <div class="my_main">
        <div class="my_title">
            <a href="javascript:showaddress();" class="fr btn" id="J-Add-Address">+添加新地址</a>



            <span class="title">收货地址管理</span>
            <span class="tip">您已创建了<span class="red" id="J-Address-Num"> </span>个收货地址，最多可以创建
            <span class="red">20</span>个</span>
        </div>

        <div class="address_list">
            <ul id="J-Address-List"></ul>
            <div id="J-Page-Info" style="padding-right: 23px;"></div>

        </div>

        <input type="hidden" id="J-totalPageIndex">
        <input type="hidden" id="J-currentPageIndex">
    </div>
</div>
<div class="pop" style="display: none" id="J-Pop-Content">
    <a href="javascript:closeaddress()" class="close" id="J-Pop-Close"></a>
    <div class="pop_title">新增收货地址</div>
    <div class="pop_con">
        <form action="" method="" class="info_list">
            <ul>
                <li>
                    <span class="name">
                        <span class="red">*</span>
                        收货人
                    </span>
                    <input type="text" name="usernam" id="J-Cust-Name" maxlength="25">
                </li>
                <li style="z-index:3">
                    <span class="name">
                        <span class="red">*</span>
                        所在地区
                    </span>
                    <div class="select_add">
                        <select name="province" id="Province">
                            <option>省份--</option>
                        </select>
                        <select name="city" id="city">
                            <option>城市--</option>
                        </select>
                        <select name="area" id="area">
                            <option>区/县--</option>
                        </select>

                    </div>
                </li>
                <li style="z-index: 2">
                    <span class="name">
                        <span class="red">*</span>
                        详情地址
                    </span>
                    <input type="text" style="width:413px;" id="J-Detail-Address" maxlength="50">
                    <ul class="drop_tip" style="width: 423px; z-index: 2;display: none">
                        <li></li>
                        <li></li>
                    </ul>
                    <div class="alart_tip" style="display: none" id="J-Detail-Tip">
                        <span class="icon_wrong"></span>
                        请填写详细街道地址,要求3个汉字以上
                    </div>
                </li>
                <li>
                    <span class="name">
                        <span class="red">*</span>
                        手机号码
                    </span>
                    <input type="text" id="J-Mobile-Phone" maxlength="20">
                    <input type="hidden" id="Mobile-Bak">
                    <div class="alart_tip" style="display: none" id="J-Mobile-Tip"></div>
                </li>
            </ul>
        </form>
        <div class="btn_bar">
            <input type="hidden" id="J-Save-Type" value="add">
            <input type="hidden" id="J-Address-Id">
            <a href="" class="btn" id="J-Save-Address" onclick="saveadd()">保存地址 </a>
        </div>
    </div>
    <div class="pop delete" id="delete_sure" style="display: none">
        <a href="" class="close"></a>
        <div class="delete_con">
            <h2>确定要删除改地址吗?</h2>
            <div class="btn_bar">
                <a href="" class="btn" id="delete_yes">确定</a>
                <a href="" class="btn cancle" id="delete_no">取消</a>
            </div>
        </div>
    </div>

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
<script src="../js/jquery.min.js"></script>
<script>
    $(function () {
        $('.back_top').click(function () {
            $('html , body').animate({scrollTop: 0}, 400);
        });
    });
</script>

</body>
</html>