package com.ddw.verse_brawl_web.controller;

import com.ddw.verse_brawl_web.common.Result;
import com.ddw.verse_brawl_web.entity.Character;
import com.ddw.verse_brawl_web.entity.Skill;
import com.ddw.verse_brawl_web.service.CharacterService;
import com.ddw.verse_brawl_web.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/character")
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @Autowired
    private SkillService skillService;

    @GetMapping("/list")
    public Result<?> getCharacterList() {
        List<Character> characters = characterService.getAllCharacters();
        return Result.success(characters);
    }

    @GetMapping("/{id}/skills")
    public Result<?> getCharacterSkills(@PathVariable Integer id) {
        List<Skill> skills = skillService.getSkillsByCharacterId(id);
        return Result.success(skills);
    }

    @GetMapping("/all")
    public Result<?> getAllWithSkills() {
        List<Character> characters = characterService.getAllCharacters();
        List<Map<String, Object>> result = new java.util.ArrayList<>();
        for (Character c : characters) {
            Map<String, Object> map = new HashMap<>();
            map.put("character", c);
            map.put("skills", skillService.getSkillsByCharacterId(c.getId()));
            result.add(map);
        }
        return Result.success(result);
    }
}