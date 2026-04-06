package com.ddw.verse_brawl_web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddw.verse_brawl_web.entity.Character;
import com.ddw.verse_brawl_web.mapper.CharacterMapper;
import com.ddw.verse_brawl_web.service.CharacterService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CharacterServiceImpl extends ServiceImpl<CharacterMapper, Character> implements CharacterService {
    @Override
    public List<Character> getAllCharacters() {
        return this.list();
    }
}