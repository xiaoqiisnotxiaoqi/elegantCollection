<%--
  Created by IntelliJ IDEA.
  User: qinjb
  Date: 2018\10\24 0024
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>帖子名</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reviewTheDetails.css">

</head>
<body>
<%--顶端导航--%>
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
            <li>欢迎进入雅致藏书</li>
            <li onclick="showDiv()">登录</li>
            <li onclick="showRegister()">加入雅致</li>
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
            <input type="button" name="" value="帖子搜索">
            <input type="button" name="" value="全站搜索">
            <span>高级搜索</span>
        </form>
    </div>
</div>
<div class="post">
    <div id="post-title">
        <img id="block-img">
        <span id="block-name"></span>
        <span>书评区</span>
        <span>书评 :</span><span id="post-num"></span>
    </div>

    <%--帖子的页码按钮--%>
    <div id="first-page1" class="first-page">

    </div>

    <div>
        <div id="subject">
            <span>回复: </span>
            <span id="title"></span>
            <button onclick="lookLandlord()">只看楼主</button>
            <button onclick="toButtonOfPage()">回复</button>
        </div>

        <!--左侧排行榜-->
        <div id="right-ranking">
            <div>热门书评榜</div>
            <ul id="top-post">
            </ul>
        </div>

        <div id="post-reply">
        </div>
    </div>
    <div>




        <!--尾部页面跳转--><%--帖子的页码按钮--%>
        <div id="first-page2" class="first-page">

        </div>

        <!-- 尾部帖子回复 -->
        <div id="reply-to-post">
            <div class="reply-hint">
                <span>发表回复</span>
                <span>发表书评请遵循</span>
                <span>国家相关法律规定</span>
            </div>
            <div class="reply-textbox">
                <div class="reply-img">
                    <%--回复成功,显示提示--%>
                    <div id="review-success" style="display: none">
                        <span style="position: relative;left: 286px;color: orange;font-size: 16px;top: 8px;">回复成功</span>
                        <span style="position: relative;left: 300px;color: orange;font-size: 16px;top: 8px;">积分 + 1</span>
                    </div>
                        <%--回复失败,显示提示--%>
                    <div id="review-file" style="display: none">
                        <span style="position: relative;color: red;font-size: 16px;left: 274px;top: 8px;">回复失败 , 请稍后再试.</span>
                    </div>
                        <%--未登录,显示提示--%>
                    <div id="review-signIn" style="display: none;">
                        <span style="position: relative;left: 300px;color: red;font-size: 16px;top: 8px;">您未登录 , 请先登录</span>
                    </div>
                </div>
                <textarea class="edui" id="edui"></textarea>
                <div class="reply-yes" onclick="replyTheOriginalPoster()">发表</div>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/reviewTheDetails.js"></script>
</body>
</html>
