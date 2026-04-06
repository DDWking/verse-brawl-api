package com.ddw.verse_brawl_web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddw.verse_brawl_web.entity.Notice;
import com.ddw.verse_brawl_web.mapper.NoticeMapper;
import com.ddw.verse_brawl_web.service.NoticeService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {
    @Override
    public List<Notice> getNoticeList(String category) {
        LambdaQueryWrapper<Notice> wrapper = new LambdaQueryWrapper<>();
        if (category != null && !category.isEmpty() && !"all".equals(category)) {
            wrapper.eq(Notice::getCategory, category);
        }
        wrapper.orderByDesc(Notice::getIsTop);
        wrapper.orderByDesc(Notice::getCreateTime);
        return this.list(wrapper);
    }

    @Override
    public Notice getNoticeDetail(Integer id) {
        return this.getById(id);
    }

    @Override
    public List<Notice> getLatestNotices(Integer limit) {
        LambdaQueryWrapper<Notice> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Notice::getCreateTime);
        wrapper.last("LIMIT " + limit);
        return this.list(wrapper);
    }
}