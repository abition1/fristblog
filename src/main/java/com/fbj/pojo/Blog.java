package com.fbj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_blog")
public class Blog implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String title;  //标题
    private String content;  //内容
    private String firstPicture;//首图
    private String flag; // 标记
    private Integer views;  //浏览次数

    private boolean appreciation; //赞赏开启
    private boolean shareStatement;//版权开启
    private boolean commentabled;//评论开启
    private boolean published;   //发布开启
    private boolean recommend;   //是否推荐
    private String description;   //博客的简单描述
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;   //创建时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;   //更新时间
    @ManyToOne   //多对一，一个类型对应多个博客
    private Type type;
    @ManyToOne
    private Tag tag;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "blog",fetch=FetchType.EAGER)
    private List<Comment> comments=new ArrayList<>();




}
