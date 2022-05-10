package com.fbj.service.impl;

import com.fbj.dao.TypeDao;
import com.fbj.pojo.Type;
import com.fbj.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
   @Autowired
    TypeDao typeDao;

   @Transactional    //把他们放到事务之中；
    @Override
    public Type saveType(Type type) {
        return typeDao.save(type);
    }
    @Transactional
    @Override
    public Type getType(long id) {
        return typeDao.getById(id);
    }
    @Transactional
    @Override
    public  Type updateType( Type type) {
        return  typeDao.save(type);
    }
    @Transactional
    @Override
    public void deleteType(long id) {
         typeDao.deleteById(id);
    }
    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeDao.findAll(pageable);   //分页查询，会返回给你一个pageable的对象回来
    }

    @Override
    public List<Type> getAllType() {
        return typeDao.findAll();
    }

    @Override
    public Type getTypeByName(String name) {
        return typeDao.getTypeByName(name);
    }
}
