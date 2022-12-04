package com.techwarriors.projectmanagementbackend.controller;

import com.techwarriors.projectmanagementbackend.api.request.AdminRequest;
import com.techwarriors.projectmanagementbackend.api.response.AdminCreationResponse;
import com.techwarriors.projectmanagementbackend.api.response.GenericAPIResponse;
import com.techwarriors.projectmanagementbackend.model.Admin;
import com.techwarriors.projectmanagementbackend.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/admin")
    public ResponseEntity<GenericAPIResponse<AdminCreationResponse>> createAdmin(@RequestBody AdminRequest adminRequest) {
        GenericAPIResponse<AdminCreationResponse> response = new GenericAPIResponse<>();
        try {
            Long createdAdminId =  adminService.createAdmin(adminRequest);
            AdminCreationResponse adminCreationResponse = new AdminCreationResponse();
            adminCreationResponse.setAdminId(createdAdminId);
            response.setMessage("Admin is created successfully");
            response.setData(adminCreationResponse);
            return ResponseEntity.ok(response);
        }
        catch(Exception exception) {
            response.setMessage("Something went wrong, Please try again later!");
            return ResponseEntity.status(500).body(response);
        }
    }

    @GetMapping("/admin/{adminId}")
    public ResponseEntity<GenericAPIResponse<Admin>> getAdminDetail(@PathVariable(name = "adminId") Long adminId) {
        GenericAPIResponse<Admin> response = new GenericAPIResponse<>();
        try {
            Optional<Admin> admin =  adminService.getAdminDetail(adminId);
            if (admin.isPresent()) {
                response.setMessage("Admin is found");
                response.setData(admin.get());
                return ResponseEntity.ok(response);
            }
            else {
                response.setMessage("Admin is not found");
                return ResponseEntity.status(400).body(response);
            }
        }
        catch(Exception exception) {
            response.setMessage("Something went wrong, Please try again later!");
            return ResponseEntity.status(500).body(response);
        }
    }
}
