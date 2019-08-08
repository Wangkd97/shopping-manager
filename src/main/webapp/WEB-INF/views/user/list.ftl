<html>
<#include  "common/header.ftl">

<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "common/nav.ftl">

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>用户类别</th>
                            <th>用户名</th>
                            <th>密码</th>
                            <th>邮箱</th>
                            <th>手机号</th>
                            <th>密保问题</th>
                            <th>密保答案</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list user as u>
                        <tr>
                            <td>${u.role}</td>
                            <td>${u.username}</td>
                            <td>${u.password}</td>
                            <td>${u.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td>${u.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td><a href="/sell/seller/category/index?categoryId=${category.categoryId}">修改</a></td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>