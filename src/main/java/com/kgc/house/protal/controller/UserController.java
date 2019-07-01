package com.kgc.house.protal.controller;

import com.kgc.house.entity.Users;
import com.kgc.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("checkUname")
    @ResponseBody
    public String checkUname(String username){
        //调用业务
        int i = userService.checkUname(username);
        return "{\"result\":"+i+"}";  //返回json
    }
    @RequestMapping("regUser")
    public String regUser(Users users){
        //调用业务
        int i = userService.addUsers(users);
        if(i>0)
            return "login";
        else
            return "error";
    }

    @RequestMapping("login")
    public String regUser(String username, String password, Model model, HttpSession session){
        //调用业务

        Users user = userService.login(username, password);
        if(user==null){
            model.addAttribute("info","用户名密码错误！");
            return "login";//继续登入
        }else {
            //只要登入:使用session或者cookie保存登入的信息
            session.setAttribute("user",user);
            session.setMaxInactiveInterval(300);
            return "redirect:getUserHouse";
        }
    }
}
