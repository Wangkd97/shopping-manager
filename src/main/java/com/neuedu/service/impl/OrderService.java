package com.neuedu.service.impl;

import com.neuedu.dao.OrderMapper;
import com.neuedu.pojo.Order;
import com.neuedu.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService{

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> selectAll() {
        return orderMapper.selectAll();
    }

    @Override
    public int alterStatus(Long orderNo) {

        return orderMapper.alterStatus(orderNo);
    }
}
