package com.ddw.verse_brawl_web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("game_info")
public class GameInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String gameName;
    private String slogan;
    private String background;
    private String gameplay;
    private String operation;
    private String feature;
    private String downloadUrl;
    private String playUrl;
    private String installNote;
    private String faq;
    private LocalDateTime updateTime;
}