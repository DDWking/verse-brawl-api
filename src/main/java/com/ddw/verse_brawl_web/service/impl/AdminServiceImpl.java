package com.ddw.verse_brawl_web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddw.verse_brawl_web.entity.Admin;
import com.ddw.verse_brawl_web.mapper.AdminMapper;
import com.ddw.verse_brawl_web.service.AdminService;
import com.ddw.verse_brawl_web.utils.MD5Utils;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Override
    public Admin login(String username, String password) {
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Admin::getUsername, username);
        wrapper.eq(Admin::getPassword, MD5Utils.encrypt(password));
        return this.getOne(wrapper);
    }
}