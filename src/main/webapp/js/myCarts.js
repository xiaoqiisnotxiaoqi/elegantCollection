/**
 *qinjb 2018-10-14
 */

/**
 * Created by Administrator on 2017/5/24.
 */
var allMoney;
var allBooks;
var orderList;
var books;
var allprice,fullReductionDiscount,groupPrice;

/**
 * 全选与全不选
 */
function checkboxAll() {

    var labelNode = document.getElementsByClassName("son_check");
    var all = document.getElementById("all").nextElementSibling;
    if (all.className === "mark") {
        for (var i = 0; i < labelNode.length; i++) {
            labelNode[i].nextSibling.className = "";
        }
        document.getElementById("settle-account").className = "";
        all.className = "";
    } else {
        for (var i = 0; i < labelNode.length; i++) {
            labelNode[i].nextSibling.className = "mark";
        }
        all.className = "mark";
        document.getElementById("settle-account").className = "btn_sty";
    }
    getAllMoney();
}


/**
 * 得到所有选择的商品的总价格和总件数
 */
function getAllMoney(){
    books = "";
    document.getElementsByClassName("piece_num")[0].innerText = "";
    document.getElementsByClassName("total_text")[0].innerText ="";
    allMoney = 0;
    allBooks = 0;
    var labelNode = document.getElementsByClassName("son_check");
    for (var i = 0; i < labelNode.length; i++){
        if(labelNode[i].nextElementSibling.className === "mark"){
            //得到商品的id
            var bookId = labelNode[i].parentNode.parentNode.getAttribute("id");

            //得到单个商品的数量
            var number = labelNode[i].parentNode.nextSibling.nextSibling.nextSibling.nextSibling.childNodes[0].childNodes[1].value;
            if (i === 0) {
                books += bookId + "=" + number;
            }else{
                books += "&"+ bookId + "=" + number;
            }
            //选择的商品的数量
            allBooks += parseInt(number);

        }
    }
    document.getElementsByClassName("piece_num")[0].innerText = allBooks;
    prices2ceshi();
}

/**
 * 查看是否有选中的商品
 */
function findIsChose(){
    var labelNode = document.getElementsByClassName("son_check");
    for (var i = 0; i < labelNode.length; i++) {
        if(labelNode[i].className === "mark"){
            return  true;
        }
    }
    return false;
}

/**
 * 查看是否有未选中的商品
 * @returns {boolean}
 */
function findIsNotChose() {
    var labelNode = document.getElementsByClassName("son_check");
    for (var i = 0; i < labelNode.length; i++) {
        if(labelNode[i].className !== "mark"){
            return  true;
        }
    }
    return false;
}



/**
 * 单个商品的选择与取消(当有未选择的商品是 全选按钮置为空)
 * @param ele
 */
function oneBox(ele){
    var lab = ele.nextSibling;
    //选择框 为选中状态
    if(lab.className === "mark") {
        document.getElementById("all").nextSibling.className = "";
        lab.className = "";
        if(findIsChose()){
            document.getElementById("settle-account").className = "";
        }
    }else{
        //选择框为 没有选择状态
        if(findIsChose()){
            lab.className = "mark";
        }else{
            lab.className = "mark";
            document.getElementById("settle-account").className = "btn_sty";
        }
    }
    if(findIsNotChose()){
        document.getElementById("all").nextElementSibling.className = "";
    }

    if(! findIsChose){
        //当没有商品选择是 将结算按钮置为不可选择状态
        document.getElementById("settle-account").className = "";
    }
    getAllMoney();
}


/**
 * 增加商品数量 触发事件
 * @param ele
 */
function addNumber(ele) {
    var num = parseInt(ele.previousSibling.value);
    if(num === 1){
        ele.previousSibling.previousSibling.className = "reduce";
    }
    ele.previousSibling.value = num + 1;
    num = ele.previousSibling.value;
    ele.parentNode.parentNode.nextSibling.childNodes[0].innerText = (parseInt(num) * parseFloat(ele.parentNode.parentNode.previousSibling.childNodes[0].innerText.substring(1))).toFixed(2);
    getAllMoney();
}

/**
 * 减少商品数量触发事件
 * @param ele
 */
function reduceNumber(ele){
    var num = parseInt(ele.nextElementSibling.value);
    if(num === 2){
        ele.nextSibling.value = 1;
        ele.className = "reduce reSty";
    }else if(num === 1){
        ele.nextSibling.value = 1;
    }else{
        ele.nextSibling.value = num - 1;
    }
    num = ele.nextSibling.value;
    ele.parentNode.parentNode.nextSibling.childNodes[0].innerText = (parseInt(num) * parseFloat(ele.parentNode.parentNode.previousSibling.childNodes[0].innerText.substring(1))).toFixed(2);
    getAllMoney();
}

/**
 * 点击删除购物车商品是 触发事件,弹出 确认框
 * @param ele
 */
function openDelete(ele){
    orderList = ele.parentNode.parentNode.parentNode;
    var Idiv     = document.getElementById("my_model");
    var Bdiv = document.getElementById("model_bg");
    Bdiv.style.display = "block";
    Idiv.style.display = "block";

    Idiv.style.left=(window.screen.availWidth )/2 + 50 +"px";
    Idiv.style.top =(window.screen.availHeight )/2 - 100 +"px";
}

/**
 * 隐藏遮罩层 以及确认框
 */
function closeThis(){
    var Idiv     = document.getElementById("my_model");
    var Bdiv = document.getElementById("model_bg");
    Bdiv.style.display = "none";
    Idiv.style.display = "none";
}
var xhr;

/**
 * 加载 用户的购物车信息
 */
function toCart(){
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET", "/cart" , true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = cartResolve;
    xhr.send();
}


/**
 * 点击确认删除 像后台传入要删除的图书id
 */
function deleteBook(){
    var bookId = orderList.getAttribute("id")
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("DELETE", "/deleteCustomerCart?bookId="+ bookId , true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = cartResolve;
    xhr.send();
}


/**
 * 跳转页面
 * @param page
 */
function getSpecifiedPageCart(page){
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET", "/cart?currentPageCode="+ page , true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = cartResolve;
    xhr.send();
}


/**
 * 上一页
 */
function previousPage(){
    var thisPage = document.getElementById("this-page").innerText;
    var toPage = parseInt(thisPage) - 1;

    getSpecifiedPageCart(toPage);
}

/**
 * 点击页码跳转页面
 * @param ele
 */
function toThisPageNum(ele){
    var toPage = ele.innerText;
    getSpecifiedPageCart(toPage);
}

/**
 * 点击下一页
 */
function nextPage(){
    var thisPage = document.getElementById("this-page").innerText;
    var toPage = parseInt(thisPage) + 1;
    getSpecifiedPageCart(toPage);
}

/**
 * 输入页面跳转
 */
function sureToJump(){
    var toPage = document.getElementById("input-page").value;
    getSpecifiedPageCart(toPage);
}

/**
 * 解析 购物车 返回的json数据
 */
function cartResolve() {
    closeThis();
        if (xhr.readyState === 4 && xhr.status === 200) {

            var pageModel = JSON.parse(xhr.responseText);
            //页面渲染===> 商品信息
            var cartNode = document.getElementById("input_cart");
            //页面渲染===> 页数
            var page = document.getElementById("page");
            page.innerHTML = "";
            if (pageModel != null) {
                var books = pageModel.modelList;

                cartNode.innerHTML = "";
                if (books != null) {
                    //购物车不为空 渲染购物车图书详情
                    for (var i = 0; i < books.length; i++) {
                        cartNode.innerHTML += ('<ul class="order_lists" id="' + books[i].bookId + '">' +
                            '<li class="list_chk">' +
                            '<input type="checkbox" id="checkbox_' + i + 2 + '" class="son_check" onclick="oneBox(this)">' +
                            '<label for="checkbox_' + i + 2 + '"></label>' +
                            '</li>' +
                            '<li class="list_con">' +
                            '<div class="list_img"><a href="javascript:;"><img src="' + books[i].bookImg + '" alt=""></a></div>' +
                            '<div class="list_text"><a href="javascript:;" onclick="goToThisBook(this)">' + books[i].bookName + '</a></div>' +
                            '</li>' +
                            '<li class="list_info">' +
                            '<p>' + '作者: ' + books[i].authorName + '</p>' +
                            '<p>' + '出版社：' + books[i].publishingName + '</p>' +
                            '</li>' +
                            '<li class="list_price">' +
                            '<p class="price">￥' + books[i].bookPrice + '</p>' +
                            '</li>' +
                            '<li class="list_amount">' +
                            '<div class="amount_box">' +
                            '<a href="javascript:void(0);" onclick="reduceNumber(this)" class="reduce reSty">-</a>' +
                            '<input type="text" value="' + books[i].bookNum + '" class="sum">' +
                            '<a href="javascript:javascript:void(0);" onclick="addNumber(this)" class="plus">+</a>' +
                            '</div>' +
                            '</li>' +
                            '<li class="list_sum">' +
                            '<p class="sum_price">￥' + (books[i].bookPrice * books[i].bookNum).toFixed(2) + '</p>' +
                            '</li>' +
                            '<li class="list_op">' +
                            '<p class="del"><a href="javascript:void (0);" onclick="openDelete(this)" class="delBtn">移除商品</a></p>' +
                            '</li>' +
                            '</ul>');
                    }

                    //渲染页数
                    if (pageModel.totalPages <= 9 && pageModel.totalPages !== 1){
                        //总页数少于十页时,将所有页面全部渲染出来
                        page.innerHTML += ('<span class="adjacent-pages" onclick="previousPage()">〈 上一页</span>');
                        for (var i = 1; i <= pageModel.totalPages;i++) {
                            if (i !=pageModel.currentPageCode ) {
                                page.innerHTML += ('<span class="page-num" onclick="toThisPageNum(this)">'+ i +'</span>');
                            }else{
                                page.innerHTML += ('<span id="this-page"">'+ pageModel.currentPageCode +'</span>');
                            }
                        }
                        page.innerHTML += ('<span class="adjacent-pages" onclick="nextPage()">下一页 〉</span>' +
                            '<span class="all-page">总共'+pageModel.totalPages+'页</span>' +
                            '<span class="all-page">跳转到</span>' +
                            '<span class="input-page"><input type="text" id="input-page" value="'+pageModel.currentPageCode+'"></span>' +
                            '<span class="all-page">页</span>' +
                            '<button class="confirm" onclick="sureToJump()">确定</button>')
                    }
                    else if(pageModel.totalPages > 9 && pageModel.currentPageCode <= 3){
                        //总页数大于九页时,当页在前三页时,渲染方式.
                        page.innerHTML += ('<span class="adjacent-pages" onclick="previousPage()">〈 上一页</span>');
                        for (var i = 1; i<pageModel.currentPageCode;i++) {
                            page.innerHTML += ('<span class="page-num" onclick="toThisPageNum(this)">'+ i +'</span>');
                        }
                        page.innerHTML += ('<span id="this-page"">'+ pageModel.currentPageCode +'</span>');
                        for (var i = pageModel.currentPageCode + 1; i < 6 ; i++ ){
                            page.innerHTML += ('<span class="page-num" onclick="toThisPageNum(this)">'+ i +'</span>');
                        }

                        page.innerHTML += ('<span class="page-interval">···</span>');

                        for (var i = pageModel.totalPages-2; i <= pageModel.totalPages ; i++ ){
                            page.innerHTML += ('<span class="page-num" onclick="toThisPageNum(this)">'+ i +'</span>');
                        }

                        page.innerHTML += ('<span class="adjacent-pages" onclick="nextPage()">下一页 〉</span>' +
                            '<span class="all-page">总共'+pageModel.totalPages+'页</span>' +
                            '<span class="all-page">跳转到</span>' +
                            '<span class="input-page"><input type="text" id="input-page" value="'+pageModel.currentPageCode+'"></span>' +
                            '<span class="all-page">页</span>' +
                            '<button class="confirm" onclick="sureToJump()">确定</button>')

                    }
                    else if(pageModel.totalPages > 9 && pageModel.totalPages - pageModel.currentPageCode <= 3){
                        //当前页靠后(离最后一页 三页以内)

                        page.innerHTML += (' <span class="adjacent-pages" onclick="previousPage()">〈 上一页</span>' +
                            '<span class="page-num" onclick="toThisPageNum()">1</span>' +
                            '<span class="page-num" onclick="toThisPageNum(this)">2</span>' +
                            '<span class="page-num" onclick="toThisPageNum(this)">3</span>' +
                            '<span class="page-num" onclick="toThisPageNum(this)">4</span>' +
                            '<span class="page-interval">···</span>');
                        for (var i = pageModel.currentPageCode-2; i < pageModel.currentPageCode ; i++ ){
                            page.innerHTML += ('<span class="page-num" onclick="toThisPageNum(this)">'+ i +'</span>');
                        }
                        page.innerHTML += ('<span id="this-page"">'+ pageModel.currentPageCode +'</span>');
                        for(var i = pageModel.currentPageCode+1; i <= pageModel.totalPages ; i++ ){
                            page.innerHTML += ('<span class="page-num" onclick="toThisPageNum(this)">'+ i +'</span>');
                        }

                        page.innerHTML += ('<span class="adjacent-pages" onclick="nextPage()">下一页 〉</span>' +
                            '<span class="all-page">总共'+pageModel.totalPages+'页</span>' +
                            '<span class="all-page">跳转到</span>' +
                            '<span class="input-page"><input type="text" id="input-page" value="'+pageModel.currentPageCode+'"></span>' +
                            '<span class="all-page">页</span>' +
                            '<button class="confirm" onclick="sureToJump()">确定</button>')

                    }
                    else if(pageModel.totalPages !== 1) {
                        page.innerHTML += ('<span class="adjacent-pages" onclick="previousPage()">〈 上一页</span>' +
                            '<span class="page-num" onclick="toThisPageNum()">1</span>' +
                            '<span class="page-interval">···</span>')

                        for (var i = pageModel.currentPageCode-2; i < pageModel.currentPageCode ; i++ ) {
                            page.innerHTML += ('<span class="page-num" onclick="toThisPageNum(this)">'+ i +'</span>');
                        }

                        page.innerHTML += ('<span id="this-page"">'+ pageModel.currentPageCode +'</span>');

                        for (var i = pageModel.currentPageCode+1; i <= pageModel.currentPageCode+2 ; i++) {
                            page.innerHTML += ('<span class="page-num" onclick="toThisPageNum(this)">'+ i +'</span>');
                        }

                        page.innerHTML += (' <span class="page-num" onclick="toThisPageNum(this)">'+pageModel.totalPages+'</span>' +
                            '<span class="adjacent-pages" onclick="nextPage()">上一页 〉</span>' +
                            '<span class="all-page">总共'+pageModel.totalPages+'页</span>' +
                            '<span class="all-page">跳转到</span>' +
                            '<span class="input-page"><input type="text" id="input-page" value="'+pageModel.currentPageCode+'"></span>' +
                            '<span class="all-page">页</span>' +
                            '<button class="confirm" onclick="sureToJump()">确定</button>');
                    }

                } else {

                }
            }
            else {
                //购物车为空
                cartNode.innerHTML += (' <div id="not-cart">' +
                    '<img src="/images/cryOfPeople.png"/>' +
                    '<span>购物车空空如野,赶快去逛逛吧!</span>' +
                    ' </div>');

            }
        }

}


/**
 * 查看用户选择的商品的折扣为多少
 */
function prices2ceshi() {
    if (books !== "") {
        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        } else {
            xhr = new ActiveXObject('Microsoft.XMLHTTP');
        }
        xhr.open("POST", "/priceShow", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        xhr.onreadystatechange = priceStatistics;
        xhr.send(books);
    }else{
        //组合优惠 优惠额
        document.getElementById("price1").innerText = "";
        //满减优惠 优惠额
        document.getElementById("price2").innerText = "";
        //用户选择的商品的总价格
        document.getElementsByClassName("total_text")[0].innerText = 0;
    }
}

/**
 * 购物车跳转到商品详情页面
 * @param ele
 */
function goToThisBook(ele) {
    // ele.parentNode.parentNode.parentNode.getAttribute("id");
    window.location = "bookdetail?bookId=" + ele.parentNode.parentNode.parentNode.getAttribute("id")
}


/**
 * 解析 从后台返回的 用户选择的商品的折扣
 */
function  priceStatistics() {
    if (xhr.readyState === 4 && xhr.status === 200){
        var bookPrice = JSON.parse(xhr.responseText);
        if (bookPrice !== null){
            allprice = bookPrice.groupPrice;
            fullReductionDiscount = bookPrice.fullReductionDiscount;
            if (bookPrice.groupDiscount == undefined){
                groupPrice = 0
            } else {
                groupPrice = bookPrice.groupDiscount;
            }
            //组合优惠 优惠额
            document.getElementById("price1").innerText = groupPrice;
            //满减优惠 优惠额
            document.getElementById("price2").innerText = fullReductionDiscount;
            //用户选择的商品的总价格
            document.getElementsByClassName("total_text")[0].innerText = (allprice - groupPrice - fullReductionDiscount).toFixed(2);
        }



    }
}


/**
 * 结算按钮
 */
function settleAccount() {
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }

    books += "&allprice=" + allprice + "&fullReductionDiscount="+ fullReductionDiscount + "&groupPrice=" + groupPrice;

    xhr.open("POST", "/butNow", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
    xhr.onreadystatechange = butItNow;
    xhr.send(books);
}


function butItNow() {
    if (xhr.readyState === 4 && xhr.status === 200){
        if (xhr.responseText == "success")
            window.location = "/pay"
    }
}
