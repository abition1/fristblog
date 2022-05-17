package com.fbj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogLinkController {




    @RequestMapping("/bloglink")
    public String  blogLink(){

        return "blog/bloglink";
    }
}
