package com.yj.mybatisplus01.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user")
public class User {
    private String id;
    private String name;
    private Integer age;
    private Date createTime;
}
