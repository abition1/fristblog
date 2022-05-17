package com.fbj.service.impl;

import com.fbj.dao.BlogDao;
import com.fbj.pojo.Blog;
import com.fbj.pojo.Type;
import com.fbj.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import until.BlogQuery;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.Predicate;

@Service
public class BlogServiceImpl  implements BlogService {

    @Autowired
    BlogDao blogDao;
    @Override
    public Blog saveBlog(Blog blog) {
        Date date=new Date();
       blog.setCreateTime(date);
       blog.setUpdateTime(date);
        return  blogDao.save(blog);
    }

    @Override
    public Blog updateBlog(Blog blog) {
        return blogDao.save(blog);
    }

    @Override
    public void deleBlog(Long id) {
        blogDao.deleteById(id);
    }


    @Override
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {
        return blogDao.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (!"".equals(blog.getTitle()) && blog.getTitle() != null) {
                    predicates.add((Predicate) cb.like(root.<String>get("title"), "%"+blog.getTitle()+"%"));
                }
                if (blog.getTypeId() != null) {
                    predicates.add(cb.equal(root.<Type>get("type").get("id"), blog.getTypeId()));
                }
                if (blog.isRecommend()) {
                    predicates.add(cb.equal(root.<Boolean>get("recommend"), blog.isRecommend()));
                }
                cq.where( predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        },pageable);
    }

    @Override
    public List<Blog> queryAllBlog() {
        return  blogDao.findAll();
    }

    @Override
    public Blog getBlog(Long id) {
        return blogDao.getById(id);
    }

    @Override
    public Page<Blog> listBlogS(Pageable pageable) {
        return  blogDao.findAll(pageable);
    }

    @Override
    public Blog queryAllsBlog() {
        return blogDao.queryAllsBlog();
    }

    @Override
    public Blog getBlogByName(String title) {
        return blogDao.getBlogByName(title);
    }

    @Override
    public List<Blog> queryBlog(String query) {
        return blogDao.queryBlog(query);
    }

    @Override
    public List<Blog> queryMyBlog(Long type_id) {
        return blogDao.queryMyBlog(type_id);
    }

    @Override
    public int updateBlog(Long id, int views) {
        return blogDao.updateBlog(id,views);
    }

    @Override
    public List<Integer> orderBySize() {
        return blogDao.orderBySize();
    }

    @Override
    public List<String> getTitle(int views) {
        return blogDao.getTitle(views);
    }

    @Override
    public List<Blog> queryMyBlogs(Long id) {
        return blogDao.queryMyBlogs(id);
    }


}
