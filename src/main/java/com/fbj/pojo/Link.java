package com.fbj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_link")
public class Link {
    @Id
    @GeneratedValue
private Long id;
private String descrip;
private String  title;
private String  http;
private String  photo;

}
