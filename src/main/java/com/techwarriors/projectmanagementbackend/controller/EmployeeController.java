package com.techwarriors.projectmanagementbackend.controller;

import com.techwarriors.projectmanagementbackend.api.request.*;
import com.techwarriors.projectmanagementbackend.api.response.*;
import com.techwarriors.projectmanagementbackend.model.Employee;
import com.techwarriors.projectmanagementbackend.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee/register")
    public ResponseEntity<GenericAPIResponse> doRegistration(@RequestBody EmployeeRequest employeeRequest){
        GenericAPIResponse<EmployeeRegistrationResponse> response = new GenericAPIResponse<>();
        EmployeeRegistrationResponse employeeRegistrationResponse = new EmployeeRegistrationResponse();
        try {
            Long createdEmployeeId = employeeService.doRegister(employeeRequest);
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


    @PostMapping("/employee/{employeeId}/contact")
    public ResponseEntity<GenericAPIResponse> addEmployeeContact(
            @PathVariable(name = "employeeId") Long employeeId,
            @RequestBody EmployeeContactRequest employeeContactRequest){
        GenericAPIResponse<EmployeeContactResponse> response = new GenericAPIResponse<>();
        EmployeeContactResponse employeeContactResponse = new EmployeeContactResponse();
        try {
            Long createdContactId = employeeService.addContact(employeeId, employeeContactRequest);
            employeeContactResponse.setEmployeeContactId(createdContactId);
            response.setMessage("Employee Contact is added successfully");
            response.setData(employeeContactResponse);
            return ResponseEntity.ok(response);
        }
        catch (Exception exception) {
            System.out.println(exception);
            response.setMessage("Something went wrong!!, Please try again later");
            return ResponseEntity.status(500).body(response);
        }
    }

    @PostMapping("/employee/{employeeId}/education")
    public ResponseEntity<GenericAPIResponse> addEmployeeEducation(
            @PathVariable(name = "employeeId") Long employeeId,
            @RequestBody EmployeeEducationRequest employeeEducationRequest){
        GenericAPIResponse<EmployeeEducationResponse> response = new GenericAPIResponse<>();
        EmployeeEducationResponse employeeEducationResponse = new EmployeeEducationResponse();
        try {
            Long createdEducationIdId = employeeService.addEducation(employeeId, employeeEducationRequest);
            employeeEducationResponse.setEmployeeEducationId(createdEducationIdId);
            response.setMessage("Employee education is added successfully");
            response.setData(employeeEducationResponse);
            return ResponseEntity.ok(response);
        }
        catch (Exception exception) {
            System.out.println(exception);
            response.setMessage("Something went wrong!!, Please try again later");
            return ResponseEntity.status(500).body(response);
        }
    }

    @PostMapping("/employee/{employeeId}/experience")
    public ResponseEntity<GenericAPIResponse> addEmployeeExperience(
            @PathVariable(name = "employeeId") Long employeeId,
            @RequestBody EmployeeExperienceRequest employeeExperienceRequest){
        GenericAPIResponse<EmployeeExperienceResponse> response = new GenericAPIResponse<>();
        EmployeeExperienceResponse employeeExperienceResponse = new EmployeeExperienceResponse();
        try {
            Long createdExperienceId = employeeService.addExperience(employeeId, employeeExperienceRequest);
            employeeExperienceResponse.setEmployeeExperienceId(createdExperienceId);
            response.setMessage("Employee experience is added successfully");
            response.setData(employeeExperienceResponse);
            return ResponseEntity.ok(response);
        }
        catch (Exception exception) {
            System.out.println(exception);
            response.setMessage("Something went wrong!!, Please try again later");
            return ResponseEntity.status(500).body(response);
        }
    }

    @PostMapping("/employee/{employeeId}/skill")
    public ResponseEntity<GenericAPIResponse> addEmployeeSkill(
            @PathVariable(name = "employeeId") Long employeeId,
            @RequestBody EmployeeSkillsRequest employeeSkillRequest){
        GenericAPIResponse<EmployeeSkillsResponse> response = new GenericAPIResponse<>();
        EmployeeSkillsResponse employeeSkillResponse = new EmployeeSkillsResponse();
        try {
            Long createdSkillId = employeeService.addSkill(employeeId, employeeSkillRequest);
            employeeSkillResponse.setEmployeeSkillId(createdSkillId);
            response.setMessage("Employee skill is added successfully");
            response.setData(employeeSkillResponse);
            return ResponseEntity.ok(response);
        }
        catch (Exception exception) {
            System.out.println(exception);
            response.setMessage("Something went wrong!!, Please try again later");
            return ResponseEntity.status(500).body(response);
        }
    }

    @GetMapping("/employee/")
    public ResponseEntity<GenericAPIResponse> getAllEmployee() {
        GenericAPIResponse<List<Employee>> response = new GenericAPIResponse<>();
        try {
            List<Employee> allEmployees = employeeService.getAllEmployee();
            response.setMessage("All employees details are fetched!");
            response.setData(allEmployees);
            return ResponseEntity.ok(response);
        }
        catch (Exception exception) {
            System.out.println(exception);
            response.setMessage("Something went wrong!!, Please try again later");
            return ResponseEntity.status(500).body(response);
        }
    }

    @GetMapping("/employee/{employeeId}")
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

    @PutMapping("/employee/{employeeId}")
    public ResponseEntity<GenericAPIResponse> getEmployee(@PathVariable (name = "employeeId") Long employeeId, @RequestBody EmployeeRequest employeeRequest) {
        GenericAPIResponse<EmployeeRegistrationResponse> response = new GenericAPIResponse<>();
        EmployeeRegistrationResponse employeeUpdateResponse = new EmployeeRegistrationResponse();
        try {
            Long updatedEmployeeId = employeeService.updateEmployeeDetails(employeeId, employeeRequest);
            employeeUpdateResponse.setEmployeeId(updatedEmployeeId);
            response.setMessage("Update is successful");
            response.setData(employeeUpdateResponse);
            return ResponseEntity.ok(response);
        } catch (Exception exception) {
            System.out.println(exception);
            response.setMessage("Something went wrong!!, Please try again later");
            return ResponseEntity.status(500).body(response);
        }
    }
}
