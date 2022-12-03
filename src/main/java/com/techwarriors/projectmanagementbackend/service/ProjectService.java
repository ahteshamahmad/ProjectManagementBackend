package com.techwarriors.projectmanagementbackend.service;

import com.techwarriors.projectmanagementbackend.api.request.ProjectApplicationRequest;
import com.techwarriors.projectmanagementbackend.api.request.ProjectRequest;
import com.techwarriors.projectmanagementbackend.api.request.ProjectSkillRequest;
import com.techwarriors.projectmanagementbackend.enums.ApplicationStatus;
import com.techwarriors.projectmanagementbackend.model.*;
import com.techwarriors.projectmanagementbackend.repository.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final EmployeeProjectApplicationRepository employeeProjectApplicationRepository;
    private final EmployeeProjectRepository employeeProjectRepository;
    private final EmployeeRepository employeeRepository;
    public ProjectService(ProjectRepository projectRepository, EmployeeProjectApplicationRepository employeeProjectApplicationRepository,
    EmployeeProjectRepository employeeProjectRepository, EmployeeRepository employeeRepository){
        this.projectRepository=projectRepository;
        this.employeeProjectApplicationRepository = employeeProjectApplicationRepository;
        this.employeeProjectRepository = employeeProjectRepository;
        this.employeeRepository = employeeRepository;
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

    public Long applyProject(Long projectId, ProjectApplicationRequest projectApplicationRequest){
        EmployeeProjectApplication employeeProjectApplication = new EmployeeProjectApplication();
        employeeProjectApplication.setApplicationStatus(ApplicationStatus.SUBMITTED.name());
        employeeProjectApplication.setApplyDate(projectApplicationRequest.getApplyDate());
        employeeProjectApplication.setEmployeeComment(projectApplicationRequest.getEmployeeComment());
        Project project = new Project();
        project.setProjectId(projectId);
        employeeProjectApplication.setProject(project);
        Employee employee = new Employee();
        employee.setEmployeeId(projectApplicationRequest.getEmployeeId());
        employeeProjectApplication.setEmployee(employee);
        EmployeeProjectApplication createdEmployeeProjectApplication = employeeProjectApplicationRepository.save(employeeProjectApplication);
        return createdEmployeeProjectApplication.getEmpApplicationId();
    }

    @Transactional(rollbackOn = Exception.class)
    public Long updateProjectApplication(Long employeeProjectApplicationId, ProjectApplicationRequest projectApplicationRequest){
        Optional<EmployeeProjectApplication> optionalEmployeeProjectApplication = employeeProjectApplicationRepository.findById(employeeProjectApplicationId);
        if (optionalEmployeeProjectApplication.isPresent()) {
            EmployeeProjectApplication employeeProjectApplication = optionalEmployeeProjectApplication.get();
            if(employeeProjectApplication.getApplicationStatus().equals(ApplicationStatus.APPROVED.name()) ||
                    employeeProjectApplication.getApplicationStatus().equals(ApplicationStatus.REJECTED.name())) {
                throw new RuntimeException("Application is not in right state for update, Update is not allowed");
            }
            employeeProjectApplication.setApplicationStatus(projectApplicationRequest.getApplicationStatus().name());
            employeeProjectApplication.setAdminComment(projectApplicationRequest.getAdminComment());
            if(employeeProjectApplication.getApplicationStatus().equals(ApplicationStatus.APPROVED.name())) {
                employeeProjectApplicationRepository.save(employeeProjectApplication);
                EmployeeProject employeeProject = new EmployeeProject();
                employeeProject.setProjectAssignDate(new Date());
                employeeProject.setApplyDate(employeeProjectApplication.getApplyDate());
                employeeProject.setEmployee(employeeProjectApplication.getEmployee());
                employeeProject.setProject(employeeProjectApplication.getProject());
                employeeProjectRepository.save(employeeProject);
            }
            else {
                employeeProjectApplicationRepository.save(employeeProjectApplication);
            }
        }
        else {
            throw new RuntimeException("EmployeeApplicationId not found");
        }
        return employeeProjectApplicationId;
    }
}
