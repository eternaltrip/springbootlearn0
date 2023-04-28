package com.bonc.migu.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobileLevel {

    private String msisdn;
    private String uuid;
    private Integer level;
    private Integer levelStatus;
    private Integer status;
    private String source;
    private String createTime;
    private String updateTime;



}
