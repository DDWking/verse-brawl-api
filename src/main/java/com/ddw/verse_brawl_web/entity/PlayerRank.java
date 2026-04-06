package com.ddw.verse_brawl_web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("player_rank")
public class PlayerRank {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String playerName;
    private Integer score;
    private Integer playTime;
    private String message;
    private Integer messageStatus; // 0未审核 1已通过 2已拒绝
    private LocalDateTime createTime;
}