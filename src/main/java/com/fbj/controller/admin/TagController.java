package com.fbj.controller.admin;

import com.fbj.pojo.Tag;
import com.fbj.service.TagService;
import com.fbj.service.TypeService;
import com.fbj.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 标签controller层
 **/
@Controller
public class TagController {
    @Autowired
    TagService service;
    /**
     * 管理员后台标签主页面
     * @return
     */
    @RequestMapping("/tagmain")
    public String main_tag(){
        System.out.println("标签主页面");
        return "admin/Tag/main";
    }
    /**
     * 添加标签方法
     */
    @RequestMapping("/addtag")
    public String addTag(Tag tag){
        service.saveTag(tag);

        return "admin/Tag/main";
    }
    /**
     * 查询全部
     */
    @RequestMapping("/selectAll")
    public String selectAll(@PageableDefault(size = 10,sort = "id",direction = Sort.Direction.DESC) Pageable pageable, Model model){
        model.addAttribute("tag",service.listTag(pageable));
        return "admin/Tag/main";
    }

}