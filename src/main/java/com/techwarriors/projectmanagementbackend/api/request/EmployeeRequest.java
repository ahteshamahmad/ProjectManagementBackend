package com.techwarriors.projectmanagementbackend.api.request;

import java.util.Date;

public class EmployeeRequest {
    private String employeeId;
    private String employeePassword;
    private Date employeeDoj;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeGender;
    private String empProfilePhotoUrl;
    private String employeeCurrentProjectId;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public Date getEmployeeDoj() {
        return employeeDoj;
    }

    public void setEmployeeDoj(Date employeeDoj) {
        this.employeeDoj = employeeDoj;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmpProfilePhotoUrl() {
        return empProfilePhotoUrl;
    }

    public void setEmpProfilePhotoUrl(String empProfilePhotoUrl) {
        this.empProfilePhotoUrl = empProfilePhotoUrl;
    }

    public String getEmployeeCurrentProjectId() {
        return employeeCurrentProjectId;
    }

    public void setEmployeeCurrentProjectId(String employeeCurrentProjectId) {
        this.employeeCurrentProjectId = employeeCurrentProjectId;
    }
}
