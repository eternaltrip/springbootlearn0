package com.bonc.migu.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobileLevel {

    //手机号码
    private String msisdn;
    //任务id
    private String uuid;
    //用户等级（0,1，2,3）
    private Integer level;
    /**
     * 已有偏好等级时，偏好等级是否修改
     * （0：否（默认），1：是））
     */
    private Integer levelStatus;
    /**
     * 是否已完成模型计算（
     * 0：否（默认），1：是
     * ）
     */
    private Integer status;
    //数据来源（SYSTEM:系统上报，QUERY：查询接口）
    private String source;

    private String createTime;
    private String updateTime;



}
