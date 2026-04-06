package com.ddw.verse_brawl_web.controller;

import com.ddw.verse_brawl_web.common.Result;
import com.ddw.verse_brawl_web.entity.GameInfo;
import com.ddw.verse_brawl_web.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/back/game")
public class BackGameController {
    @Autowired
    private GameInfoService gameInfoService;

    @GetMapping
    public Result<?> getGameInfo() {
        GameInfo gameInfo = gameInfoService.getGameInfo();
        return Result.success(gameInfo);
    }

    @PostMapping("/update")
    public Result<?> updateGameInfo(@RequestBody GameInfo gameInfo) {
        gameInfoService.updateById(gameInfo);
        return Result.success("更新成功");
    }
}