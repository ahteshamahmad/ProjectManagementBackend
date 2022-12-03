package com.techwarriors.projectmanagementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity(name="employee_application")
public class EmployeeProjectApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_application_id")
    private Long empApplicationId;
    @ManyToOne
    @JoinColumn(name = "emp_id")
    @JsonIgnoreProperties("employeeProjectApplications")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonIgnoreProperties("employeeProjectApplications")
    private Project project;
    @Column(name="application_status")
    private String applicationStatus;
    @Column(name="apply_date")
    private Date applyDate;

    @Column(name="employee_comment")
    private String employeeComment;

    @Column(name="admin_comment")
    private String adminComment;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Long getEmpApplicationId() {
        return empApplicationId;
    }

    public void setEmpApplicationId(Long empApplicationId) {
        this.empApplicationId = empApplicationId;
    }

    public String getEmployeeComment() {
        return employeeComment;
    }

    public void setEmployeeComment(String employeeComment) {
        this.employeeComment = employeeComment;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Project getProject() {
        return project;
    }

    public String getAdminComment() {
        return adminComment;
    }

    public void setAdminComment(String adminComment) {
        this.adminComment = adminComment;
    }
}
