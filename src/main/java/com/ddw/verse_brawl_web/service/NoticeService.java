package com.ddw.verse_brawl_web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddw.verse_brawl_web.entity.Notice;
import java.util.List;

public interface NoticeService extends IService<Notice> {
    List<Notice> getNoticeList(String category);
    Notice getNoticeDetail(Integer id);
    List<Notice> getLatestNotices(Integer limit);
}