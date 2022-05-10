package com.fbj.dao;

import com.fbj.pojo.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogDao extends JpaRepository<Blog,Long> {
    Page<Blog> findAll(Specification<Blog> blogSpecification, Pageable pageable);
}
