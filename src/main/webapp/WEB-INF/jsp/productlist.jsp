<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/6
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ProductList</title>
</head>
<body>

<table>
    <thead>
    <th>商品Id</th>
    <th>商品所属类别</th>
    <th>商品名称</th>
    <th>商品副标题</th>
    <th>商品主图片</th>
    <th>商品副图片</th>
    <th>商品描述</th>
    <th>商品价格</th>
    <th>商品库存</th>
    <th>商品状态</th>
    <th>操作</th>
    </thead>

    <c:forEach items="${list}" var="product">

        <tr>
            <th>${product.id}</th>
            <th>${product.categoryName}</th>
            <th>${product.name}</th>
            <th>${product.subtitle}</th>
            <th>${product.mainImage}</th>
            <th>${product.subImages}</th>
            <th>${product.detail}</th>
            <th>${product.price}</th>
            <th>${product.stock}</th>
            <th>${product.status}</th>
            <th>
                <a href="#" >修改</a>
                <a href="" >删除</a>
            </th>
        </tr>

    </c:forEach>


</table>


</body>
</html>
