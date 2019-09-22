<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav">
        <li class="sidebar-brand">
            <a href="#">
                卖家管理系统
            </a>
        </li>
        <#--<li>-->
            <#--<a href="/sell/seller/order/list"><i class="fa fa-fw fa-list-alt"></i> 订单</a>-->
            <#--<ul class="dropdown-menu" role="menu">-->
                <#--<li class="dropdown-header">操作</li>-->
                <#--<li><a href="/business/user/order/selectAll">列表</a></li>-->
                <#--<li><a href="/business/user/">新增</a></li>-->
            <#--</ul>-->
        <#--</li>-->
        <li class="dropdown open">
            <a href="" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 订单 <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li class="dropdown-header">操作</li>
                <li><a href="/business/user/order/selectfenye/1/10">订单列表</a></li>
                <li><a href="/business/user/order/selectfahuo/1/10">待发货订单</a></li>
                <li><a href="/business/user/order/gotofind">查询订单</a></li>
            </ul>
        </li>
        <li class="dropdown open">
            <a href="" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 商品 <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li class="dropdown-header">操作</li>
                <li><a href="/business/user/product/getfenye/1/10">商品列表</a></li>
                <li><a href="/business/user/product/insert">新增商品</a></li>
            </ul>
        </li>
        <li class="dropdown open">
            <a href="" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 类别 <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li class="dropdown-header">操作</li>
                <li><a href="/business/user/category/find">类别列表</a></li>
                <li><a href="/business/user/category/insert">新增类别</a></li>
            </ul>
        </li>
        <li class="dropdown open">
            <a href="" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 用户 <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li class="dropdown-header">操作</li>
                <li><a href="/business/user/getAllUser">用户列表</a></li>
            </ul>
        </li>
        <li>
            <a href="/business/user/exit"><i class="fa fa-fw fa-list-alt"></i> 登出</a>
        </li>
    </ul>
</nav>