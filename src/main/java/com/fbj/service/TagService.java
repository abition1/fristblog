package com.fbj.service;


import com.fbj.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagService {
    //添加标签
    Tag saveTag(Tag tag);
    //查询全部
    Page<Tag> listTag(Pageable pageable);
    //删除标签
    void  deleteTag(long id);
    //更改
    Tag  updateType(Tag tag); //更新
    //id.。.
    Tag  getType(long id);  //通过id来获得它的内容

    List<Tag>  getAllTag(); //提供给blog

    Tag   getTagName(String name); //通过姓名非空校验

    List<Tag>   queryById(Long id);
}
