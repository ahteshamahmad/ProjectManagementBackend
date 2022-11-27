package com.techwarriors.projectmanagementbackend.model;

import javax.persistence.*;

@Entity(name="employee_skills")
public class EmployeeSkills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_skill_id")
    private Long empSkillId;
    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Column(name="knowledge_level")
    private String knowledgeLevel;
    @Column(name="skills")
    private String skills;
    @Column(name="experience_in_year")
    private String experienceInYear;
    @Column(name="extra_skill")
    private String extraSkill;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getExperienceInYear() {
        return experienceInYear;
    }

    public void setExperienceInYear(String experienceInYear) {
        this.experienceInYear = experienceInYear;
    }

    public String getExtraSkill() {
        return extraSkill;
    }

    public void setExtraSkill(String extraSkill) {
        this.extraSkill = extraSkill;
    }

    public Long getEmpSkillId() {
        return empSkillId;
    }

    public void setEmpSkillId(Long empSkillId) {
        this.empSkillId = empSkillId;
    }
}
