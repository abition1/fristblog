package com.fbj.service;

import com.fbj.pojo.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import until.BlogQuery;

import java.util.List;

@Repository
public interface BlogService {

     Blog saveBlog(Blog blog);
     Blog  updateBlog(Blog blog);
     void  deleBlog(Long id);
     Page<Blog>  listBlog(Pageable pageable, BlogQuery blog);
     List<Blog> queryAllBlog();
    Blog  getBlog(Long id);
     Page<Blog>  listBlogS(Pageable pageable);

     Blog  getBlogByName(String title);
}
