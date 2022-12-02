package com.techwarriors.projectmanagementbackend.api.request;

import com.techwarriors.projectmanagementbackend.enums.SkillKnowledgeLevel;
import com.techwarriors.projectmanagementbackend.model.Skill;

public class EmployeeSkillsRequest {
    private SkillRequest skillRequest;
    private SkillKnowledgeLevel knowledgeLevel;
    private Double experienceInYear;

    private boolean isPrimarySkill;

    private boolean isSecondarySkill;

    public SkillKnowledgeLevel getKnowledgeLevel() {
        return knowledgeLevel;
    }

    public void setKnowledgeLevel(SkillKnowledgeLevel knowledgeLevel) {
        this.knowledgeLevel = knowledgeLevel;
    }


    public Double getExperienceInYear() {
        return experienceInYear;
    }

    public void setExperienceInYear(Double experienceInYear) {
        this.experienceInYear = experienceInYear;
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

    public SkillRequest getSkillRequest() {
        return skillRequest;
    }

    public void setSkillRequest(SkillRequest skillRequest) {
        this.skillRequest = skillRequest;
    }
}
