package com.neuedu.controller;

import com.neuedu.pojo.Category;
import com.neuedu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/user/category/")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @RequestMapping("find")
    public  String  findAll(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        List<Category> categoryList=categoryService.findAll();
        session.setAttribute("categorylist",categoryList);

        List<Category> kindList2=categoryService.newSelectAll();
        List<List<Category>> kindList = new ArrayList<>();
        int temp=0;
        for (int i=0;i<=kindList2.get(kindList2.size()-1).getKind();i++){
            ArrayList<Category> list = new ArrayList<>();
            for(int j=temp;j<kindList2.size()-2;j++,temp++){
                if(kindList2.get(j).getKind()==kindList2.get(j+1).getKind()){
                   list.add(kindList2.get(j));
                }else{
                    list.add(kindList2.get(j));
                    kindList.add(list);
                    break;
                }
            }
        }
        Category lastcategory= kindList2.get(kindList2.size()-1);
        Category lastSecond=kindList2.get(kindList2.size()-2);
        if(lastcategory.getKind()==lastSecond.getKind()){
            kindList.get(kindList.size()-1).add(lastcategory);
        }else{
            ArrayList<Category> list = new ArrayList<>();
            list.add(lastSecond);
            kindList.add(list);
        }
        session.setAttribute("kindSize",kindList.size()-1);
        session.setAttribute("kindList",kindList);



        return "categorylist";
    }


    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public  String  update(@PathVariable("id") Integer categoryId,
                           HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        List<Category> list = categoryService.newSelectAll();
        request.setAttribute("categorykinds",list);

        Category category=categoryService.findCategoryById(categoryId);
        request.setAttribute("category",category);

        return "categoryupdate";
    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public  String  update(Category category, HttpServletRequest request,
                           HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println(category.getParent_id()+" ==="+category.getParentId()+"==");
       //
       int count= categoryService.updateCategory(category);


       if(count>0){
           //修改成功
           return "redirect:/user/category/find";
       }

        return "categoryupdate";
    }

    @RequestMapping("findAll")
    public String newFindAll(HttpSession session){
        //这个是查询商品类别
        List<Category> list = categoryService.newSelectAll();
        session.setAttribute("categorykinds",list);
        return "categoryupdate";
    }
    @RequestMapping("selectByKind/{kind}")
    public String selectByKind(@PathVariable("kind") int kind ,HttpSession session){
        List<Category> list = categoryService.selectByKind(kind);
        session.setAttribute("subcategory",list);
        return "categoryupdate";
    }

    @RequestMapping("deleteById/{id}")
    public String deleteById(@PathVariable("id") int id){
        int i=categoryService.deleteCategory(id);
        if (i>0){
            return "redirect:/user/category/find";
        }
        return "categoryupdate";
    }
}
