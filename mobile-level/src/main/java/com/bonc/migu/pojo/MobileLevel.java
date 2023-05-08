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
    //用户等级（0,1，2,3）
    private Integer level;
    /**
     * 已有偏好等级时，偏好等级是否修改
     * （0：否（默认），1：是））
     */
    private Integer levelStatus;



}
