<html>
<#include "common/header.ftl">

<body>
<div id="wrapper" class="toggled">

<#--边栏sidebar-->
    <#include "common/nav.ftl">


<#--主要内容content-->


    <div id="page-content-wrapper">
        <div>
          <input><button>查询</button>
        </div>
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-4 column">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>订单id</th>
                            <th>订单总金额</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${orderDTO.orderNo}</td>
                            <td>${orderDTO.total}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>

            <#--订单详情表数据-->
                <div class="col-md-12 column">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>商品id</th>
                            <th>商品名称</th>
                            <th>价格</th>
                            <th>数量</th>
                            <th>总额</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list orderDTO.list as orderDetail>
                        <tr>
                            <td>${orderDetail.productId}</td>
                            <td>${orderDetail.productName}</td>
                            <td>${orderDetail.currentUnitPrice}</td>
                            <td>${orderDetail.quantity}</td>
                            <td>${orderDetail.quantity * orderDetail.currentUnitPrice}</td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

            <#--操作-->
                <div class="col-md-12 column">
                <#if orderDTO.status == 20>
                    <a href="/business/user/order/selectdetail/${orderDTO.orderId}" type="button" class="btn btn-default btn-primary">详情</a>
                    <a href="/business/user/order/alterStatus/${orderDTO.orderId}" type="button" class="btn btn-default btn-danger">发货</a>
                </#if>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>