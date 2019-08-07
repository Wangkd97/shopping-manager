<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/6
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <thead>
    <th>用户Id</th>
    <th>用户名</th>
    <th>密码</th>
    <th>邮箱</th>
    <th>手机号</th>
    <th>密保问题</th>
    <th>密保答案</th>
    <th>操作</th>
    </thead>

    <c:forEach items="${list}" var="user">

        <tr>
            <th>${user.id}</th>
            <th>${user.username}</th>
            <th>${user.password}</th>
            <th>${user.email}</th>
            <th>${user.phone}</th>
            <th>${user.question}</th>
            <th>${user.answer}</th>
            <th>
                <a href="#" >修改</a>
                <a href="#" >删除</a>
            </th>
        </tr>

    </c:forEach>


</table>
</body>
</html>
