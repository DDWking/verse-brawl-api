package com.ddw.verse_brawl_web.controller;

import com.ddw.verse_brawl_web.common.Result;
import com.ddw.verse_brawl_web.entity.GameInfo;
import com.ddw.verse_brawl_web.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameInfoService gameInfoService;

    @GetMapping("/info")
    public Result<?> getGameInfo() {
        GameInfo gameInfo = gameInfoService.getGameInfo();
        return Result.success(gameInfo);
    }
}