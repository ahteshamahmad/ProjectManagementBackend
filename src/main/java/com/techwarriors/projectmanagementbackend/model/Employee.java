package com.techwarriors.projectmanagementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @OneToMany(mappedBy = "employee")
    private Set<EmployeeProject> employeeProjects;

    @OneToMany(mappedBy = "employee")
    private Set<EmployeeExperience> employeeExperiences;

    @OneToMany(mappedBy = "employee")
    private Set<EmployeeSkills> employeeSkills;

    @OneToOne(mappedBy = "employee")
    private EmployeeContact employeeContact;

    @OneToMany(mappedBy = "employee")
    private Set<EmployeeEducation> employeeEducations;

    @OneToMany(mappedBy = "employee")
    private Set<EmployeeProjectApplication> employeeProjectApplications;

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

    public Set<EmployeeSkills> getEmployeeSkills() {
        return employeeSkills;
    }

    public Set<EmployeeExperience> getEmployeeExperiences() {
        return employeeExperiences;
    }

    public EmployeeContact getEmployeeContact() {
        return employeeContact;
    }

    public Set<EmployeeEducation> getEmployeeEducations() {
        return employeeEducations;
    }

    public Set<EmployeeProjectApplication> getEmployeeProjectApplications() {
        return employeeProjectApplications;
    }



//    public EmployeeProject getEmployeeCurrentProject() {
//        Date maxDate = null;
//        EmployeeProject latestProject = null;
//        for (EmployeeProject employeeProject : this.employeeCurrentProject) {
//            if (maxDate == null) {
//                maxDate = employeeProject.getProjectAssignDate();
//                latestProject = employeeProject;
//            }
//            else {
//                if (maxDate.before(employeeProject.getProjectAssignDate())) {
//                    maxDate = employeeProject.getProjectAssignDate();
//                    latestProject = employeeProject;
//                }
//            }
//        }
//        return latestProject;
//    }


//    public Set<EmployeeProject> getEmployeeProjects() {
//        return employeeProjects;
//    }
}

