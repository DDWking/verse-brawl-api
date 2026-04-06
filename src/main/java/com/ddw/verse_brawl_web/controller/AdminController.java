package com.ddw.verse_brawl_web.controller;

import com.ddw.verse_brawl_web.common.Result;
import com.ddw.verse_brawl_web.entity.Admin;
import com.ddw.verse_brawl_web.service.AdminService;
import com.ddw.verse_brawl_web.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/back")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Result<?> login(@RequestBody Map<String, String> params) {
        String username = params.get("username");
        String password = params.get("password");
        Admin admin = adminService.login(username, password);
        if (admin == null) {
            return Result.error("用户名或密码错误");
        }
        String token = JwtUtils.generateToken(admin.getId(), admin.getUsername());
        Map<String, Object> data = new HashMap<>();
        data.put("token", token);
        data.put("admin", admin);
        return Result.success(data);
    }

    @GetMapping("/info")
    public Result<?> getAdminInfo(@RequestParam String token) {
        if (!JwtUtils.validateToken(token)) {
            return Result.error("token无效");
        }
        Integer userId = JwtUtils.getUserId(token);
        Admin admin = adminService.getById(userId);
        return Result.success(admin);
    }
}