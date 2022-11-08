package com.techwarriors.projectmanagementbackend.api.request;

import java.util.Date;

public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private String highestDegree;
    private Date lastDegreeYear;
    private String designation;
    private String jobFamilyId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHighestDegree() {
        return highestDegree;
    }

    public void setHighestDegree(String highestDegree) {
        this.highestDegree = highestDegree;
    }

    public Date getLastDegreeYear() {
        return lastDegreeYear;
    }

    public void setLastDegreeYear(Date lastDegreeYear) {
        this.lastDegreeYear = lastDegreeYear;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getJobFamilyId() {
        return jobFamilyId;
    }

    public void setJobFamilyId(String jobFamilyId) {
        this.jobFamilyId = jobFamilyId;
    }



}
