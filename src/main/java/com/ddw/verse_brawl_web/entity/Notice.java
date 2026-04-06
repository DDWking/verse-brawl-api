package com.ddw.verse_brawl_web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("notice")
public class Notice {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String category;
    private String content;
    private Integer isTop; // 0否 1是
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}