var xhr = null;
var xhr0 = null;
var allUrl = null;
var payPriceValue = 0;
var bookQuantity = 0;
var bookName = "";
var orderItem = document.getElementById("order-item");
onload = function getFirstPage() {
    refresh();
}
alterOrder();

function alterOrder() {
    var url = "/order/finishOrder"
    if (window.XMLHttpRequest) {
        xhr0 = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
    } else {
        xhr0 = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
    }

    if (xhr0 != null) {
        xhr0.open("GET", url, false);
        xhr0.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
        xhr0.onreadystatechange;
        xhr0.send();
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }
}

function refresh() {
    allUrl = "/order/showOrderDetail";
    refreshData(allUrl);
}

/**
 * 请求订单信息
 * @param url
 */
function refreshData(url) {
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
    }

    if (xhr != null) {
        xhr.open("GET", url, true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
        xhr.cache = false;
        xhr.onreadystatechange = getDate;
        xhr.send();
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }
};

/**
 * 页面渲染
 */
function getDate() {
    if (xhr.readyState === 4 && xhr.status === 200) {
        var orderNumber = document.getElementById("order-number");
        var orderState = document.getElementById("order-state");
        var icons = document.getElementsByClassName("icon");
        var segmentation = document.getElementsByClassName("order-state-segmentation");
        var orderImg = document.getElementById("order-img");
        var orderPostWay = document.getElementById("order-post-way");
        var consigneeName = document.getElementById("consignee-name");
        var addressDetail = document.getElementById("address-detail");
        var consigneePhone = document.getElementById("consignee-phone");
        var payTime = document.getElementById("pay-time");
        var totalPrice = document.getElementById("total-price");
        var payPrice = document.getElementById("pay-price");
        var discountAmount = document.getElementById("discount-amount");

        var bookAllInfos = document.getElementById("book-all-infos");

        var jsonText = JSON.parse(xhr.responseText);
        var shopOrder = jsonText.shopOrder;
        var address = jsonText.address;
        orderNumber.innerHTML = shopOrder.orderNumber;
        var orderStateCode = shopOrder.orderStatus;
        orderState.innerHTML = StatusJudge(orderStateCode);
        for (var i = orderStateCode + 1; i < 5; i++) {
            var iconSrc = icons[i].src;
            icons[i].src = iconSrc.replace("-b", "-a");
        }
        for (var i = orderStateCode; i < 4; i++) {
            var segmentationSrc = segmentation[i].src;
            segmentation[i].src = segmentationSrc.replace("-b", "-a");
        }

        var shopOrderDetailList = jsonText.shopOrderDetailList;
        var orderImgSource = shopOrderDetailList[0].bookImg;
        orderImg.src = ".." + orderImgSource;
        orderPostWay.innerHTML = "普通快递";
        consigneeName.innerHTML = address.consigneeName;
        addressDetail.innerHTML = address.province + " " + address.city + " " + address.district + " " + address.addressDetail;
        consigneePhone.innerHTML = address.consigneePhone;
        payTime.innerHTML = dataConversion(shopOrder.paymentTime);
        totalPrice.innerHTML = shopOrder.orderPrice;
        payPriceValue = shopOrder.orderPrice - shopOrder.discountAmount;
        payPrice.innerHTML = payPriceValue;
        discountAmount.innerHTML = shopOrder.discountAmount;
        for (var i = 0; i < shopOrderDetailList.length; i++) {
            bookAllInfos.innerHTML += "<div class=\"book-all-info\">\n" +
                "                <div class=\"book-tip\"><a href=\"#\" onclick='javascript:toDetail(" + shopOrderDetailList[i].bookId + ")'><img src=" + shopOrderDetailList[i].bookImg + "></a></div>\n" +
                "                <div class=\"book-information\">" + shopOrderDetailList[i].bookId + "</div>\n" +
                "                <div class=\"book-information\">" + shopOrderDetailList[i].bookSellingPrice + "</div>\n" +
                "                <div class=\"book-information\">" + shopOrderDetailList[i].quality + "</div>\n" +
                "            </div>"
            bookQuantity += shopOrderDetailList[i].quality;
            bookName += shopOrderDetailList[i].bookName + "    ";
        }
        if (orderStateCode == 0) {
            orderItem.innerHTML = "<a href=\"#\" class=\"wait4pay\" onclick=\"pay(" + shopOrder.orderId + ")\">等待支付</a>";
        }

        var courierCompanyId = shopOrder.courierCompanyId;
        var logisticsId = shopOrder.logisticsId;

        allUrl = null;
        allUrl = "/order/getTransport?no=" + logisticsId + "&com=" + courierCompanyId;
        refreshTransport(allUrl);
    }
    else {
        // alert("xhr.readyState = " + xhr.readyState + ", xhr.status =  " + xhr.status)
    }
}

/**
 * 物流信息获取
 * @param url
 */
function refreshTransport(url) {
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
    }
    if (xhr != null) {
        xhr.open("GET", url, true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
        xhr.onreadystatechange = getTranport;
        xhr.send();
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }
}

function getTranport() {
    if (xhr.readyState === 4 && xhr.status === 200) {
        var jsonText = JSON.parse(xhr.responseText);
        var result = jsonText.result;
        var list = result.list;

        var courierCompany = document.getElementById("courier_company");
        courierCompany.innerText = result.company;
        var orderTransportShow = document.getElementById("order-transport-show");
        for (var i = 0; i < list.length; i++) {
            orderTransportShow.innerHTML += " <div class=\"transport-item\">\n" +
                "            <span class=\"transport-time\">" + list[i].datetime + "</span>\n" +
                "            <span class=\"transport-context\">" + list[i].remark + "</span>\n" +
                "        </div>";
        }
    } else {
        //alert("xhr1.readyState = " + xhr.readyState + ", xhr1.status =  " + xhr.status)
    }
}

//查询图书详情
function toDetail(bookId) {
    window.location = "bookdetail/?bookId=" + bookId;
}

/**
 * 状态判断
 * @param statusCode 状态码
 * @returns {*} 状态信息
 * @constructor
 */
function StatusJudge(statusCode) {
    var statusMsg;
    if (statusCode == 0)
        statusMsg = '待付款';
    else if (statusCode == 1)
        statusMsg = '待发货';
    else if (statusCode == 2)
        statusMsg = '待收货';
    else if (statusCode == 3)
        statusMsg = '已完成';
    else if (statusCode == 4)
        statusMsg = '已删除'
    return statusMsg;
}

/**
 * 时间转换
 * @param time
 * @returns {*}
 */
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

function pay(orderId) {
    window.location="order/pay?payPriceValue=" + payPriceValue + "&bookQuantity=" + bookQuantity + "&bookName=" + bookName + "&orderId=" + orderId;
}