package com.ddw.verse_brawl_web.controller;

import com.ddw.verse_brawl_web.common.Result;
import com.ddw.verse_brawl_web.entity.PlayerRank;
import com.ddw.verse_brawl_web.service.PlayerRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/back/rank")
public class BackRankController {
    @Autowired
    private PlayerRankService playerRankService;

    @GetMapping("/list")
    public Result<?> getRankList() {
        List<PlayerRank> ranks = playerRankService.list();
        return Result.success(ranks);
    }

    @PostMapping("/update")
    public Result<?> updateRank(@RequestBody PlayerRank rank) {
        playerRankService.updateById(rank);
        return Result.success("更新成功");
    }

    @DeleteMapping("/{id}")
    public Result<?> deleteRank(@PathVariable Integer id) {
        playerRankService.removeById(id);
        return Result.success("删除成功");
    }

    @PostMapping("/audit/{id}")
    public Result<?> auditMessage(@PathVariable Integer id, @RequestParam Integer status) {
        PlayerRank rank = playerRankService.getById(id);
        rank.setMessageStatus(status);
        playerRankService.updateById(rank);
        return Result.success("审核完成");
    }
}