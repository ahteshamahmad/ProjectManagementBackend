package com.techwarriors.projectmanagementbackend.controller;

import com.techwarriors.projectmanagementbackend.api.request.ProjectApplicationRequest;
import com.techwarriors.projectmanagementbackend.api.request.ProjectRequest;
import com.techwarriors.projectmanagementbackend.api.response.EmployeeExperienceResponse;
import com.techwarriors.projectmanagementbackend.api.response.GenericAPIResponse;
import com.techwarriors.projectmanagementbackend.api.response.ProjectApplicationResponse;
import com.techwarriors.projectmanagementbackend.api.response.ProjectResponse;
import com.techwarriors.projectmanagementbackend.model.Project;
import com.techwarriors.projectmanagementbackend.model.ProjectDescription;
import com.techwarriors.projectmanagementbackend.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
public class ProjectController {
    private final ProjectService projectService;
    public ProjectController(ProjectService projectService){
        this.projectService=projectService;
    }
    @PostMapping("/project")
    public ResponseEntity<GenericAPIResponse<ProjectResponse>> createProject(@RequestBody ProjectRequest projectRequest){
        GenericAPIResponse<ProjectResponse> response = new GenericAPIResponse<>();
        try {
            Long createdProjectId = projectService.createProject(projectRequest);
            ProjectResponse projectResponse = new ProjectResponse();
            projectResponse.setProjectId(createdProjectId);
            response.setMessage("Project is created successfully");
            response.setData(projectResponse);
            return ResponseEntity.ok(response);
        }
        catch (Exception exception) {
            System.out.println(exception);
            response.setMessage("Something went wrong!!, Please try again later");
            return ResponseEntity.status(500).body(response);
        }
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<GenericAPIResponse<Project>> getProjectDetail(@PathVariable(name = "projectId") Long projectId){
        GenericAPIResponse<Project> response = new GenericAPIResponse<>();
        try {
            Optional<Project> project = projectService.getProjectDetails(projectId);
            if (project.isPresent()) {
                response.setMessage("Project is found");
                response.setData(project.get());
                return ResponseEntity.ok(response);
            }
            else {
                response.setMessage("Project is not found");
                return ResponseEntity.status(404).body(response);
            }
        }
        catch (Exception exception) {
            System.out.println(exception);
            response.setMessage("Internal Server Error");
            return ResponseEntity.status(500).body(response);
        }
    }

    @PostMapping("/project/{projectId}/apply")
    public ResponseEntity<GenericAPIResponse<ProjectApplicationResponse>> applyProject(@PathVariable(name = "projectId") Long projectId,
                                                                                           @RequestBody ProjectApplicationRequest projectApplicationRequest){
        GenericAPIResponse<ProjectApplicationResponse> response = new GenericAPIResponse<>();
        try {
            Long createdProjectApplicationId = projectService.applyProject(projectId, projectApplicationRequest);
            ProjectApplicationResponse projectResponse = new ProjectApplicationResponse();
            projectResponse.setProjectApplicationId(createdProjectApplicationId);
            response.setMessage("Project is applied successfully");
            response.setData(projectResponse);
            return ResponseEntity.ok(response);
        }
        catch (Exception exception) {
            System.out.println(exception);
            response.setMessage("Something went wrong!!, Please try again later");
            return ResponseEntity.status(500).body(response);
        }
    }

    @PutMapping("/project/application/{applicationId}")
    public ResponseEntity<GenericAPIResponse<ProjectApplicationResponse>> updateEmployeeProjectApplication(@PathVariable(name = "applicationId") Long applicationId,
                                                                                       @RequestBody ProjectApplicationRequest projectApplicationRequest){
        GenericAPIResponse<ProjectApplicationResponse> response = new GenericAPIResponse<>();
        try {
            Long updatedProjectApplicationId = projectService.updateProjectApplication(applicationId, projectApplicationRequest);
            ProjectApplicationResponse projectResponse = new ProjectApplicationResponse();
            projectResponse.setProjectApplicationId(updatedProjectApplicationId);
            response.setMessage("Project is updated successfully");
            response.setData(projectResponse);
            return ResponseEntity.ok(response);
        }
        catch (Exception exception) {
            if (exception.getMessage() !=null && exception.getMessage().equals("EmployeeApplicationId not found")) {
                response.setMessage("EmployeeApplicationId not found");
                return ResponseEntity.status(404).body(response);
            }
            System.out.println(exception);
            response.setMessage("Something went wrong!!, Please try again later");
            return ResponseEntity.status(500).body(response);
        }
    }
}
