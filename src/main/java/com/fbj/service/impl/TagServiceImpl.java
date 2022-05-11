package com.fbj.service.impl;

import com.fbj.dao.TagDao;
import com.fbj.pojo.Tag;
import com.fbj.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagDao tagDao;
    @Transactional
    @Override
    //添加标签
    public Tag saveTag(Tag tag) {
        return tagDao.save(tag);
    }
    //查询所有
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagDao.findAll(pageable);
    }
    //删除标签
    @Transactional
    @Override
    public void deleteTag(long id) {
        tagDao.deleteById(id);
    }
    //修改

    @Override
    public Tag updateType(Tag tag) {
        return tagDao.save(tag);
    }
    //获得内容

    @Override
    public Tag getType(long id) {
        return tagDao.getById(id);
    }

    @Override
    public List<Tag> getAllTag() {
        return tagDao.findAll();
    }

    @Override
    public Tag getTagName(String name) {
        return tagDao.getTagName(name);
    }


}
