package com.techwarriors.projectmanagementbackend.service;

import com.techwarriors.projectmanagementbackend.api.request.LoginRequest;
import com.techwarriors.projectmanagementbackend.model.Employee;
import com.techwarriors.projectmanagementbackend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final EmployeeRepository employeeCredentialRepository;

    public LoginService(EmployeeRepository employeeCredentialRepository) {
        this.employeeCredentialRepository = employeeCredentialRepository;
    }

    public boolean isCredentialCorrect(LoginRequest loginRequest) {
        Optional<Employee> pass = employeeCredentialRepository.findById(loginRequest.getEmployeeId());
        if (pass.isPresent() && pass.get().getPassword().equals(loginRequest.getPassword())) {
            return true;
        }
        return false;
    }
}
