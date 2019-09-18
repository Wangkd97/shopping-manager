package com.neuedu.controller;

import com.neuedu.pojo.Category;
import com.neuedu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

        Map<String,List<Category>> map = new HashMap<>();
        int temp=0;  //这是为了去除0级商品
        System.out.println("kindList2.size()=="+kindList2.size());
        for (int i=0;i<=kindList2.get(kindList2.size()-1).getKind()+1;i=i+1){
            System.out.println("i===="+i);
            ArrayList<Category> list = new ArrayList<>();
            for(int j=temp;j<kindList2.size()-1;){
                System.out.println("temp"+temp);

                System.out.println("j===="+j);
                System.out.println("kindList2.size()-2    "+(kindList2.size()-2));
                System.out.println("kindList2.get(j).getKind()  "+kindList2.get(j).getKind());
                if(kindList2.get(j).getKind()==kindList2.get(j+1).getKind()){
                   list.add(kindList2.get(j));
                    System.out.println(kindList2.get(j)+"===="+j);
                }else{
                    System.out.println(kindList2.get(j)+"*************");
                    list.add(kindList2.get(j));
                    kindList.add(list);
                    map.put(i+"",list);
                    temp=temp+1;
                    break;
                }
                j=j+1;
                temp=temp+1;
            }
            if (i==kindList2.get(kindList2.size()-1).getKind()+1){
                Category lastcategory= kindList2.get(kindList2.size()-1);
                Category lastSecond=kindList2.get(kindList2.size()-2);
                if(lastcategory.getKind()==lastSecond.getKind()){
                    kindList.get(kindList.size()-1).add(lastcategory);
                    kindList.add(list);
                    map.put(i+"",list);
                }else{
                    ArrayList<Category> list22 = new ArrayList<>();
                    list22.add(lastcategory);
                    kindList.add(list22);
                    map.put(i+"",list22);
                }

            }
        }

        for (List<Category> cc:kindList){
            System.out.println("=============");
            for (Category c:cc) {
                System.out.println(c.getName());
            }
        }
        session.setAttribute("kindSize",kindList.size()-1); //去除0级商品
       session.setAttribute("kindList",kindList);

        session.setAttribute("kindMap",map);

        return "category/list";
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

        return "category/index";
    }

    @RequestMapping(value = "update/${id}}",method = RequestMethod.POST)
    public  String  update(Category category, HttpServletRequest request,
                           HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println(category.getParent_id()+" ==="+category.getParentId()+"==");
        //
        if (category.getId()==null){
            addCategory(category);
            return "redirect:/user/category/find";

        }else{
            int count= categoryService.updateCategory(category);
            if(count>0){
                //修改成功
                return "redirect:/user/category/find";
            }
        }
        //return "category/index";
        return "redirect:/user/category/find";
    }
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public  String  update2(Category category, HttpServletRequest request,
                           HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println(category.getParent_id()+" ==="+category.getParentId()+"==");
       //
        if (category.getId()==null){
            addCategory(category);
        }
       int count= categoryService.updateCategory(category);
       if(count>0){
           //修改成功
           return "redirect:/user/category/find";
       }

        return "category/index";
    }

    @RequestMapping(value = "insert")
    public String insert(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        List<Category> list = categoryService.newSelectAll();
        request.setAttribute("categorykinds",list);
        return "category/index";
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
        return "forward:/user/category/find";
    }

    @RequestMapping("deleteById/{id}")
    public String deleteById(@PathVariable("id") int id){
        int i=categoryService.deleteCategory(id);
        if (i>0){
            return "redirect:/user/category/find";
        }
        return "categoryupdate";
    }
    @RequestMapping("addCategory")
    public String addCategory( Category ca){
        if (ca.getParentId()!=null&&ca.getName()!=null){
            Category last=categoryService.selectLast();
            System.out.println(last.getSortOrder()+"========");
            System.out.println(last.getSort_order()+"***********");
            ca.setSortOrder(last.getSortOrder());
            ca.setSortOrder(last.getSort_order()+1);
            ca.setSort_order(last.getSort_order()+1);
            ca.setSort_order(last.getSortOrder());
            int i=categoryService.addCategory(ca);

            if (i>0){
               // return "redirect:/user/category/find";
                return "category/list";
            }
        }

        return "categorylist"; //这个使用freemarker还需要修改
    }
}
