package com.techwarriors.projectmanagementbackend.model;

import javax.persistence.*;

@Entity(name="project_skills")
public class ProjectSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_skill_id")
    private Long projectSkillId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Column(name="knowledge_level")
    private String knowledgeLevel;
    @Column(name="is_mandatory_skill")
    private boolean isMandatorySkill;

    @Column(name="is_additional_skill")
    private boolean isAdditionalSkill;

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public String getKnowledgeLevel() {
        return knowledgeLevel;
    }

    public void setKnowledgeLevel(String knowledgeLevel) {
        this.knowledgeLevel = knowledgeLevel;
    }

    public boolean isMandatorySkill() {
        return isMandatorySkill;
    }

    public void setMandatorySkill(boolean mandatorySkill) {
        isMandatorySkill = mandatorySkill;
    }

    public boolean isAdditionalSkill() {
        return isAdditionalSkill;
    }

    public void setAdditionalSkill(boolean additionalSkill) {
        isAdditionalSkill = additionalSkill;
    }

    public Long getProjectSkillId() {
        return projectSkillId;
    }

    public void setProjectSkillId(Long projectSkillId) {
        this.projectSkillId = projectSkillId;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
