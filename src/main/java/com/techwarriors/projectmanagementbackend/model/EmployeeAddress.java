package com.techwarriors.projectmanagementbackend.model;

import javax.persistence.*;

@Entity(name="employee_address")
public class EmployeeAddress {
    @OneToOne
    private EmployeeContact employeeContact;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="emp_address_id")
    private Long employeeAddressId;

    @Column(name="first_address_line")
    private String firstAddressLine;


    @Column(name="second_address_line")
    private String secondAddressLine;

    @Column(name="landmark")
    private String landmark;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="area_pin_code")
    private String areaPinCode;

    @Column(name="country")
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