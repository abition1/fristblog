package com.fbj.service;

import com.fbj.pojo.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentService {
    //添加评论
    Comment save(Comment comment);
    //查询所有评论
    List<Comment> list();
}
