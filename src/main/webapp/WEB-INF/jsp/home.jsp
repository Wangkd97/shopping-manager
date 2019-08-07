<%--
  Created by IntelliJ IDEA.
  User: Neuedu
  Date: 2019/8/2
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>

</head>
<body>

<h1>欢迎,${user.username}登录</h1>

<a href="/user/category/find">管理类别信息</a>
<br>
<a href="/user/getAllUser">管理用户信息</a>
<br>
<a href="/user/product/getAll">管理商品信息</a>

</body>
</html>
