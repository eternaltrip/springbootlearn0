package com.bonc.migu.pojo;


import lombok.Data;

/**
 * 场景信息
 */
@Data
public class Scene {
    private String listen_type	;          //试听类别
    private String Listen_for_details;	  //试听类型
    private String speed;	                  //速度
    private String orchestrate;	          //配器
    private String emotion;	                  //情绪
    private String genre;	                  //流派
    private String describe;                     //描述

}
