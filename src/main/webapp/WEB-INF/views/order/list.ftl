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
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>订单id</th>
                            <th>姓名</th>
                            <th>手机号</th>
                            <th>地址</th>
                            <th>金额</th>
                            <th>订单状态</th>
                            <#--<th>支付状态</th>-->
                            <th>创建时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list orderDTOPage.list as orderDTO>
                        <tr>
                            <td>${orderDTO.orderId}</td>
                            <td>${orderDTO.shipname}</td>
                            <td>${orderDTO.phone}</td>
                            <td>${orderDTO.address}</td>
                            <td>${orderDTO.total}</td>
                            <td>${orderDTO.orderStatus}</td>
                            <#--<td>${orderDTO.getPayStatusEnum().message}</td>-->
                            <td>${orderDTO.createTime}</td>
                            <td><a href="/business/user/order/selectdetail/${orderDTO.orderId}">详情</a></td>
                            <td>
                                <#if orderDTO.orderStatus == "已支付">
                                    <a href="/business/user/order/alterStatus/${orderDTO.orderId}">发货</a>
                                </#if>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

            <#--分页-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                    <#if orderDTOPage.currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li><a href="/business/user/order/selectfenye/${orderDTOPage.currentPage - 1}/${size}">上一页</a></li>
                    </#if>

                    <#list 1..orderDTOPage.totalPage as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/business/user/order/selectfenye/${index}/${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if orderDTOPage.currentPage gte orderDTOPage.totalPage>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/business/user/order/selectfenye/${orderDTOPage.currentPage + 1}/${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>

<#--弹窗-->
<#--<div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">-->
    <#--<div class="modal-dialog">-->
        <#--<div class="modal-content">-->
            <#--<div class="modal-header">-->
                <#--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>-->
                <#--<h4 class="modal-title" id="myModalLabel">-->
                    <#--提醒-->
                <#--</h4>-->
            <#--</div>-->
            <#--<div class="modal-body">-->
                <#--你有新的订单-->
            <#--</div>-->
            <#--<div class="modal-footer">-->
                <#--<button onclick="javascript:document.getElementById('notice').pause()" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>-->
                <#--<button onclick="location.reload()" type="button" class="btn btn-primary">查看新的订单</button>-->
            <#--</div>-->
        <#--</div>-->
    <#--</div>-->
<#--</div>-->



<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script>
    // var websocket = null;
    // if('WebSocket' in window) {
    //     websocket = new WebSocket('ws://sell.natapp4.cc/sell/webSocket');
    // }else {
    //     alert('该浏览器不支持websocket!');
    // }
    //
    // websocket.onopen = function (event) {
    //     console.log('建立连接');
    // }
    //
    // websocket.onclose = function (event) {
    //     console.log('连接关闭');
    // }
    //
    // websocket.onmessage = function (event) {
    //     console.log('收到消息:' + event.data)
    //     //弹窗提醒, 播放音乐
    //     $('#myModal').modal('show');
    //
    //     document.getElementById('notice').play();
    // }
    //
    // websocket.onerror = function () {
    //     alert('websocket通信发生错误！');
    // }
    //
    // window.onbeforeunload = function () {
    //     websocket.close();
    // }

</script>

</body>
</html>