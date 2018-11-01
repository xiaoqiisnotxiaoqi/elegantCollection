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

</head>
<body style="padding:0;">
<%--引入头部--%>
<jsp:include page="topIndex.jsp"/>
<%--<iframe src="/top" style="width: 100%; height: 220px;border: none;frameborder:0;"></iframe>--%>

<!--左侧图书分类-->
<div class="container">
    <div class="row classify">
        <div class="panel panel-default">
            <div class="panel-heading " id="classify-title">
                <h3 class="panel-title classify-font">图书分类</h3>
            </div>
            <div class="panel-body classify-content">

                <div class="row">
                    <div class="col-md-10 classify-content-title" onclick="clickCate(this)"><input type="hidden"
                                                                                                   name="10003">教育
                    </div>
                </div>
                <div class="row classify-content-all">
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10004">教材
                        </div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10005">外语
                        </div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10006">工具书
                        </div>
                    </div>
                    <%--<div class="classify-bottom-xian"></div>--%>
                </div>
            </div>

            <div class="panel-body classify-content">
                <div class="classify-bottom-xian"></div>
                <div class="row">
                    <div class="col-md-10 classify-content-title" onclick="clickCate(this)"><input type="hidden"
                                                                                                   name="10008">文艺
                    </div>
                </div>
                <div class="row classify-content-all">
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10009">文学
                        </div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10010">传记
                        </div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10011">艺术
                        </div>
                    </div>
                    <%--<div class="classify-bottom-xian"></div>--%>
                </div>
            </div>
            <div class="panel-body classify-content">
                <div class="classify-bottom-xian"></div>
                <div class="row">
                    <div class="col-md-10 classify-content-title" onclick="clickCate(this)"><input type="hidden"
                                                                                                   name="10013">人文社科
                    </div>
                </div>
                <div class="row classify-content-all">
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10014">历史
                        </div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10015">哲学
                        </div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10016">文化
                        </div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10017">政治/军事
                        </div>
                        <div class="classify-xian"></div>
                    </div>

                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10018">法律
                        </div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10019">社会科学
                        </div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10020">心理学
                        </div>
                    </div>
                    <%--<div class="classify-bottom-xian"></div>--%>
                </div>
            </div>
            <div class="panel-body classify-content">
                <div class="classify-bottom-xian"></div>
                <div class="row">
                    <div class="col-md-10 classify-content-title" onclick="clickCate(this)"><input type="hidden"
                                                                                                   name="10022">生活
                    </div>
                </div>
                <div class="row classify-content-all">
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10023">两性
                        </div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10024">育儿
                        </div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10025">亲子家教
                        </div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10026">运动
                        </div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10027">家居
                        </div>
                    </div>
                    <%--<div class="classify-bottom-xian"></div>--%>
                </div>
            </div>
            <div class="panel-body classify-content">
                <div class="classify-bottom-xian"></div>
                <div class="row">
                    <div class="col-md-10 classify-content-title" onclick="clickCate(this)"><input type="hidden"
                                                                                                   name="10028">科技
                    </div>
                </div>
                <div class="row classify-content-all">
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10029">建筑
                        </div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10030">医学
                        </div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10031">计算机
                        </div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10032">自然科学
                        </div>
                        <div class="classify-xian"></div>
                    </div>
                    <div class="col-md-2 classify-content-con">
                        <div class="classify-con" onclick="clickCate(this)"><input type="hidden" name="10033">工业
                        </div>
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
                <div class="col-md-3"></div>
                <div class="col-md-3"></div>
                <div class="col-md-3"></div>
                <div class="col-md-3"></div>
            </div>
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-3"></div>
                <div class="col-md-3"></div>
                <div class="col-md-3"></div>
            </div>
        </div>
        <%--第二页--%>
        <div class="item  new-active" name="page2">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-3"></div>
                <div class="col-md-3"></div>
                <div class="col-md-3"></div>
            </div>
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-3"></div>
                <div class="col-md-3"></div>
                <div class="col-md-3"></div>
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
<!--*****************************************从这里开始复制************************************************************-->
<!--右侧新书热卖榜-->
<div class="row hot-book">
    <div class="col-md-4 hot-book-icon"><img src="/images/cp.png" alt=""></div>
    <div class="col-md-8 hot-book-title">新书热卖榜</div>
    <div class="row hot-book-content">
        <ul id="myTab" class="nav nav-tabs hot-book-main">
            <li class="active hot-book-first">
                <a href="#all" data-toggle="tab">总榜</a>
            </li>
            <li class="hot-book-second"><a href="#childbook1" data-toggle="tab">教育</a></li>
            <li class="hot-book-three"><a href="#childbook2" data-toggle="tab">文艺</a></li>
            <li class="hot-book-four"><a href="#childbook3" data-toggle="tab">生活</a></li>
            <li class="hot-book-four"><a href="#childbook4" data-toggle="tab">科技</a></li>

        </ul>

        <div id="myTabContent" class="tab-content">
            <!--总榜-->
            <div class="tab-pane fade in active" id="all"></div>
            <div class="tab-pane fade" id="childbook1"></div>
            <div class="tab-pane fade" id="childbook2"></div>
            <div class="tab-pane fade" id="childbook3"></div>
            <div class="tab-pane fade" id="childbook4"></div>
        </div>
        <script>
            $(function () {
                $('#myTab li:eq(0) a').tab('show');
            });
        </script>
    </div>
</div>


<!--2018-10-31 中间作者介绍 -->
<div class="row hot-author">
    <!--标签页头部-->
    <div class="row hot-author-title">
        <div class="col-lg-2 hot-author-name">
            热门作者
        </div>
        <div class="col-lg-10 hot-author-other"></div>
    </div>
    <!--作者照片和简介-->
    <div class="row hot-author-information" id="first-author">
        <div class="col-md-1">
            <div class="num-1">1</div>
            <div class="num-st">st</div>
        </div>
        <div class="col-md-2 hot-author-img">
            <img src="images/hot-author.jpg" alt="">
        </div>
        <div class="col-md-8">
            <div class="row">
                <div class="col-md-12 author-name">
                    高铭
                </div>
                <div class="col-md-12">
                    <div class="author-content">
                        <p class="author-content-p">高铭 70年代生于北京。他喜欢问为什么，但不是哲学家。他喜欢探究心理，但不是心理学家。他喜欢
                            追问世界本源，但不是历史学家。他喜欢动物，但从不去动物园。他是个探险家，但不怎么旅游。他写
                            过畅销书《天才在左，疯子在右》。他喜欢白色、金属金和银色。他喜欢用“贪婪”形容自己。他喜欢自
                            己制定规则。他坚信自己能拯救世界。他谁也不是，但他谁都是。</p>
                    </div>
                </div>
            </div>
        </div>
    </div>


</div>
<!--中间的分割线-->
<div class="infor-work-cut">
    <div class="cut-work">作品</div>
    <div class="information-work-xian"></div>
</div>
<!--作者作品介绍-->
<div class="row hot-author-work" id="first-author-books">

</div>
<!--作者排行榜-->
<div class="row author-sort" id="author-sort">

</div>


<%--仨书单--%>
<div class="row books-order" id="orders">
    <div class="col-lg-4 book-order-content">
        <img src="images/book_order.jpg" alt="">
    </div>
    <div class="col-lg-4 book-order-content">
        <img src="images/book_order.jpg" alt="">
    </div>
    <div class="col-lg-4 book-order-content">
        <img src="images/book_order.jpg" alt="">
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/lunbotu.js"></script>
</body>
</html>
