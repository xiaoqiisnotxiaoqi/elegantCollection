var xhr = null;
var allUrl = null;
onload = function getFirstPage() {
    refreshByPage(1);
}


function refreshData(url) {
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
    }

    if (xhr != null) {
        xhr.open("GET", url, true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
        xhr.onreadystatechange = getDate;
        xhr.send();
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }
};

function refreshByPage(currentPageCode) {
    allUrl = null;
    allUrl = "/order/queryAll?currentPageCode=" + currentPageCode;
    refreshData(allUrl)
}

function getDate() {
    if (xhr.readyState === 4 && xhr.status === 200) {
        var orderDate = document.getElementById("order-date");
        var orderPage = document.getElementById("order-page")
        orderDate.innerHTML = "";
        orderPage.innerHTML = "";
        getTime();
        var jsonText = JSON.parse(xhr.responseText);
        var orderList = jsonText.modelList;
        for (var i = 0; i < orderList.length; i++) {
            orderDate.innerHTML += "<tr>\n" +
                "    <td class=\"td-segmentation\" colspan=\"6\">\n" +
                "        <div class=\"block-segmentation\"></div>\n" +
                "    </td>\n" +
                "    </tr>\n" +
                "<tr>\n" +
                "    <td class=\"order-introduction\" colspan=\"6\">\n" +
                "    <span id=\"order-time\">\n" +
                "        " + dataConversion(orderList[i].shopOrder.orderCreateTime) + "\n" +
                "    </span>\n" +
                "        <span id=\"order-number\">\n" +
                "        " + orderList[i].shopOrder.orderNumber +
                "    </span>\n" +
                "        <span>\n" +
                "            <a class=\"waiter-link\" href=\"#\"><img src=\"../images/waiter-icon.png\">（客服）</a>\n" +
                "    </span>\n" +
                "    </td>\n" +
                "</tr>\n"
            var orderDetailList = orderList[i].shopOrderDetailList;
            for (var j = 0; j < orderDetailList.length; j++) {
                var bookNumber = orderDetailList[j].quality;
                orderDate.innerHTML +=
                    "<tr class=\"order-item\">\n" +
                    "    <td>\n" +
                    "        <div class=\"book-img\">\n" +
                    "            <img src=\"" + orderDetailList[j].bookImg + "\">\n" +
                    "        </div>\n" +
                    "    </td>\n" +
                    "\n" +
                    "    <td>\n" +
                    "        <div class=\"book-msg\">" + orderDetailList[j].bookName + "</div>\n" +
                    "        <div class=\"book-number\">" + 'x' + bookNumber + "</div>\n" + "</td>\n" +
                    "            <td>" + (j == 0 ?
                    "        <div class=\"consignee-tooltip\">" + orderList[i].consigneeName + "</div>\n" +
                    "    </td>\n" +
                    "    <td>\n" +
                    "        <div>\n" +
                    "            " + orderDetailList[j].bookSellingPrice * orderDetailList[j].quality + "\n" +
                    "        </div>\n" +
                    "        <div>\n" +
                    "            在线支付\n" +
                    "        </div>\n" +
                    "    </td>\n" +
                    "    <td>\n" +
                    "        <div>" + StatusJudge(orderList[i].shopOrder.orderStatus) + "</div>\n" +
                    "        <div><a href=\"www.baidu.com\">订单详情</a></div>\n" +
                    "    </td>\n" +
                    "    <td>\n" +
                    "        <a class=\"order-operate\" href=\"#\" onclick=\"remove(" + orderList[i].shopOrder.orderId + ")\">删除</a>\n" +
                    "    </td>\n" : "<td colspan=\"4\"></td>") +
                    "</tr>\n" +
                    "<tr></tr>\n" +
                    "\n";
            }
        }
        var previousNumber = jsonText.currentPageCode - 1;
        var nextNumber = jsonText.currentPageCode + 1;
        orderPage.innerHTML = "<tr>\n" +
            "            <td colspan=\"6\">\n" +
            "                <div class=\"page-information\">\n" +
            (jsonText.currentPageCode != jsonText.totalPages ? "<a href=\"#\" onclick=\"refreshByPage(" + jsonText.totalPages + ")\">尾页</a>\n" : "<a href=\"#\">尾页</a>\n") +
            (jsonText.currentPageCode != jsonText.totalPages ? "<a href=\"#\" onclick=\"refreshByPage(" + nextNumber + ")\">下一页</a>\n" : "<a href=\"#\">下一页</a>\n") +
            "                    <span class=\"page-code\">" + jsonText.currentPageCode + "</span>\n" +
            (jsonText.currentPageCode != 1 ? "<a href=\"#\" onclick=\"refreshByPage(" + previousNumber + ")\">上一页</a>\n" : "<a href=\"#\">上一页</a>\n") +
            (jsonText.currentPageCode != 1 ? "<a href=\"#\" onclick=\"refreshByPage(1)\">首页</a>\n" : "<a href=\"#\">首页</a>\n") +
            "                    <span>总页数</span>\n" +
            "               <span>" + jsonText.totalPages + "</span>\n" +
            "                </div>\n" +
            "            </td>\n" +
            "        </tr>"
    } else {
        // alert("xhr.readyState = " + xhr.readyState + ", xhr.status =  " + xhr.status)
    }
}


function refreshData4State(url) {
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
    }

    if (xhr != null) {
        xhr.open("GET", url, true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
        xhr.onreadystatechange = getDate4State;
        xhr.send();
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }
}

function refreshByState(orderStatus, timeState, currentPageCode) {
    allUrl = null;
    allUrl = "/order/queryByState?orderStatus=" + orderStatus + "&timeState=" + timeState + "&currentPageCode=" + currentPageCode;
    refreshData4State(allUrl)
}

function getDate4State() {
    if (xhr.readyState == 4 && xhr.status == 200) {
        var orderDate = document.getElementById("order-date");
        var orderPage = document.getElementById("order-page")
        orderDate.innerHTML = "";
        orderPage.innerHTML = "";
        var jsonText = JSON.parse(xhr.responseText);
        var orderList = jsonText.modelList;
        for (var i = 0; i < orderList.length; i++) {
            orderDate.innerHTML += "<tr>\n" +
                "    <td class=\"td-segmentation\" colspan=\"6\">\n" +
                "        <div class=\"block-segmentation\"></div>\n" +
                "    </td>\n" +
                "    </tr>\n" +
                "<tr>\n" +
                "    <td class=\"order-introduction\" colspan=\"6\">\n" +
                "    <span id=\"order-time\">\n" +
                "        " + dataConversion(orderList[i].shopOrder.orderCreateTime) + "\n" +
                "    </span>\n" +
                "        <span id=\"order-number\">\n" +
                "        " + orderList[i].shopOrder.orderNumber + "(订单号)\n" +
                "    </span>\n" +
                "        <span>\n" +
                "            <a class=\"waiter-link\" href=\"#\"><img src=\"../images/waiter-icon.png\">（客服）</a>\n" +
                "    </span>\n" +
                "    </td>\n" +
                "</tr>\n"
            var orderDetailList = orderList[i].shopOrderDetailList;
            for (var j = 0; j < orderDetailList.length; j++) {
                var bookNumber = orderDetailList[j].quality;
                orderDate.innerHTML +=
                    "<tr class=\"order-item\">\n" +
                    "    <td>\n" +
                    "        <div class=\"book-img\">\n" +
                    "            <img src=\"" + orderDetailList[j].bookImg + "\">\n" +
                    "        </div>\n" +
                    "    </td>\n" +
                    "\n" +
                    "    <td>\n" +
                    "        <div class=\"book-msg\">" + orderDetailList[j].bookName + "</div>\n" +
                    "        <div class=\"book-number\">" + 'x' + bookNumber + "</div>\n" +
                    "    </td>\n" +
                    "    <td>\n" + (j == 0 ?
                    "        <div class=\"consignee-tooltip\">" + orderList[i].consigneeName + "</div>\n" +
                    "    </td>\n" +
                    "    <td>\n" +
                    "        <div>\n" +
                    "            " + orderDetailList[j].bookSellingPrice * orderDetailList[j].quality + "\n" +
                    "        </div>\n" +
                    "        <div>\n" +
                    "            在线支付\n" +
                    "        </div>\n" +
                    "    </td>\n" +
                    "    <td>\n" +
                    "        <div>" + StatusJudge(orderList[i].shopOrder.orderStatus) + "</div>\n" +
                    "        <div><a href=\"#\">订单详情</a></div>\n" +
                    "    </td>\n" +
                    "    <td>\n" +
                    "        <a class=\"order-operate\" href=\"#\" onclick=\"remove(" + orderList[i].shopOrder.orderId + ")\">删除</a>\n" +
                    "    </td>\n" : "<td colspan=\"4\"></td>") +
                    "</tr>\n" +
                    "<tr></tr>\n" +
                    "\n";
            }
        }
        var previousNumber = jsonText.currentPageCode - 1;
        var nextNumber = jsonText.currentPageCode + 1;
        var State = orderList[0].shopOrder.orderStatus;
        orderPage.innerHTML = "<tr>\n" +
            "            <td colspan=\"6\">\n" +
            "                <div class=\"page-information\">\n" +
            (jsonText.currentPageCode != jsonText.totalPages ? "<a href=\"#\" onclick=\"refreshByState(" + State + ",0," + jsonText.totalPages + ")\">尾页</a>\n" : "<a href=\"#\">尾页</a>\n") +
            (jsonText.currentPageCode != jsonText.totalPages ? "<a href=\"#\" onclick=\"refreshByState(" + State + ",0," + nextNumber + ")\">下一页</a>\n" : "<a href=\"#\">下一页</a>\n") +
            "                    <span class=\"page-code\">" + jsonText.currentPageCode + "</span>\n" +
            (jsonText.currentPageCode != 1 ? "<a href=\"#\" onclick=\"refreshByState(" + State + ",0," + previousNumber + ")\">上一页</a>\n" : "<a href=\"#\">上一页</a>\n") +
            (jsonText.currentPageCode != 1 ? "<a href=\"#\" onclick=\"refreshByState(" + State + ",0,1)\">首页</a>\n" : "<a href=\"#\">首页</a>\n") +
            "                    <span>总页数</span>\n" +
            "               <span>" + jsonText.totalPages + "</span>\n" +
            "                </div>\n" +
            "            </td>\n" +
            "        </tr>"
    } else {
        // alert("xhr.readyState = " + xhr.readyState + ", xhr.status =  " + xhr.status)
    }
}


function refreshData4Condition(url) {
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
    }

    if (xhr != null) {
        xhr.open("GET", url, true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
        xhr.onreadystatechange = getDate4Condition;
        xhr.send();
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }
}

function refreshByCondition(condition, currentPageCode) {
    allUrl = null;
    allUrl = "/order/queryByCondition?condition=" + condition + "&currentPageCode=" + currentPageCode;
    refreshData4Condition(allUrl)
}

function getDate4Condition() {
    if (xhr.readyState == 4 && xhr.status == 200) {
        var orderDate = document.getElementById("order-date");
        var orderPage = document.getElementById("order-page")
        orderDate.innerHTML = "";
        orderPage.innerHTML = "";
        var jsonText = JSON.parse(xhr.responseText);
        var orderList = jsonText.modelList;
        for (var i = 0; i < orderList.length; i++) {
            orderDate.innerHTML += "<tr>\n" +
                "    <td class=\"td-segmentation\" colspan=\"6\">\n" +
                "        <div class=\"block-segmentation\"></div>\n" +
                "    </td>\n" +
                "    </tr>\n" +
                "<tr>\n" +
                "    <td class=\"order-introduction\" colspan=\"6\">\n" +
                "    <span id=\"order-time\">\n" +
                "        " + dataConversion(orderList[i].shopOrder.orderCreateTime) + "\n" +
                "    </span>\n" +
                "        <span id=\"order-number\">\n" +
                "        " + orderList[i].shopOrder.orderNumber + "(订单号)\n" +
                "    </span>\n" +
                "        <span>\n" +
                "            <a class=\"waiter-link\" href=\"#\"><img src=\"../images/waiter-icon.png\">（客服）</a>\n" +
                "    </span>\n" +
                "    </td>\n" +
                "</tr>\n"
            var orderDetailList = orderList[i].shopOrderDetailList;
            for (var j = 0; j < orderDetailList.length; j++) {
                var bookNumber = orderDetailList[j].quality;
                orderDate.innerHTML +=
                    "<tr class=\"order-item\">\n" +
                    "    <td>\n" +
                    "        <div class=\"book-img\">\n" +
                    "            <img src=\"" + orderDetailList[j].bookImg + "\">\n" +
                    "        </div>\n" +
                    "    </td>\n" +
                    "\n" +
                    "    <td>\n" +
                    "        <div class=\"book-msg\">" + orderDetailList[j].bookName + "</div>\n" +
                    "        <div class=\"book-number\">" + 'x' + bookNumber + "</div>\n" +
                    "    </td>\n" +
                    "    <td>\n" + (j == 0 ?
                    "        <div class=\"consignee-tooltip\">" + orderList[i].consigneeName + "</div>\n" +
                    "    </td>\n" +
                    "    <td>\n" +
                    "        <div>\n" +
                    "            " + orderDetailList[j].bookSellingPrice * orderDetailList[j].quality + "\n" +
                    "        </div>\n" +
                    "        <div>\n" +
                    "            在线支付\n" +
                    "        </div>\n" +
                    "    </td>\n" +
                    "    <td>\n" +
                    "        <div>" + StatusJudge(orderList[i].shopOrder.orderStatus) + "</div>\n" +
                    "        <div><a href=\"#\">订单详情</a></div>\n" +
                    "    </td>\n" +
                    "    <td>\n" +
                    "        <a class=\"order-operate\" href=\"#\" onclick=\"remove(" + orderList[i].shopOrder.orderId + ")\">删除</a>\n" +
                    "    </td>\n" : "<td colspan=\"4\"></td>") +
                    "</tr>\n" +
                    "<tr></tr>\n" +
                    "\n";
            }
        }
        var previousNumber = jsonText.currentPageCode - 1;
        var nextNumber = jsonText.currentPageCode + 1;
        var State = orderList[0].shopOrder.orderStatus;
        orderPage.innerHTML = "<tr>\n" +
            "            <td colspan=\"6\">\n" +
            "                <div class=\"page-information\">\n" +
            (jsonText.currentPageCode != jsonText.totalPages ? "<a href=\"#\" onclick=\"refreshByState(" + State + ",0," + jsonText.totalPages + ")\">尾页</a>\n" : "<a href=\"#\">尾页</a>\n") +
            (jsonText.currentPageCode != jsonText.totalPages ? "<a href=\"#\" onclick=\"refreshByState(" + State + ",0," + nextNumber + ")\">下一页</a>\n" : "<a href=\"#\">下一页</a>\n") +
            "                    <span class=\"page-code\">" + jsonText.currentPageCode + "</span>\n" +
            (jsonText.currentPageCode != 1 ? "<a href=\"#\" onclick=\"refreshByState(" + State + ",0," + previousNumber + ")\">上一页</a>\n" : "<a href=\"#\">上一页</a>\n") +
            (jsonText.currentPageCode != 1 ? "<a href=\"#\" onclick=\"refreshByState(" + State + ",0,1)\">首页</a>\n" : "<a href=\"#\">首页</a>\n") +
            "                    <span>总页数</span>\n" +
            "               <span>" + jsonText.totalPages + "</span>\n" +
            "                </div>\n" +
            "            </td>\n" +
            "        </tr>"
    } else {
        // alert("xhr.readyState = " + xhr.readyState + ", xhr.status =  " + xhr.status)
    }
}


function remove(orderId) {
    allUrl = null;
    allUrl = "order/removeByOrderId?orderId=" + orderId;
    refreshData(allUrl);
    refreshByPage(1);
}

function dataConversion(time) {
    var date = new Date(time);
    Y = date.getFullYear() + '-';
    M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
    D = date.getDate() + ' ';
    h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
    m = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
    s = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
    return (Y + M + D + h + m + s);
}

function StatusJudge(statusCode) {
    var statusMsg;
    if (statusCode == 0)
        statusMsg = '待付款';
    else if (statusCode == 1)
        statusMsg = '待发货';
    else if (statusCode == 2)
        statusMsg = '待收货';
    else if (statusCode == 3)
        statusMsg = '待评价';
    else if (statusCode == 4)
        statusMsg = '已删除'
    return statusMsg;
}


var timeFilter = document.getElementById("order-time-filter");

timeFilter.addEventListener("change", function () {
    var opt = timeFilter.value;
    refreshByState(6, opt, 1);
});

var searchButton = document.getElementById("search-button");
var searchTxt=document.getElementById("search-txt");
searchButton.addEventListener("click", function () {
    refreshByCondition(searchTxt.value,1)
})


function getTime() {
    var date = new Date();
    var Year1 = date.getFullYear() - 1;
    var Year2 = date.getFullYear() - 2;
    var Year3 = date.getFullYear() - 3;
    var Year4 = date.getFullYear() - 4;
    timeFilter.innerHTML = "";
    timeFilter.innerHTML += "<option value='" + 0 + "'>今年内的订单</option>\n" +
        "                    <option value='" + 1 + "'>" + Year1 + "年订单</option>\n" +
        "                    <option value='" + 2 + "'>" + Year2 + "年订单</option>\n" +
        "                    <option value='" + 3 + "'>" + Year3 + "年订单</option>\n" +
        "                    <option value='" + 4 + "'>" + Year4 + "年及之前的订单</option>";
}


