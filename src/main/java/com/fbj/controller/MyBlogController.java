package com.fbj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBlogController {

@RequestMapping("/bloglogin")
    public String  blogLogin(){

    return  "blogindex";


}
}
