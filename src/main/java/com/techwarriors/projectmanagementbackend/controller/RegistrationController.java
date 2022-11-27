package com.techwarriors.projectmanagementbackend.controller;

import com.techwarriors.projectmanagementbackend.api.request.RegistrationRequest;
import com.techwarriors.projectmanagementbackend.api.response.EmployeeRegistrationResponse;
import com.techwarriors.projectmanagementbackend.api.response.GenericAPIResponse;
import com.techwarriors.projectmanagementbackend.model.Employee;
import com.techwarriors.projectmanagementbackend.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/employee")
public class RegistrationController {
    private final EmployeeService employeeService;

    public RegistrationController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/register")
    public ResponseEntity<GenericAPIResponse> doRegistration(@RequestBody RegistrationRequest registrationRequest){
        GenericAPIResponse<EmployeeRegistrationResponse> response = new GenericAPIResponse<>();
        EmployeeRegistrationResponse employeeRegistrationResponse = new EmployeeRegistrationResponse();
        try {
            Long createdEmployeeId = employeeService.doRegister(registrationRequest);
            employeeRegistrationResponse.setEmployeeId(createdEmployeeId);
            response.setMessage("Registration is successful");
            response.setData(employeeRegistrationResponse);
            return ResponseEntity.ok(response);
        }
        catch (Exception exception) {
            System.out.println(exception);
            response.setMessage("Something went wrong!!, Please try again later");
            return ResponseEntity.status(500).body(response);
        }
    }

    @GetMapping("/")
    public ResponseEntity<GenericAPIResponse> getAllEmployee() {
        GenericAPIResponse<List<Employee>> response = new GenericAPIResponse<>();
        try {
            List<Employee> allEmployees = employeeService.getAllEmployee();
            response.setMessage("Registration is successful");
            response.setData(allEmployees);
            return ResponseEntity.ok(response);
        }
        catch (Exception exception) {
            System.out.println(exception);
            response.setMessage("Something went wrong!!, Please try again later");
            return ResponseEntity.status(500).body(response);
        }
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<GenericAPIResponse> getEmployee(@PathVariable (name = "employeeId") Long employeeId) {
        GenericAPIResponse<Employee> response = new GenericAPIResponse<>();
        try {
            Optional<Employee> employee = employeeService.getEmployee(employeeId);
            if (employee.isPresent()) {
                response.setMessage("Employee is found");
                response.setData(employee.get());
                return ResponseEntity.ok(response);
            }
            else {
                response.setMessage("Employee is not found");
                return ResponseEntity.status(404).body(response);
            }
        }
        catch (Exception exception) {
            System.out.println(exception);
            response.setMessage("Something went wrong!!, Please try again later");
            return ResponseEntity.status(500).body(response);
        }
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<GenericAPIResponse> getEmployee(@PathVariable (name = "employeeId") Long employeeId, @RequestBody RegistrationRequest registrationRequest) {
        GenericAPIResponse<EmployeeRegistrationResponse> response = new GenericAPIResponse<>();
        EmployeeRegistrationResponse employeeRegistrationResponse = new EmployeeRegistrationResponse();
        try {
            Long createdEmployeeId = employeeService.doRegister(registrationRequest);
            employeeRegistrationResponse.setEmployeeId(createdEmployeeId);
            response.setMessage("Registration is successful");
            response.setData(employeeRegistrationResponse);
            return ResponseEntity.ok(response);
        }
        catch (Exception exception) {
            System.out.println(exception);
            response.setMessage("Something went wrong!!, Please try again later");
            return ResponseEntity.status(500).body(response);
        }
    }
}
