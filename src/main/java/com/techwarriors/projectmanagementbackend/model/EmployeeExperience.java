package com.techwarriors.projectmanagementbackend.model;

import javax.persistence.*;

@Entity(name="employee_experience")
public class EmployeeExperience {
    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeExperienceId;

    @Column(name="start_date")
    private String startDate;
    @Column(name="end_date")
    private String endDate;
    @Column(name="project_title")
    private String projectTitle;
    @Column(name="project_responsibility")
    private String projectResponsibility;
    @Column(name="is_current")
    private boolean isCurrent;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getEmployeeExperienceId() {
        return employeeExperienceId;
    }

    public void setEmployeeExperienceId(Long employeeExperienceId) {
        this.employeeExperienceId = employeeExperienceId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectResponsibility() {
        return projectResponsibility;
    }

    public void setProjectResponsibility(String projectResponsibility) {
        this.projectResponsibility = projectResponsibility;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }


}
