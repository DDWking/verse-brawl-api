package com.ddw.verse_brawl_web.utils;

import cn.hutool.crypto.digest.DigestUtil;

public class MD5Utils {
    public static String encrypt(String password) {
        return DigestUtil.md5Hex(password);
    }

    public static boolean verify(String password, String encrypted) {
        return encrypt(password).equals(encrypted);
    }
}