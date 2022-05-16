package com.fbj.controller.comment;

import com.fbj.pojo.Comment;
import com.fbj.service.CommentService;
import com.fbj.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
        service.save(comment);
        System.out.println("zhelimian");
        return "blog/message";

    }
@RequestMapping("/testcomment")
    public  String OOO(){
    System.out.println("你好");
        return "blog/message";
}
}
