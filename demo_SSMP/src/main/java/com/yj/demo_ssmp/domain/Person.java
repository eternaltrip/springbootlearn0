package com.yj.demo_ssmp.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;

import java.util.Date;

@Data
@TableName("person_a")
public class Person {
    private String id;
    private String name;
    private String age;
    private  String address;
    private Date createTime;
    private String uuid;
}
