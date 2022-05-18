package com.fbj.controller.comment;

import com.fbj.pojo.Comment;
import com.fbj.service.CommentService;
import com.fbj.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class CommentController {
    @Autowired
    CommentServiceImpl service;
    @RequestMapping("/addcomment")
    public String test(HttpServletRequest request){
        String nickname=request.getParameter("nickname");
        String content=request.getParameter("editorContent");
        String email=request.getParameter("email");
        Comment comment=new Comment();
        comment.setNickname(nickname);
        comment.setContent(content);
        comment.setEmail(email);
        Date date=new Date();
        Timestamp time=new Timestamp(date.getTime());
        //  System.out.println(time);
        comment.setCreateTime(time);
        service.save(comment);

        System.out.println("zhelimian");
        return "redirect:/blogmessage";
    }
}
