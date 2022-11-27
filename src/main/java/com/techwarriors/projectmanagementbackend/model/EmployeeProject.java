package com.techwarriors.projectmanagementbackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name="employee_project")
public class EmployeeProject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_project_id")
    private Long empProjectId;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Employee employee;

    @Column(name="apply_date")
    private Date applyDate;
    @Column(name="project_title")
    private String projectTitle;
    @Column(name="project_position")
    private String projectPosition;
    @Column(name="project_head_count")
    private int projectHeadCount;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectPosition() {
        return projectPosition;
    }

    public void setProjectPosition(String projectPosition) {
        this.projectPosition = projectPosition;
    }

    public int getProjectHeadCount() {
        return projectHeadCount;
    }

    public void setProjectHeadCount(int projectHeadCount) {
        this.projectHeadCount = projectHeadCount;
    }

    public Long getEmpProjectId() {
        return empProjectId;
    }

    public void setEmpProjectId(Long empProjectId) {
        this.empProjectId = empProjectId;
    }
}
