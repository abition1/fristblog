package com.fbj.service;

import com.fbj.pojo.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentService {
    //添加评论
    Comment save(Comment comment);
}
