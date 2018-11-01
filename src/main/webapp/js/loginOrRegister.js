/**
 * 弹出登录界面
 */
function showDiv(){
    var Idiv     = document.getElementById("loginModal");
    Idiv.className = "modal";
    Idiv.style.display = "block";
    Idiv.style.position = "absolute";
    //以下部分要将弹出层居中显示
    Idiv.style.left= "0px";
    Idiv.style.top =(window.screen.availHeight - 320)/2 - 100 +"px";

    //以下部分使整个页面至灰不可点击
    var procbg = document.createElement("div"); //首先创建一个div
    procbg.setAttribute("id","mybg"); //定义该div的id
    procbg.style.background = "#000000";
    procbg.style.width = "100%";
    procbg.style.height = "100%";
    procbg.style.position = "absolute";
    procbg.style.top = "0";
    procbg.style.left = "0";
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
