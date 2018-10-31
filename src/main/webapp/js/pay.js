var xhr = null;
var xhr0 = null;
//订单id
var orderId;
//地址id
var addressId;
//期望到达时间
var expectationTime;
//总价
var allprice;
//满减优惠
var fullReductionDiscount;
//组合优惠
var groupPrice;
//总折扣=满减优惠+组合优惠
var discountPriceValue;
//应支付价格
var payPriceValue;
//订单编号
var orderNumber;
//图书数量
var bookQuantity = 0;
//图书名称
var bookName = "";
//地址信息
var addressOptions = document.getElementById("address-options");
//期待到达时间
var transportDate = document.getElementById("transport-date");
//物流信息框
var transport = document.getElementById("transport");
//订单简略信息
var orderSimpleInfo = document.getElementById("order-simple-info");
//总价
var totalPrice = document.getElementById("total-price");
//折扣
var discountPrice = document.getElementById("discount-price");
//实际支付价格
var payPrice = document.getElementById("pay-price");
//图书重量
var bookWeight = document.getElementById("book-weight");
//支付按钮
var payButton = document.getElementById("pay-button");
//支付方式
var paymentOption = document.getElementById("payment-option");
paymentOption.addEventListener("click", function () {
    this.style.color = "red";
})
onload = function () {
    refreshAddress();
    refreshOther();
//获取并复制动态页面高度
    var style = window.getComputedStyle(orderSimpleInfo, null);
    transport.style.height = style.height;
}

/**
 * 刷新地址
 */
function refreshAddress() {
    allUrl = "/order/getAddress";
    refreshAddressData(allUrl);
}

function refreshAddressData(url) {
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
    }

    if (xhr != null) {
        xhr.open("GET", url, true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
        xhr.cache = false;
        xhr.onreadystatechange = getAddressDate;
        xhr.send();
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }
};

function getAddressDate() {
    if (xhr.readyState === 4 && xhr.status === 200) {
        var jsonText = JSON.parse(xhr.responseText);
        var addressList = jsonText;
        for (var i = 0; i < addressList.length; i++) {
            var consigneePhone = addressList[i].consigneePhone;
            consigneePhone = consigneePhone.substr(0, 3) + "****" + consigneePhone.substr(7, 4);
            addressOptions.innerHTML += "<li>\n" + "<p hidden>" + addressList[i].addressId + "</p>" +
                "                <div class=\"address-option\">" + addressList[i].consigneeName + "</div>\n" +
                "                <span class=\"address-detail\">" + addressList[i].consigneeName + "   " + addressList[i].province + "   " + addressList[i].city + "   " + addressList[i].district + "   " + addressList[i].addressDetail + "   " + consigneePhone + "</span></li>\n" +
                "            ";
        }
        bookWeight.innerText = "总重量：" + Math.floor(Math.random() * 10) + "kg"
        var addressOption = document.getElementsByClassName("address-option");
        //地址选项改变样式并取地址的值
        for (var i = 0; i < addressOption.length; i++)
            addressOption[i].addEventListener("click", function () {
                addressId = this.parentNode.childNodes[1].innerHTML;
                removeOther();
                this.style.color = "red";
            });

        function removeOther() {
            for (var i = 0; i < addressOption.length; i++)
                addressOption[i].style.color = "black";
        }
    } else {
        // alert("xhr.readyState = " + xhr.readyState + ", xhr.status =  " + xhr.status)
    }

}

/**
 * 订单提交
 */
function refreshOther() {
    allUrl = "/order/add";
    refreshOtherData(allUrl);
}

function refreshOtherData(url) {
    if (window.XMLHttpRequest) {
        xhr0 = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
    } else {
        xhr0 = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
    }

    if (xhr0 != null) {
        xhr0.open("GET", url, true);
        xhr0.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
        xhr0.onreadystatechange = getOtherData;
        xhr0.send();
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }
};

function getOtherData() {
    if (xhr0.readyState === 4 && xhr0.status === 200) {
        var jsonText = JSON.parse(xhr0.responseText);
        var bookList = jsonText.bookList;
        for (var i = 0; i < bookList.length; i++) {
            var theBook = bookList[i];
            bookQuantity += theBook.bookNumber;
            bookName += theBook.book.bookName + "    ";
            orderSimpleInfo.innerHTML += "<div class=\"block-segmentation2\"></div>\n" +
                "            <div class=\"book-info\">\n" +
                "                <a class=\"book_img\" href=\"#\" onclick=\"javascript:toDetail(" + theBook.book.bookId + ")\"><img src=" + theBook.book.bookImg + "></a>\n" +
                "                <a class=\"book-name\" href=\"#\">" + theBook.book.bookName + "</a>\n" +
                "                <span class=\"book-price\">￥" + theBook.book.bookSellingPrice + "</span>\n" +
                "                <span class=\"book-number\">x" + theBook.bookNumber + "</span>\n" +
                "            </div>";
        }
        orderId = jsonText.orderId;
        allprice = jsonText.allprice;
        fullReductionDiscount = jsonText.fullReductionDiscount;
        groupPrice = jsonText.groupPrice;
        orderNumber = jsonText.orderNumber;

        discountPriceValue = fullReductionDiscount + groupPrice;
        payPriceValue = allprice - discountPriceValue;
        totalPrice.innerHTML += "￥ " + allprice;
        discountPrice.innerHTML += "￥ " + discountPriceValue;
        payPrice.innerHTML += "￥ " + payPriceValue;
    } else {
        //alert("xhr.readyState = " + xhr.readyState + ", xhr.status =  " + xhr.status)
    }
}

transportDate.addEventListener("change", function () {
        expectationTime = this.value;
    }
)

//完成订单
payButton.addEventListener("click", toPay);

/**
 * 订单完善
 */
function toPay() {
    window.location = "/order/pay?orderNumber=" + orderNumber + "&payPriceValue=" + payPriceValue + "&bookQuantity=" + bookQuantity + "&bookName=" + bookName + "&orderId=" + orderId + "&addressId=" + addressId + "&expectationTime=" + expectationTime + "&discountPriceValue=" + discountPriceValue;

}


//查询图书详情
function toDetail(bookId) {
    window.location = "bookdetail/?bookId=" + bookId;
}
