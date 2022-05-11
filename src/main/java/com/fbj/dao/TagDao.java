package com.fbj.dao;

import com.fbj.pojo.Tag;
import com.fbj.pojo.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 标签dao层
 */
public interface TagDao extends JpaRepository<Tag,Long> {
    @Query(nativeQuery = true,value = "select * from t_tag where name = ?")
    Tag   getTagName(String name);
}
