package com.bonc.migu.pojo;


import lombok.Data;

/**
 * 视频背景音关联信息
 */
@Data
public class Music {
    private String contentId ;//场景
    private String firmName ;//歌曲名
    private String emotion ;//情绪
    private String musicalInstruments ;//乐器
    private String style ;//风格
    private String velocity ;//速度
    private String humanLength ;//时长


}
