package com.techwarriors.projectmanagementbackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name="employee_education")
public class EmployeeEducation {
    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_education_id")
    private Long employeeEducationId;
    @Column(name="major")
    private String major;
    @Column(name="start_date")
    private Date startDate;
    @Column(name="end_date")
    private Date endDate;

    @Column(name="completed_date")
    private Date completedDate;

    @Column(name="score_measurement_type")
    private String scoreMeasurementType;

    @Column(name="score_value")
    private Double scoreValue;

    @Column(name="division")
    private String division;
    @Column(name="univ_name")
    private String univName;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public String getScoreMeasurementType() {
        return scoreMeasurementType;
    }

    public void setScoreMeasurementType(String scoreMeasurementType) {
        this.scoreMeasurementType = scoreMeasurementType;
    }

    public Double getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(Double scoreValue) {
        this.scoreValue = scoreValue;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getUnivName() {
        return univName;
    }

    public void setUnivName(String univName) {
        this.univName = univName;
    }

    public Long getEmployeeEducationId() {
        return employeeEducationId;
    }

    public void setEmployeeEducationId(Long employeeEducationId) {
        this.employeeEducationId = employeeEducationId;
    }
}
