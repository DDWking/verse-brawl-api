package com.ddw.verse_brawl_web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddw.verse_brawl_web.entity.GameInfo;

public interface GameInfoService extends IService<GameInfo> {
    GameInfo getGameInfo();
}