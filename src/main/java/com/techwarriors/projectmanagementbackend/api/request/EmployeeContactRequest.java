package com.techwarriors.projectmanagementbackend.api.request;

import com.techwarriors.projectmanagementbackend.model.Employee;
import com.techwarriors.projectmanagementbackend.model.EmployeeAddress;

import javax.persistence.*;

public class EmployeeContactRequest {

    private Long employeeContactId;
    private String employeeEmailId;
    private String employeePhoneNumber;
    private EmployeeAddressRequest employeeAddressRequest;

    public Long getEmployeeContactId() {
        return employeeContactId;
    }

    public void setEmployeeContactId(Long employeeContactId) {
        this.employeeContactId = employeeContactId;
    }

    public String getEmployeeEmailId() {
        return employeeEmailId;
    }

    public void setEmployeeEmailId(String employeeEmailId) {
        this.employeeEmailId = employeeEmailId;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public EmployeeAddressRequest getEmployeeAddressRequest() {
        return employeeAddressRequest;
    }

    public void setEmployeeAddressRequest(EmployeeAddressRequest employeeAddressRequest) {
        this.employeeAddressRequest = employeeAddressRequest;
    }
}
