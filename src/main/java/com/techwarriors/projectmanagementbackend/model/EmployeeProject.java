package com.techwarriors.projectmanagementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity(name="employee_project")
public class EmployeeProject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_project_id")
    private Long empProjectId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonIgnoreProperties("employeeProjects")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    @JsonIgnoreProperties("employeeProjects")
    private Employee employee;

    @Column(name="apply_date")
    private Date applyDate;

    @Column(name="project_assign_date")
    private Date projectAssignDate;

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

    public Long getEmpProjectId() {
        return empProjectId;
    }

    public void setEmpProjectId(Long empProjectId) {
        this.empProjectId = empProjectId;
    }

    public Date getProjectAssignDate() {
        return projectAssignDate;
    }

    public void setProjectAssignDate(Date projectAssignDate) {
        this.projectAssignDate = projectAssignDate;
    }
}
