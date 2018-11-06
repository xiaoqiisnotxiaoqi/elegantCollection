<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>雅致藏书--书评区</title>
    <link rel="stylesheet" href="../../css/post.css">
</head>
<body>

<div class="page-body">
    <div class="block-top">
        <div class="block-top-image"><img src="" class="block-background" id="block-background">
            <img src="" class="block-image" id="block-image"></div>
        <div class="block-data">
            <span class="block-name" id="block-name"></span>
            <span class="block-info" id="block-info"></span>
        </div>
        <ul class="columns" id="columns">
            <li><a href="#" onclick="refreshPost(1)">书评</a></li>
            <li><a href="#" onclick="refreshBestPost(1)">精品</a></li>
            <li><a href="#" onclick="">作者</a></li>
        </ul>
    </div>
    <div class="block-context">
        <div class="postlist-context" id="postlist-context">
            <div class="popular-posts" id="popular-posts">
            </div>
            <div class="block-segmentation"></div>
            <div class="time-posts" id="time-posts">
            </div>
            <div class="block-segmentation"></div>
        </div>
        <div class="all-popular-posts" id="all-popular-posts">
            <span class="all-popular-posts-tip"> 热门书评榜</span>
        </div>
        <div class="pagination">
            <div id="pagination-btns">
            </div>
            <span class="posts-info">书评数 <span class="posts-number" id="posts-number"></span>篇</span>
        </div>
    </div>
    <div class="posting">
        <div class="posting-form">
            <input type="text" class="post-title" placeholder="请填写标题" id="post-title"><span class="remind-login" id="remind-login">请登陆后发帖</span>
            <textarea class="post-context" id="post-context"></textarea>
            <input type="button" class="post-button" value="发表" id="post-button">
        </div>
    </div>
</div>

<script src="../../js/post.js"></script>
</body>
</html>
</html>
