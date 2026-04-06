package com.ddw.verse_brawl_web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddw.verse_brawl_web.entity.Skill;
import java.util.List;

public interface SkillService extends IService<Skill> {
    List<Skill> getSkillsByCharacterId(Integer characterId);
}