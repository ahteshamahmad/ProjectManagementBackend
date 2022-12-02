package com.techwarriors.projectmanagementbackend.model;

import javax.persistence.*;

@Entity(name="employee_application")
public class EmployeeApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_application_id")
    private Long empApplicationId;
    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @Column(name="project_is_active")
    private boolean projectIsActive;
    @Column(name="skills")
    private String skills;
    @Column(name="application_status")
    private String applicationStatus;
    @Column(name="apply_date")
    private String applyDate;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public boolean isProjectIsActive() {
        return projectIsActive;
    }

    public void setProjectIsActive(boolean projectIsActive) {
        this.projectIsActive = projectIsActive;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public Long getEmpApplicationId() {
        return empApplicationId;
    }

    public void setEmpApplicationId(Long empApplicationId) {
        this.empApplicationId = empApplicationId;
    }
}
