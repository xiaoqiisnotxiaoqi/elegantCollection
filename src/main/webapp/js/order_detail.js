var xhr = null;
var allUrl = null;
onload = function getFirstPage() {
    refresh();
}

function refresh() {
    allUrl = "/order/showOrderDetail";
    refreshData(allUrl);
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
        xhr.cache = false;
        xhr.onreadystatechange = getDate;
        xhr.send();
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }
};

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

        var bookAllInfo = document.getElementById("book-all-info");

        var jsonText = JSON.parse(xhr.responseText);
        var shopOrder = jsonText.shopOrder;
        var address = jsonText.address;
        orderNumber.innerHTML = shopOrder.orderNumber;
        var orderStateCode = shopOrder.orderStatus
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
        var payPrice = shopOrder.orderPrice - shopOrder.discountAmount;
        payPrice.innerHTML = shopOrder.payPrice;
        discountAmount.innerHTML = shopOrder.discountAmount;

        for (var i = 0; i < shopOrderDetailList.length; i++) {
            bookAllInfo.innerHTML += " <div class=\"book-tip\"><a href=\"#\"><img src=" + shopOrderDetailList[i].bookImg + "></a></div>\n" +
                "        <div class=\"book-information\">" + shopOrderDetailList[i].bookId + "</div>\n" +
                "        <div class=\"book-information\">" + shopOrderDetailList[i].bookSellingPrice + "</div>\n" +
                "        <div class=\"book-information\">" + shopOrderDetailList[i].quality + "</div>"
        }


        var courierCompanyId = shopOrder.courierCompanyId;
        var logisticsId = shopOrder.logisticsId;

        allUrl = null;
        allUrl = "/order/getTransport?no=" + logisticsId + "&com=" + courierCompanyId;
        //refreshTransport(allUrl);
    }
    else {
        // alert("xhr.readyState = " + xhr.readyState + ", xhr.status =  " + xhr.status)
    }
}

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