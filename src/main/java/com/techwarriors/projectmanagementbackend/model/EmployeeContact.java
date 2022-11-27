package com.techwarriors.projectmanagementbackend.model;

import javax.persistence.*;

@Entity(name="employee_contact")
public class EmployeeContact {
    @OneToOne
    private Employee employee;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="emp_contact_id")
    private Long employeeContactId;

    @Column(name="emp_email_id")
    private String employeeEmailId;

    @Column(name="emp_phone_no")
    private String employeePhoneNumber;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

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
}
