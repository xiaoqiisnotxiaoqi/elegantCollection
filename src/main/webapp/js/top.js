/**
 * Created by Administrator on 2018\10\5 0005.
 * 头部样式以及 聚焦等事件
 */
 //用于判断 页面显示的是密码登录还是短信登录
var passwordLogin = true;

//用于判断登录弹窗是否开启
var isLogin = false;


/**
 * 切换密码 或是 手机登录
 * @param loginMode document对象
 */
function loginModeConversion(loginMode){
    if(passwordLogin){
        document.getElementById('password-login').style.display = "none";
        document.getElementById('note-login').style.display = "";
        passwordLogin = false;
        loginMode.innerText = "密码登录"
    }else{
        document.getElementById('note-login').style.display = "none";
        document.getElementById('password-login').style.display = "";
        passwordLogin = true;
        loginMode.innerText = "短信登录"
    }
}

function topCustEle() {
    window.top.location = "/userinfo"
}


/**
 * 鼠标聚焦 我的购物车事件
 */
function onCart(){
    document.getElementById("cart-img").src = "../images/cart-red.png";
    document.getElementById("cart-span").style.color = "red";
    document.getElementById("cart-num").style.color = "red";
    document.getElementById("cart").style.backgroundColor = "#F6F6F6";
    document.getElementById("cart").style.borderColor = "#DCDCDC";
}


/**
 * 鼠标移除聚焦 我的购物车事件
 */
function outCart(){
    document.getElementById("cart-img").src = "../images/cart-white.png";
    document.getElementById("cart-span").style.color = "#ffffff";
    document.getElementById("cart").style.backgroundColor = "red";
    document.getElementById("cart").style.borderColor = "red";
    document.getElementById("cart-num").style.color = "#ffffff";
}

/**
 * 鼠标聚焦  导航菜单事件
 * @param ele
 */
function onli(ele){
    ele.style.backgroundColor = "red";
    ele.style.color = "#ffffff"
}

/**
 * 鼠标移除聚焦  导航菜单事件
 * @param ele
 */
function outli(ele){
    ele.style.backgroundColor = "#ffffff";
    ele.style.color = "#000000";
}


/**
 * 弹出登录界面
 */
function showDiv(){
        var Idiv     = document.getElementById("loginModal");
        Idiv.className = "modal";
        Idiv.style.display = "fixed";
        Idiv.style.top = "40%";
        Idiv.style.left = "45%";
        Idiv.style.position = "absolute";
        //以下部分要将弹出层居中显示
        Idiv.style.left=(window.screen.availWidth - 540)/2 + 100 +"px";
        Idiv.style.top =(window.screen.availHeight - 320)/2 - 100 +"px";
                         
        //以下部分使整个页面至灰不可点击
        var procbg = document.createElement("div"); //首先创建一个div
        procbg.setAttribute("id","mybg"); //定义该div的id
        procbg.style.background = "#000000";
        procbg.style.width = "100%";
        procbg.style.height = "100%";
        procbg.style.position = "fixed";
        procbg.style.top = "0";
        procbg.style.left = "0";
        procbg.style.bottom = "0";
        procbg.style.right = "0";
        procbg.style.zIndex = "500";
        procbg.style.opacity = "0.6";
        procbg.style.filter = 0.9;
        //背景层加入页面
        document.body.appendChild(procbg);
        document.body.style.overflow = "hidden"; //取消滚动条
        isLogin = true;

}


/**
 * 弹出首页 登录界面
 */
function showDiv2(){
    var Idiv     = document.getElementById("loginModal");
    Idiv.className = "modal";
    Idiv.style.display = "block";
    Idiv.style.position = "absolute";
    //以下部分要将弹出层居中显示
    Idiv.style.left="0";
    Idiv.style.top =(window.screen.availHeight - 320)/2 - 100 +"px";

    //以下部分使整个页面至灰不可点击
    var procbg = document.createElement("div"); //首先创建一个div
    procbg.setAttribute("id","mybg"); //定义该div的id
    procbg.style.background = "#000000";
    procbg.style.width = "100%";
    procbg.style.height = "100%";
    procbg.style.position = "fixed";
    procbg.style.top = "0";
    procbg.style.left = "0";
    procbg.style.bottom = "0";
    procbg.style.right = "0";
    procbg.style.zIndex = "500";
    procbg.style.opacity = "0.6";
    procbg.style.filter = 0.9;
    //背景层加入页面
    document.body.appendChild(procbg);
    document.body.style.overflow = "hidden"; //取消滚动条
    isLogin = true;

}



/**
 * 点击 关闭登录事件
 */
function stopLoginDiv(){
    var Idiv = document.getElementById("loginModal");
    var cc = document.getElementById("mybg");
    Idiv.className = "modal fade";
    cc.parentNode.removeChild(cc);
    Idiv.style.display = "none";
    isLogin = false;
}

/**
 * 短信验证码 重新发送
 * @type {string}
 */
var clock = '';
var nums = 120;
var btn;
function sendCode(thisBtn) {
    btn = thisBtn;
    btn.disabled = true; //将按钮置为不可点击
    btn.value = '重新获取（'+nums+'）';
    clock = setInterval(doLoop, 1000); //一秒执行一次
    //判断是 登录发送验证码  还是 注册发送验证码
    var formData;
    var phone;
    if (btn.className == "sms"){
        phone = document.getElementById("phone").value;
        formData = "phone=" + phone + "&num=2";
    } else{
        phone = document.getElementById("id_account_2").value;
        formData = "phone=" + phone + "&num=1";
    }
    //将手机号传置后台 发送验证码
    /*if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("POST", "/sendText" , true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
    xhr.onreadystatechange = reult;
    xhr.send(formData);*/
    alert("短信功能占时关闭")
}

/**
 * 解析 发送短信后的数据(省事,为空)
 */
function reult() {

}
/**
 *从新发送计时器
 */
function doLoop() {
    nums--;
    if (nums > 0) {
        btn.value = '重新获取（'+nums+'）';
    } else {
        clearInterval(clock); //清除js定时器
        btn.disabled = false;
        btn.value = '点击发送验证码';
        nums = 120; //重置时间
    }
}

/**
 * 点击 弹出注册页面
 */
function showRegister(){
    var Idiv     = document.getElementById("register");
    Idiv.className = "modal";
    Idiv.style.display = "block";
    Idiv.style.zIndex = "1000";
    //以下部分要将弹出层居中显示
    Idiv.style.left=(document.documentElement.clientWidth-Idiv.clientWidth)/2+document.documentElement.scrollLeft - 500+"px";
    Idiv.style.top =(document.documentElement.clientHeight-Idiv.clientHeight)/2+document.documentElement.scrollTop+"px";

    //以下部分使整个页面至灰不可点击
    var procbg = document.createElement("div"); //首先创建一个div
    procbg.setAttribute("id","mybg"); //定义该div的id
    procbg.style.background = "#000000";
    procbg.style.width = "100%";
    procbg.style.height = "100%";
    procbg.style.position = "fixed";
    procbg.style.top = "0";
    procbg.style.left = "0";
    procbg.style.zIndex = "500";
    procbg.style.opacity = "0.6";
    procbg.style.filter = 0.9;
    //背景层加入页面
    document.body.appendChild(procbg);
    document.body.style.overflow = "hidden"; //取消滚动条
    isRegister = true;
}

/**
 * 点击关闭注册页面
 */
function stopRegisterDiv(){
    var Idiv = document.getElementById("register");
    var cc = document.getElementById("mybg");
    cc.parentNode.removeChild(cc);
    Idiv.style.display = "none";
    isRegister = false;
}


/**
 * 验证输入的两次密码是否相同
 * @param pwd
 */
function samePassword(pwd){
    var pwd1 = document.getElementById("password").value;
    if(pwd.value === pwd1){
        document.getElementById("confirm-password-span").innerText = "";
    }else{
        document.getElementById("confirm-password-span").innerText = "两次密码不一致，请重新输入";
        document.getElementById("confirm-password-span").style.color= "red";
    }
}


/**
 * 当输入密码时,获得提示
 */
function passwordHint() {
    document.getElementById("password-span").innerText="密码必须为大小写字母和数字的8-10字符。";
}

/**
 * 查看密码是否符合规范
 * @param thePwd
 */
function isPassword(thePwd){
    var pwd = thePwd.value;
    var password =/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,10}$/;
    if (!password.test(pwd)) {
        document.getElementById("password-span").style.color= "red";
    } else {
        document.getElementById("password-span").innerText="";
    }
}


/**
 * 登录弹窗转到 注册弹窗
 */
function login2Register(){
    stopLoginDiv();
    showRegister();
}

/**
 * 注册弹窗 跳转 登录
 */
function register2Login(){
    stopRegisterDiv();
    showDiv();
}



/**
 * 跳转到购物车
 */
function loginOrCart() {
    var name = document.getElementsByClassName("DetermineWhetherLog");
    if (name[0].innerText == 1){
        window.location = "/custCart";
    } else {
        showDiv();
    }
}


/**
 * 跳转到我的订单
 */
function myOrder() {
    var name = document.getElementsByClassName("DetermineWhetherLog");
    if (name[0].innerText == 1){
        window.top.location = "/order_all";
    } else {
        showDiv();
    }
}

/**
 * 跳转到讨论区
 */
function  topDiscuss() {
    window.top.location = "/post";
}

/**
 * 跳转至首页
 */
function homePage() {
    window.top.location = "/index"
}


/**
 * 忘记密码
 */
function forgetPassword() {
    window.top.location = "/findpwd";
}

/**
 * 跳转到榜单页面
 */
function rankingList() {
    window.top.location = "/ranking";
}

/**
 * 跳转到书单页面
 */
function bookList() {
    window.top.location = "booklist";
}
