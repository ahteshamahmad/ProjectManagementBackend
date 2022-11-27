package com.techwarriors.projectmanagementbackend.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="project_id")
    private Long projectId;
    @Column(name="project_title")
    private String projectTitle;
    @ManyToOne
    @JoinColumn(name = "project_type_id")
    private ProjectType projectType;

    @Column(name="project_start_date")
    private String projectStartDate;
    @Column(name="project_end_date")
    private String projectEndDate;
    @Column(name="project_manager_id")
    private String projectManagerId;
    @Column(name="project_position")
    private String projectPosition;
    @Column(name="project_designation")
    private String projectDesignation;
    @Column(name="project_salary")
    private String projectSalary;
    @Column(name="project_active")
    private boolean projectActive;
    @Column(name="project_post_date")
    private String projectPostDate;

    @OneToOne(mappedBy = "project")
    private ProjectDescription projectDescription;

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

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public boolean isProjectActive() {
        return projectActive;
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

    public void setProjectPosition(String projectPosition) {
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

    public ProjectDescription getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(ProjectDescription projectDescription) {
        this.projectDescription = projectDescription;
    }
}
