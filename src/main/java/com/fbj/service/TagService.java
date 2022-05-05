package com.fbj.service;


import com.fbj.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface TagService {
    //添加标签
    Tag saveTag(Tag tag);
    //查询全部
    Page<Tag> listTag(Pageable pageable);
}
