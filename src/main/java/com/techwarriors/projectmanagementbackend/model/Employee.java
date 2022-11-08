package com.techwarriors.projectmanagementbackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long employeeId;
    @Column(name = "password")
    private String password;
    @Column(name="doj")
    private Date doj;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name = "email_id", unique = true)
    private String emailId;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Column(name="highestDegree")
    private String highestDegree;
    @Column(name="lastDegreeYear")
    private Date lastDegreeYear;
    @Column(name="designation")
    private String designation;
    @Column(name="jobFamilyId")
    private String jobFamilyId;

    public String getJobFamilyId() {
        return jobFamilyId;
    }

    public void setJobFamilyId(String jobFamilyId) {
        this.jobFamilyId = jobFamilyId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getLastDegreeYear() {
        return lastDegreeYear;
    }

    public void setLastDegreeYear(Date lastDegreeYear) {
        this.lastDegreeYear = lastDegreeYear;
    }

    public String getHighestDegree() {
        return highestDegree;
    }

    public void setHighestDegree(String highestDegree) {
        this.highestDegree = highestDegree;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Employee() {
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

