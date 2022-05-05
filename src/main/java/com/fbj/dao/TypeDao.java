package com.fbj.dao;

import com.fbj.pojo.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TypeDao extends JpaRepository<Type,Long> {



    //@Query("update AdminUser set username=:#{#adminUser.username},password=:#{#adminUser.password} where id=:#{#adminUser.id}")


}
