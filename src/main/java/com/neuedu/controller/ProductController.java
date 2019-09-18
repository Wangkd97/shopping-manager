package com.neuedu.controller;

import com.neuedu.pojo.Category;
import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import com.neuedu.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        return "product/list";
    }

    @RequestMapping("selectById/{id}")
    public String selectById(@PathVariable("id") int id,HttpSession session){
        Product product=iProductService.selectById(id);

        List<Category> list =iProductService.newSelectAll();
        session.setAttribute("productInfo",product);
        session.setAttribute("categoryList",list);
        return "product/index";
    }
    @RequestMapping("update")
    public String update(Product product,HttpSession session){

        if (product.getId()!=null){
            System.out.println(product.getSubImages()+"===");
            int i=iProductService.updateById(product);

            if (i>0){
                return "redirect:/user/product/getAll";
            }

        }else{
            int i=iProductService.insert(product);
            if (i>0){
                return "redirect:/user/product/getAll";
            }
        }

        return "product/index";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") int id){
        int i=iProductService.deleteById(id);
        if (i>0){
            return "redirect:/user/product/getAll";
        }
        return "product/index";

    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(Product product){
        int i=iProductService.insert(product);
        if (i>0){
            return "redirect:/user/product/getAll";
        }
        return "product/index";
    }
    @RequestMapping(value = "insert",method = RequestMethod.GET)
    public String insert(HttpSession session){
        List<Category> list =iProductService.newSelectAll();
        session.setAttribute("categoryList",list);
        return "product/insert";
    }

    @RequestMapping("updatestatus/{id}/{status}")
    public String updatestatus(@PathVariable("id") int id,
                               @PathVariable("status") int status,
                               Product product){

        product.setStatus(status);
        product.setId(id);
        int i=iProductService.updatestatus(product);
        if (i>0){
            return "redirect:/user/product/getAll";
        }
        return "redirect:/user/product/getAll";
    }
    @RequestMapping("getfenye/{page}/{size}")
    public String getfenye(@PathVariable("page") int page,
                           @PathVariable("size") int size,HttpSession session){
        List<Product> list = iProductService.getfenye(page,size);
        System.out.println(list);
        session.setAttribute("list",list);
        return "product/list";

    }


}
