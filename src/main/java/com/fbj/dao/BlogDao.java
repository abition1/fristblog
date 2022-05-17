package com.fbj.dao;

import com.fbj.pojo.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BlogDao extends JpaRepository<Blog,Long> {
    Page<Blog> findAll(Specification<Blog> blogSpecification, Pageable pageable);
    @Query(nativeQuery = true,value = "select * from t_blog where title = ?")
    Blog  getBlogByName(String title);
    @Query(nativeQuery = true,value = "select * from t_blog  where id = ?")
    Blog   queryAllsBlog();
    @Query(nativeQuery = true,value = "select * from t_blog  where title like ?1 or content like ?1")
    List<Blog> queryBlog(String query);
    @Query(nativeQuery = true,value = "select * from t_blog where type_id = ?")
    List<Blog> queryMyBlog(Long type_id);

    @Modifying
    @Transactional
    @Query(value="update t_blog set views=?2 where id=?1",nativeQuery=true)
    int  updateBlog(Long id,int views);
@Query(value = "select views from t_blog order by views ",nativeQuery=true)
    List<Integer>  orderBySize();

@Query(value ="select title from t_blog where views=?1",nativeQuery=true)
List<String>  getTitle(int views);
    @Query(nativeQuery = true,value = "select * from t_blog where tag_id = ?")
    List<Blog> queryMyBlogs(Long id);
}
