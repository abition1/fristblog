package com.fbj.service;

import com.fbj.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeService  {

Type  saveType(Type type);

Type  getType(long id);  //通过id来获得它的类型

Type  updateType(Type type); //更新

void  deleteType(long id);  //通过id来删除

Page<Type>  listType(Pageable pageable); //分页查询

}
