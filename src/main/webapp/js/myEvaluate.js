window.onload = loadEvaluate();

function loadEvaluate() {
    var xhr = null;
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
    }
    var pageCode = 1;
    if (xhr != null) {
        xhr.open("GET", "/getMyEvaluate", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
        xhr.onreadystatechange = callFun;
        xhr.send("pageCode=" + pageCode);
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }

    function callFun() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log(xhr.responseText)
            var jsObj = JSON.parse(xhr.responseText);
            //    渲染页面
            var evaluateul = document.getElementById("evaluateul");
            evaluateul.innerHTML = "";

            var pageModel = jsObj.pageModel;
            var evaluateList = pageModel.modelList;
            var bookList = jsObj.bookList;
            //渲染每一条评论
            for (var i = 0; i < evaluateList.length; i++) {
                var bookimg = null;
                var bookName = null;
                var bookPrice = null;
                for (var j = 0; j < bookList.length; j++) {
                    if (bookList[j].bookId == evaluateList[i].bookId) {
                        bookimg = bookList[j].bookImg;
                        bookName = bookList[j].bookName;
                        bookPrice = bookList[j].bookSellingPrice;

                    }
                }
                evaluateul.innerHTML += "  <li class=\"eval-li\">\n" +
                    "                <div class=\"inner-div\"><img src=" + bookimg + "/></div>\n" +
                    "                <div class=\"inner-div\">\n" +
                    "                    <div class=\"shuming\"> " + bookName + "</div>\n" +
                    "                    <div class=\"price\">¥" + bookPrice + "</div>\n" +
                    "                </div>\n" +
                    "\n" +
                    "                <div class=\"neirong\">\n" +
                    "                    <div class=\"shuming\">" + evaluateList[i].evaluateText + "</div>\n" +
                    "                    <div class=\"price\">[ " + fmtDate(evaluateList[i].evaluateTime) + " ]</div>\n" +
                    "                </div>\n" +
                    "                <div class=\"inner-div\">\n" +
                    "                    <button class=\"btn\">订单详情</button>\n" +
                    "                </div>\n" +
                    "            </li>  ";


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