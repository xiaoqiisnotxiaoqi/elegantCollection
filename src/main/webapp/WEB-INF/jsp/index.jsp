<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/26/026
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/classify.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/lunbotu.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/lunbotu.js"></script>
</head>
<body>
<%--引入头部--%>
<%--<jsp:include page="top.jsp"/>--%>

<!--左侧图书分类-->
<div class="container">
    <div class="row classify">
        <div class="panel panel-default">
            <div class="panel-heading " id="classify-title">
                <h3 class="panel-title classify-font">图书分类</h3>
            </div>
            <div class="panel-body classify-content">

                <div class="row" cid="10003">
                    <div class="col-md-10 classify-content-title" onclick="clickCate(this)"><input name="分类ID"
                                                                                                   value="10003"
                                                                                                   type="hidden">教育
                    </div>
                    <div class="col-md-2"> ></div>
                </div>
                <div class="row classify-content-all">
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con"><input name="分类ID" value="10003" type="hidden">教材</div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con"><input name="分类ID" value="10003" type="hidden">外语</div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" cid="10006" onclick="javascript:clickCate(this)"><input name="分类ID"
                                                                                                          value="10003"
                                                                                                          type="hidden">工具书
                        </div>
                        <div class="classify-xian"></div>
                    </div>
                    <%--<div class="classify-bottom-xian"></div>--%>
                </div>
            </div>

            <div class="panel-body classify-content">
                <div class="classify-bottom-xian"></div>
                <div class="row">
                    <div class="col-md-10 classify-content-title">文艺</div>
                    <div class="col-md-2"> ></div>
                </div>
                <div class="row classify-content-all">
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con">文学</div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con">传记</div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con">艺术</div>
                        <div class="classify-xian"></div>
                    </div>
                    <%--<div class="classify-bottom-xian"></div>--%>
                </div>
            </div>
            <div class="panel-body classify-content">
                <div class="classify-bottom-xian"></div>
                <div class="row">
                    <div class="col-md-10 classify-content-title">人文社科</div>
                    <div class="col-md-2"> ></div>
                </div>
                <div class="row classify-content-all">
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con">历史</div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con">哲学</div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con">文化</div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con">政治/军事</div>
                        <div class="classify-xian"></div>
                    </div>

                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con">法律</div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con">社会科学</div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con">心理学</div>
                        <div class="classify-xian"></div>
                    </div>
                    <%--<div class="classify-bottom-xian"></div>--%>
                </div>
            </div>
            <div class="panel-body classify-content">
                <div class="classify-bottom-xian"></div>
                <div class="row">
                    <div class="col-md-10 classify-content-title">生活</div>
                    <div class="col-md-2"> ></div>
                </div>
                <div class="row classify-content-all">
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con">两性</div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con">育儿</div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con">亲子家教</div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con">运动</div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con">家居</div>
                        <div class="classify-xian"></div>
                    </div>
                    <%--<div class="classify-bottom-xian"></div>--%>
                </div>
            </div>
            <div class="panel-body classify-content">
                <div class="classify-bottom-xian"></div>
                <div class="row">
                    <div class="col-md-10 classify-content-title">科技</div>
                    <div class="col-md-2"> ></div>
                </div>
                <div class="row classify-content-all">
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con">建筑</div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con">医学</div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con">计算机</div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con">自然科学</div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con">工业</div>
                        <div class="classify-xian"></div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <div>

    </div>
</div>


<!--轮播图-->
<div id="container" class="trun_img">
    <div id="list" style="left: -750px;">
        <img src="${pageContext.request.contextPath}/images/5.jpg" alt="1">
        <img src="${pageContext.request.contextPath}/images/1.jpg" alt="1">
        <img src="${pageContext.request.contextPath}/images/2.jpg" alt="2">
        <img src="${pageContext.request.contextPath}/images/3.jpg" alt="3">
        <img src="${pageContext.request.contextPath}/images/4.jpg" alt="4">
        <img src="${pageContext.request.contextPath}/images/5.jpg" alt="5">
        <img src="${pageContext.request.contextPath}/images/1.jpg" alt="5">
    </div>
    <div id="buttons">
        <span index="1" class="on"></span>
        <span index="2" class=""></span>
        <span index="3" class=""></span>
        <span index="4" class=""></span>
        <span index="5" class=""></span>
    </div>
    <a href="javascript:;" id="prev" class="arrow">&lt;</a>
    <a href="javascript:;" id="next" class="arrow">&gt;</a>
</div>

<!--右侧最新同态 新书预售-->
<div class="row new-trends">
    <div class="col-lg-12 new-trends-title">最新动态</div>
    <div class="col-lg-12 new-trends-content">
        <ul>
            <li><img src="${pageContext.request.contextPath}/images/point.png" alt=""><a href="">艺术，每满150减50</a></li>
            <li><img src="${pageContext.request.contextPath}/images/point.png" alt=""><a href="">一本好书，5折抢购！</a></li>
            <li><img src="${pageContext.request.contextPath}/images/point.png" alt=""><a href="">当当出版，5折封顶！</a></li>
        </ul>
    </div>
</div>
<!--右侧小轮播图-->
<div class="row little-lunbotu">
    <div class="col-lg-12 new-trends-title">新书预售</div>
    <div class="col-lg-12 new-trends-content">
        <div class="test">
            <div id="myCarousel" class="carousel slide">
                <!-- 轮播（Carousel）指标 -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>
                <!-- 轮播（Carousel）项目 -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="${pageContext.request.contextPath}/images/s1.jpg" alt="First slide"
                             title="说一万遍我爱你，不如好好在一起（林熙新书）">
                        <div class="test-word"><a href="">说一万遍我爱你，不如好好在</a></div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/images/s2.jpg" alt="Second slide"
                             title="迭代：让情商和见识成为你最大的底气（知名公众号“薇安说”创始人首部力作）">
                        <div class="test-word"><a href="">迭代：让情商和见识成为你最大</a></div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/images/s3.jpg" alt="Third slide"
                             title="幼儿启智认知洞洞书(全3册)">
                        <div class="test-word"><a href="">幼儿启智认知洞洞书(全3册)</a></div>
                    </div>
                </div>
                <a class="left " href="#myCarousel" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right " href="#myCarousel" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
</div>
<!--中间的新书上架-->
<div class="container">
    <div class="row">
        <div class="col-lg-12 new-all">
            <div class="new-title">新</div>
            <div class="new-content">书上架</div>
        </div>
        <div class="col-lg-12 new-xian">

        </div>
    </div>
</div>
<!--中间新书上架轮播图-->
<div id="new-myCarousel" class="carousel new-car slide">
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators new-yuan">
        <li data-target="#new-myCarousel" data-slide-to="0" class="active new-active"></li>
        <li data-target="#new-myCarousel" data-slide-to="1"></li>
        <li data-target="#new-myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner new-car-inn">
        <%--第一页--%>
        <div class="item active new-active">
            <div class="row">
                <div class="col-md-3">
                    <img src="${pageContext.request.contextPath}/images/n1.jpg">
                    <div class="new-title-word">每日读诗日历2019</div>
                    <div class="new-author">廉萍 著，新经典 出</div>
                    <div class="cost-price-icon">¥</div>
                    <div class="cost-price">44.00</div>
                    <div class="original-price-icon">¥</div>
                    <div class="original-price">88.00</div>
                </div>
                <div class="col-md-3">
                    <img src="${pageContext.request.contextPath}/images/n2.jpg">
                    <div class="new-title-word">曼食慢语（Amanda</div>
                    <div class="new-author">曼达（Amanda）</div>
                    <div class="cost-price-icon">¥</div>
                    <div class="cost-price">48.90</div>
                    <div class="original-price-icon">¥</div>
                    <div class="original-price">68.00</div>
                </div>
                <div class="col-md-3">
                    <img src="${pageContext.request.contextPath}/images/n3.jpg">
                    <div class="new-title-word">楚辞·观</div>
                    <div class="new-author">陈丝雨 绘</div>
                    <div class="cost-price-icon">¥</div>
                    <div class="cost-price">129.60</div>
                    <div class="original-price-icon">¥</div>
                    <div class="original-price">180.00</div>
                </div>
                <div class="col-md-3">
                    <img src="${pageContext.request.contextPath}/images/n4.jpg">
                    <div class="new-title-word">别做那只迷途的候鸟</div>
                    <div class="new-author">刘同 著</div>
                    <div class="cost-price-icon">¥</div>
                    <div class="cost-price">31.10</div>
                    <div class="original-price-icon">¥</div>
                    <div class="original-price">45.00</div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <img src="${pageContext.request.contextPath}/images/n5.jpg">
                    <div class="new-title-word">曼食慢语（Amanda</div>
                    <div class="new-author">曼达（Amanda）</div>
                    <div class="cost-price-icon">¥</div>
                    <div class="cost-price">129.60</div>
                    <div class="original-price-icon">¥</div>
                    <div class="original-price">180.00</div>
                </div>
                <div class="col-md-3">
                    <img src="${pageContext.request.contextPath}/images/n6.jpg">
                    <div class="new-title-word">曼食慢语（Amanda</div>
                    <div class="new-author">曼达（Amanda）</div>
                    <div class="cost-price-icon">¥</div>
                    <div class="cost-price">129.60</div>
                    <div class="original-price-icon">¥</div>
                    <div class="original-price">180.00</div>
                </div>
                <div class="col-md-3">
                    <img src="${pageContext.request.contextPath}/images/n7.jpg">
                    <div class="new-title-word">曼食慢语（Amanda</div>
                    <div class="new-author">曼达（Amanda）</div>
                    <div class="cost-price-icon">¥</div>
                    <div class="cost-price">129.60</div>
                    <div class="original-price-icon">¥</div>
                    <div class="original-price">180.00</div>
                </div>
                <div class="col-md-3">
                    <img src="${pageContext.request.contextPath}/images/n8.jpg">
                    <div class="new-title-word">曼食慢语（Amanda</div>
                    <div class="new-author">曼达（Amanda）</div>
                    <div class="cost-price-icon">¥</div>
                    <div class="cost-price">129.60</div>
                    <div class="original-price-icon">¥</div>
                    <div class="original-price">180.00</div>
                </div>
            </div>
        </div>
        <%--第二页--%>
        <div class="item  new-active" name="page2">
            <div class="row">
                <div class="col-md-3">
                    <img src="${pageContext.request.contextPath}/images/n9.jpg">
                    <div class="new-title-word">曼食慢语（Amanda</div>
                    <div class="new-author">曼达（Amanda）</div>
                    <div class="cost-price-icon">¥</div>
                    <div class="cost-price">129.60</div>
                    <div class="original-price-icon">¥</div>
                    <div class="original-price">180.00</div>
                </div>
                <div class="col-md-3">
                    <img src="${pageContext.request.contextPath}/images/n10.jpg">
                    <div class="new-title-word">曼食慢语（Amanda</div>
                    <div class="new-author">曼达（Amanda）</div>
                    <div class="cost-price-icon">¥</div>
                    <div class="cost-price">129.60</div>
                    <div class="original-price-icon">¥</div>
                    <div class="original-price">180.00</div>
                </div>
                <div class="col-md-3">
                    <img src="${pageContext.request.contextPath}/images/n11.jpg">
                    <div class="new-title-word">曼食慢语（Amanda</div>
                    <div class="new-author">曼达（Amanda）</div>
                    <div class="cost-price-icon">¥</div>
                    <div class="cost-price">129.60</div>
                    <div class="original-price-icon">¥</div>
                    <div class="original-price">180.00</div>
                </div>
                <div class="col-md-3">
                    <img src="${pageContext.request.contextPath}/images/n12.jpg">
                    <div class="new-title-word">曼食慢语（Amanda</div>
                    <div class="new-author">曼达（Amanda）</div>
                    <div class="cost-price-icon">¥</div>
                    <div class="cost-price">129.60</div>
                    <div class="original-price-icon">¥</div>
                    <div class="original-price">180.00</div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <img src="${pageContext.request.contextPath}/images/n9.jpg">
                    <div class="new-title-word">曼食慢语（Amanda</div>
                    <div class="new-author">曼达（Amanda）</div>
                    <div class="cost-price-icon">¥</div>
                    <div class="cost-price">129.60</div>
                    <div class="original-price-icon">¥</div>
                    <div class="original-price">180.00</div>
                </div>
                <div class="col-md-3">
                    <img src="${pageContext.request.contextPath}/images/n10.jpg">
                    <div class="new-title-word">曼食慢语（Amanda</div>
                    <div class="new-author">曼达（Amanda）</div>
                    <div class="cost-price-icon">¥</div>
                    <div class="cost-price">129.60</div>
                    <div class="original-price-icon">¥</div>
                    <div class="original-price">180.00</div>
                </div>
                <div class="col-md-3">
                    <img src="${pageContext.request.contextPath}/images/n11.jpg">
                    <div class="new-title-word">曼食慢语（Amanda</div>
                    <div class="new-author">曼达（Amanda）</div>
                    <div class="cost-price-icon">¥</div>
                    <div class="cost-price">129.60</div>
                    <div class="original-price-icon">¥</div>
                    <div class="original-price">180.00</div>
                </div>
                <div class="col-md-3">
                    <img src="${pageContext.request.contextPath}/images/n12.jpg">
                    <div class="new-title-word">曼食慢语（Amanda</div>
                    <div class="new-author">曼达（Amanda）</div>
                    <div class="cost-price-icon">¥</div>
                    <div class="cost-price">129.60</div>
                    <div class="original-price-icon">¥</div>
                    <div class="original-price">180.00</div>
                </div>
            </div>
        </div>


    </div>
    <!-- 轮播（Carousel）导航 -->
    <a class="left new-left" href="#new-myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right new-right" href="#new-myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>


<script>

    function clickCate(ele) {
        alert(ele.firstElementChild.value)
        console.log(ele.firstElementChild.value)
    }

    window.onload = loadNew();

    //    写入新书上架数据
    function loadNew() {

        var xhr = null;
        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
        }
        else {
            xhr = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
        }
        if (xhr != null) {
            xhr.open("GET", "book/index", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
            xhr.onreadystatechange = callFun;
            xhr.send();
        } else {
            alert("不能创建XMLHttpRequest对象实例");
        }

        function callFun() {
            if (xhr.readyState == 4 && xhr.status == 200) {
                console.log(xhr.responseText);
                //获取所有新书上架的元素集合
                var jsObj = JSON.parse(xhr.responseText);
                var classList = document.getElementsByClassName("col-md-3");

                var newBookList = jsObj.bookList0;
                for (let i = 0; i < 16; i++) {
                    classList[i].innerHTML = "     <img src=\"${pageContext.request.contextPath}" + newBookList[i].bookImg + " \"width=150px height=150px>\n" +
                        "                    <div class=\"new-title-word\">" + newBookList[i].bookName + "</div>\n" +
                        "                    <div class=\"new-author\">" + newBookList[i].authorId + "</div>\n" +
                        "                    <div class=\"cost-price-icon\">¥</div>\n" +
                        "                    <div class=\"cost-price\">" + newBookList[i].bookSellingPrice + "</div>\n" +
                        "                    <div class=\"original-price-icon\">¥</div>\n" +
                        "                    <div class=\"original-price\">" + newBookList[i].bookMarkedPrice + "</div> ";
                }
            }
        }

    }


</script>
</body>
</html>
