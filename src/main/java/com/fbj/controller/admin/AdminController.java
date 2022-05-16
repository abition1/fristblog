package com.fbj.controller.admin;

import com.fbj.pojo.User;
import com.fbj.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/login")
    public String  login(){

        return "/admin/login";
    }

    @RequestMapping("/tologin")
    public  String login(String username, String password, Model model, HttpSession session){
        Subject subject= SecurityUtils.getSubject();//获取用户对象
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);//将用户对象封装起来
        try {
            subject.login(token);
            session.setAttribute("user",token);
            return "admin/index";
        }catch (UnknownAccountException e){
            model.addAttribute("message","用户名错误");
            return "admin/login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("message","密码错误");
            return "admin/login";
        }

    }
    @RequestMapping("/logout")
    public  String  logout(HttpSession session){
        session.removeAttribute("user");
          return "redirect:/login";

    }

}
