package com.techwarriors.projectmanagementbackend.model;

import javax.persistence.*;

@Entity(name="project_description")
public class ProjectDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_desc_id")
    private Long projectDescId;
    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @Column(name="role_and_responsibilities")
    private String roleAndResponsibilities;
    @Column(name="skill_set_requirement")
    private String skillSetRequirement;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getRoleAndResponsibilities() {
        return roleAndResponsibilities;
    }

    public void setRoleAndResponsibilities(String roleAndResposibilities) {
        this.roleAndResponsibilities = roleAndResposibilities;
    }

    public String getSkillSetRequirement() {
        return skillSetRequirement;
    }

    public void setSkillSetRequirement(String skillSetRequirement) {
        this.skillSetRequirement = skillSetRequirement;
    }

    public Long getProjectDescId() {
        return projectDescId;
    }

    public void setProjectDescId(Long projectDescId) {
        this.projectDescId = projectDescId;
    }
}
