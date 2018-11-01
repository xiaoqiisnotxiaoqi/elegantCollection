var url_getauthor = '/author/getauthor';
var url_getbook = '/author/getbook';
onload = function () {
    refreshAuthor(url_getauthor);
    refreshBook(url_getbook);
}
var xhr = null;
var xrh = null;
function refreshAuthor(url_getauthor){
    if(window.XMLHttpRequest){
        xhr = new XMLHttpRequest();
    }else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET",url_getauthor,true);
    xhr.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr.onreadystatechange = loadAuthor;
    xhr.send();
}
function loadAuthor() {
    if (xhr.readyState == 4 && xhr.status == 200) {
        var result = JSON.parse(xhr.responseText);
        var jian = document.getElementById("jian");
        jian.innerHTML += ('<div class="tu"><img src="' + result.authorImg + '"></div><div class="jie">' +
            '<div class="ming"><span>' + result.authorName + '</span></div><div class="zi">' +
            '<span>' + result.authorIntro + '</span></div></div>');
    }
}
function refreshBook(url_getbook){
    if(window.XMLHttpRequest){
        xrh = new XMLHttpRequest();
    }else {
        xrh = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xrh.open("GET",url_getbook,true);
    xrh.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xrh.onreadystatechange = loadBook;
    xrh.send();
}
function loadBook() {
    if (xrh.readyState == 4 && xrh.status == 200) {
        var result = JSON.parse(xrh.responseText);
        var zuo = document.getElementById("zuo");
        zuo.innerHTML = "";
        for (var i = 0; i < result.length; i++) {
            zuo.innerHTML += ('<div class="pin"><a href="#" name="' + result[i].bookId + '" onclick="getDetail(this)' +
                '"> <img src="' + result[i].bookImg + '"></a><a href="#" name="' + result[i].bookId + '" onclick="' +
                'getDetail(this)"><span class="shuzi">' + result[i].bookName + '</span></a><label class="jia">¥' +
                '</label><span class="jia">' + result[i].bookSellingPrice + '</span></div>');
        }
        var style = window.getComputedStyle(zuo, null);
        var style1= window.getComputedStyle(all, null);
        var height=parseInt(style.height)+250+parseInt(style1.height);
        all.style.height=height+'px';
    }
}
function getDetail(pro) {
    window.location = "bookdetail/?bookId=" + pro.name;
}