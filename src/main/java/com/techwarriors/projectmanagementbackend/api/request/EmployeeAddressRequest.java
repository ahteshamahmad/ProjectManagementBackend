package com.techwarriors.projectmanagementbackend.api.request;

import com.techwarriors.projectmanagementbackend.model.EmployeeContact;

import javax.persistence.*;

public class EmployeeAddressRequest {
    private EmployeeContact employeeContact;
    private Long employeeAddressId;
    private String firstAddressLine;
    private String secondAddressLine;
    private String landmark;
    private String city;
    private String state;
    private String areaPinCode;
    private String country;

    public EmployeeContact getEmployeeContact() {
        return employeeContact;
    }

    public void setEmployeeContact(EmployeeContact employeeContact) {
        this.employeeContact = employeeContact;
    }

    public Long getEmployeeAddressId() {
        return employeeAddressId;
    }

    public void setEmployeeAddressId(Long employeeAddressId) {
        this.employeeAddressId = employeeAddressId;
    }

    public String getFirstAddressLine() {
        return firstAddressLine;
    }

    public void setFirstAddressLine(String firstAddressLine) {
        this.firstAddressLine = firstAddressLine;
    }

    public String getSecondAddressLine() {
        return secondAddressLine;
    }

    public void setSecondAddressLine(String secondAddressLine) {
        this.secondAddressLine = secondAddressLine;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAreaPinCode() {
        return areaPinCode;
    }

    public void setAreaPinCode(String areaPinCode) {
        this.areaPinCode = areaPinCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
