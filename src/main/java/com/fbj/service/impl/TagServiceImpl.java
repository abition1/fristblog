package com.fbj.service.impl;

import com.fbj.dao.TagDao;
import com.fbj.pojo.Tag;
import com.fbj.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagDao tagDao;
    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagDao.save(tag);
    }


    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagDao.findAll(pageable);
    }
}
