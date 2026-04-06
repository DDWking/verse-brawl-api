package com.ddw.verse_brawl_web.config;

import com.ddw.verse_brawl_web.common.Result;
import com.ddw.verse_brawl_web.utils.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            if (JwtUtils.validateToken(token)) {
                return true;
            }
        }

        response.setContentType("application/json;charset=utf-8");
        Result<?> result = Result.error("未登录或token无效");
        response.getWriter().write(new ObjectMapper().writeValueAsString(result));
        return false;
    }
}