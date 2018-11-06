onload = refresh();


function refresh() {
    //获取所有参数

    if (sessionStorage.getItem("keyWord") != null)
        document.getElementById("keyword").name = sessionStorage.getItem("keyWord");
    else
        document.getElementById("keyword").name = '';
    if (sessionStorage.getItem("categoryId") != null)
        document.getElementById("current-category").name = sessionStorage.getItem("categoryId");
    else
        document.getElementById("current-category").name = '';

    // sessionStorage.clear();

    var categoryId = document.getElementById("current-category").name;
    var keyWord = document.getElementById("keyword").name;
    var minPrice = document.getElementById("minPrice").name;
    var maxPrice = document.getElementById("maxPrice").name;
    var bookStatus = document.getElementById("bookStatus").name;
    var bookLanguage = document.getElementById("language").name;
    var orderBy = document.getElementById("orderBy").value;
    var pageCode = document.getElementById("currentPageCode").name;
    var isDiscount = document.getElementById("isDiscount").name;
    var zhekou = document.getElementById("zhekou").name;


    var xhr = null;
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
    }
    else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
    }
    if (xhr != null) {
        var url = "categoryId=" + categoryId + "&keyWord=" + keyWord + "&minPrice=" + minPrice + "&maxPrice=" + maxPrice + "&bookLanguage=" + bookLanguage + "&bookStatus=" + bookStatus + "&orderBy=" + orderBy + "&isDiscount=" + isDiscount + "&zhekou=" + zhekou + "&pageCode=" + pageCode;
        console.log(url)
        xhr.open("GET", "book/test?" + url, true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
        xhr.onreadystatechange = callFun;
        xhr.send();
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }

    function callFun() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log(xhr.responseText);
            var jsObj = JSON.parse(xhr.responseText);
            //渲染子分类列表
            var childCategories = jsObj.data.childCategoryList;
            if (childCategories != null && childCategories.length != 0) {
                document.getElementById("zifenlei").innerHTML = "<span class=\"li-title\">子分类</span>";
                for (var i = 0; i < childCategories.length; i++) {
                    document.getElementById("zifenlei").innerHTML += "<a class=\"li-options\" name=\"" + childCategories[i].categoryId + "\" onclick=\"javascript:clickCategory(this)\">" + childCategories[i].categoryName + "</a>";
                }
            } else {
                //如果当前分类下没有子分类,隐藏子分类的li
                document.getElementById("zifenlei").style.display = "none";
            }

            //渲染图书列表以及分页信息
            var bookUl = document.getElementById("books-box")
            bookUl.innerHTML = "";
            var pageModel = jsObj.data.pageModel;
            var bookList = pageModel.modelList;
            //渲染图书列表
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
                    "                    <img src=\"../images/fivestars.png \" /> \n" +
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
                    "                <button class=\"btn-cart\" onclick=\"  add2Cart(" + bookList[i].bookId + ")\" > 加入购物车 </button>\n" +
                    "                <button class=\"btn-cart\" onclick= \" buyNow(" + bookList[i].bookId + ")\">购买</button>\n" +
                    "\n" +
                    "            </div>\n" +
                    "        </li>";

            }
            //    渲染分页信息
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


        } else {
            console.log("readyState =" + xhr.readyState + "\t status =" + xhr.status);
        }
    }
}

//查看详情
function toDetail(ele) {
    window.location = "bookdetail/?bookId=" + ele.name;
}


//点击子分类
function clickCategory(category) {
    if (category.id == "categoryname") {

        sessionStorage.setItem("categoryId", 10034);
    } else {
        sessionStorage.setItem("categoryId", category.name);
        document.getElementById("categoryname").innerText = "当前分类>" + category.innerText + "";
    }
    refresh();
}

//点击价格区间
function clickPrice(price) {
    // price.style.color = "#ff6666";
    if (price.name == "1") {
        document.getElementById("minPrice").name = '0';
        document.getElementById("maxPrice").name = '9';
    } else if (price.name == "2") {
        document.getElementById("minPrice").name = '9';
        document.getElementById("maxPrice").name = '19';
    } else if (price.name == "3") {
        document.getElementById("minPrice").name = '19';
        document.getElementById("maxPrice").name = '29';
    } else if (price.name == "4") {
        document.getElementById("minPrice").name = '29';
        document.getElementById("maxPrice").name = '49';
    } else if (price.name == "5") {
        document.getElementById("minPrice").name = document.getElementById("mininput").value;
        document.getElementById("maxPrice").name = document.getElementById("maxinput").value;
    }
    else {
        document.getElementById("minPrice").name = '49';
        document.getElementById("maxPrice").name = '';
    }
    refresh();
}

//点击语言
function clickLanguage(ele) {

    document.getElementById("language").name = ele.name;
    refresh();
}

//点击只看有货
function clickStatus(ele) {
    if (document.getElementById("bookStatus").name == '1') {
        document.getElementById("bookStatus").name = "";

    } else {

        document.getElementById("bookStatus").name = '1'
    }
    refresh();
}


//点击分页按钮
function page(ele) {
    if (ele.id == "pageBtn") {
        if (document.getElementById("pageinput").value < document.getElementById("totalPages").innerText)
            document.getElementById("currentPageCode").name = document.getElementById("pageinput").value;
    } else
        document.getElementById("currentPageCode").name = ele.value;
    refresh();
}

//点击排序
function clickOrderBy(ele) {
    if (ele.value == '1')
        document.getElementById("orderBy").value = "book_id";
    else if (ele.value == '2')
        if (document.getElementById("orderBy").value == "book_sales_total")
            document.getElementById("orderBy").value = "book_sales_total desc";
        else
            document.getElementById("orderBy").value = "book_sales_total";
    else if (ele.value == '3')
        if (document.getElementById("orderBy").value == "book_selling_price")
            document.getElementById("orderBy").value = "book_selling_price desc";
        else
            document.getElementById("orderBy").value = "book_selling_price";
    else if (ele.value == '4')
        if (document.getElementById("orderBy").value == "book_time")
            document.getElementById("orderBy").value = "book_time desc";
        else
            document.getElementById("orderBy").value = "book_time";
    refresh();
}

//点击只看优惠
function clickIsDiscount(ele) {
    if (document.getElementById("isDiscount").name == '1') {
        document.getElementById("isDiscount").name = '0';
    } else {
        document.getElementById("isDiscount").name = '1';
    }
    refresh();
}

//点击折扣
function clickZhekou(ele) {
    document.getElementById("zhekou").name = ele.name;
    refresh();
}


// 添加到购物车
function add2Cart(ele) {
    var bookId = ele;
    var count = 1;

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

function buyNow(ele) {
    var bookId = ele;
    var count = 1;

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
