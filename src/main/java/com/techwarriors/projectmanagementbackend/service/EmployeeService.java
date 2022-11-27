package com.techwarriors.projectmanagementbackend.service;

import com.techwarriors.projectmanagementbackend.api.request.RegistrationRequest;
import com.techwarriors.projectmanagementbackend.model.Employee;
import com.techwarriors.projectmanagementbackend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Long doRegister(RegistrationRequest registrationRequest){
        Employee employee=new Employee();
        employee.setEmployeeDoj(new Date());
        employee.setEmployeeFirstName(registrationRequest.getEmployeeFirstName());
        employee.setEmployeeLastName(registrationRequest.getEmployeeLastName());
        employee.setEmployeeGender(registrationRequest.getEmployeeGender());
        employee.setEmployeeCurrentProjectId(null);
        employee.setEmployeePassword(registrationRequest.getEmployeePassword());
        employee.setEmpProfilePhotoUrl(registrationRequest.getEmpProfilePhotoUrl());
        Employee createdEmployee = employeeRepository.save(employee);
        return createdEmployee.getEmployeeId();
    }

    public List<Employee> getAllEmployee(){
        List<Employee> allEmployees = new ArrayList<>();
        employeeRepository.findAll().iterator().forEachRemaining(allEmployees::add);
        return allEmployees;
    }

    public Optional<Employee> getEmployee(Long employeeId){
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employee;
    }

    public Long updateEmployeeDetails(Long employeeId, RegistrationRequest registrationRequest) throws Exception {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isPresent()) {
            Employee employeeObject = employee.get();
            employeeObject.setEmployeeDoj(new Date());
            employeeObject.setEmployeeFirstName(registrationRequest.getEmployeeFirstName());
            employeeObject.setEmployeeLastName(registrationRequest.getEmployeeLastName());
            employeeObject.setEmployeeGender(registrationRequest.getEmployeeGender());
            employeeObject.setEmployeeCurrentProjectId(registrationRequest.getEmployeeCurrentProjectId());
            employeeObject.setEmployeePassword(registrationRequest.getEmployeePassword());
            employeeObject.setEmpProfilePhotoUrl(registrationRequest.getEmpProfilePhotoUrl());
            return employeeRepository.save(employeeObject).getEmployeeId();
        }
        else {
            throw new Exception("Employee not found");
        }
    }
}
