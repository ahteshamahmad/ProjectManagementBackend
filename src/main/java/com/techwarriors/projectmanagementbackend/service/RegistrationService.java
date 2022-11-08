package com.techwarriors.projectmanagementbackend.service;

import com.techwarriors.projectmanagementbackend.api.request.RegistrationRequest;
import com.techwarriors.projectmanagementbackend.model.Employee;
import com.techwarriors.projectmanagementbackend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegistrationService {
    private final EmployeeRepository employeeRepository;

    public RegistrationService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Long doRegister(RegistrationRequest registrationRequest){
        Employee employee=new Employee();
        employee.setDoj(new Date());
        employee.setFirstName(registrationRequest.getFirstName());
        employee.setLastName(registrationRequest.getLastName());
        employee.setEmailId(registrationRequest.getEmailId());
        employee.setDesignation(registrationRequest.getDesignation());
        employee.setHighestDegree(registrationRequest.getHighestDegree());
        employee.setLastDegreeYear(registrationRequest.getLastDegreeYear());
        employee.setPassword(registrationRequest.getPassword());
        employee.setJobFamilyId(registrationRequest.getJobFamilyId());
        Employee createdEmployee = employeeRepository.save(employee);
        return createdEmployee.getEmployeeId();
    }
}
