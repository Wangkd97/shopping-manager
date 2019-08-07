package com.neuedu.controller;

import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/user/product/")
public class ProductController {

   @Autowired
   IProductService iProductService;

    @RequestMapping("getAll")
    public  String getAll(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        List<Product> list = iProductService.getAllProduct();
        System.out.println(list);
        session.setAttribute("list",list);
        return "productlist";
    }


}
