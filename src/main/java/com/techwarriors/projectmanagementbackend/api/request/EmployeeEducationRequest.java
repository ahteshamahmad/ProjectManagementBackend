package com.techwarriors.projectmanagementbackend.api.request;

import com.techwarriors.projectmanagementbackend.enums.DegreeDivision;
import com.techwarriors.projectmanagementbackend.enums.ScoreMeasurementType;
import com.techwarriors.projectmanagementbackend.model.Employee;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class EmployeeEducationRequest {
    private Long employeeId;
    private String major;
    private Date startDate;
    private Date endDate;
    private Date completedDate;
    private ScoreMeasurementType scoreMeasurementType;
    private Double scoreValue;
    private DegreeDivision division;
    private String univName;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    public ScoreMeasurementType getScoreMeasurementType() {
        return scoreMeasurementType;
    }

    public void setScoreMeasurementType(ScoreMeasurementType scoreMeasurementType) {
        this.scoreMeasurementType = scoreMeasurementType;
    }

    public Double getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(Double scoreValue) {
        this.scoreValue = scoreValue;
    }

    public DegreeDivision getDivision() {
        return division;
    }

    public void setDivision(DegreeDivision division) {
        this.division = division;
    }

    public String getUnivName() {
        return univName;
    }

    public void setUnivName(String univName) {
        this.univName = univName;
    }
}
