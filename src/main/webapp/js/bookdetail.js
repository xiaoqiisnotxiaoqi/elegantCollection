window.onload = function getDetail() {
    var xhr = null;
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
    }

    if (xhr != null) {
        xhr.open("GET", "/book/detail", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
        xhr.onreadystatechange = callFun;
        xhr.send();
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }

    function callFun() {
        if (xhr.readyState == 4 && xhr.status == 200) {

            window.console.log(xhr.responseText);
            var jsObj = JSON.parse(xhr.responseText);
            //    渲染页面
            var book = jsObj.book;
            var bookImgList = jsObj.bookImgList;
            document.getElementById("book-imgs-box").innerHTML = " ";
            for (var i = 0; i < bookImgList.length; i++) {
                document.getElementById("book-imgs-box").innerHTML += "<div class=\"other-pic\"><img  onmouseover=changePic(this) src=\" " + bookImgList[i].imgAddress + "\"></div>";

            }
            document.getElementById("main-pic-box").innerHTML = "<img src=\"" + book.bookImg + "\"/>"
            document.getElementById("name-info").innerHTML = "<h2>" + book.bookName + "</h2>";
            document.getElementById("author").innerText = "作者:" + jsObj.author.authorName + " ";
            document.getElementById("chubanshe").innerText = "出版社:" + book.publishingName + "";
            document.getElementById("publish-time").innerText = "出版时间:" + fmtDate(book.bookTime) + "";
            document.getElementById("pinglunshu").innerHTML = " <a href=\"\">" + jsObj.evaluatePageModel.totalRecord + "</a>条评论";
            document.getElementById("sale-price").innerText = " " + book.bookSellingPrice + "";
            document.getElementById("mark-price").innerText = " " + book.bookMarkedPrice + "";
            document.getElementById("discount").innerText = "(" + parseFloat(book.bookSellingPrice * 10 / book.bookMarkedPrice).toFixed(1) + ")折";
            document.getElementById("neirong").innerText = book.bookIntro;
            document.getElementById("zuozhe").innerText=jsObj.author.authorIntro;
            document.getElementById("mulu").innerText=book.bookCatalog;
            document.getElementById("jingcai").innerText=book.bookWonderful;
            document.getElementById("meiti").innerText=book.bookMediaEvaluation;

        }
    }
}

function fmtDate(obj) {
    var date = new Date(obj);
    var y = 1900 + date.getYear();
    var m = "0" + (date.getMonth() + 1);
    var d = "0" + date.getDate();
    return y + "年" + m.substring(m.length - 2, m.length) + "月" + d.substring(d.length - 2, d.length) + "日";
}

//改变展示图片的js
function changePic(ele) {
    document.getElementById("main-pic-box").innerHTML = "<img  src=\"" + ele.src.substring(21) + "\"/>";
}
