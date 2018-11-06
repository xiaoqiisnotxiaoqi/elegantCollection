var url_getbookorder = '/bookorder/getbookorder';
var url_getbookorderdetail = '/bookorder/getbookorderdetail';
onload = function () {
    refreshBookOrder(url_getbookorder);
    refreshBookOrderDetail(url_getbookorderdetail);
}
var xhr = null;
var xrh = null;
//获取书单信息
function refreshBookOrder(url_getbookorder){
    if(window.XMLHttpRequest){
        xhr = new XMLHttpRequest();
    }else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET",url_getbookorder,true);
    xhr.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr.onreadystatechange = loadBookOrder;
    xhr.send();
}
function loadBookOrder() {
    if (xhr.readyState === 4 && xhr.status === 200) {
        var result = JSON.parse(xhr.responseText);
        var neid = document.getElementById("neid");
        neid.innerHTML += ('<div class="oi"><img src="' + result.orderImg + '"></div>' +
            '<div class="xiang"><span class="dati">' + result.orderTitle + '</span>' +
            '<span class="jieshao">' + result.orderIntro + '</span></div>');
    }
}
获取该书单内所有书籍
function refreshBookOrderDetail(url_getbookorderdetail){
    if(window.XMLHttpRequest){
        xrh = new XMLHttpRequest();
    }else {
        xrh = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xrh.open("GET",url_getbookorderdetail,true);
    xrh.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xrh.onreadystatechange = loadBookOrderDetail;
    xrh.send();
}
function loadBookOrderDetail() {
    if (xrh.readyState === 4 && xrh.status === 200) {
        var result = JSON.parse(xrh.responseText);
        var shen = document.getElementById("shen");
        shen.innerHTML = "";
        for (var i = 0; i < result.length; i++) {
            shen.innerHTML += ('<div class="danshu"><a href="#" name="' + result[i].bookId + '" onclick="' +
                'getDetail(this)"> <img src="' + result[i].bookImg + '"></a><a href="#" name="' + result[i].bookId +
                '" onclick="getDetail(this)"><span class="shuzi">' + result[i].bookName + '</span></a>' +
                '<label class="jia">¥</label><span class="jia">' + result[i].bookSellingPrice + '</span></div>');
        }
        var style = window.getComputedStyle(shen, null);
        var style1= window.getComputedStyle(all, null);
        var height=parseInt(style.height)+330+parseInt(style1.height);
        all.style.height=height+'px';
    }
}
//跳转到书籍详情
function getDetail(pro) {
    window.location = "bookdetail/?bookId=" + pro.name;
}