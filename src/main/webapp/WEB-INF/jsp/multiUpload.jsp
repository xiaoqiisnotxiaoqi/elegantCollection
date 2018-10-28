<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\9\30 0030
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>多文件上传</title>
</head>
<body>
<form method="post" action="/multiUpload" enctype="multipart/form-data">
    <input type="file" name="file"><br>
    <input type="file" name="file"><br>
    <input type="file" name="file"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>