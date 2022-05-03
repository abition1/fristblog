package com.fbj.controller.admin;

import com.fbj.pojo.User;
import com.fbj.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/login")
    public String  login(){

        return "admin/login";
    }
    @RequestMapping("/tologin")
    public String tologin(String username, String password, HttpSession session, Model model){
     User user= userService.findByUsernameAndPassword(username,password);
        if(user!=null){
            user.setPassword(null);
            session.setAttribute("user",user);
            return "admin/index";
        }
        model.addAttribute("error","用户名或者密码错误");
        return "redirect:/login";
    }
}
