package com.fbj.dao;

import com.fbj.pojo.Tag;
import com.fbj.pojo.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 标签dao层
 */
public interface TagDao extends JpaRepository<Tag,Long> {
}
