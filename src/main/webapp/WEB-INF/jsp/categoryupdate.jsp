<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Neuedu
  Date: 2019/8/6
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpdateCategory</title>

</head>
<body>
<h1>修改类别</h1>

<form action="" method="post">

   <input type="hidden" name="id" value="${category.id}"><br/>
    名称:<input type="text" name="name" value="${category.name}"><br/>
    父类名称:

    <select id="user_id" name="parent_id">
        <c:forEach items="${categorykinds}" var="u">
            <option value="${u.sortOrder}"  name="parent_id" <c:if test="${category.parentId==u.sortOrder}"><c:out value="selected"/></c:if>>
                    ${u.name}
            </option>
        </c:forEach>
    </select>

    <%--类别状态:<input id="status" type="text" name="status" ><br/>--%>
    类别状态：
    <select id="zhuangtai" name="status">
        <option name="status" value="1" <c:if test="${category.status=='1'}"><c:out value="selected"/></c:if>>在售</option>
        <option name="status" value="2" <c:if test="${category.status=='2'}"><c:out value="selected"/></c:if>>下架</option>
        <option name="status" value="3" <c:if test="${category.status=='3'}"><c:out value="selected"/></c:if>>删除</option>
    </select>
    <input type="submit"  value="修改"><br/>

</form>


</body>
<script type="text/javascript">

    var h_cate=${category.status};
    var tran_status="";
    if(h_cate==1) //在售，2下架，3删除
    {
        tran_status="在售";
    }else if(h_cate==2){
        tran_status="下架";
    }else {
        tran_status="删除";
    }
    document.getElementById("status").setAttribute("value",tran_status);


</script>
</html>
