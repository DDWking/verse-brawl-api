package com.ddw.verse_brawl_web.controller;

import com.ddw.verse_brawl_web.common.Result;
import com.ddw.verse_brawl_web.entity.PlayerRank;
import com.ddw.verse_brawl_web.service.PlayerRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rank")
public class RankController {
    @Autowired
    private PlayerRankService playerRankService;

    @GetMapping("/list")
    public Result<?> getRankList(@RequestParam(defaultValue = "all") String timeRange) {
        List<PlayerRank> ranks = playerRankService.getRankList(timeRange);
        return Result.success(ranks);
    }

    @PostMapping("/submit")
    public Result<?> submitScore(@RequestBody PlayerRank rank) {
        playerRankService.submitScore(rank.getPlayerName(), rank.getScore(), rank.getPlayTime());
        return Result.success("分数提交成功");
    }
}