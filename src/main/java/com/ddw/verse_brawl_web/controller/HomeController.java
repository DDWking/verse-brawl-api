package com.ddw.verse_brawl_web.controller;

import com.ddw.verse_brawl_web.common.Result;
import com.ddw.verse_brawl_web.entity.GameInfo;
import com.ddw.verse_brawl_web.entity.Notice;
import com.ddw.verse_brawl_web.service.GameInfoService;
import com.ddw.verse_brawl_web.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private GameInfoService gameInfoService;

    @Autowired
    private NoticeService noticeService;

    @GetMapping
    public Result<?> getHomeData() {
        Map<String, Object> data = new HashMap<>();
        GameInfo gameInfo = gameInfoService.getGameInfo();
        data.put("gameInfo", gameInfo);
        List<Notice> notices = noticeService.getLatestNotices(2);
        data.put("latestNotices", notices);
        data.put("serverStatus", "online");
        return Result.success(data);
    }
}