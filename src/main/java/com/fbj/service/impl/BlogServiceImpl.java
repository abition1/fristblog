package com.fbj.service.impl;

import com.fbj.dao.BlogDao;
import com.fbj.pojo.Blog;
import com.fbj.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl  implements BlogService {

    @Autowired
    BlogDao blogDao;



    @Override
    public Blog saveBlog(Blog blog) {
        return  blogDao.save(blog);
    }

    @Override
    public Blog updateBlog(Blog blog) {
        return null;
    }

    @Override
    public void deleBlog(Long id) {
        blogDao.deleteById(id);
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable) {
        return blogDao.findAll(pageable);
    }
}
