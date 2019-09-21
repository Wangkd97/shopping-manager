package com.neuedu.vo;

import com.neuedu.pojo.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public class orderDetailVo {
    private Long orderNo;
    private BigDecimal total;
    private List<OrderItem> list;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<OrderItem> getList() {
        return list;
    }

    public void setList(List<OrderItem> list) {
        this.list = list;
    }
}
