package com.ddw.verse_brawl_web.controller;

import com.ddw.verse_brawl_web.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @GetMapping("/home")
    public Result<?> home() {
        Map<String, Object> map = new HashMap<>();
        map.put("gameName", "Verse Brawl");
        map.put("slogan", "跨次元，来乱斗");
        map.put("serverStatus", "online");
        return Result.success(map);
    }
}