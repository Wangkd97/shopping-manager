package com.neuedu.service.impl;

import com.neuedu.dao.OrderItemMapper;
import com.neuedu.pojo.OrderItem;
import com.neuedu.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemImpl implements IOrderItemService {
    @Autowired
    OrderItemMapper iOrderItemService;

    @Override
    public List<OrderItem> selectByNo(Long no) {
        return iOrderItemService.selectByNo(no);
    }
}
