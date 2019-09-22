package com.neuedu.service;

import com.neuedu.pojo.Order;
import com.neuedu.vo.pageVo;

import java.util.List;

public interface IOrderService {
    public List<Order> selectAll();
    public int alterStatus(Long orderNo);
    public  List<Order> selectfenye(pageVo pageVo);
    public int selectcount();
    public  List<Order> selectfahuo(pageVo pageVo);
    public int selectfahuocount();
    public Order selectByNo(Long no);
    public int cancelOrder(Long no);
}
