package com.techwarriors.projectmanagementbackend.service;

import com.techwarriors.projectmanagementbackend.api.request.ProjectRequest;
import com.techwarriors.projectmanagementbackend.model.Project;
import com.techwarriors.projectmanagementbackend.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository=projectRepository;
    }
    public Long createProject(ProjectRequest projectRequest){
        Project project=new Project();
        project.setProjectActive(true);
        project.setProjectDesignation(projectRequest.getProjectDesignation());
        project.setProjectEndDate(projectRequest.getProjectEndDate());
        project.setProjectManagerId(projectRequest.getProjectManagerId());
        project.setProjectPosition(project.getProjectPosition());
        project.setProjectPostDate(project.getProjectPostDate());
        project.setProjectSalary(project.getProjectSalary());
        project.setProjectStartDate(project.getProjectStartDate());
        project.setProjectTitle(project.getProjectTitle());
        Project createdProject=projectRepository.save(project);
        return createdProject.getProjectId();
    }

    public Optional<Project> getProjectDetails(Long projectId) {
        return projectRepository.findById(projectId);
    }
}
