package com.yj.springboot_cache.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("person_a")
public class Person implements Serializable {
    private Integer id;
    private String name;
    private String age;
    private  String address;
    private Date createTime;
    private String uuid;
}
