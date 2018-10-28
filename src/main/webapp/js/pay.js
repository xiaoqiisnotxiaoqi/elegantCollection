var xhr=null;
var xhr0=null;
var addressId = null;
var addressOptions = document.getElementById("address-options");

var transport = document.getElementById("transport");
var orderSimpleInfo = document.getElementById("order-simple-info");
var totalPrice = document.getElementById("total-price");
var discountPrice = document.getElementById("discount-price");
var payPrice = document.getElementById("pay-price");
var bookWeight = document.getElementById("book-weight");
var payButton = document.getElementById("pay-button");
onload = function () {
    refreshAddress();
    setTimeout(refreshOther(),500);
//获取并复制动态页面高度
    var style = window.getComputedStyle(orderSimpleInfo, null);
    transport.style.height = style.height;
}


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
            orderSimpleInfo.innerHTML += "<div class=\"block-segmentation2\"></div>\n" +
                "            <div class=\"book-info\">\n" +
                "                <a class=\"book_img\" href=\"#\"><img src=" + theBook.book.bookImg + "></a>\n" +
                "                <a class=\"book-name\" href=\"#\" id=\"book-name\">" + theBook.book.bookName + "</a>\n" +
                "                <span class=\"book-price\">￥ " + theBook.book.bookSellingPrice + "</span>\n" +
                "                <span class=\"book-number\">x " + theBook.bookNumber + "</span>\n" +
                "            </div>";
        }
        var allprice = jsonText.allprice;
        var fullReductionDiscount = jsonText.fullReductionDiscount;
        var groupPrice = jsonText.groupPrice;
        var discountPriceValue = fullReductionDiscount + groupPrice;
        var payPriceValue = allprice - discountPriceValue;
        totalPrice.innerHTML += "￥ " + allprice;
        discountPrice.innerHTML += "￥ " + discountPriceValue;
        payPrice.innerHTML += "￥ " + payPriceValue;
    } else {
        //alert("xhr.readyState = " + xhr.readyState + ", xhr.status =  " + xhr.status)
    }
}


payButton.addEventListener("click", function () {
    //完成订单
})