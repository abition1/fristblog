package com.fbj.dao;

import com.fbj.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
    @Query(nativeQuery = true,value = "select * from t_user where username = ?")
User findByUsername(String username);
}
