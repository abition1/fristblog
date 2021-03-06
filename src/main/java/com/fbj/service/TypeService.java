package com.fbj.service;

import com.fbj.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService  {

Type  saveType(Type type);//添加分类

Type  getType(long id);  //通过id来获得它的类型

Type  updateType(Type type); //更新

void  deleteType(long id);  //通过id来删除

Page<Type>  listType(Pageable pageable); //分页查询

 List<Type>  getAllType(); //获得所有type，给blog分类查询使用

 Type  getTypeByName(String name);
}
