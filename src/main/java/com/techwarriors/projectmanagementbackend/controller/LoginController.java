package com.techwarriors.projectmanagementbackend.controller;

import com.techwarriors.projectmanagementbackend.api.request.LoginRequest;
import com.techwarriors.projectmanagementbackend.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/admin/login")
    public ResponseEntity doAdminLogin(@RequestBody LoginRequest loginRequest) {
        try {
            boolean isLoginSuccessful = loginService.isCredentialCorrect(true, loginRequest);
            if (isLoginSuccessful) {
                return ResponseEntity.ok("Login is successful");
            }
            else {
                return ResponseEntity.badRequest().body("bad credential");
            }
        }
        catch(Exception exception) {
            return ResponseEntity.status(500).body("Something went wrong");
        }
    }

    @PostMapping("/employee/login")
    public ResponseEntity doEmployeeLogin(@RequestBody LoginRequest loginRequest) {
        try {
            boolean isLoginSuccessful = loginService.isCredentialCorrect(false, loginRequest);
            if (isLoginSuccessful) {
                return ResponseEntity.ok("Login is successful");
            }
            else {
                return ResponseEntity.badRequest().body("bad credential");
            }
        }
        catch(Exception exception) {
            return ResponseEntity.status(500).body("Something went wrong");
        }
    }
}
