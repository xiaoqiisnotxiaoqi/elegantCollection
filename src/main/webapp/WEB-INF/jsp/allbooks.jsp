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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/allbooks.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>
<%--引入头部--%>
<jsp:include page="top.jsp"/>

<input id="current-category" name="10034" type="hidden"/>
<input id="keyword" name="" type="hidden"/>
<input id="minPrice" name="" type="hidden"/>
<input id="maxPrice" name="" type="hidden"/>
<input id="language" name="" type="hidden"/>
<input id="discount" name="" type="hidden"/>
<input id="orderBy" name="" value="" type="hidden"/>
<input id="bookStatus" name="" type="hidden"/>
<input id="isDiscount" name="" type="hidden"/>
<input id="currentPageCode" name="1" type="hidden"/>
<input id="zhekou" name="" type="hidden"/>


<div id="main-area">
    <div id="fenji-nav-box">
        <a href="" class="a" id="categoryname" onclick="clickCategory(this)">当前分类>所有图书</a>

    </div>
    <div id="filtrate-box">
        <ul id="filtrate-list">
            <li class="li" id="zifenlei">
                <span class="li-title">子分类</span>
                <a class="li-options" name=" 123" href="javascript:refresh()"></a>

            </li>

            <li class="li">
                <span class="li-title">价格</span>
                <a class="li-options" name="1" onclick="javascript:clickPrice(this)">0-9</a>
                <a class="li-options" name="2" onclick="javascript:clickPrice(this)">9-19</a>
                <a class="li-options" name="3" onclick="javascript:clickPrice(this)">19-29</a>
                <a class="li-options" name="4" onclick="javascript:clickPrice(this)">29-49</a>
                <a class="li-options" name="6" onclick="javascript:clickPrice(this)">49以上</a>
            </li>
            <li class="li">
                <span class="li-title">语言</span>
                <a class="li-options" onclick="javascript:clickLanguage(this)" name="中文">中文</a>
                <a class="li-options" onclick="javascript:clickLanguage(this)" name="英文">英文</a>
                <a class="li-options" onclick="javascript:clickLanguage(this)" name="日文">日文</a>
                <a class="li-options" onclick="javascript:clickLanguage(this)" name="俄文">俄文</a>

            </li>
            <li class="li">
                <span class="li-title">折扣</span>
                <a class="li-options" name="0.3" onclick="clickZhekou(this)">3折以下</a>
                <a class="li-options" name="0.5" onclick="clickZhekou(this)">5折以下</a>
                <a class="li-options" name="0.7" onclick="clickZhekou(this)">7折以下</a>
                <a class="li-options" name="0.9" onclick="clickZhekou(this)">9折以下</a>

            </li>


        </ul>

    </div>
    <div id="orderby-box">
        <ul class="orderby-ul">
            <li class="orderby-li" value="1" onclick="clickOrderBy(this)">综合排序</li>
            <li class="orderby-li" value="2" onclick="clickOrderBy(this)">销量</li>
            <li class="orderby-li" value="3" onclick="clickOrderBy(this)">价格</li>
            <li class="orderby-li" value="4" onclick="clickOrderBy(this)">出版时间</li>

            <li class="orderby-li" style="width: 180px">
                价格
                <input type="text" class="orderby-input" id="mininput"><span> -</span>
                <input type="text" class="orderby-input" id="maxinput">
                <button id="price-btn" name="5" onclick="javascript:clickPrice(this)">确定</button>
            </li>
        </ul>
        <ul class="orderby-ul">
            <li class="options"><a class="on" onclick="javascript:clickStatus(this)">只看有货</a></li>
            <li class="options"><a class="on" onclick="javascript:clickIsDiscount(this)">只看优惠</a></li>
        </ul>
    </div>
    <%--图书区域--%>
    <ul id="books-box">


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

    <!--右侧广告-->

</div>

<jsp:include page="bottom.jsp"/>
<%--加载js--%>
<script src="${pageContext.request.contextPath}/js/allbooks.js"></script>
<%--<script src="${pageContext.request.contextPath}/js/utilsnotoken.js"></script>--%>
</body>
</html>
