package com.fbj.controller;

import com.fbj.pojo.Blog;
import com.fbj.pojo.Tag;
import com.fbj.pojo.Type;
import com.fbj.service.BlogService;
import com.fbj.service.TagService;
import com.fbj.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.model.IModel;

import java.util.List;

@Controller
public class MyBlogController {
    @Autowired
private BlogService blogservice;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
@RequestMapping("/bloglogin")
    public String  blogLogin(){

    return  "blog/blogindex";

}
@RequestMapping("/article")
    public String article(Model model){
    List<Blog> blogs = blogservice.queryAllBlog();
    List<Type> allType = typeService.getAllType();
    List<Tag> allTag = tagService.getAllTag();
    model.addAttribute("myblog",blogs);
    model.addAttribute("mytype",allType);
    model.addAttribute("mytag",allTag);
    return  "blog/article";
}
    @RequestMapping("/article/{type_id}")
    public String article1(Model model,@PathVariable Long type_id){
        List<Blog> blogs = blogservice.queryMyBlog(type_id);
        model.addAttribute("myblog",blogs);
        List<Type> allType = typeService.getAllType();
        model.addAttribute("mytype",allType);
        return  "blog/article";
    }


@RequestMapping("/read/{id}")
public  String  read(Model model,@PathVariable Long id){
    Blog blog = blogservice.getBlog(id);
    model.addAttribute("myblog",blog);
   return "blog/read";
}


@RequestMapping("/blogmessage")
public String blogMessage(){


  return  "blog/message";
}

@RequestMapping("/blogsearch")
public  String  blogSearch(String query,Model model){
    List<Blog> blogs = blogservice.queryBlog("%" + query + "%");
    model.addAttribute("blogsearch",blogs);
model.addAttribute("query",query);
return "blog/seachth";
}


}
