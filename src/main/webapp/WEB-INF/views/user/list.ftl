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
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list list as u>
                        <tr>
                            <td><#if u.role == '0'>管理员<#else >普通用户</#if></td>
                            <td>${u.username}</td>
                            <td>${u.password}</td>
                            <td>${u.email}</td>
                            <td>${u.phone}</td>
                            <td>${u.question}</td>
                            <td>${u.answer}</td>
                            <td><a href="/business/user/update/${u.id}">修改</a>
                                <a href="/business/user/deleteById/${u.id}">删除</a>
                            </td>

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