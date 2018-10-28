/**
 * Created by Administrator on 2018\10\16 0016.
 */
var replyId;
var xhr;


function renderingPostReply() {
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET", "/postReplyView" , true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = postPutRequest;
    xhr.send();
}


/**
 * 用户点击回复时触发事件
 * @param ele
 */
function postRevert(ele){
    //得到该条回复的id
    var idNode = ele.previousSibling;
    replyId = idNode.innerText;

    ele.parentNode.parentNode.className = "post-news2";
    ele.parentNode.nextSibling.style.display = "";
}

/**
 * 点击提交评论 触发事件
 * @param ele
 */
function postPut(ele){
    var text = ele.previousSibling.value;
    if (text != null) {
        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        } else {
            xhr = new ActiveXObject('Microsoft.XMLHTTP');
        }
        var transmitData = "text=" + text + "&replyId=" + replyId;
        alert(transmitData);
        xhr.open("POST", "/writeBack", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        xhr.onreadystatechange = postPutRequest;
        xhr.send(transmitData);
    }else{
        ele.previousSibling.value = "回复内容不能为空!!"
    }
}

/**
 * 解析json数据 页面渲染
 */
function postPutRequest(){
    if(xhr.readyState === 4 && xhr.status === 200){
        var resolve = JSON.parse(xhr.responseText);
        alert(resolve);
        var modelList = resolve.modelList;
        var textNode = document.getElementById("input-text");
        textNode.innerHTML = "";
        if(modelList !== null){
            for(var i = 0; i < modelList.length; i++){
                textNode.innerHTML +=('<div class="post-news">'+
                    '<div class="post-new">'+
                        '<span class="replier1">'+modelList[i].postReply+'</span>'+
                        '<span class="replier2">回复了我:</span>'+
                        '<span class="replier4" style="z-index: 1" >'+modelList[i].postReplyText +'</span>'+
                    '</div>'+
                    '<div class="my-new">'+
                        '<span class="replier2">'+ modelList[i].byPostReply +'</span>'+
                        '<span class="replier5">: '+ modelList[i].byPostReplyText +'</span>'+
                    '</div>'+
                    '<div class="post-operater">'+
                        '<span style="display: none">'+modelList[i].postReplyId+'</span>'+
                        '<span onclick="postRevert(this)" class="post-revert">回复</span>'+
                        '<span onclick="postRemove(this)" class="post-remove">删除</span>'+
                        '<span onclick="skip2TheBookReviewArea(this)" class="to-bookReview">转至书评区</span>'+
                    '</div>'+
                    '<form class="comment-box" style="display: none">'+
                        '<textarea name="a" class="comment1"></textarea>'+
                        '<span class="comment2" onclick="postPut(this)">提交</span>'+
                        '<span class="comment3" onclick="postCancel(this)">取消</span>'+
                    '</form>'+
                '</div>')
            }
        }else{
            //空的消息列表
        }


    }
}

/**
 * 用户点击取消按钮 触发事件
 * @param ele
 */
function postCancel(ele){
    ele.parentNode.parentNode.className = "post-news";
    ele.parentNode.style.display = "none";
}


/**
 * 用户点击 删除触发弹出确认框事件
 * @param ele
 */
function postRemove(ele){
    //得到该条回复的id
    var idNode = ele.previousElementSibling.previousElementSibling;
    replyId = idNode.innerText;
    //显示确实删除弹框
    var Idiv     = document.getElementById("cust-deleve");
    //显示遮罩层
    var Bdiv = document.getElementById("cust-black-ded");
    Bdiv.style.display = "block";
    Idiv.style.display = "block";

    Idiv.style.left=(document.documentElement.clientWidth-Idiv.clientWidth)/2+document.documentElement.scrollLeft + 200 +"px";
    Idiv.style.top =(document.documentElement.clientHeight-Idiv.clientHeight)/2+document.documentElement.scrollTop +50 +"px";
}


/**
 * 确认删除评论  触发事件
 */
function deleteTheMessage(){
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("DELETE", "/deleteReply?replyId="+replyId , true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = postPutRequest();
    xhr.send();
}



/**
 * 关闭弹出确认删除框
 */
function closeDed(){
    //的到确实删除弹框 节点
    var Idiv     = document.getElementById("cust-deleve");
    //遮罩层 节点
    var Bdiv = document.getElementById("cust-black-ded");

    Bdiv.style.display = "none";
    Idiv.style.display = "none";
}

/**
 * 用户点击跳转到 书评区按钮触发的事件
 * @param ele
 */
function skip2TheBookReviewArea(ele){
    var idNode = ele.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling;
    replyId = idNode.innerText;
}