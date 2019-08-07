<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/6
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>InsertProduct</title>
</head>
<body>
    <span >商品名称：</span>
    <input type="text" name="name" ><br>
    <span >商品副标题：</span>
    <input type="text" name="subtitle" ><br>
    <span >商品图片：</span>
    <input type="file" name="main_image" ><br>
    <span >商品详情：</span>
    <input type="text" name="detail" ><br>
    <span >商品价格：</span>
    <input type="text" name="price" ><br>
    <span >商品库存：</span>
    <input type="text" name="stock" ><br>
    <span >商品状态：</span>
    <select name="status">
        <option>在售</option>
        <option>下架</option>
        <option>删除</option>
    </select><br>
    <input type="submit" value="添加">
</body>
</html>
