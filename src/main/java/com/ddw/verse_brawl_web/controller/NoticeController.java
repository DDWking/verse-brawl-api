package com.ddw.verse_brawl_web.controller;

import com.ddw.verse_brawl_web.common.Result;
import com.ddw.verse_brawl_web.entity.Notice;
import com.ddw.verse_brawl_web.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @GetMapping("/list")
    public Result<?> getNoticeList(@RequestParam(defaultValue = "all") String category) {
        List<Notice> notices = noticeService.getNoticeList(category);
        return Result.success(notices);
    }

    @GetMapping("/{id}")
    public Result<?> getNoticeDetail(@PathVariable Integer id) {
        Notice notice = noticeService.getNoticeDetail(id);
        return Result.success(notice);
    }
}