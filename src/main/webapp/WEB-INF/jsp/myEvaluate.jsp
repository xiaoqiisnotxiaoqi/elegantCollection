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
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/user_info.js"></script>
</head>
<body>
<%--引入头部--%>
<iframe src="${pageContext.request.contextPath}/top" style="width: 100%; height: 220px;border: none;frameborder:0;"></iframe>


<div class="mydnew_break">
    您现在的位置：
    <a href="#">雅志</a> &gt;
    <span><a href="#">我的Elegant</a></span> &gt;
    <span>个人档案</span>
</div>
<!--个人信息开始操作-->
<div class="main_frame">
    <!--左侧栏开始-->
    <div class="mydang_left">
        <div class="mydang_left_inner">
            <h3 class="mydang_left_title border_top0">我的长用链接
                <a id="DocPersonal_set" name="setting" href="#" style="font-size: 12px; color:#1A66B3;
                    font-family: 宋体; font-weight:normal; padding-left: 40px;">设置</a>
            </h3>
            <ul style="padding:0px;" class="my_href" id="myfavoriteLink"></ul>
            <h3 class="mydang_left_title">我的交易
                <a class="slide_up" id="class600" href="javascript:click_a('class600','display600')"></a>
            </h3>

            <ul class="my_content" style="display:block;" id="display600">

                <li><a class="" target="_parent" href="#"
                       name="myallorders">我的订单test</a>
                </li>

            </ul>


            <h3 class="mydang_left_title">我的钱包
                <a class="slide_up" id="class620" href="javascript:click_a('class620','display620')"></a>
            </h3>
            <ul class="my_content" style="display:block;" id="display620">

                <li><a class="" target="_parent" href="#" name="mycoupons">我的礼券</a></li>

                <li><a class="" target="_parent" href="#" name="points_index_list">我的积分</a></li>
            </ul>
            <h3 class="mydang_left_title">售后服务
                <a class="slide_up" id="class630" href="javascript:click_a('class630','display630')"></a>
            </h3>
            <ul class="my_content" style="display:block;" id="display630">
                <li><a class="" target="_parent" href="#" name="re_list">申请/查询退换货</a></li>
                <li><a class="" target="_parent" href="#" name="myinvoice">补开发票</a></li>
            </ul>
            <h3 class="mydang_left_title">个人中心
                <a class="slide_up" id="class640" href="javascript:click_a('class640','display640')"></a>
            </h3>
            <ul class="my_content" style="display:block;" id="display640">
                <li><a href="#" class="on">个人信息</a></li>

                <li><a class="" target="_parent" href="#" name="myaddress">收货地址</a></li>
                <li><a class="" target="_parent" href="#" name="myfeed">邮件/短信订阅</a></li>
            </ul>
            <h3 class="mydang_left_title">安全中心
                <a class="slide_up" id="class610" href="javascript:click_a('class610','display610')"></a>
            </h3>
            <ul class="my_content" style="display:block;" id="display610">
                <li><a class="" target="_parent" href="#" name="my_login_pwd">登录密码</a></li>
                <li><a class="" target="_parent" href="#" name="my_email">邮箱验证</a></li>
                <li><a class="" target="_parent" href="#" name="my_phone">手机绑定</a></li>

            </ul>

            <h3 class="mydang_left_title">社区
                <a class="slide_up" id="class650" href="javascript:click_a('class650','display650')"></a>
            </h3>
            <ul class="my_content" style="display:block;" id="display650">
                <li><a class="" target="_parent" href="#" name="myreview">评论/晒单</a></li>
                <li><a class="" target="_parent" href="#" name="myquestion">提问/回答</a></li>
            </ul>
        </div>
    </div>


    <!--左侧结束-->
    <!--右侧开始-->
    <div class="account_right" id="your_position">
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
            <li class="eval-li">
                <div class="inner-div"><img src="sadss"/></div>
                <div class="inner-div">
                    <div class="shuming"> 书名书名书名书名书名书名书名书名书名</div>
                    <div class="price">价格</div>
                </div>

                <div class="neirong">
                    <div class="shuming">这本书怎么这么好看这本书怎么这么好看这本书怎么这么好看这本书怎么这么好看这本书怎么这么好看这本书怎么这么好看</div>
                    <div class="price">xx年xx月xx日</div>
                </div>
                <div class="inner-div">
                    <button class="btn">订单详情</button>
                </div>
            </li>
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
                <li value="" class="active" id="currentPage"></li>
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


<script src="${pageContext.request.contextPath}/js/myEvaluate.js"></script>
</body>

</html>
