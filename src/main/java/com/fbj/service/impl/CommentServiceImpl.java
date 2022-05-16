package com.fbj.service.impl;

import com.fbj.dao.CommentDao;
import com.fbj.pojo.Comment;
import com.fbj.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;
    @Transactional
    @Override
    public Comment save(Comment comment) {
        return commentDao.save(comment);
    }
}
