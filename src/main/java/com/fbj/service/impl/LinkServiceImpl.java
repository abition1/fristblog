package com.fbj.service.impl;

import com.fbj.dao.LinkDao;
import com.fbj.pojo.Link;
import com.fbj.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    LinkDao linkDao;


    @Override
    public Page<Link> listLink(Pageable pageable) {
        return linkDao.findAll(pageable);
    }

    @Override
    public Link saveLink(Link link) {
        return linkDao.save(link);
    }

    @Override
    public void deleteLink(Long id) {
        linkDao.deleteById(id);
    }

    @Override
    public Link getLinkType(long id) {
        return linkDao.getById(id);
    }

    @Override
    public List<Link> getAllLink() {
        return linkDao.findAll();
    }


}
