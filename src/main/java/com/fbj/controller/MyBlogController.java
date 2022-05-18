package com.fbj.controller;

import com.fbj.pojo.Blog;
import com.fbj.pojo.Comment;
import com.fbj.pojo.Tag;
import com.fbj.pojo.Type;
import com.fbj.service.BlogService;
import com.fbj.service.CommentService;
import com.fbj.service.TagService;
import com.fbj.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.model.IModel;
import until.RedisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class MyBlogController {
    @Autowired
private BlogService blogservice;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    @Autowired
   RedisTemplate redisTemplate;
    @Autowired
    CommentService commentService;
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
    List<Integer> list = blogservice.orderBySize();
    Collections.reverse(list);
    List<Integer>  list1 = list.subList(0,list.size()-2);
    List<String> title = blogservice.getTitle(list1.get(0));
    String string = title.toString();
    model.addAttribute("siez",string);
    List<String> title1 = blogservice.getTitle(list1.get(1));
    String string1 = title1.toString();
    model.addAttribute("siez1",string1);
    List<String> title2 = blogservice.getTitle(list1.get(2));
    String string2 = title2.toString();
    model.addAttribute("siez2",string2);

    return  "blog/article";
}
    @RequestMapping("/article/{type_id}")
    public String article1(Model model,@PathVariable Long type_id){
        List<Blog> blogs = blogservice.queryMyBlog(type_id);
        model.addAttribute("myblog",blogs);
        List<Type> allType = typeService.getAllType();
        model.addAttribute("mytype",allType);
        List<Type> allTypes = typeService.getAllType();
        List<Tag> allTag = tagService.getAllTag();
        model.addAttribute("mytype",allTypes);
        model.addAttribute("mytag",allTag);
        return  "blog/article";
        
    }
    @RequestMapping("/articles/{id}")
    public  String article2(Model model,@PathVariable Long id){
    List<Blog> blogList=blogservice.queryMyBlogs(id);
        model.addAttribute("myblog",blogList);
        List<Type> allTypes = typeService.getAllType();
        List<Tag> allTag = tagService.getAllTag();
        model.addAttribute("mytype",allTypes);
        model.addAttribute("mytag",allTag);
        return  "blog/article";
}


@RequestMapping("/read/{id}")
public  String  read(Model model, @PathVariable Long id, HttpSession session){
    Blog blog = blogservice.getBlog(id);
    model.addAttribute("myblog",blog);
    RedisUtil redisUtil=new RedisUtil();
   redisTemplate.opsForHash().increment("views"+id, 1, 1);
    Integer a =(Integer) redisTemplate.opsForHash().get("views" + id,1);
          blogservice.updateBlog(blog.getId(),a);
    model.addAttribute("view",a);
    session.setAttribute("view",a);
    return "blog/read";
}

    /*
          这里是跳转到留言的页面
     */
    @RequestMapping("/blogmessage")
    public String blogMessage(HttpServletRequest request, Model model){
        List<Comment>list= commentService.list();
        model.addAttribute("comment_list",list);
        //System.out.println(list.size());
        // System.out.println("留言的地方 ！！！");
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
