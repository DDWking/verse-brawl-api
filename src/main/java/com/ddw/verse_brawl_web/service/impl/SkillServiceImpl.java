package com.ddw.verse_brawl_web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddw.verse_brawl_web.entity.Skill;
import com.ddw.verse_brawl_web.mapper.SkillMapper;
import com.ddw.verse_brawl_web.service.SkillService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillServiceImpl extends ServiceImpl<SkillMapper, Skill> implements SkillService {
    @Override
    public List<Skill> getSkillsByCharacterId(Integer characterId) {
        LambdaQueryWrapper<Skill> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Skill::getCharacterId, characterId);
        return this.list(wrapper);
    }
}