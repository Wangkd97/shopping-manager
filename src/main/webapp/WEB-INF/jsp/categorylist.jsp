<%--
  Created by IntelliJ IDEA.
  User: Neuedu
  Date: 2019/8/6
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>



</head>
<body>
<div>
    <table>
        <thead>
        <th>类别Id</th>
        <th>类别名称</th>
        <th>所属父类</th>
        <th>类别状态</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>操作</th>
        </thead>
        <c:forEach items="${categorylist}" var="category">
            <tr>
                <th >${category.id}</th>
                <th>${category.name}</th>
                <th>${category.parentName}</th>
                <th><c:if test="${category.status=='1'}"><c:out value="在售"/></c:if>
                    <c:if test="${category.status=='2'}"><c:out value="下架"/></c:if>
                    <c:if test="${category.status=='3'}"><c:out value="删除"/></c:if></th>
                <th>${category.createTime}</th>
                <th>${category.updateTime}</th>
                <th>
                    <a href="update/${category.id}" >修改</a>
                    <a href="/user/category/deleteById/${category.id}" >删除</a>
                </th>
            </tr>

        </c:forEach>


    </table>


</div>

<p>${kindSize}=====================================</p>
<div>
    <button onclick="">添加商品类别</button>
    <form method="post" action="">
        类别名称：<input name="name" type="text" >
        类别级别:<select  name="id">
        <c:forEach  var ="i" begin="0"
                    end="${kindSize}"
                    step="1">
            <option value="${i}" name="id">${i+1}级类别</option>
            <%--<c:forEach items="${subList}" var="u">--%>
                <%--<option value="${u.id}"  name="id" >--%>
                        <%--${u.name}--%>
                <%--</option>--%>
            <%--</c:forEach>--%>

        </c:forEach>

    </select>
        类别状态：<select name="status">
                    <option name="status" value="1" selected="selected">正常</option>
                    <option name="status" value="2">已废弃</option>
    </select>
        <input type="submit" value="添加">
    </form>
</div>



</body>
</html>
