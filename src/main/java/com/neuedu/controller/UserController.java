package com.neuedu.controller;

import com.neuedu.consts.Const;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    IUserService userService;
    @RequestMapping(value="login",method = RequestMethod.GET)
    public  String login(HttpSession session){
        if (session.getAttribute("user")!=null){
            return "redirect:home";
        }
        return "index";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public  String login(UserInfo userInfo, HttpSession session){


        if (session.getAttribute("user")!=null){
            return "redirect:home";
        }
       UserInfo loginUserInfo= userService.login(userInfo);

        System.out.println(loginUserInfo);

        if(loginUserInfo!=null){
            session.setAttribute(Const.CURRENT_USER,loginUserInfo);

            return "redirect:home";
        }
        return "index";
    }


    @RequestMapping("home")
    public  String  home(){

        return "home/home";
    }

    @RequestMapping("getAllUser")
    public String getAllUser(HttpSession session){

        List<UserInfo> list =userService.getAllUser();
        session.setAttribute("list",list);
        return "user/list";
    }

    @RequestMapping("regist")
    public String regist(){
        return "rigist";
    }
    @RequestMapping("index")
    public String index(){
        return "user/index";
    }

    @RequestMapping(value = "update/{id}",method =RequestMethod.GET)
    public String update(@PathVariable("id") int id,HttpSession session){
        UserInfo userInfo=userService.selectById(id);
        session.setAttribute("user",userInfo);
        return "user/index";
    }
    @RequestMapping(value = "update",method =RequestMethod.POST)
    public String update(UserInfo userInfo){
        if (userInfo.getId()==null){
            //注册
                int i = userService.insert(userInfo);
                if (i>0){
                    return "redirect:/user/getAllUser";
                }else{
                    return "index";
                }
        }else{
            //修改
            int j=userService.updateById(userInfo);
            if (j>0){
                return "redirect:/user/getAllUser";
            }else{
                return "index";
            }
        }

    }
    @RequestMapping(value = "deleteById/{id}")
    public String deleteById(@PathVariable("id") int id){
        int i=userService.deleteById(id);
        if (i>0){
            return "redirect:/user/getAllUser";
        }
        return "redirect:/user/getAllUser";
    }
    @RequestMapping("exit")
    public String exit(HttpSession session){
        session.invalidate();
        return "redirect:/user/login";
    }
}
