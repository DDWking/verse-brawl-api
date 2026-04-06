package com.ddw.verse_brawl_web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("skill")
public class Skill {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer characterId;
    private String name;
    private String icon;
    private String description;
    private LocalDateTime updateTime;
}