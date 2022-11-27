package com.techwarriors.projectmanagementbackend.service;

import com.techwarriors.projectmanagementbackend.api.request.ProjectRequest;
import com.techwarriors.projectmanagementbackend.api.request.SkillRequest;
import com.techwarriors.projectmanagementbackend.model.Skill;
import com.techwarriors.projectmanagementbackend.repository.ProjectRepository;
import com.techwarriors.projectmanagementbackend.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillService {
    private final SkillRepository skillRepository;
    public SkillService(SkillRepository skillRepository){
        this.skillRepository=skillRepository;
    }
    public Long createSkill(SkillRequest skillRequest){
        Skill skill=new Skill();
        skill.setSkillName(skillRequest.getSkillName());
        Skill createdSkill =  skillRepository.save(skill);
        return createdSkill.getSkillId();
    }

    public List<Skill> getAllSkills(){
        List<Skill> allSkills = new ArrayList<>();
        Iterable<Skill> allStoredSkills =  skillRepository.findAll();
        allStoredSkills.iterator().forEachRemaining(allSkills::add);
        return allSkills;
    }
}
