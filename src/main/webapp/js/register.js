/**
 * Created by Administrator on 2018\10\4 0004.
 * 头部 用于与后台交互的事件
 */

var custLodin;

/**
 * 判断手机号码格式,以及是否以及被注册过
 * @param thePhone
 */
function isPhone(thePhone){
    var ph = thePhone.value;
    var phone =/^[1][3,4,5,6,7,8][0-9]{9}$/;
    if (!phone.test(ph)) {
        document.getElementById("phone-span").innerText = "手机号错误。";
        document.getElementById("phone-span").style.color= "red";
    } else {
        document.getElementById("phone-span").innerText = "";
        verifyPhone(ph)
    }
}

var xhr;
/**
 * 查看手机号是否已被注册
 * @param phone
 */
function verifyPhone(phone){
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET", "/phoneIsRegistered?phone="+phone , true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = verificationResultsOfPhone;
    xhr.send();
}
/**
 * 解析json数据 查看手机号是否已被注册
 */
function verificationResultsOfPhone(){
    if (xhr.readyState === 4 && xhr.status === 200){
        if(xhr.responseText !== "success"){
            document.getElementById("phone-span").innerText="该手机号已被注册!";
            document.getElementById("phone-span").style.color= "red";
        }else{
            document.getElementById("phone-span").innerText=""
        }
    }
}


/**
 * 提交注册信息
 */
function registerPost(){
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    var phone = document.getElementById("phone").value;
    var password = document.getElementById("password").value;
    var imgCode = document.getElementById("captcha").value;
    var phoneCode = document.getElementById("message-authentication-code").value;
    var formData = "phone="+phone+"&password="+password+"&imgCode="+imgCode+"&phoneCode="+phoneCode;
    // 提交表单地址
    var url  = "/singIn";
    xhr.open("POST", url , true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
    xhr.onreadystatechange = responseRegister;
    xhr.send(formData);
}

/**
 * 解析从后台传来的注册json数据
 */
function responseRegister() {
    if (xhr.readyState === 4 && xhr.status === 200){
        if(xhr.responseText === "图片验证码错误"){
            document.getElementById("captcha-span").innerText = "图片验证码错误";
        }else if(xhr.responseText === "短信验证码错误"){
            document.getElementById("message-span").innerText = "短信验证码错误";
        }else {
            custLodin = true;
            window.location = "/index";
        }

    }
}


/**
 * 用户登录
 */
function login() {
    var url;
    var formData;
    if (document.getElementById("note-login").style.display == "none"){
        url = "/login";
        var custName = document.getElementById("id_account_l").value;
        var pwd = document.getElementById("id_password_l").value;
        formData = "custName="+custName+"&pwd="+pwd;
    } else {
        url = "textLogin";
        var phone = document.getElementById("id_account_2").value;
        var securityCode = document.getElementById("id_password_2").value;
        formData = "phone=" + phone + "&securityCode=" + securityCode;
    }
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }


    xhr.open("POST", url , true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
    xhr.onreadystatechange = responselogin;
    xhr.send(formData);
}

/**
 * 登录json数据解析
 */
function responselogin() {
    if (xhr.readyState === 4 && xhr.status === 200){
        if(xhr.responseText != "success"){
            document.getElementById("loginModalLabel").innerText +="              " + xhr.responseText;
            sessionStorage.setItem("login","success");
        }else {
            document.getElementById("loginModalLabel").innerText = "登录";
            window.location = "/index";
        }
    }
}

/**
 * 显示用户未查看的 客服消息,以及书评区消息数量
 */
function news(){
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET", "/notifications" , true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = newsResolve();
    xhr.send();
}

/**
 * 解析查看消息是 后台返回的json数据
 */
function newsResolve(){
    if (xhr.readyState === 4 && xhr.status === 200){
        var newResolve = JSON.parse(xhr.responseText);
        //用户未查看的客服消息数量
        var messageNum = newResolve.messageNum;
        //用户未查看的书评区消息数量
        var postReplyNum = newResolve.postReplyNum;
        if(messageNum !== 0){
            document.getElementById("service-news").innerText = messageNum;
            document.getElementById("service-news").style.display = "";
        }else{
            document.getElementById("service-news").innerText = "";
            document.getElementById("service-news").style.display = "none";
        }

        if(postReplyNum !== 0){
            document.getElementById("discuss-news").innerText = postReplyNum;
            document.getElementById("discuss-news").style.display = "";
        }else{
            document.getElementById("discuss-news").innerText = "";
            document.getElementById("discuss-news").style.display = "none";
        }
    }
}

/**
 * 用于查看 用户购物车中商品的数量
 */
function cartNum(){
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET", "/cartNum" , true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = cartResolve();
    xhr.send();
}

/**
 * 解析从后台返回的购物车数量 信息
 */
function cartResolve(){
    if(xhr.readyState===4 && xhr.status === 200){
        var resolve = JSON.parse(xhr.responseText);
        if(resolve !== 0){
            document.getElementById("cart-num").innerText = resolve;
        }else{
            document.getElementById("cart-num").innerText = "";
        }
    }
}

/**
 * 退出登录
 */
function loginOut() {
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("DELETE", "/loginOut" , true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    xhr.onreadystatechange = loginOutResolution;
    xhr.send();
}

/**
 * 解析退出登录时 返回的json数据
 */
function loginOutResolution() {
    if (xhr.readyState === 4 && xhr.status === 200){
        if (xhr.responseText === "success") {
            custLodin = false;
            sessionStorage.removeItem("login");
            window.location = "/index"
        }
    }
}

/**
 * 根据关键字搜索
 */
function searchBox() {
    //把keyword添加到jsSession
    sessionStorage.clear();
    sessionStorage.setItem("keyWord", document.getElementById("searchInput").value);
    window.location = "/allbooks";

}

/**
 * 点击分类
 * @param ele
 */
function clickcaterory(ele) {
    sessionStorage.clear();
    sessionStorage.setItem("categoryId", ele.id);
    window.top.location = "allbooks";
}



