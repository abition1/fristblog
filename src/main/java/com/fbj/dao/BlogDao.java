package com.fbj.dao;

import com.fbj.pojo.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogDao extends JpaRepository<Blog,Long> {
}
