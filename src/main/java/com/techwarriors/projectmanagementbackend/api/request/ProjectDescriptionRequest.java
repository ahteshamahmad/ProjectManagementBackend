package com.techwarriors.projectmanagementbackend.api.request;

public class ProjectDescriptionRequest {
    private Long projectDescId;
    private String description;
    private String roleAndResponsibilities;

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

    public String getRoleAndResponsibilities() {
        return roleAndResponsibilities;
    }

    public void setRoleAndResponsibilities(String roleAndResponsibilities) {
        this.roleAndResponsibilities = roleAndResponsibilities;
    }
}
