package com.neuedu.controller;

import com.neuedu.pojo.Order;
import com.neuedu.pojo.Shipping;
import com.neuedu.service.IOrderService;
import com.neuedu.service.IShipService;
import com.neuedu.vo.oderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user/order/")
public class OrderController {

    @Autowired
    IOrderService iOrderService;
    @Autowired
    IShipService iShipService;

    @RequestMapping("selectAll")
    public String selectAll(HttpSession session){
        List<oderVo> oderVolist=new ArrayList<>();
        List<Order> list = iOrderService.selectAll();
        for (Order o:list) {
            System.out.println(o.getOrderNo()+"o.num========");
            oderVo oder=new oderVo();
            Shipping shipping=iShipService.selectByPrimaryKey(o.getShippingId());
            String address=shipping.getReceiverProvince()+shipping.getReceiverCity()+shipping.getReceiverDistrict()+shipping.getReceiverAddress();
            oder.setAddress(address);
            oder.setOrderId(o.getOrderNo());
            if (o.getStatus()==10){
                oder.setOrderStatus("未支付");
            }if (o.getStatus()==20){
                oder.setOrderStatus("已支付");
            }if (o.getStatus()==40){
                oder.setOrderStatus("已发货");
            }if (o.getStatus()==50){
                oder.setOrderStatus("交易成功");
            }
            oder.setPhone(shipping.getReceiverPhone());
            oder.setShipname(shipping.getReceiverName());
            oder.setTotal(o.getPayment());
            oder.setCreateTime(o.getCreateTime().toString());

            oderVolist.add(oder);

        }
        session.setAttribute("orderDTOPage",oderVolist);
        return "/order/list";
    }

    @RequestMapping("alterStatus/{orderNo}")
    public String alterStatus(@PathVariable("orderNo") Long orderNo){

        System.out.println(orderNo+"===========dingdanhao======");
        int i=iOrderService.alterStatus(orderNo);
        if (i>0){
            return "redirect:/user/order/selectAll";
        }
        return "redirect:/user/order/selectAll";
    }

}
