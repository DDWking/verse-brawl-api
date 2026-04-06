package com.ddw.verse_brawl_web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddw.verse_brawl_web.entity.PlayerRank;
import com.ddw.verse_brawl_web.mapper.PlayerRankMapper;
import com.ddw.verse_brawl_web.service.PlayerRankService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PlayerRankServiceImpl extends ServiceImpl<PlayerRankMapper, PlayerRank> implements PlayerRankService {
    @Override
    public List<PlayerRank> getRankList(String timeRange) {
        LambdaQueryWrapper<PlayerRank> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(PlayerRank::getScore);

        if ("today".equals(timeRange)) {
            wrapper.ge(PlayerRank::getCreateTime, LocalDateTime.now().toLocalDate().atStartOfDay());
        } else if ("week".equals(timeRange)) {
            wrapper.ge(PlayerRank::getCreateTime, LocalDateTime.now().minusDays(7));
        }

        return this.list(wrapper);
    }

    @Override
    public void submitScore(String playerName, Integer score, Integer playTime) {
        PlayerRank rank = new PlayerRank();
        rank.setPlayerName(playerName);
        rank.setScore(score);
        rank.setPlayTime(playTime);
        rank.setMessageStatus(0);
        rank.setCreateTime(LocalDateTime.now());
        this.save(rank);
    }
}