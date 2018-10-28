var xhr = null;
onload = function refresh(pageCode) {
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
    }

    if (xhr != null) {
        xhr.open("GET", "/book/all", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
        xhr.onreadystatechange = callFun;
        xhr.send("pageCode=" + pageCode.value);
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }
}

function callFun() {
    if (xhr.readyState == 4 && xhr.status == 200) {
        var bookUl = document.getElementById("books-box")
        bookUl.innerHTML = "";
        var jsObj = JSON.parse(xhr.responseText);

        var bookList = jsObj.modelList;
        for (var i = 0; i < bookList.length; i++) {

            bookUl.innerHTML += "<li class=\"book-li\">\n" +
                "            <a class=\"book-pic\" name='" + bookList[i].bookId + "' href='javascript:void(0)' onclick='javascript:toDetail(this)'><img src=\"" + bookList[i].bookImg + "\"/></a>\n" +
                "            <p class=\"book-price\">\n" +
                "                <span class=\"price_n\">¥" + bookList[i].bookSellingPrice + "</span>\n" +
                "                <a style=\"color: #878787;font-size: small\">定价:</a>\n" +
                "                <span class=\"price_r \">¥" + bookList[i].bookMarkedPrice + "</span>\n" +
                "                <span class=\"price_s\">(" + parseFloat(bookList[i].bookSellingPrice * 10 / bookList[i].bookMarkedPrice).toFixed(1) + "折)</span>\n" +
                "            </p>\n" +
                "            <p class=\"name\">\n" +
                "                <a href=\"\" class=\"title\"> " + bookList[i].bookName + "</a>\n" +
                "            </p>\n" +
                "            <p class=\"intro\">\n" +
                "                " + bookList[i].bookIntro + "" +
                "            </p>\n" +
                "            <p class=\"star\">\n" +
                "                <span class=\"level\">\n" +
                "                    <span style=\"width: 100%\"></span>\n" +
                "\n" +
                "                </span>\n" +
                "                <a href=\"\">xxx条评论</a>\n" +
                "            </p>\n" +
                "            <span class=\"new-lable\">\n" +
                "                <span class=\"new-lable1\">正品保障</span>\n" +
                "                <span class=\"new-lable2\">限时特惠</span>\n" +
                "\n" +
                "            </span>\n" +
                "            <!--图片右上角广告-->\n" +
                "            <span class=\"tag_box\">\n" +
                "            </span>\n" +
                "            <div class=\"shop-button\">\n" +
                "                <button class=\"btn-cart\">加入购物车</button>\n" +
                "                <button class=\"btn-cart\">购买</button>\n" +
                "\n" +
                "            </div>\n" +
                "        </li>";
        }
    } else {

    }


}

function toDetail(ele) {
    //alert(ele.name)
    //window.location = "../WEB-INF/jsp/bookdetail.jsp";
    window.location = "bookdetail/?bookId=" + ele.name;
}