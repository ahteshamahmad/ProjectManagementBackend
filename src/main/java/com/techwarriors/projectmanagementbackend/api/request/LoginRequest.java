package com.techwarriors.projectmanagementbackend.api.request;

public class LoginRequest {
    private String employeeId;
    private String password;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
