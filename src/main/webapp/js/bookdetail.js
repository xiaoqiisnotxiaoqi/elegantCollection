window.onload = getDetail()

function getDetail() {
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
            var pageModel = jsObj.evaluatePageModel;
            document.getElementById("book-imgs-box").innerHTML = " ";
            document.getElementById("bookId").value = book.bookId;

            for (var i = 0; i < bookImgList.length; i++) {
                document.getElementById("book-imgs-box").innerHTML += "<div class=\"other-pic\"><img  onmouseover=changePic(this) src=\" " + bookImgList[i].imgAddress + "\"></div>";

            }
            document.getElementById("main-pic-box").innerHTML = "<img src=\"" + book.bookImg + "\"/>"
            document.getElementById("name-info").innerHTML = "<h2>" + book.bookName + "</h2>";
            if (jsObj.author != null) {
                document.getElementById("zuozhe").innerText = jsObj.author.authorIntro;
                document.getElementById("author").innerHTML = "作者:<a href=\"/author/?authorId=" + jsObj.author.authorId + "\">" + jsObj.author.authorName + "</a> ";
            }
            document.getElementById("chubanshe").innerText = "出版社:" + book.publishingName + "";
            document.getElementById("publish-time").innerText = "出版时间:" + fmtDate(book.bookTime) + "";
            document.getElementById("pinglunshu").innerHTML = " <a href=\"\">" + jsObj.evaluatePageModel.totalRecord + "</a>条评论";
            document.getElementById("sale-price").innerText = " " + book.bookSellingPrice + "";
            document.getElementById("mark-price").innerText = " " + book.bookMarkedPrice + "";
            document.getElementById("discount").innerText = "(" + parseFloat(book.bookSellingPrice * 10 / book.bookMarkedPrice).toFixed(1) + ")折";
            document.getElementById("neirong").innerText = book.bookIntro;
            document.getElementById("postbtn").name = jsObj.blockId;
            document.getElementById("mulu").innerText = book.bookCatalog;
            document.getElementById("jingcai").innerText = book.bookWonderful;
            document.getElementById("meiti").innerText = book.bookMediaEvaluation;
            document.getElementById("isbn").innerText = book.bookIsbn;
            document.getElementById("kaiben").innerText = book.bookSize;
            document.getElementById("baozhuang").innerText = book.bookPacking;


            document.getElementById("nav-bookcategory").innerText = "" + jsObj.mainCategory.categoryName + "";
            document.getElementById("info-cateName").innerText = "" + jsObj.mainCategory.categoryName + "";

            document.getElementById("detail-category").innerText = "" + jsObj.mainCategory.categoryName + "";
            document.getElementById("nav-bookname").innerText = book.bookName;


            //渲染满减优惠
            if (jsObj.manjian == null) {
                document.getElementById("manjian").style.display = "none";
            } else
                document.getElementById("manjian-money").innerHTML = "满" + jsObj.manjian.more1 + "元立减" + jsObj.manjian.discountMoney + "元";

            //渲染组合优惠
            if (jsObj.zuheBooks == null || jsObj.zuheBooks == "") {
                document.getElementById("zuhe").style.display = "none";
            } else {
                var zuhebooks = jsObj.zuheBooks;
                document.getElementById("zuhe-box").innerHTML = "";
                for (var i = 0; i < 3; i++) {
                    document.getElementById("zuhe-box").innerHTML += "<div class=\"zuhe-detail\">\n" +
                        "                                <a href=\"/bookdetail/?bookId=" + zuhebooks[i].bookId + "\">\n" +
                        "                                    <div class=\"zuhe-picbox\"><img src=\"" + zuhebooks[i].bookImg + "\"/> </div>\n" +
                        "                                    <span class=\"zuhe-info\">" + zuhebooks[i].bookName + "</span>\n" +
                        "                                </a>\n" +
                        "                                <span class=\"zuhe-price\">¥" + zuhebooks[i].bookSellingPrice + "</span>\n" +
                        "                            </div>";
                }

            }
            //    渲染所有评论
            var evaluateList = pageModel.modelList;
            var customers = jsObj.evaluateCustomers;
            document.getElementById("pingjia-ul").innerHTML = "";
            for (var i = 0; i < evaluateList.length; i++) {
                document.getElementById("pingjia-ul").innerHTML += "           <li class=\"pingjias\">\n" +
                    "                    <div class=\"customerInfo\">\n" +
                    "                        <img src=\" " + customers[i].custProfile + "  \" class=\"profile\"/>\n" +
                    "                        <span class=\"evaluater\" >" + customers[i].custName + "</span>\n" +
                    "                    </div>\n" +
                    "                    <div class=\"evaldiv\">\n" +
                    "                        <p>\n" +
                    "                            " + evaluateList[i].evaluateText + "</p>\n" +
                    "                    </div>\n" +
                    "                    <div class=\"eval-score\">\n" +
                    "                        <span class=\"score\">" + evaluateList[i].describeScore + ".0</span>\n" +
                    "                        <span class=\"evaluatetime\">" + fmtDate(evaluateList[i].evaluateTime) + "</span>\n" +
                    "                    </div>\n" +
                    "                </li>";
            }


            //    渲染评论分页信息
            document.getElementById("last").value = pageModel.totalPages;
            document.getElementById("currentPage").innerText = pageModel.currentPageCode;
            document.getElementById("shangye").value = pageModel.currentPageCode - 1;
            if (pageModel.currentPageCode != pageModel.totalPages)
                document.getElementById("xiaye").value = pageModel.currentPageCode + 1;
            else
                document.getElementById("xiaye").value = pageModel.currentPageCode;
            document.getElementById("totalPages").innerText = pageModel.totalPages;
            document.getElementById("totalRecord").innerText = pageModel.totalRecord;
            document.getElementById("pageSize").innerText = pageModel.pageSize;
        }
    }
}

//数量加减
function add() {
    document.getElementById("booknum").value++;
}

function minus() {
    if (document.getElementById("booknum").value > 0)
        document.getElementById("booknum").value--;
}


//格式化日期
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

//切换评价和详情
function detailorpingjia(ele) {


    if (ele.id == "detailBtn") {
        document.getElementById("detailbox").style.display = "block";
        document.getElementById("pingjiabox").style.display = "none";
    } else {
        document.getElementById("detailbox").style.display = "none";
        document.getElementById("pingjiabox").style.display = "block";
    }
}

//点击分页按钮
function page(ele) {
    if (ele.id == "pageBtn") {
        if (document.getElementById("pageinput").value < document.getElementById("totalPages").innerText)
            document.getElementById("currentPageCode").name = document.getElementById("pageinput").value;
    } else
        document.getElementById("currentPageCode").name = ele.value

    getDetail();
}

// 添加到购物车
function add2Cart(btn) {
    var bookId = document.getElementById("bookId").value;
    var count = document.getElementById("booknum").value;

    var xhr1 = null;
    if (window.XMLHttpRequest) {
        xhr1 = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
    } else {
        xhr1 = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
    }
    if (xhr1 != null) {
        var url = "?bookId=" + bookId + "&count=" + count

        xhr1.open("GET", "/book/add2Cart" + url, true);
        xhr1.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
        xhr1.onreadystatechange = add2CartResp;
        xhr1.send();
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }

    function add2CartResp() {
        if (xhr1.readyState == 4 && xhr1.status == 200) {
            var jsObj = JSON.parse(xhr1.responseText);
            alert(jsObj.msg);
        }
    }
}

function buyNow() {
    var bookId = document.getElementById("bookId").value;
    var count = document.getElementById("booknum").value;

    var xhr1 = null;
    if (window.XMLHttpRequest) {
        xhr1 = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
    } else {
        xhr1 = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
    }
    if (xhr1 != null) {
        var url = "?bookId=" + bookId + "&count=" + count

        xhr1.open("GET", "/book/add2Cart" + url, true);
        xhr1.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
        xhr1.onreadystatechange = buyResp;
        xhr1.send();
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }

    function buyResp() {
        if (xhr1.readyState == 4 && xhr1.status == 200) {
            window.location = "/custCart";
        }
    }
}

function gotoPost(ele) {
    window.location = "/post/?blockId=" + ele.name;
}
