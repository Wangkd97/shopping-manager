package com.neuedu.service;

import com.neuedu.pojo.Order;

import java.util.List;

public interface IOrderService {
    public List<Order> selectAll();
    public int alterStatus(Long orderNo);
}
