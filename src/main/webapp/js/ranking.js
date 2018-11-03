var url_getcategory = '/category/getcategory';
var url_getbooktotal = '/category/getbooktotal';
var url_getbooklastmonth = '/category/getbooklastmonth';
var url_getbooklastmonthcategory = '/category/getbooklastmonthcategory?categoryId=';
onload = function () {
    refreshCategory(url_getcategory);
    refreshBookTotal(url_getbooktotal);
}
var xhr = null;
var xrh = null;
//获取书籍二级类别
function refreshCategory(url_getcategory){
    if(window.XMLHttpRequest){
        xrh = new XMLHttpRequest();
    }else {
        xrh = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xrh.open("GET",url_getcategory,true);
    xrh.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xrh.onreadystatechange = loadCategory;
    xrh.send();
}
function loadCategory() {
    if (xrh.readyState == 4 && xrh.status == 200) {
        var result = JSON.parse(xrh.responseText);
        var danxiang = document.getElementById("danxiang");
        danxiang.innerHTML = "";
        for (var i = 0; i < result.length; i++) {
            var href = 'javascript:getLastMonthCategory("' + url_getbooklastmonthcategory + result[i].categoryId + '")';
            var dx = "<span class='lei'><a href='" + href + "'>" + result[i].categoryName + "</a></span>";
            danxiang.innerHTML += dx;
        }
    }
}
//按总销量降序显示图书
function refreshBookTotal(ugbt){
    if(window.XMLHttpRequest){
        xhr = new XMLHttpRequest();
    }else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET",ugbt,true);
    xhr.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr.onreadystatechange = loadBookTotal;
    xhr.send();
}
function loadBookTotal() {
    if (xhr.readyState == 4 && xhr.status == 200) {
        var result = JSON.parse(xhr.responseText);
        var relist = result.modelList;
        var shulie = document.getElementById("shulie");
        shulie.innerHTML = "";
        for (var i = 0; i < relist.length; i++) {
            shulie.innerHTML += ('<div class="shu"><div class="zuo"><a id="bd" href="#" name="' + relist[i].bookId +
                '" onclick="getDetail(this)"><img src="' + relist[i].bookImg + '"></a></div><div class="you">' +
                '<span class="sqone"><a href="#" name="' + relist[i].bookId + '" onclick="getDetail(this)">' +
                relist[i].bookName + '</a></span><span class="jia">¥</span><span class="jia">' +
                relist[i].bookSellingPrice + '</span><span class="jiaxian">¥</span><span class="jiaxian">' +
                relist[i].bookMarkedPrice + '</span><span class="che"><a id="gw" href="javascript:checklogin()">' +
                '加入购物车</a></span></div></div>');
        }
        //判断是否登录
        var su = sessionStorage.getItem("login");
        if (su != "success") {
            var df = document.getElementById("gw");
            df.disabled = true;
        }
        var fenye = document.getElementById("fenye");
        fenye.innerHTML = "";
        if(result.currentPageCode != result.totalPages){
            var url_next_page = url_getbooktotal + "?page=" + (result.currentPageCode + 1);
            var href = 'javascript:refreshBookTotal("' + url_next_page + '")';
            var nextPageEle = "<span class='ye'><a href='" + href + "'>下一页</a> </span>";
            fenye.innerHTML += nextPageEle;
        }
        var currentPageEle = "<span class='ma'>" + result.currentPageCode + "</span>";
        fenye.innerHTML += currentPageEle;
        if(result.currentPageCode != 1){
            var url_pre_page = url_getbooktotal + "?page=" + (result.currentPageCode - 1);
            var href = 'javascript:refreshBookTotal("' + url_pre_page + '")';
            var prePageEle = "<span class='ye'><a href='" + href + "'>上一页</a> </span>";
            fenye.innerHTML += prePageEle;
        }
    }
}
function checklogin() {
    var bd = document.getElementById("bd").name;
    comecart(bd);
}
var url_gotocart = '/find/cart?bookId=';
var ppx = null;
//向购物车添加数据
function comecart(dd) {
    var ulr = url_gotocart + dd + "&bookCount=" + 1;
    if(window.XMLHttpRequest){
        ppx = new XMLHttpRequest();
    }else {
        ppx = new ActiveXObject('Microsoft.XMLHTTP');
    }
    ppx.open("GET",ulr,true);
    ppx.setRequestHeader("Content-Type","application/json;charset=utf-8");
    ppx.onreadystatechange = loadCart;
    ppx.send();
}
//跳转到购物车
function loadCart() {
    if (xhr.readyState == 4 && xhr.status == 200){
        var result = JSON.parse(xhr.responseText);
        if (result != "添加失败") {
            window.location = "custCart";
        }
    }
}
//按上月销量降序显示图书
function getLastMonth(ugbl) {
    if(window.XMLHttpRequest){
        xhr = new XMLHttpRequest();
    }else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET",ugbl,true);
    xhr.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr.onreadystatechange = loadBookLastMonth;
    xhr.send();
}
function loadBookLastMonth() {
    if (xhr.readyState == 4 && xhr.status == 200) {
        var result = JSON.parse(xhr.responseText);
        var relist = result.modelList;
        var shulie = document.getElementById("shulie");
        shulie.innerHTML = "";
        for (var i = 0; i < relist.length; i++) {
            shulie.innerHTML += ('<div class="shu"><div class="zuo"><a id="bd" href="#" name="' + relist[i].bookId +
                '" onclick="getDetail(this)"><img src="' + relist[i].bookImg + '"></a></div><div class="you">' +
                '<span class="sqone"><a href="#" name="' + relist[i].bookId + '" onclick="getDetail(this)">' +
                relist[i].bookName + '</a></span><span class="jia">¥</span><span class="jia">' +
                relist[i].bookSellingPrice + '</span><span class="jiaxian">¥</span><span class="jiaxian">' +
                relist[i].bookMarkedPrice + '</span><span class="che"><a id="gw" href="javascript:checklogin()">' +
                '加入购物车</a></span></div></div>');
        }
        var su = sessionStorage.getItem("login");
        if (su != "success") {
            var df = document.getElementById("gw");
            df.disabled = true;
        }
        var fenye = document.getElementById("fenye");
        fenye.innerHTML = "";
        if(result.currentPageCode != result.totalPages){
            var url_next_page = url_getbooklastmonth + "?page=" + (result.currentPageCode + 1);
            var href = 'javascript:getLastMonth("' + url_next_page + '")';
            var nextPageEle = "<span class='ye'><a href='" + href + "'>下一页</a> </span>";
            fenye.innerHTML += nextPageEle;
        }
        var currentPageEle = "<span class='ma'>" + result.currentPageCode + "</span>";
        fenye.innerHTML += currentPageEle;
        if(result.currentPageCode != 1){
            var url_pre_page = url_getbooklastmonth + "?page=" + (result.currentPageCode - 1);
            var href = 'javascript:getLastMonth("' + url_pre_page + '")';
            var prePageEle = "<span class='ye'><a href='" + href + "'>上一页</a> </span>";
            fenye.innerHTML += prePageEle;
        }
    }
}
var ugbc = null;
//单一类别按总销量降序显示图书
function getLastMonthCategory(pro) {
    ugbc = pro;
    if(window.XMLHttpRequest){
        xhr = new XMLHttpRequest();
    }else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET",ugbc,true);
    xhr.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr.onreadystatechange = loadBookLastMonthCategory;
    xhr.send();
}
function loadBookLastMonthCategory() {
    console.log(xhr.responseText);
    if (xhr.readyState == 4 && xhr.status == 200) {
        var result = JSON.parse(xhr.responseText);
        var relist = result.modelList;
        var shulie = document.getElementById("shulie");
        shulie.innerHTML = "";
        for (var i = 0; i < relist.length; i++) {
            shulie.innerHTML += ('<div class="shu"><div class="zuo"><a id="bd" href="#" name="' + relist[i].bookId +
                '" onclick="getDetail(this)"><img src="' + relist[i].bookImg + '"></a></div><div class="you">' +
                '<span class="sqone"><a href="#" name="' + relist[i].bookId + '" onclick="getDetail(this)">' +
                relist[i].bookName + '</a></span><span class="jia">¥</span><span class="jia">' +
                relist[i].bookSellingPrice + '</span><span class="jiaxian">¥</span><span class="jiaxian">' +
                relist[i].bookMarkedPrice + '</span><span class="che"><a id="gw" href="javascript:checklogin()">' +
                '加入购物车</a></span></div></div>');
        }
        var su = sessionStorage.getItem("login");
        if (su != "success") {
            var df = document.getElementById("gw");
            df.disabled = true;
        }
        var fenye = document.getElementById("fenye");
        fenye.innerHTML = "";
        if(result.currentPageCode != result.totalPages){
            var url_next_page = ugbc + "&page=" + (result.currentPageCode + 1);
            alert(url_next_page);
            var href = 'javascript:getLastMonthCategory("' + url_next_page + '")';
            var nextPageEle = "<span class='ye'><a href='" + href + "'>下一页</a> </span>";
            fenye.innerHTML += nextPageEle;
        }
        var currentPageEle = "<span class='ma'>" + result.currentPageCode + "</span>";
        fenye.innerHTML += currentPageEle;
        if(result.currentPageCode != 1){
            var url_pre_page = ugbc + "&page=" + (result.currentPageCode - 1);
            var href = 'javascript:getLastMonthCategory("' + url_pre_page + '")';
            var prePageEle = "<span class='ye'><a href='" + href + "'>上一页</a> </span>";
            fenye.innerHTML += prePageEle;
        }
    }
}
//跳转到图书详情
function getDetail(pro) {
    window.location = "bookdetail?bookId=" + pro.name;
}