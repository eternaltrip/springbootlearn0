package com.yj.mybatisplus01.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("order_a")
public class Order {
    private String id;
    private String userId;
    private String balance;
    private Date createTime;
}
