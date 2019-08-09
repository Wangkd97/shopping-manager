<html>
<#include "common/header.ftl">

<body>
<div id="wrapper" class="toggled">

<#--边栏sidebar-->
<#include "common/nav.ftl">

<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/user/update">
                        <div class="form-group">
                            <label>用户类型</label>
                            <select name="role">
                                <option name="role" value="0" <#if user.role =='0'>selected="selected"</#if>管理员</option>
                                <option name="role" value="1" <#if user.role =='1'>selected="selected"</#if>>普通用户</option>
                            </select>

                        </div>
                        <div class="form-group">
                            <label>用户名</label>
                            <input name="username" type="text" class="form-control" value="${(user.username)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>密码</label>
                            <input name="password" type="text" class="form-control" value="${(user.password)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>邮箱</label>
                            <input name="email" type="text" class="form-control" value="${(user.email)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>手机号</label>
                            <input name="phone" type="text" class="form-control" value="${(user.phone)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>密保问题</label>
                            <input name="question" type="text" class="form-control" value="${(user.question)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>密保答案</label>
                            <input name="answer" type="text" class="form-control" value="${(user.answer)!''}"/>
                        </div>
                        <input hidden type="text" name="id" value="${(user.id)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>