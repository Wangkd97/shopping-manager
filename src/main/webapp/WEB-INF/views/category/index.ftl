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
                    <form role="form" method="post" action="/business/user/category/update">
                        <div class="form-group">
                            <label>名字</label>
                            <input name="name" type="text" class="form-control" value="${(category.name)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>级别</label>
                            <select  name="kind" id="kindid" onchange="getChange();">
                                <#list 1.. kindSize as i>
                                    <option value="${i}" name="kind" >${i}级类别</option>
                                </#list>

                        </select>
                        </div>
                        <div class="form-group">
                            <label>父类</label>
                            <input name="categoryType" type="number" class="form-control" value="${(category.sortOrder)!''}"/>
                            <select id="user_id" name="parentId">
                                    <#list categorykinds as u>
                                        <option value="${u.sortOrder}"  name="parent_id" <#if category.parentId==u.sortOrder>selected="selected"</#if>>
                                        ${u.name}
                                        </option>
                                    </#list>
                            </select>

                        </div>
                        <div class="form-group">
                            <label>状态</label>
                            <select id="zhuangtai" name="status">
                                <option name="status" value="1" <#if category.status=='1'>selected="selected"</#if>>正常</option>
                                <option name="status" value="2" <#if category.status=='2'>selected="selected"</#if>>已废弃</option>
                                <option name="status" value="3" <#if category.status=='3'>selected="selected"</#if>>删除</option>
                            </select>
                        </div>

                        <input hidden type="text" name="id" value="${(category.id)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>