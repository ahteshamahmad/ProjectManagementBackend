package com.techwarriors.projectmanagementbackend.controller;

import com.techwarriors.projectmanagementbackend.api.request.RegistrationRequest;
import com.techwarriors.projectmanagementbackend.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public ResponseEntity doRegistration(@RequestBody RegistrationRequest registrationRequest){
        try {
            Long createdEmployeeId = registrationService.doRegister(registrationRequest);
            return ResponseEntity.ok(createdEmployeeId);
        }
        catch (Exception exception) {
            System.out.println(exception);
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
}
