package com.fbj.controller;

import com.fbj.pojo.Link;
import com.fbj.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogLinkController {

@Autowired
    LinkService linkService;


    @RequestMapping("/bloglink")
    public String  blogLink(Model model){
        List<Link> allLink = linkService.getAllLink();
        model.addAttribute("alllink",allLink);
        return "blog/bloglink";
    }

}
