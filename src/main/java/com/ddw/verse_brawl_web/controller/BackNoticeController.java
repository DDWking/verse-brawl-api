package com.ddw.verse_brawl_web.controller;

import com.ddw.verse_brawl_web.common.Result;
import com.ddw.verse_brawl_web.entity.Notice;
import com.ddw.verse_brawl_web.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/back/notice")
public class BackNoticeController {
    @Autowired
    private NoticeService noticeService;

    @GetMapping("/list")
    public Result<?> getNoticeList() {
        List<Notice> notices = noticeService.list();
        return Result.success(notices);
    }

    @GetMapping("/{id}")
    public Result<?> getNoticeDetail(@PathVariable Integer id) {
        Notice notice = noticeService.getById(id);
        return Result.success(notice);
    }

    @PostMapping("/add")
    public Result<?> addNotice(@RequestBody Notice notice) {
        notice.setCreateTime(LocalDateTime.now());
        notice.setUpdateTime(LocalDateTime.now());
        noticeService.save(notice);
        return Result.success("添加成功");
    }

    @PostMapping("/update")
    public Result<?> updateNotice(@RequestBody Notice notice) {
        notice.setUpdateTime(LocalDateTime.now());
        noticeService.updateById(notice);
        return Result.success("更新成功");
    }

    @DeleteMapping("/{id}")
    public Result<?> deleteNotice(@PathVariable Integer id) {
        noticeService.removeById(id);
        return Result.success("删除成功");
    }
}