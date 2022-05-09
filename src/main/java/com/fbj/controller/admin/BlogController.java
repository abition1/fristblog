package com.fbj.controller.admin;

import com.fbj.pojo.Type;
import com.fbj.service.BlogService;
import com.fbj.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
@Autowired
    TypeService typeService;
    @RequestMapping("/blogs")
//通过@PageableDeafault来对分页数据的控制
    public String  Pagelist(@PageableDefault(size = 5,sort = "id",direction = Sort.Direction.DESC) Pageable pageable, Model model){
        model.addAttribute("blogs",blogService.listBlog(pageable));
      List<Type> list= typeService.getAllType();
      model.addAttribute("type",list);
        return  "admin/blogs" ;

    }

}
