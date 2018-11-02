<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>找回密码</title>
    <link rel="stylesheet" href="../../css/findpwd.css">
</head>
<body>
<jsp:include page="top.jsp"/>
<script src="../../js/findpwd.js"></script>
<div class="all">
    <div class="neitu">
        <div class="toud">
            <span class="firstspan">找回密码</span>
        </div>
        <div class="shend">
            <div class="snei">
                <div class="sneisg">
                    <ul>
                        <li class="oneli">
                            <span class="lisno">1</span>
                            <span class="lisn">填写账户名</span>
                        </li>
                        <li class="oneli">
                            <span class="lisno">2</span>
                            <span class="lisn">身份验证</span>
                        </li>
                        <li class="oneli">
                            <span class="lisno">3</span>
                            <span class="lisn">设置新密码</span>
                        </li>
                        <li class="oneli">
                            <span class="lisno">4</span>
                            <span class="lisn">完成</span>
                        </li>
                    </ul>
                </div>
                <div class="sneixa">
                    <ul id="bianhuan">
                        <li class="xazi">用户名 :</li>
                        <li><input id="phonenb" type="text" placeholder="请输入手机号"></li>
                        <li class="xazi">图形验证码 :</li>
                        <li><input id="textcode" type="text" placeholder="请填写验证码,不区分大小写"><input type="button"  id="code" onclick="createCode()" title="点击更换验证码"></li>
                        <li><span class="xiabu"><a class="bua" href="#" onclick="checkphone()">下一步</a></span> </li>
                        <%--<li class="xazi">手机号 :</li>--%>
                        <%--<li class="xazi">133****6375</li>--%>
                        <%--<li class="xazi">短信验证码 :</li>--%>
                        <%--<li><input type="text" placeholder="请输入短信验证码"><span class="huoma"><a class="maa" href="#">获取验证码</a> </span></li>--%>
                        <%--<li><span class="xiabu"><a class="bua" href="#">下一步</a> </span></li>--%>
                        <%--<li class="xazi">新密码 :</li>--%>
                        <%--<li><input type="text" placeholder=""></li>--%>
                        <%--<li class="xazi">确认密码 :</li>--%>
                        <%--<li><input id="newpwd" type="text" placeholder="请再次输入密码"></li>--%>
                        <%--<li><span class="xiabu"><a class="bua" href="#" onclick="uppassd()">下一步</a> </span> </li>--%>
                        <%--<li><span class="gong">登录密码重置成功!</span></li>--%>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="bottom.jsp"/>
</body>
</html>