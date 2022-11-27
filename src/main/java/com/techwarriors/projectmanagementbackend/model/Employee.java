package com.techwarriors.projectmanagementbackend.model;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;
import java.util.Set;

@Entity(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Long employeeId;
    @Column(name = "emp_password")
    private String employeePassword;
    @Column(name="emp_doj")
    private Date employeeDoj;
    @Column(name="emp_first_name")
    private String employeeFirstName;
    @Column(name="emp_last_Name")
    private String employeeLastName;
    @Column(name="emp_gender")
    private String employeeGender;
    @Column(name="emp_profile_photo_url")
    private String empProfilePhotoUrl;
    @Column(name="emp_current_project_id")
    private String employeeCurrentProjectId;

    @OneToMany(mappedBy = "employee")
    private Set<EmployeeSkills> employeeSkills;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
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

    public Set<EmployeeSkills> getEmployeeSkills() {
        return employeeSkills;
    }

    public void setEmployeeSkills(Set<EmployeeSkills> employeeSkills) {
        this.employeeSkills = employeeSkills;
    }

}

