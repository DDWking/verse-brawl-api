package com.ddw.verse_brawl_web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddw.verse_brawl_web.entity.Character;
import java.util.List;

public interface CharacterService extends IService<Character> {
    List<Character> getAllCharacters();
}