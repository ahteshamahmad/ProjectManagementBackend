package com.techwarriors.projectmanagementbackend.controller;

import com.techwarriors.projectmanagementbackend.api.request.ProjectRequest;
import com.techwarriors.projectmanagementbackend.model.Project;
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
    public ResponseEntity doProject(@RequestBody ProjectRequest projectRequest){
        try {
            Long createdProjectId = projectService.createProject(projectRequest);
            return ResponseEntity.ok(createdProjectId);
        }
        catch (Exception exception) {
            System.out.println(exception);
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity getProjectDetail(@PathVariable(name = "projectId") Long projectId){
        try {
            Optional<Project> project = projectService.getProjectDetails(projectId);
            if (project.isPresent()) {
                return ResponseEntity.ok(project);
            }
            else {
                return ResponseEntity.notFound().build();
            }
        }
        catch (Exception exception) {
            System.out.println(exception);
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
}
