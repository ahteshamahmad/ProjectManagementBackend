package com.techwarriors.projectmanagementbackend.service;

import com.techwarriors.projectmanagementbackend.api.request.AdminRequest;
import com.techwarriors.projectmanagementbackend.model.Admin;
import com.techwarriors.projectmanagementbackend.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Long createAdmin(AdminRequest adminRequest) {
        Admin admin = new Admin();
        admin.setAdminEmailId(adminRequest.getAdminEmailId());
        admin.setAdminPhoneNum(adminRequest.getAdminPhoneNum());
        admin.setAdminPassword(adminRequest.getAdminPassword());
        admin.setAdminFirstName(adminRequest.getAdminFirstName());
        admin.setAdminLastName(adminRequest.getAdminLastName());
        return adminRepository.save(admin).getAdminId();
    }

    public Optional<Admin> getAdminDetail(Long adminId) {
        return adminRepository.findById(adminId);
    }
}
