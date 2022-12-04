package com.techwarriors.projectmanagementbackend.model;

import javax.persistence.*;

@Entity(name="project_description")
public class ProjectDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_desc_id")
    private Long projectDescId;

    @Column(name="description")
    private String description;

    @Column(name="role_and_responsibilities")
    private String roleAndResponsibilities;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public String getRoleAndResponsibilities() {
        return roleAndResponsibilities;
    }

    public void setRoleAndResponsibilities(String roleAndResposibilities) {
        this.roleAndResponsibilities = roleAndResposibilities;
    }

    public Long getProjectDescId() {
        return projectDescId;
    }

    public void setProjectDescId(Long projectDescId) {
        this.projectDescId = projectDescId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
