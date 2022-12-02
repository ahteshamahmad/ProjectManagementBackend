package com.techwarriors.projectmanagementbackend.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    private Long projectId;
    @Column(name = "project_title")
    private String projectTitle;
    @ManyToOne
    @JoinColumn(name = "project_type_id")
    private ProjectType projectType;

    @Column(name = "project_start_date")
    private Date projectStartDate;
    @Column(name = "project_end_date")
    private Date projectEndDate;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @Column(name = "total_position")
    private int totalPosition;
    @Column(name = "project_salary")
    private int projectSalary;
    @Column(name = "is_project_active")
    private boolean isProjectActive;
    @Column(name = "project_post_date")
    private Date projectPostDate;

    @OneToOne(mappedBy = "project", cascade = CascadeType.ALL)
    private ProjectDescription projectDescription;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<ProjectSkills> projectSkills;

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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public int getTotalPosition() {
        return totalPosition;
    }

    public void setTotalPosition(int totalPosition) {
        this.totalPosition = totalPosition;
    }

    public int getProjectSalary() {
        return projectSalary;
    }

    public void setProjectSalary(int projectSalary) {
        this.projectSalary = projectSalary;
    }

    public boolean isProjectActive() {
        return isProjectActive;
    }

    public void setProjectActive(boolean projectActive) {
        isProjectActive = projectActive;
    }

    public Date getProjectPostDate() {
        return projectPostDate;
    }

    public void setProjectPostDate(Date projectPostDate) {
        this.projectPostDate = projectPostDate;
    }

    public ProjectDescription getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(ProjectDescription projectDescription) {
        this.projectDescription = projectDescription;
        this.projectDescription.setProject(this);
    }

    public Set<ProjectSkills> getProjectSkills() {
        return projectSkills;
    }

    public void setProjectSkills(Set<ProjectSkills> projectSkills) {
        this.projectSkills = projectSkills;
        for (ProjectSkills projectSkill : this.projectSkills) {
            projectSkill.setProject(this);
        }
    }
}
