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
   @OneToMany(mappedBy = "tag",fetch=FetchType.EAGER)
    private List<Blog>  blogs=new ArrayList<>();
}
