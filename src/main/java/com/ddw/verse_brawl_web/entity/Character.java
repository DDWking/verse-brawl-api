package com.ddw.verse_brawl_web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("character")
public class Character {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String avatar;
    private String intro;
    private String advantage;
    private String disadvantage;
    private LocalDateTime updateTime;
}