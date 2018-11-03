/**
 * Created by Administrator on 2018/10/30.
 */
//产生验证码
onload = function() {
    createCode();
}
var code; //在全局定义验证码
function createCode() {
    code = "";
    var codeLength = 4; //验证码的长度
    var checkCode = document.getElementById("code");
    var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
        'q','r','s','t','u','v','w','x','y','z','A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
        'O', 'P', 'Q', 'R','S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); //随机数
    for(var i = 0; i < codeLength; i++) { //循环操作
        var index = Math.floor(Math.random() * 62); //取得随机数的索引（0~61）
        code += random[index]; //根据索引取得随机数加到code上
    }
    checkCode.value = code; //把code值赋给验证码
}
var url_contentphone = '/find/phonething?custPhone=';
var xhr = null;
var chuan = null;
var dx = null;
//根据手机号码查看用户是否存在
function checkphone() {
    var inputPhone = document.getElementById("phonenb").value;
    chuan = inputPhone;
    var url_checkph = url_contentphone + inputPhone;
    if(window.XMLHttpRequest){
        xhr = new XMLHttpRequest();
    }else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET",url_checkph,true);
    xhr.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr.onreadystatechange = loadPhone;
    xhr.send();
}
function loadPhone() {
    if (xhr.readyState == 4 && xhr.status == 200){
        var result = JSON.parse(xhr.responseText);
        //校验验证码
        var inputCode = document.getElementById("textcode").value.toUpperCase(); //获取输入框内验证码并转化为大写
        if(inputCode.length <= 0) { //若输入的验证码长度为0
            alert("请输入验证码！"); //则弹出请输入验证码
        }
        else if(inputCode != code.toUpperCase()) { //若输入的验证码与产生的验证码不一致时
            alert("验证码输入错误!"); //则弹出验证码输入错误
            createCode(); //刷新验证码
            document.getElementById("textcode").value = "";//清空文本框
        } else { //输入正确时
            if(result = true){
                var hao = chuan.slice(0,3) + "****" + chuan.slice(7,11);
                var bianhuan = document.getElementById("bianhuan");
                bianhuan.innerHTML = ('<li class="xazi">手机号 :</li><li class="xazi">' + hao + '</li>' +
                    '<li class="xazi">短信验证码 :</li><li><input id="duanma" type="text" ' +
                    'placeholder="请输入短信验证码"><input id="quma" class="mab" type="button" value="获取验证码" ' +
                    'onclick="fasong(this)"></li><li><span class="xiabu"><a class="bua" href="#" onclick="yanzheng()">' +
                    '下一步</a></span></li>');
            }
        }
    }
}
var xxh = null;
var clock = '';
var nums = 120;
var btn;
function fasong(thisBtn) {
    btn = thisBtn;
    btn.disabled = true; //将按钮置为不可点击
    btn.value = '重新获取（'+nums+'）';
    clock = setInterval(doLoop, 1000); //一秒执行一次
    if (window.XMLHttpRequest) {
        xxh = new XMLHttpRequest();
    } else {
        xxh = new ActiveXObject('Microsoft.XMLHTTP');
    }
    var data = "phone=" + chuan + "&num=" + 3;
    var url  = "/sendText";
    xxh.open("POST", url , true);
    xxh.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
    xxh.onreadystatechange = loadyzm;
    xxh.send(data);
}
function doLoop() {
    nums--;
    if (nums > 0) {
        btn.value = '重新获取（'+nums+'）';
    } else {
        clearInterval(clock); //清除js定时器
        btn.disabled = false;
        btn.value = '获取验证码';
        nums = 120; //重置时间
    }
}
function loadyzm() {
    if (xxh.readyState == 4 && xxh.status == 200){
        if(xxh.responseText != "success"){
            alert("短信验证码发送失败!");
        }
    }
}
var url_upmess = '/find/message?mage=';
var xxx = null;
function yanzheng() {
    dx = document.getElementById("duanma").value;
    var urll = url_upmess + dx;
    if(window.XMLHttpRequest){
        xxx = new XMLHttpRequest();
    }else {
        xxx = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xxx.open("GET",urll,true);
    xxx.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xxx.onreadystatechange = loadmima;
    xxx.send();
}
function loadmima() {
    if (xxx.readyState == 4 && xxx.status == 200){
        var result = JSON.parse(xxx.responseText);
        if(result = true){
            var bianhuan = document.getElementById("bianhuan");
            bianhuan.innerHTML = ('<li class="xazi">新密码 :</li><li><input id="npwd" type="password" placeholder=""></li>' +
                '<li class="xazi">确认密码 :</li><li><input id="newpwd" type="password" placeholder="请再次输入密码"></li>' +
                '<li><span class="xiabu"><a class="bua" href="#" onclick="uppassd()">下一步</a> </span> </li>');
        }
    }
}
var url_uppwd = '/find/phonepwd?custPhone=';
var xrh = null;
//更改用户密码
function uppassd() {
    var inputPwd = document.getElementById("newpwd").value;
    var url_doubletran = url_uppwd + chuan + "&custPassword=" + inputPwd;
    if(window.XMLHttpRequest){
        xrh = new XMLHttpRequest();
    }else {
        xrh = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xrh.open("GET",url_doubletran,true);
    xrh.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xrh.onreadystatechange = loadPwd;
    xrh.send();
}
function loadPwd() {
    if (xrh.readyState == 4 && xrh.status == 200){
        var result = JSON.parse(xrh.responseText);
        if(result = true){
            var bianhuan = document.getElementById("bianhuan");
            bianhuan.innerHTML = ('<li><span class="gong">登录密码重置成功!</span></li>');
        }else {
            alert("修改失败!");
        }
    }
}
