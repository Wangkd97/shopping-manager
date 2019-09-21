package com.neuedu.service;


import com.neuedu.pojo.OrderItem;

import java.util.List;

public interface IOrderItemService {
    public List<OrderItem> selectByNo(Long no);
}
