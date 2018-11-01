<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/17
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>排行榜</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ranking.css">
</head>
<body>
<jsp:include page="top.jsp"/>
<div class="all">
    <div class="danming">
        <span class="tou">榜单</span>
        <span class="saner"><a href="javascript:refreshBookTotal(url_getbooktotal)">总销量榜</a> </span>
        <span class="saner"><a href="javascript:getLastMonth(url_getbooklastmonth)">月销量榜</a> </span>
    </div>
    <div class="danshen">
        <div id="danxiang" class="danxiang">
            <%--<span class="xiangtou">分类排行</span>--%>

        </div>
        <div id="shulie" class="shulie">
            <%--<div class="shu">--%>
                <%--<div class="zuo">--%>
                    <%--<a href="#"><img src="../images/zuopin.jpg"></a>--%>
                <%--</div>--%>
                <%--<div class="you">--%>
                    <%--<span class="sqone"><a href="#">神奇校车</a> </span>--%>
                    <%--&lt;%&ndash;<span class="sqtwo"><a href="#">乔安娜柯尔</a> </span>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<span class="sqthree">贵州人民出版社</span>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<span class="sqthree">2018-05-10</span>&ndash;%&gt;--%>
                    <%--<span class="jia">¥</span><span class="jia">99.00</span>--%>
                    <%--<span class="jiaxian">¥</span><span class="jiaxian">108.00</span>--%>
                    <%--<span class="che"><a href="#">加入购物车</a></span>--%>
                <%--</div>--%>
            <%--</div>--%>
        </div>
        <div id="fenye" class="fenye">
            <%--<span class="ye"><a href="#">下一页</a> </span>--%>
            <%--<span class="ma">1</span>--%>
            <%--<span class="ye"><a href="#">上一页</a> </span>--%>
        </div>
    </div>
</div>
<script src="../../js/ranking.js"></script>
<jsp:include page="bottom.jsp"/>
</body>
</html>
