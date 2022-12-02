package com.techwarriors.projectmanagementbackend.api.request;

import com.techwarriors.projectmanagementbackend.enums.SkillKnowledgeLevel;

public class ProjectSkillRequest {
    private Long skillId;
    private SkillKnowledgeLevel knowledgeLevel;
    private boolean mandatorySkill;
    private boolean additionalSkill;

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public SkillKnowledgeLevel getKnowledgeLevel() {
        return knowledgeLevel;
    }

    public void setKnowledgeLevel(SkillKnowledgeLevel knowledgeLevel) {
        this.knowledgeLevel = knowledgeLevel;
    }

    public boolean isMandatorySkill() {
        return mandatorySkill;
    }

    public void setMandatorySkill(boolean mandatorySkill) {
        this.mandatorySkill = mandatorySkill;
    }

    public boolean isAdditionalSkill() {
        return additionalSkill;
    }

    public void setAdditionalSkill(boolean additionalSkill) {
        this.additionalSkill = additionalSkill;
    }
}
