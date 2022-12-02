package com.techwarriors.projectmanagementbackend.api.request;

import com.techwarriors.projectmanagementbackend.model.Employee;

import javax.persistence.*;

public class EmployeeExperienceRequest {
    private Long employeeId;
    private Long employeeExperienceId;
    private String startDate;
    private String endDate;
    private String projectTitle;
    private String projectResponsibility;
    private boolean isCurrent;

    public Long getEmployee() {
        return employeeId;
    }

    public void setEmployee(Long employee) {
        this.employeeId = employeeId;
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

    public void setIsCurrent(boolean current) {
        isCurrent = current;
    }
}
