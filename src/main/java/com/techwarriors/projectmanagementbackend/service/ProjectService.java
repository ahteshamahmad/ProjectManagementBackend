package com.techwarriors.projectmanagementbackend.service;

import com.techwarriors.projectmanagementbackend.api.request.ProjectRequest;
import com.techwarriors.projectmanagementbackend.api.request.ProjectSkillRequest;
import com.techwarriors.projectmanagementbackend.model.*;
import com.techwarriors.projectmanagementbackend.repository.AdminRepository;
import com.techwarriors.projectmanagementbackend.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final AdminRepository adminRepository;
    public ProjectService(ProjectRepository projectRepository, AdminRepository adminRepository){
        this.projectRepository=projectRepository;
        this.adminRepository = adminRepository;
    }
    public Long createProject(ProjectRequest projectRequest){
        Project project=new Project();
        project.setProjectTitle(projectRequest.getProjectTitle());
        project.setProjectActive(projectRequest.isProjectActive());
        ProjectType projectType=new ProjectType();
        projectType.setProjectTypeId(projectRequest.getProjectType().getProjectTypeId());
        projectType.setProjectTypeName(projectRequest.getProjectType().getProjectTypeName());
        project.setProjectType(projectType);
        project.setProjectStartDate(projectRequest.getProjectStartDate());
        project.setProjectEndDate(projectRequest.getProjectEndDate());
        project.setProjectSalary(projectRequest.getProjectSalary());
        project.setProjectPostDate(projectRequest.getProjectPostDate());
        ProjectDescription projectDescription=new ProjectDescription();
        projectDescription.setDescription(projectRequest.getProjectDescription().getDescription());
        projectDescription.setRoleAndResponsibilities(projectRequest.getProjectDescription().getRoleAndResponsibilities());
        project.setProjectDescription(projectDescription);

        Set<ProjectSkills> projectSkillsList = new HashSet<>();
        for (ProjectSkillRequest projectSkillRequest : projectRequest.getProjectSkillRequest()) {
            ProjectSkills projectSkill = new ProjectSkills();
            Skill skill = new Skill();
            skill.setSkillId(projectSkillRequest.getSkillId());
            projectSkill.setSkill(skill);
            projectSkill.setKnowledgeLevel(projectSkillRequest.getKnowledgeLevel().name());
            projectSkill.setMandatorySkill(projectSkillRequest.isMandatorySkill());
            projectSkill.setAdditionalSkill(projectSkillRequest.isAdditionalSkill());
            projectSkillsList.add(projectSkill);
        }
        project.setProjectSkills(projectSkillsList);
        Admin admin = new Admin();
        admin.setAdminId(projectRequest.getAdmin().getAdminId());
        System.out.println(projectRequest.getAdmin().getAdminId());
        project.setAdmin(admin);
        project.setTotalPosition(projectRequest.getTotalPosition());
        Project createdProject=projectRepository.save(project);
        return createdProject.getProjectId();
    }

    public Optional<Project> getProjectDetails(Long projectId) {
        return projectRepository.findById(projectId);
    }
}
