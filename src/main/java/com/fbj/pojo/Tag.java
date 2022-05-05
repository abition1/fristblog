package com.fbj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/**
 * 标签实体类
 *
**/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_tag")
public class Tag {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "tags")  //多对多的关系映射
    private List<Blog>  blogs=new ArrayList<>();
}
