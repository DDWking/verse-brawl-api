package com.ddw.verse_brawl_web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddw.verse_brawl_web.entity.PlayerRank;
import java.util.List;

public interface PlayerRankService extends IService<PlayerRank> {
    List<PlayerRank> getRankList(String timeRange);
    void submitScore(String playerName, Integer score, Integer playTime);
}