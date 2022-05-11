package com.fbj.controller.admin;

import com.fbj.pojo.Blog;
import com.fbj.pojo.Tag;
import com.fbj.pojo.Type;
import com.fbj.service.BlogService;
import com.fbj.service.TagService;
import com.fbj.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import until.BlogQuery;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
@Autowired
    TypeService typeService;

@Autowired
    TagService tagService;
    @RequestMapping("/blogs")
//通过@PageableDeafault来对分页数据的控制
    public String  Pagelist(@PageableDefault(size = 5,sort = "updateTime",direction = Sort.Direction.DESC) Pageable pageable, Model model, BlogQuery blog){
        model.addAttribute("page",blogService.listBlogS(pageable));
      List<Type> list= typeService.getAllType();
      model.addAttribute("type",list);
        return  "admin/blogs" ;
    }

    @PostMapping("/search")
    public String search(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                         BlogQuery blog, Model model) {
        model.addAttribute("page",blogService.listBlog(pageable, blog));
        return "admin/blogs :: blogList";
    }

    @RequestMapping("/addblog")
    public String addBlog(Model model){
        model.addAttribute("blog",new Blog());
        List<Type> list= typeService.getAllType();
        List<Tag>  list1=tagService.getAllTag();
        model.addAttribute("types",list);
        model.addAttribute("tags",list1);
        return  "admin/addblog";

    }

    @PostMapping("/saveblog")
    public String saveBlog(Blog blog,Model model){

     Blog blog1=  blogService.saveBlog(blog);
       if(blog1==null){
           model.addAttribute("error","内容为空不能保存");
       }

        return "redirect:/blogs";
    }

    @RequestMapping("/deleteblog/{id}")
    public String  deleteBlog(@PathVariable Long id){
        blogService.deleBlog(id);
        return  "redirect:/blogs";
    }

@RequestMapping("/getblog/{id}")
    public String getBlog(@PathVariable Long id,Model model){
     Blog  blog =blogService.getBlog(id);
    int i= Math.toIntExact(blog.getId());
    model.addAttribute("id",i);
    model.addAttribute("blog",new Blog());
    List<Type> list= typeService.getAllType();
    List<Tag>  list1=tagService.getAllTag();
    model.addAttribute("types",list);
    model.addAttribute("tags",list1);
     model.addAttribute("infos",blog);
     return "admin/updateblog";
}

@RequestMapping("/saveblog")
public String saveBlog(Blog blog){
 blogService.saveBlog(blog);
        return "admin/blogs";
}
}
