package com.techwarriors.projectmanagementbackend.controller;

import com.techwarriors.projectmanagementbackend.api.request.LoginRequest;
import com.techwarriors.projectmanagementbackend.api.response.GenericAPIResponse;
import com.techwarriors.projectmanagementbackend.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/admin/login")
    public ResponseEntity doAdminLogin(@RequestBody LoginRequest loginRequest) {
        GenericAPIResponse<String> response = new GenericAPIResponse<>();
        try {
            boolean isLoginSuccessful = loginService.isCredentialCorrect(true, loginRequest);
            if (isLoginSuccessful) {
                response.setMessage("Login is successful");
                return ResponseEntity.ok(response);
            }
            else {
                response.setMessage("Bad Credential");
                return ResponseEntity.status(400).body(response);
            }
        }
        catch(Exception exception) {
            response.setMessage("Something went wrong");
            return ResponseEntity.status(500).body(response);
        }
    }

    @PostMapping("/employee/login")
    public ResponseEntity<GenericAPIResponse<String>> doEmployeeLogin(@RequestBody LoginRequest loginRequest) {
        GenericAPIResponse<String> response = new GenericAPIResponse<>();
        try {
            boolean isLoginSuccessful = loginService.isCredentialCorrect(false, loginRequest);
            if (isLoginSuccessful) {
                response.setMessage("Login is successful");
                return ResponseEntity.ok(response);
            }
            else {
                response.setMessage("Bad Credential");
                return ResponseEntity.status(400).body(response);
            }
        }
        catch(Exception exception) {
            response.setMessage("Something went wrong");
            return ResponseEntity.status(500).body(response);
        }
    }
}
