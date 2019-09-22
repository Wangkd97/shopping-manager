package com.neuedu.controller;

import com.neuedu.pojo.Order;
import com.neuedu.pojo.OrderItem;
import com.neuedu.pojo.Shipping;
import com.neuedu.service.IOrderItemService;
import com.neuedu.service.IOrderService;
import com.neuedu.service.IShipService;
import com.neuedu.vo.oderVo;
import com.neuedu.vo.orderDetailVo;
import com.neuedu.vo.pageVo;
import com.neuedu.vo.returnOrderVo;
import com.sun.scenario.effect.impl.sw.java.JSWBrightpassPeer;
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
    @Autowired
    IOrderItemService iOrderItemService;
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
            }if (o.getStatus()==0){
                oder.setOrderStatus("已取消交易");
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
    @RequestMapping("selectfenye/{start}/{size}")
    public String selectfenye( @PathVariable("start")int start,
                               @PathVariable("size") int size,
                               HttpSession session){
        pageVo pageVo=new pageVo();
        returnOrderVo returnOrderVo=new returnOrderVo();
        pageVo.setStart((start-1)*size);
        pageVo.setSize(size);
        List<oderVo> oderVolist=new ArrayList<>();
        List<Order> list = iOrderService.selectfenye(pageVo);
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
            }if (o.getStatus()==0){
                oder.setOrderStatus("已取消交易");
            }
            oder.setPhone(shipping.getReceiverPhone());
            oder.setShipname(shipping.getReceiverName());
            oder.setTotal(o.getPayment());
            oder.setCreateTime(o.getCreateTime().toString());

            oderVolist.add(oder);

        }
        returnOrderVo.setList(oderVolist);
        returnOrderVo.setCurrentPage(start);
        int total=iOrderService.selectcount();
        if (total%size==0){
            total=total/10;
        }else{
            total=(total/10)+1;
        }
        returnOrderVo.setTotalPage(total);
        session.setAttribute("orderDTOPage",returnOrderVo);
        return "/order/list";
    }

    @RequestMapping("selectfahuo/{start}/{size}")
    public String selectfahuo( @PathVariable("start")int start,
                               @PathVariable("size") int size,
                               HttpSession session){
        pageVo pageVo=new pageVo();
        returnOrderVo returnOrderVo=new returnOrderVo();
        pageVo.setStart((start-1)*size);
        pageVo.setSize(size);
        List<oderVo> oderVolist=new ArrayList<>();
        List<Order> list = iOrderService.selectfahuo(pageVo);
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
        returnOrderVo.setList(oderVolist);
        returnOrderVo.setCurrentPage(start);
        int total=iOrderService.selectfahuocount();
        if (total%size==0){
            total=total/10;
        }else{
            total=(total/10)+1;
        }
        returnOrderVo.setTotalPage(total);
        session.setAttribute("orderDTOPage",returnOrderVo);
        return "/order/fahuolist";

    }

    @RequestMapping("selectdetail/{no}")
    public String selectdetail(@PathVariable("no") Long no,
                               HttpSession session){
        Order order=iOrderService.selectByNo(no);
        List<OrderItem> list =iOrderItemService.selectByNo(no);
        orderDetailVo orderDetailVo=new orderDetailVo();
        orderDetailVo.setList(list);
        orderDetailVo.setOrderNo(order.getOrderNo());
        orderDetailVo.setTotal(order.getPayment());
        orderDetailVo.setStatus(order.getStatus());
        session.setAttribute("orderDTO",orderDetailVo);
        return "/order/detail";

    }
    @RequestMapping("gotofind")
    public String gotofind(){
        return "/order/find";
    }

    @RequestMapping("finddetail/{no}")
    public String finddetail(@PathVariable("no") Long no,
                               HttpSession session){
        Order order=iOrderService.selectByNo(no);
        List<OrderItem> list =iOrderItemService.selectByNo(no);
        orderDetailVo orderDetailVo=new orderDetailVo();
        orderDetailVo.setList(list);
        orderDetailVo.setOrderNo(order.getOrderNo());
        orderDetailVo.setTotal(order.getPayment());
        orderDetailVo.setStatus(order.getStatus());
        session.setAttribute("orderDTO",orderDetailVo);
        return "/order/finddetail";

    }
    @RequestMapping("cancelOrder/{no}")
    public String cancelOrder(@PathVariable("no") Long no){
        int i=iOrderService.cancelOrder(no);
        if (i>0){
            return "redirect:/user/order/selectfenye/1/10";
        }
        return "redirect:/user/order/selectfenye/1/10";
    }
}
