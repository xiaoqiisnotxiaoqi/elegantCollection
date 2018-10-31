var xhr;

//要跳转的 书评帖id 以及 页数
var  thisPostId,currentPage;

// 当前 书评贴 的 id号 以及发帖人的 id ,发帖人昵称
var pagePostId , pageCustId , pageCustName;

//要回复的子回复的昵称
var backName;
//要回复的子回复的replyid;
var backReplyId;
// 要渲染的 div节点
var reviewDivNode;

/**
 * 书评区 详情
 */
function reviewOfTheBeginning() {
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET", "/reviewHead", true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = reviewResouse;
    xhr.send();
}

/**
 * 书评区 板块信息 解析并加载
 */
function reviewResouse() {
    if(xhr.readyState === 4 && xhr.status === 200){
        var map = JSON.parse(xhr.responseText);

        //将 板块的图片 引入页面
        document.getElementById("block-img").src  += map.blockImg;
        //将板块名写入页面
        document.getElementById("block-name").innerText = map.blockName;
        //将书评数量写入页面
        document.getElementById("post-num").innerText = map.postNum;
        //将标题写入页面
        document.getElementById("title").innerText = map.postName;

        pagePostId = map.postId;
        pageCustId = map.custId;
        pageCustName = map.custName;

         replyContent();

    }
}

/**
 * 书评区 向后台发送请求  得到 消息列表
 */
function replyContent() {
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    var url="/reviewTheDetails";
    if (thisPostId !== null && currentPage !== null){
        url += "?postId="+thisPostId + "&currentPage=" + currentPage;
    } else if (currentPage !== null){
        url += "?currentPage=" + currentPage;
    } else if (thisPostId !== null){
        url += "?postId="+thisPostId;
    }


    xhr.open("GET", "/reviewTheDetails", true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = replyContentReoue;
    xhr.send();
}


/**
 * 解析 书评区 消息 并将当前页的消息 写入页面中
 */
function replyContentReoue() {
    if (xhr.readyState === 4 && xhr.status === 200) {
        var status = JSON.parse(xhr.responseText);
        if (status.modelList !== null){
            //像页面写入 页数按钮
            var page1 = document.getElementById("first-page1");
            var page2 = document.getElementById("first-page2");
            page1.innerHTML = "";
            page2.innerHTML = "";
            //总页数小于等于10 大于1
            var h = "";
            if (status.totalPages <= 10 && status.totalPages > 1){
                h += '<ul><li>';
                for (var i = 1; i <= status.totalPages ; i++ ){
                    if (status.totalPages == status.currentPageCode) {
                        h = ('<a href="javaScript:void(0);" id="this-page">1</a>');
                    }else {
                        h += '<a href="javaScript:void(0);" onclick="toPage(this)">' + i + '</a>';
                    }
                }
                h += '</li>' +
                    '<li>' +
                    '<span>'+ status.totalRecord +'</span><span>条回复贴, 共</span><span> '+ status.totalPages +' </span><span>页 ,</span>' +
                    '</li>' +
                    '<li>' +
                    '<span>跳到</span><input type="text" name=""><span> 页 </span>' +
                    '<button onclick="toPageButton(this)">确定</button>' +
                    '</li></ul>';
                page1.innerHTML = h;
                page2.innerHTML = h;
            }
            //总页数为1 时
            else if (status.totalPages === 1){
                var h = ('<ul><li>' +
                    '<span>'+ status.totalRecord +'</span><span>条回复贴, 共</span><span> '+ status.totalPages +' </span><span>页 </span>' +
                    '</li>' +
                    '<li>' +
                    '</li></ul>'
                );
                page1.innerHTML = h;
                page2.innerHTML = h;
            }
            //总页数大于10 当前页为1
            else if(status.totalPages >= 10 && status.currentPageCode === 1){
                var h = ('<ul><li><a href="javaScript:void(0);" id="this-page">1</a>');
                var i = 2;
                while(i <= 10){
                    h += '<a href="javaScript:void(0);" onclick="toPage(this)">'+ i +'</a>';
                }
                h += '</li>' +
                    '<li>' +
                    '<span>'+ status.totalRecord +'</span><span>条回复贴, 共</span><span> '+ status.totalPages +' </span><span>页 ,</span>' +
                    '</li>' +
                    '<li>' +
                    '<span>跳到</span><input type="text" name=""><span> 页 </span>' +
                    '<button onclick="toPageButton(this)">确定</button>' +
                    '</li></ul>';
                page1.innerHTML = h;
                page2.innerHTML = h;
            }
            //总页数大于10 当前页不为1 且小于5
            else if (status.totalPages >= 10 && status.currentPageCode !== 1 && status.currentPageCode <= 5) {
                var h = '<ul><li><a href="javaScript:void(0);">首页</a><a href="javaScript:void(0);" onclick="bookReviewLastPage('+status.currentPageCode+')">上一页</a>';
                for (var i = 1; i < status.currentPageCode; i++){
                    h += '<a href="javaScript:void(0);" onclick="toPage(this)">'+ i +'</a>'
                }
                h += '<a href="javaScript:void(0);" id="this-page">'+ status.currentPageCode +'</a>';
                for (var i = status.currentPageCode + 1; i < 10; i++){
                    h += '<a href="javaScript:void(0);" onclick="toPage(this)">'+ i +'</a>'
                }
                h += '</li>' +
                    '<li>' +
                    '<span>'+ status.totalRecord +'</span><span>条回复贴, 共</span><span> '+ status.totalPages +' </span><span>页 ,</span>' +
                    '</li>' +
                    '<li>' +
                    '<span>跳到</span><input type="text" name=""><span> 页 </span>' +
                    '<button onclick="toPageButton(this)">确定</button>' +
                    '</li></ul>';
                page1.innerHTML = h;
                page2.innerHTML = h;
            }
            //总页数 大于10 当前页 不为1 且大于5
            else {
                var h = '<ul><li><a href="javaScript:void(0);">首页</a><a href="javaScript:void(0);" onclick="bookReviewLastPage('+status.currentPageCode+')">上一页</a>';
                if (status.totalPages - status.currentPageCode >= 5){
                    for (var i = status.currentPageCode - 4; i < status.currentPageCode; i++){
                        h += '<a href="javaScript:void(0);" onclick="toPage(this)">'+ i +'</a>'
                    }
                    h += '<a href="javaScript:void(0);" id="this-page">'+ status.currentPageCode +'</a>';
                    for (var i = status.currentPageCode + 1; i <= status.currentPageCode + 5; i++) {
                        h += '<a href="javaScript:void(0);" onclick="toPage(this)">'+ i +'</a>'
                    }
                } 
                else{
                    for (var i = status.totalPages - 9; i < status.currentPageCode; i++){
                        h += '<a href="javaScript:void(0);">'+ i +'</a>'
                    }
                    h += '<a href="javaScript:void(0);" class="this-page">'+ status.currentPageCode +'</a>';
                    for (var i = status.currentPageCode + 1; i <= status.totalPages + 5; i++) {
                        h += '<a href="javaScript:void(0);">'+ i +'</a>'
                    }
                }
                h += '</li>' +
                    '<li>' +
                    '<span>'+ status.totalRecord +'</span><span>条回复贴, 共</span><span> '+ status.totalPages +' </span><span>页 ,</span>' +
                    '</li>' +
                    '<li>' +
                    '<span>跳到</span><input type="text" name=""><span> 页 </span>' +
                    '<button onclick="toPageButton(this)">确定</button>' +
                    '</li></ul>';
                page1.innerHTML = h;
                page2.innerHTML = h;
            }


            
            //像页面写入 帖子回复信息
            var text = document.getElementById("post-reply");
            text.innerHTML = "";

            //获得modelList
            var list1 = status.modelList ;
            var obj2 ='';
            for(var i =0; i<list1.length; i++){
                var  a = "",b = "", c = "";
                //页面渲染 直接回复
                a = ('<div class="invitation">' +
                    '<div class="post-left">' +
                    '<div class="personal-information">' +
                    '<div>' +
                    '<img src="'+ list1[i].custProfile +'"/>' +
                    '</div>');
                if (pageCustName === list1[i].custName) {
                    a += '<div><img src="/images/starter.png"></div>'+
                        '<div>'+ list1[i].custName +'</div>' +
                        '<div>积分:'+list1[i].custPoints+'</div>';
                }else {
                    a += '<div></div>' +
                        '<div style="margin-top: 10px">'+ list1[i].custName +'</div>' +
                        '<div>积分:'+list1[i].custPoints+'</div>' ;
                }
                a += '</div>' +
                    '</div>' +
                    '<div class="comment-content">' +
                    '<div class="Message">'+list1[i].replytext+'</div>' +
                    '<div class="message-information ">' +
                    '<div class="message-information1">' +
                    '<span>举报</span>' +
                    '<span>'+ list1[i].replyFloor+'</span><span>楼</span>' +
                    '<span>'+list1[i].date+'</span>' +
                    '<span>回复('+list1[i].childBackNum+')</span>' +
                    '<span style="display: none">'+list1[i].postReplyId+'</span>'+
                    '</div>' +
                    '<div class="message-information2"><ul>';



                obj2= list1[i].childBack;
                var list3 = obj2.modelList;
                //获得modelList中的childBack

                if (list3 !== null) {
                    //子回复页面渲染
                    for (var j = 0; j < list3.length; j++) {

                        b += '<li>' +
                            '<div><img src="'+ list3[j].custProfile+'"/></div>' +
                            '<div>' +
                            '<a href="javaScript:void(0);">'+list3[j].custName+': </a>' +
                            '<span> 回复 </span>';


                            if (list3[j].byReplyId != null){
                                    b += '<a href="javaScript:void(0);">'+list3[j].byReplyId+ ': </a>' +
                                        '<span>'+list3[j].replytext+'</span>' +
                                        '<div class="message-information3">' +
                                        '<span>'+list3[j].childDate+'</span>' +
                                        '<span onclick="replyMessage(this)">回复</span>'+
                                        '<span style="display: none">'+list3[j].replyId+'</span>' +
                                        '</div>' +
                                        '</div>' +
                                        '</li>';
                            }else {
                                b += '<a href="javaScript:void(0);">: </a>' +
                                    '<span>'+list3[j].replytext+'</span>' +
                                    '<div class="message-information3">' +
                                    '<span>'+list3[j].childDate+'</span>' +
                                    '<span onclick="replyMessage(this)">回复</span>'+
                                    '<span style="display: none">'+list3[j].replyId+'</span>' +
                                    '</div>' +
                                    '</div>' +
                                    '</li>';
                            }
                    }
                    //子回复 页面按钮写入
                    if(obj2.totalPages === 1){

                    }
                    else if(obj2.totalPages <= 10){
                        b += ('<li class="information-page"><ul><li><a href="javaScript:void(0);" onclick="reviewLastPage(this)">上一页</a>');
                        for (var m = 1 ; m <= obj2.totalPages; m++){
                            if (m === obj2.currentPageCode) {
                                //当前页
                                b += ('<a href="javaScript:void(0);" class="current-page">'+m+'</a>');
                            }else {
                                b += ('<a href="javaScript:void(0);" onclick="pageTransfer(this)">'+m+'</a>');
                            }
                        }
                        b +=('<a href="javaScript:void(0);" onclick="reviewNextPage(this)">下一页</a></li></ul>')
                    }
                    else if(obj2.totalPages > 10 && obj2.totalPages - obj2.currentPageCode > 5){
                        b += ('<li class="information-page"><ul><li><a href="javaScript:void(0);" onclick="fistPage(this)">首页</a><a href="javaScript:void(0);" onclick="reviewLastPage(this)">上一页</a>');
                        for (var m = obj2.currentPageCode - 4 ; m < obj2.currentPageCode; m++){
                            text.innerHTML += ('<a href="javaScript:void(0);" onclick="pageTransfer(this)">'+m+'</a>');
                        }
                        //当前页
                        b += ('<a href="javaScript:void(0);" class="current-page">'+obj2.currentPageCode+'</a>');
                        for (var n = obj2.currentPageCode + 1 ; n < obj2.currentPageCode + 5; n++){
                            b += ('<a href="javaScript:void(0);" onclick="pageTransfer(this)">'+m+'</a>');
                        }
                        b +=('<a href="javaScript:void(0);" onclick="reviewNextPage(this)">下一页</a><a href="javaScript:void(0);" onclick="lastPage(this)">尾页</a></li></ul>')
                    }
                    else {
                        b += ('<li class="information-page"><ul><li><a href="javaScript:void(0);" onclick="fistPage(this)">首页</a><a href="javaScript:void(0);" onclick="reviewLastPage(this)">上一页</a>');
                        for (var m = obj2.totalPages - 9 ; m <= obj2.totalPages; m++){
                            if (m !== obj2.currentPageCode) {
                                b += ('<a href="javaScript:void(0);" onclick="pageTransfer(this)">'+m+'</a>');
                            }else{
                                //当前页
                                b += ('<a href="javaScript:void(0);" class="current-page">'+obj2.currentPageCode+'</a>');
                            }
                        }
                        b +=('<a href="javaScript:void(0);" onclick="reviewNextPage(this)">下一页</a><a href="javaScript:void(0);" onclick="lastPage(this)">尾页</a></li></ul>');
                    }

                }
                c = ('<li class="message-reply"><textarea></textarea><div class="yes-reply" onclick="reply2Comment(this)">提交</div></li>'+
                    '</ul></div></div></div></div>');
                text.innerHTML += a + b +c;
            }


        }
    }
}



/**
 * 发送请求 得到 一段时间内的评论热度 前十的书评帖
 */
function topPort(){
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET", "/finTopReview", true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = topPortRedus;
    xhr.send();
}


/**
 * 解析数据 并将数据 写入到top榜单中
 */
function topPortRedus(){
    if (xhr.readyState === 4 && xhr.status === 200){
        var topJson = JSON.parse(xhr.responseText);
        var top = document.getElementById("top-post");
        top.innerHTML = "";
        for (var i = 0; i < topJson.length ; i++){
            var a = "", b = "";
            if (i < 3){
                a += ('<li>' +
                    '<span class="topic_item1">'+ (i + 1)+'</span>');
            } else {
                a += ('<li>' +
                    '<span class="topic_item">'+ (i + 1)+'</span>');
            }


            b += ('<span class="topic_title">'+topJson[i].title+'</span>' +
            '<span class="topic_num">'+topJson[i].num+'</span>' +
            '<span style="display: none">'+topJson[i].postId+'</span></li>');
           // console.log(a);
          //  console.log(b);
            top.innerHTML += a + b;
        }
        reviewOfTheBeginning();
    }

}

/**
 * 点击按钮 跳到页尾评价部分
 */
function toButtonOfPage(){
    window.location.hash = "#reply-to-post";
}



/**
 * 文档加载完成后 触发事件
 */
window.onload = function () {topPort();};



/**
 * 只看 楼主按钮 触发事件
 */
function lookLandlord() {
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET", "/lookLandlord4Port", true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = replyContentReoue;
    xhr.send();
}

/**
 * 点击子评论的回复 光标聚焦文本域
 * @param ele
 */
function replyMessage(ele) {
    //得到要回复的子评论的replyId
    backReplyId = ele.nextSibling.innerText;
    //让光标聚焦文本域
    ele.parentNode.parentNode.parentNode.parentNode.lastChild.firstChild.focus();
}

/**
 * 回复 消息(层主 或者子回复 消息)
 * @param ele
 */
function reply2Comment(ele){
    //将要渲染的div保存
    reviewDivNode = ele.parentNode.parentNode.parentNode;
    //得到回复的类容
    var text = ele.previousSibling.value;
    alert(text);
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    var requestDast;
    //判断用户回复的是 层主 或者是 层主下面的回复
    if (backReplyId != null) {
        //当用户回复 子回复时
        requestDast = "replyId=" + backReplyId + "&text=" + text;
    }else {
        //当用户 回复一级回复时
        var landingId = ele.parentNode.parentNode.parentNode.previousSibling.lastChild.innerText;
        requestDast = "replyId=" + landingId + "&text=" + text;
    }
    xhr.open("POST", "/ReplyLevelMessage", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
    xhr.onreadystatechange = subcommentLoading;
    xhr.send(requestDast);
}

/**
 * 解析子回复页面渲染
 */
function subcommentLoading(){
    if (xhr.readyState === 4 && xhr.status === 200){
        var text = JSON.parse(xhr.responseText);
        reviewDivNode.innerHTML = "";
        var b = "<ul>" ;
        var list = text.modelList;
        if (list != null) {
            //子回复页面渲染
            for (var j = 0; j < list.length; j++) {
                console.log(list[j].custProfile);
                b += '<li>' +
                    '<div><img src="'+ list[j].custProfile+'"/></div>' +
                    '<div>' +
                    '<a href="javaScript:void(0);">'+list[j].custName+': </a>' +
                    '<span> 回复 </span>';


                if (list[j].byReplyId != null){
                    b += '<a href="javaScript:void(0);">'+list[j].byReplyId+ ': </a>' +
                        '<span>'+list[j].replytext+'</span>' +
                        '<div class="message-information3">' +
                        '<span>'+list[j].childDate+'</span>' +
                        '<span onclick="replyMessage(this)">回复</span>'+
                        '<span style="display: none">'+list[j].replyId+'</span>' +
                        '</div>' +
                        '</div>' +
                        '</li>';
                }else {
                    b += '<a href="javaScript:void(0);">: </a>' +
                        '<span>'+list[j].replytext+'</span>' +
                        '<div class="message-information3">' +
                        '<span>'+list[j].childDate+'</span>' +
                        '<span onclick="replyMessage(this)">回复</span>'+
                        '<span style="display: none">'+list[j].replyId+'</span>' +
                        '</div>' +
                        '</div>' +
                        '</li>';
                }
            }
            //子回复 页面按钮写入
            if(text.totalPages === 1){

            }
            else if(text.totalPages <= 10){
                b += ('<li class="information-page"><ul><li><a href="javaScript:void(0);" onclick="reviewLastPage(this)">上一页</a>');
                for (var m = 1 ; m <= text.totalPages; m++){
                    if (m === text.currentPageCode) {
                        //当前页
                        b += ('<a href="javaScript:void(0);" class="current-page">'+m+'</a>');
                    }else {
                        b += ('<a href="javaScript:void(0);" onclick="pageTransfer(this)">'+m+'</a>');
                    }
                }
                b +=('<a href="javaScript:void(0);" onclick="reviewNextPage(this)">下一页</a></li></ul>')
            }
            else if(text.totalPages > 10 && text.totalPages - text.currentPageCode > 5){
                b += ('<li class="information-page"><ul><li><a href="javaScript:void(0);" onclick="fistPage(this)">首页</a><a href="javaScript:void(0);" onclick="reviewLastPage(this)">上一页</a>');
                for (var m = text.currentPageCode - 4 ; m < text.currentPageCode; m++){
                    b += ('<a href="javaScript:void(0);" onclick="pageTransfer(this)">'+m+'</a>');
                }
                //当前页
                b += ('<a href="javaScript:void(0);" class="current-page">'+reviewDivNode.currentPageCode+'</a>');
                for (var n = text.currentPageCode + 1 ; n < text.currentPageCode + 5; n++){
                    b += ('<a href="javaScript:void(0);" onclick="pageTransfer(this)">'+m+'</a>');
                }
                b +=('<a href="javaScript:void(0);" onclick="reviewNextPage(this)">下一页</a><a href="javaScript:void(0);"onclick="lastPage(this)">尾页</a></li></ul>')
            }
            else {
                b += ('<li class="information-page"><ul><li><a href="javaScript:void(0);" onclick="fistPage(this)">首页</a><a href="javaScript:void(0);" onclick="reviewLastPage(this)">上一页</a>');
                for (var m = text.totalPages - 9 ; m <= text.totalPages; m++){
                    if (m !== text.currentPageCode) {
                        b += ('<a href="javaScript:void(0);" onclick="pageTransfer(this)">'+m+'</a>');
                    }else{
                        //当前页
                        b += ('<a href="javaScript:void(0);" class="current-page">'+text.currentPageCode+'</a>');
                    }
                }
                b +=('<a href="javaScript:void(0);" onclick="reviewNextPage(this)">下一页</a><a href="javaScript:void(0);" onclick="lastPage(this)">尾页</a></li></ul>');
            }

        }
        var c = ('<li class="message-reply"><textarea></textarea><div class="yes-reply" onclick="reply2Comment(this)">提交</div></li>'+
            '</ul></div></div></div></div>');
        reviewDivNode.innerHTML += b +c;
    }

}


/**
 * 子回复  指定页面跳转
 * @param ele
 */
function pageTransfer(ele) {
    reviewDivNode = undefined;
    //得到页面渲染的div
    reviewDivNode = ele.parentNode.parentNode.parentNode.parentNode.parentNode;
    alert(reviewDivNode.previousSibling.innerHTML);
    //得到要跳转的页面
    var page = ele.innerText;
    //得到 当前楼层
    var floor = reviewDivNode.previousSibling.childNodes[1].innerText;
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET", "/subreplyPageJump?postId=" + pagePostId + "&floor=" + floor + "&currentPageCode=" + page, true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = subcommentLoading;
    xhr.send();
}


/**
 * 书评贴 指定页面跳转
 * @param ele
 */
function  toPage(ele) {
    //得到要跳转的页面
    var page = ele.innerText;
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET", "/reviewTheDetails?postId=" + pagePostId + "&currentPage=" + page, true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = replyContentReoue;
    xhr.send();
}


/**
 * 书评帖 上一页跳转
 * @param num 当前页
 */
function bookReviewLastPage(num){
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET", "/reviewTheDetails?postId=" + pagePostId + "&currentPageCode=" + (num - 1), true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = replyContentReoue;
    xhr.send();
}


/**
 * 书评帖 下一页跳转
 * @param num 当前页
 */
function bookReviewNextPage(num){
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET", "/reviewTheDetails?postId=" + pagePostId + "&currentPageCode=" + (num + 1), true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = replyContentReoue;
    xhr.send();
}

/**
 * 子回复 上一页跳转
 * @param ele 上一页所在节点
 * @param num 当前页
 */
function reviewLastPage(ele) {
    reviewDivNode = undefined;
    //得到页面渲染的div
    reviewDivNode = ele.parentNode.parentNode.parentNode.parentNode.parentNode;
    //得到要跳转的页面
    var page = parseInt(ele2pageNum(ele)) - 1;
    //得到 当前楼层
    var floor = reviewDivNode.previousSibling.childNodes[1].innerText;
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET", "/subreplyPageJump?postId=" + pagePostId + "&floor=" + floor + "&currentPageCode=" + page, true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = subcommentLoading;
    xhr.send();
}

/**
 * 子回复 下一页跳转
 * @param ele 下一页按钮所在节点
 */
function reviewNextPage(ele) {
    reviewDivNode = undefined;
    //得到页面渲染的div
    reviewDivNode = ele.parentNode.parentNode.parentNode.parentNode.parentNode;

    //得到要跳转的页面
    var page = parseInt(ele2pageNum(ele)) + 1;
    //得到 当前楼层
    var floor = reviewDivNode.previousSibling.childNodes[1].innerText;
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET", "/subreplyPageJump?postId=" + pagePostId + "&floor=" + floor + "&currentPageCode=" + page, true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = subcommentLoading;
    xhr.send();
}

/**
 * 子回复 跳转首页
 */
function fistPage(ele) {
    reviewDivNode = undefined;
    //得到页面渲染的div
    reviewDivNode = ele.parentNode.parentNode.parentNode.parentNode.parentNode;
    //得到要跳转的页面
    var page = 1;
    //得到 当前楼层
    var floor = reviewDivNode.previousSibling.childNodes[1].innerText;
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET", "/subreplyPageJump?postId=" + pagePostId + "&floor=" + floor + "&currentPageCode=" + page, true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = subcommentLoading;
    xhr.send();
}


/**
 * 子回复 跳转尾页
 */
function lastPage(ele) {
    reviewDivNode = undefined;
    //得到页面渲染的div
    reviewDivNode = ele.parentNode.parentNode.parentNode.parentNode.parentNode;
    //得到要跳转的页面
    var page = 500;
    //得到 当前楼层
    var floor = reviewDivNode.previousSibling.childNodes[1].innerText;
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET", "/subreplyPageJump?postId=" + pagePostId + "&floor=" + floor + "&currentPageCode=" + page, true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = subcommentLoading;
    xhr.send();
}


/**
 * 根据 页码节点 得到当前页面
 */
function ele2pageNum(ele) {
    var pageNodes = ele.parentNode.childNodes;
    for (var i = 1; i < pageNodes.length ; i++){
        if (pageNodes[i].className === "current-page") {
            return pageNodes[i].innerText;
        }
    } 
}


/**
 * 回复楼主
 */
function replyTheOriginalPoster() {
    var text = document.getElementById("edui").value;
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    var sendText = "postId=" + pagePostId + "&text=" + text;
    alert(sendText);
    xhr.open("PUT", "/replyOriginalPoster", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
    xhr.onreadystatechange = replyTheResults;
    xhr.send(sendText);
}


/**
 * 解析回复楼主 返回的json数据 查看是否回复成功
 */
function replyTheResults() {
    if (xhr.readyState === 4 && xhr.status === 200){
        var hint = JSON.parse(xhr.responseText)
        if (hint.err != null){
            if (hint.err === "用户未登陆") {
                document.getElementById("review-signIn").style.display = "";
                setTimeout(function() {
                    document.getElementById("review-signIn").style.display = "none";
                }, 3000);

            }else {
                document.getElementById("review-file").style.display = "";
                setTimeout(function() {
                    document.getElementById("review-file").style.display = "none";
                }, 3000);

            }
        }else {
            document.getElementById("edui").value = "";
            document.getElementById("review-success").style.display = "";
            setTimeout(function() {
                document.getElementById("review-success").style.display = "none";
            }, 3000);
        //返回页面的顶部
        // document.documentElement.scrollTop = 0;
            var scrollToptimer = setInterval(function () {
                console.log("定时循环回到顶部")
                var top = document.body.scrollTop || document.documentElement.scrollTop;
                var speed = top / 4;
                if (document.body.scrollTop!==0) {
                    document.body.scrollTop -= speed;
                }else {
                    document.documentElement.scrollTop -= speed;
                }
                if (top === 0) {
                    clearInterval(scrollToptimer);
                }
            }, 30);

        }



    }
}


function f() {

}

/**
 * 文本框 输入页码 跳转页面
 * @param ele
 */
function toPageButton(ele){
    var page = ele.previousSibling.previousSibling.value;
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET", "/reviewTheDetails?postId=" + pagePostId + "&currentPage=" + page, true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = replyContentReoue;
    xhr.send();
}


