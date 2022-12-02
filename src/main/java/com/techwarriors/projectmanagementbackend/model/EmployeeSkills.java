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

    @Column(name="experience_in_year")
    private double experienceInYear;

    @Column(name = "is_primary_skill")
    private boolean isPrimarySkill;

    @Column(name = "is_secondary_skill")
    private boolean isSecondarySkill;

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


    public Double getExperienceInYear() {
        return experienceInYear;
    }

    public void setExperienceInYear(Double experienceInYear) {
        this.experienceInYear = experienceInYear;
    }


    public Long getEmpSkillId() {
        return empSkillId;
    }

    public void setEmpSkillId(Long empSkillId) {
        this.empSkillId = empSkillId;
    }

    public boolean getIsPrimarySkill() {
        return isPrimarySkill;
    }

    public void setIsPrimarySkill(boolean primarySkill) {
        isPrimarySkill = primarySkill;
    }

    public boolean getIsSecondarySkill() {
        return isSecondarySkill;
    }

    public void setIsSecondarySkill(boolean secondarySkill) {
        isSecondarySkill = secondarySkill;
    }
}
