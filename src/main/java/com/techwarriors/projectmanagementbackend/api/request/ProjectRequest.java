package com.techwarriors.projectmanagementbackend.api.request;

import com.fasterxml.jackson.databind.DatabindException;
import com.techwarriors.projectmanagementbackend.model.Admin;
import com.techwarriors.projectmanagementbackend.model.ProjectDescription;
import com.techwarriors.projectmanagementbackend.model.ProjectSkills;
import com.techwarriors.projectmanagementbackend.model.ProjectType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ProjectRequest {
    private Long projectId;
    private String projectTitle;
    private ProjectTypeRequest projectType;
    private Date projectStartDate;
    private Date projectEndDate;
    private AdminRequest admin;
    private Integer totalPosition;
    private Integer projectSalary;
    private boolean isProjectActive;
    private Date projectPostDate;
    private ProjectDescriptionRequest projectDescription;

    private List<ProjectSkillRequest> ProjectSkillRequest;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public ProjectTypeRequest getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectTypeRequest projectType) {
        this.projectType = projectType;
    }

    public Date getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(Date projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public Date getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(Date projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public AdminRequest getAdmin() {
        return admin;
    }

    public void setAdmin(AdminRequest admin) {
        this.admin = admin;
    }

    public Integer getTotalPosition() {
        return totalPosition;
    }

    public void setTotalPosition(Integer totalPosition) {
        this.totalPosition = totalPosition;
    }

    public Integer getProjectSalary() {
        return projectSalary;
    }

    public void setProjectSalary(Integer projectSalary) {
        this.projectSalary = projectSalary;
    }

    public boolean isProjectActive() {
        return isProjectActive;
    }

    public void setIsProjectActive(boolean projectActive) {
        isProjectActive = projectActive;
    }

    public Date getProjectPostDate() {
        return projectPostDate;
    }

    public void setProjectPostDate(Date projectPostDate) {
        this.projectPostDate = projectPostDate;
    }

    public ProjectDescriptionRequest getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(ProjectDescriptionRequest projectDescription) {
        this.projectDescription = projectDescription;
    }

    public void setProjectActive(boolean projectActive) {
        isProjectActive = projectActive;
    }

    public List<com.techwarriors.projectmanagementbackend.api.request.ProjectSkillRequest> getProjectSkillRequest() {
        return ProjectSkillRequest;
    }

    public void setProjectSkillRequest(List<com.techwarriors.projectmanagementbackend.api.request.ProjectSkillRequest> projectSkillRequest) {
        ProjectSkillRequest = projectSkillRequest;
    }
}
