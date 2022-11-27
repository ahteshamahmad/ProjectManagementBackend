package com.techwarriors.projectmanagementbackend.api.request;

import javax.persistence.Column;

public class ProjectRequest {
    private String projectId;
    private String projectTitle;
    private String projectStartDate;
    private String projectEndDate;
    private String projectManagerId;
    private String projectPosition;
    private String projectDesignation;
    private String projectSalary;
    private boolean projectActive;
    private String projectPostDate;


    public String getProjectId() {
        return projectId;
    }
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    public String getProjectTitle() {
        return projectTitle;
    }
    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }
    public String getProjectStartDate() {
        return projectStartDate;
    }
    public void setProjectStartDate(String projectStartDate) {
        this.projectStartDate = projectStartDate;
    }
    public String getProjectEndDate() {
        return projectEndDate;
    }
    public void setProjectEndDate(String projectEndDate) {
        this.projectEndDate = projectEndDate;
    }
    public String getProjectManagerId() {
        return projectManagerId;
    }
    public void setProjectManagerId(String projectManagerId) {
        this.projectManagerId = projectManagerId;
    }
    public String getProjectPosition() {
        return projectPosition;
    }
    public void setProjectPostion(String projectPosition) {
        this.projectPosition = projectPosition;
    }
    public String getProjectDesignation() {
        return projectDesignation;
    }
    public void setProjectDesignation(String projectDesignation) {
        this.projectDesignation = projectDesignation;
    }
    public String getProjectSalary() {
        return projectSalary;
    }
    public void setProjectSalary(String projectSalary) {
        this.projectSalary = projectSalary;
    }
    public boolean getProjectActive() {
        return projectActive;
    }
    public void setProjectActive(boolean projectActive) {
        this.projectActive = projectActive;
    }
    public String getProjectPostDate() {
        return projectPostDate;
    }
    public void setProjectPostDate(String projectPostDate) {
        this.projectPostDate = projectPostDate;
    }
}
