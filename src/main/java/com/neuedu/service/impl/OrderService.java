package com.neuedu.service.impl;

import com.neuedu.dao.OrderMapper;
import com.neuedu.pojo.Order;
import com.neuedu.service.IOrderService;
import com.neuedu.vo.pageVo;
import org.apache.xpath.operations.Or;
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

    @Override
    public List<Order> selectfenye(pageVo pageVo) {
        return orderMapper.selectfenye(pageVo);
    }
    @Override
    public int selectcount() {
        return orderMapper.selectcount();
    }
    @Override
    public List<Order> selectfahuo(pageVo pageVo){
        return orderMapper.selectfahuo(pageVo);
    }
    @Override
    public int selectfahuocount(){
        return orderMapper.selectfahuocount();
    }
    @Override
    public Order selectByNo(Long no){
        return orderMapper.selectByNo(no);
    }
}
