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
    @Column(name="key_skills")
    private String keySkills;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

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

    public String getKeySkills() {
        return keySkills;
    }

    public void setKeySkills(String keySkills) {
        this.keySkills = keySkills;
    }

    public Long getProjectSkillId() {
        return projectSkillId;
    }

    public void setProjectSkillId(Long projectSkillId) {
        this.projectSkillId = projectSkillId;
    }
}
