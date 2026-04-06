package com.ddw.verse_brawl_web.controller;

import com.ddw.verse_brawl_web.common.Result;
import com.ddw.verse_brawl_web.entity.Character;
import com.ddw.verse_brawl_web.entity.Skill;
import com.ddw.verse_brawl_web.service.CharacterService;
import com.ddw.verse_brawl_web.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/back/character")
public class BackCharacterController {
    @Autowired
    private CharacterService characterService;

    @Autowired
    private SkillService skillService;

    @GetMapping("/list")
    public Result<?> getCharacterList() {
        List<Character> characters = characterService.list();
        return Result.success(characters);
    }

    @PostMapping("/add")
    public Result<?> addCharacter(@RequestBody Character character) {
        character.setUpdateTime(LocalDateTime.now());
        characterService.save(character);
        return Result.success("添加成功");
    }

    @PostMapping("/update")
    public Result<?> updateCharacter(@RequestBody Character character) {
        character.setUpdateTime(LocalDateTime.now());
        characterService.updateById(character);
        return Result.success("更新成功");
    }

    @DeleteMapping("/{id}")
    public Result<?> deleteCharacter(@PathVariable Integer id) {
        // 先删除关联技能
        List<Skill> skills = skillService.getSkillsByCharacterId(id);
        for (Skill skill : skills) {
            skillService.removeById(skill.getId());
        }
        characterService.removeById(id);
        return Result.success("删除成功");
    }

    @GetMapping("/{characterId}/skills")
    public Result<?> getSkills(@PathVariable Integer characterId) {
        List<Skill> skills = skillService.getSkillsByCharacterId(characterId);
        return Result.success(skills);
    }

    @PostMapping("/{characterId}/skill/add")
    public Result<?> addSkill(@PathVariable Integer characterId, @RequestBody Skill skill) {
        skill.setCharacterId(characterId);
        skill.setUpdateTime(LocalDateTime.now());
        skillService.save(skill);
        return Result.success("添加成功");
    }

    @PostMapping("/skill/update")
    public Result<?> updateSkill(@RequestBody Skill skill) {
        skill.setUpdateTime(LocalDateTime.now());
        skillService.updateById(skill);
        return Result.success("更新成功");
    }

    @DeleteMapping("/skill/{id}")
    public Result<?> deleteSkill(@PathVariable Integer id) {
        skillService.removeById(id);
        return Result.success("删除成功");
    }
}