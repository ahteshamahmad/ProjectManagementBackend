package com.techwarriors.projectmanagementbackend.service;

import com.techwarriors.projectmanagementbackend.api.request.LoginRequest;
import com.techwarriors.projectmanagementbackend.model.Admin;
import com.techwarriors.projectmanagementbackend.model.Employee;
import com.techwarriors.projectmanagementbackend.repository.AdminRepository;
import com.techwarriors.projectmanagementbackend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final EmployeeRepository employeeCredentialRepository;
    private final AdminRepository adminRepository;

    public LoginService(EmployeeRepository employeeCredentialRepository, AdminRepository adminRepository) {
        this.employeeCredentialRepository = employeeCredentialRepository;
        this.adminRepository = adminRepository;
    }

    public boolean isCredentialCorrect(boolean isAdmin, LoginRequest loginRequest) {
        String password = "";
        if (isAdmin == true) {
            Optional<Admin> admin = adminRepository.findById(loginRequest.getEmployeeId());
            if (admin.isPresent() && admin.get().getAdminPassword().equals(loginRequest.getPassword())) {
                return true;
            }
        }
        else {
            Optional<Employee> employee = employeeCredentialRepository.findById(loginRequest.getEmployeeId());
            if (employee.isPresent() && employee.get().getEmployeePassword().equals(loginRequest.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
