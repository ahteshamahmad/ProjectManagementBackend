package com.techwarriors.projectmanagementbackend.controller;

import com.techwarriors.projectmanagementbackend.api.request.ProjectRequest;
import com.techwarriors.projectmanagementbackend.api.response.EmployeeExperienceResponse;
import com.techwarriors.projectmanagementbackend.api.response.GenericAPIResponse;
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
}
