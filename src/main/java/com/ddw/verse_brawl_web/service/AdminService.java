package com.ddw.verse_brawl_web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddw.verse_brawl_web.entity.Admin;

public interface AdminService extends IService<Admin> {
    Admin login(String username, String password);
}