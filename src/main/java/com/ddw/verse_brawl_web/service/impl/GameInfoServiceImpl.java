package com.ddw.verse_brawl_web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddw.verse_brawl_web.entity.GameInfo;
import com.ddw.verse_brawl_web.mapper.GameInfoMapper;
import com.ddw.verse_brawl_web.service.GameInfoService;
import org.springframework.stereotype.Service;

@Service
public class GameInfoServiceImpl extends ServiceImpl<GameInfoMapper, GameInfo> implements GameInfoService {
    @Override
    public GameInfo getGameInfo() {
        // 获取第一条游戏信息记录
        return this.getById(1);
    }
}