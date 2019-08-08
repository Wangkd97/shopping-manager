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
                <th><c:if test="${category.status=='1'}"><c:out value="正常"/></c:if>
                    <c:if test="${category.status=='2'}"><c:out value="已废弃"/></c:if>

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
    <form method="post" action="/user/category/addCategory" >
        类别名称：<input name="name" type="text" >
        类别级别:<select  name="kind" id="kindid" onchange="getChange();">
        <c:forEach  var ="i" begin="1"
                    end="${kindSize}"
                    step="1">
            <option value="${i}" name="kind">${i}级类别</option>
            <%--<c:forEach items="${subList}" var="u">--%>
                <%--<option value="${u.id}"  name="id" >--%>
                        <%--${u.name}--%>
                <%--</option>--%>
            <%--</c:forEach>--%>

        </c:forEach>


    </select>

        <select id="detailid" name="parentId">
                <option>----</option>
                <c:forEach items="${subcategory}" var="u">
                <option value="${u.id}"  name="id" >
                ${u.name}
                </option>
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
<script type="text/javascript">
    
    function getChange() {
        var value=document.getElementById("kindid").selectedIndex;
        //var father=document.getElementById("detailid");
        //father.length=1;
        parseInt(value);
        var area= document.getElementById("detailid");
        area.innerHTML = "";

        for(var i=0;i<area.childNodes.length;i++){
            area.removeChild(area.options[i]);
            area.remove(i);
            area.options[i] = null;
        }
        alert(value);
            var reg_select = document.getElementById('detailid');  //找到select标签
            var frag = document.createDocumentFragment(); //创建文档片段，文档片段的作用就是让for循环中创建的标签先放到文档片段中，待for循环结束后直接将文档片段插入制定的标签元素内，可以减少dom的操作
       var cc=0;
        <%--<c:forEach items="${kindList}" var ="isindex ">--%>
            <%--cc++;--%>
            <%--alert(cc+"=======");--%>
            <%--<c:if test="cc==value">--%>
        <%--<c:forEach items="${isindex}" var="u">--%>
        <%--alert(${u.name}+"***********");--%>
        <%--var option = document.createElement("option");  //创建option标签--%>
        <%--option.value = ${u.id};    //设置正在创建的option的value属性--%>
        <%--option.innerHTML = "${u.name}";--%>
        <%--frag.appendChild(option);   //将设置好的 option插入文档片段。--%>
        <%--</c:forEach>--%>
        <%--reg_select.appendChild(frag);  //循环结束后一次性，将文档片段插入制定的dom中--%>
        <%--</c:if>--%>
        <%--if (cc==value){--%>
            <%--//alert("asdsadasd"+${isindex[1].name });--%>
            <%--<c:forEach items="${isindex}" var="u">--%>
            <%--alert(${u.name}+"***********");--%>
            <%--var option = document.createElement("option");  //创建option标签--%>
            <%--option.value = ${u.id};    //设置正在创建的option的value属性--%>
            <%--option.innerHTML = "${u.name}";--%>
            <%--frag.appendChild(option);   //将设置好的 option插入文档片段。--%>
            <%--</c:forEach>--%>
            <%--reg_select.appendChild(frag);  //循环结束后一次性，将文档片段插入制定的dom中--%>

        <%--}--%>

        <%--</c:forEach>--%>

        if (value==0){
            var reg_select = document.getElementById('detailid');  //找到select标签
            var frag = document.createDocumentFragment(); //创建文档片段，文档片段的作用就是让for循环中创建的标签先放到文档片段中，待for循环结束后直接将文档片段插入制定的标签元素内，可以减少dom的操作
            <%--for (var i = 0; i < ${kindList[1]}; i++) {--%>
                <%--var option = document.createElement("option");  //创建option标签--%>
                <%--option.value = [i];    //设置正在创建的option的value属性--%>
                <%--option.innerHTML = json[i].desc + "&nbsp" + "(" + "+" + json[i].cc + ")";--%>
                <%--frag.appendChild(option);   //将设置好的 option插入文档片段。--%>
            <%--}--%>
            <c:forEach items="${kindList[1]}" var="u">
            var option = document.createElement("option");  //创建option标签
            option.value = ${u.sortOrder};    //设置正在创建的option的value属性
            option.name="parentId";
            option.innerHTML = "${u.name}";
            frag.appendChild(option);   //将设置好的 option插入文档片段。
            </c:forEach>
            reg_select.appendChild(frag);  //循环结束后一次性，将文档片段插入制定的dom中

        }else if(value==1){
            var reg_select = document.getElementById('detailid');  //找到select标签
            var frag = document.createDocumentFragment(); //创建文档片段，文档片段的作用就是让for循环中创建的标签先放到文档片段中，待for循环结束后直接将文档片段插入制定的标签元素内，可以减少dom的操作
            <c:forEach items="${kindList[2]}" var="u">
            var option = document.createElement("option");  //创建option标签
            option.value = ${u.sortOrder};    //设置正在创建的option的value属性
            option.name="parentId";
            option.innerHTML = "${u.name}";
            frag.appendChild(option);   //将设置好的 option插入文档片段。
            </c:forEach>
            reg_select.appendChild(frag);  //循环结束后一次性，将文档片段插入制定的dom中

        }else if(value==2){
            var reg_select = document.getElementById('detailid');  //找到select标签
            var frag = document.createDocumentFragment(); //创建文档片段，文档片段的作用就是让for循环中创建的标签先放到文档片段中，待for循环结束后直接将文档片段插入制定的标签元素内，可以减少dom的操作
            <c:forEach items="${kindList[3]}" var="u">
            var option = document.createElement("option");  //创建option标签
            option.value = ${u.sortOrder};    //设置正在创建的option的value属性
            option.name="parentId";
            option.innerHTML = "${u.name}";
            frag.appendChild(option);   //将设置好的 option插入文档片段。
            </c:forEach>
            reg_select.appendChild(frag);  //循环结束后一次性，将文档片段插入制定的dom中
        }else if(value==3){
            var reg_select = document.getElementById('detailid');  //找到select标签
            var frag = document.createDocumentFragment(); //创建文档片段，文档片段的作用就是让for循环中创建的标签先放到文档片段中，待for循环结束后直接将文档片段插入制定的标签元素内，可以减少dom的操作
            <c:forEach items="${kindList[4]}" var="u">
            var option = document.createElement("option");  //创建option标签
            option.value = ${u.sortOrder};    //设置正在创建的option的value属性
            option.name="parentId";
            option.innerHTML = "${u.name}";
            frag.appendChild(option);   //将设置好的 option插入文档片段。
            </c:forEach>
            reg_select.appendChild(frag);  //循环结束后一次性，将文档片段插入制定的dom中
        }else if(value==4){
            var reg_select = document.getElementById('detailid');  //找到select标签
            var frag = document.createDocumentFragment(); //创建文档片段，文档片段的作用就是让for循环中创建的标签先放到文档片段中，待for循环结束后直接将文档片段插入制定的标签元素内，可以减少dom的操作
            <c:forEach items="${kindList[5]}" var="u">
            var option = document.createElement("option");  //创建option标签
            option.value = ${u.sortOrder};    //设置正在创建的option的value属性
            option.name="parentId";
            option.innerHTML = "${u.name}";
            frag.appendChild(option);   //将设置好的 option插入文档片段。
            </c:forEach>
            reg_select.appendChild(frag);  //循环结束后一次性，将文档片段插入制定的dom中
        }else if(value==5){
            var reg_select = document.getElementById('detailid');  //找到select标签
            var frag = document.createDocumentFragment(); //创建文档片段，文档片段的作用就是让for循环中创建的标签先放到文档片段中，待for循环结束后直接将文档片段插入制定的标签元素内，可以减少dom的操作
            <c:forEach items="${kindList[6]}" var="u">
            var option = document.createElement("option");  //创建option标签
            option.value = ${u.sortOrder};    //设置正在创建的option的value属性
            option.name="parentId";
            option.innerHTML = "${u.name}";
            frag.appendChild(option);   //将设置好的 option插入文档片段。
            </c:forEach>
            reg_select.appendChild(frag);  //循环结束后一次性，将文档片段插入制定的dom中
        }else if(value==6){
            var reg_select = document.getElementById('detailid');  //找到select标签
            var frag = document.createDocumentFragment(); //创建文档片段，文档片段的作用就是让for循环中创建的标签先放到文档片段中，待for循环结束后直接将文档片段插入制定的标签元素内，可以减少dom的操作
            <c:forEach items="${kindList[7]}" var="u">
            var option = document.createElement("option");  //创建option标签
            option.value = ${u.sortOrder};    //设置正在创建的option的value属性
            option.name="parentId";
            option.innerHTML = "${u.name}";
            frag.appendChild(option);   //将设置好的 option插入文档片段。
            </c:forEach>
            reg_select.appendChild(frag);  //循环结束后一次性，将文档片段插入制定的dom中
        }
    }
</script>

</html>
