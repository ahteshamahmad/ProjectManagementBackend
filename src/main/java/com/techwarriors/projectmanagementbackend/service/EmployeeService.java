package com.techwarriors.projectmanagementbackend.service;

import com.techwarriors.projectmanagementbackend.api.request.*;
import com.techwarriors.projectmanagementbackend.model.*;
import com.techwarriors.projectmanagementbackend.repository.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeContactRepository employeeContactRepository;
    private final EmployeeEducationRepository employeeEducationRepository;

    private final EmployeeExperienceRepository employeeExperienceRepository;

    private final EmployeeSkillsRepository employeeSkillsRepository;

    private final ProjectRepository projectRepository;

    private static final double PRIMARY_PROJECT_MATCHING_PERCENTAGE_THRESHOLD = 60;


    public EmployeeService(EmployeeRepository employeeRepository, EmployeeContactRepository employeeContactRepository,
                           EmployeeEducationRepository employeeEducationRepository,
                           EmployeeExperienceRepository employeeExperienceRepository,
                           EmployeeSkillsRepository employeeSkillsRepository,
                           ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeContactRepository = employeeContactRepository;
        this.employeeEducationRepository = employeeEducationRepository;
        this.employeeExperienceRepository = employeeExperienceRepository;
        this.employeeSkillsRepository = employeeSkillsRepository;
        this.projectRepository = projectRepository;
    }

    public Long doRegister(EmployeeRequest employeeRequest){
        Employee employee=new Employee();
        employee.setEmployeeDoj(new Date());
        employee.setEmployeeFirstName(employeeRequest.getEmployeeFirstName());
        employee.setEmployeeLastName(employeeRequest.getEmployeeLastName());
        employee.setEmployeeGender(employeeRequest.getEmployeeGender());
        employee.setEmployeePassword(employeeRequest.getEmployeePassword());
        employee.setEmpProfilePhotoUrl(employeeRequest.getEmpProfilePhotoUrl());
        Employee createdEmployee = employeeRepository.save(employee);
        return createdEmployee.getEmployeeId();
    }

    public Long addContact(Long employeeId, EmployeeContactRequest employeeContactRequest){
        Employee employee=new Employee();
        employee.setEmployeeId(employeeId);
        EmployeeContact employeeContact = new EmployeeContact();
        employeeContact.setEmployee(employee);
        employeeContact.setEmployeeEmailId(employeeContactRequest.getEmployeeEmailId());
        employeeContact.setEmployeePhoneNumber(employeeContactRequest.getEmployeePhoneNumber());
        EmployeeAddress employeeAddress = new EmployeeAddress();
        employeeAddress.setFirstAddressLine(employeeContactRequest.getEmployeeAddressRequest().getFirstAddressLine());
        employeeAddress.setSecondAddressLine(employeeContactRequest.getEmployeeAddressRequest().getSecondAddressLine());
        employeeAddress.setCity(employeeContactRequest.getEmployeeAddressRequest().getCity());
        employeeAddress.setCountry(employeeContactRequest.getEmployeeAddressRequest().getCountry());
        employeeAddress.setLandmark(employeeContactRequest.getEmployeeAddressRequest().getLandmark());
        employeeAddress.setAreaPinCode(employeeContactRequest.getEmployeeAddressRequest().getAreaPinCode());
        employeeAddress.setState(employeeContactRequest.getEmployeeAddressRequest().getState());
        employeeContact.setEmployeeAddress(employeeAddress);
        EmployeeContact createdEmployeeContact = employeeContactRepository.save(employeeContact);
        return createdEmployeeContact.getEmployeeContactId();
    }

    public Long addEducation(Long employeeId, EmployeeEducationRequest employeeEducationRequest){
        Employee employee=new Employee();
        employee.setEmployeeId(employeeId);
        EmployeeEducation employeeEducation = new EmployeeEducation();
        employeeEducation.setEmployee(employee);
        employeeEducation.setDivision(employeeEducationRequest.getDivision().name());
        employeeEducation.setMajor(employeeEducationRequest.getMajor());
        employeeEducation.setCompletedDate(employeeEducationRequest.getCompletedDate());
        employeeEducation.setEndDate(employeeEducationRequest.getEndDate());
        employeeEducation.setScoreMeasurementType(employeeEducationRequest.getScoreMeasurementType().name());
        employeeEducation.setStartDate(employeeEducationRequest.getStartDate());
        employeeEducation.setScoreValue(employeeEducationRequest.getScoreValue());
        employeeEducation.setUnivName(employeeEducationRequest.getUnivName());
        EmployeeEducation createdEmployeeEducation = employeeEducationRepository.save(employeeEducation);
        return createdEmployeeEducation.getEmployeeEducationId();
    }
    public Long addExperience(Long employeeId, EmployeeExperienceRequest employeeExperienceRequest) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        EmployeeExperience employeeExperience = new EmployeeExperience();
        employeeExperience.setEmployee(employee);
        employeeExperience.setStartDate(employeeExperienceRequest.getStartDate());
        employeeExperience.setEndDate(employeeExperienceRequest.getEndDate());
        employeeExperience.setCurrent(employeeExperienceRequest.isCurrent());
        employeeExperience.setProjectTitle(employeeExperienceRequest.getProjectTitle());
        employeeExperience.setProjectResponsibility(employeeExperienceRequest.getProjectResponsibility());
        EmployeeExperience createdEmployeeExperienceList = employeeExperienceRepository.save(employeeExperience);
        return createdEmployeeExperienceList.getEmployeeExperienceId();
    }

    public Long addSkill(Long employeeId, EmployeeSkillsRequest employeeSkillRequest){
        Employee employee=new Employee();
        employee.setEmployeeId(employeeId);
        EmployeeSkills employeeSkill = new EmployeeSkills();
        employeeSkill.setEmployee(employee);
        employeeSkill.setExperienceInYear(employeeSkillRequest.getExperienceInYear());
        Skill skill = new Skill();
        skill.setSkillId(employeeSkillRequest.getSkillRequest().getSkillId());
        employeeSkill.setSkill(skill);
        employeeSkill.setKnowledgeLevel(employeeSkillRequest.getKnowledgeLevel().name());
        employeeSkill.setIsPrimarySkill(employeeSkillRequest.getIsPrimarySkill());
        employeeSkill.setIsSecondarySkill(employeeSkillRequest.getIsSecondarySkill());
        EmployeeSkills createdEmployeeSkill = employeeSkillsRepository.save(employeeSkill);
        return createdEmployeeSkill.getEmpSkillId();
    }

    public List<Employee> getAllEmployee(){
        List<Employee> allEmployees = new ArrayList<>();
        employeeRepository.findAll().iterator().forEachRemaining(allEmployees::add);
        return allEmployees;
    }

    public Optional<Employee> getEmployee(Long employeeId){
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employee;
    }

    public Long updateEmployeeDetails(Long employeeId, EmployeeRequest employeeRequest) throws Exception {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isPresent()) {
            Employee employeeObject = employee.get();
            employeeObject.setEmployeeDoj(new Date());
            employeeObject.setEmployeeFirstName(employeeRequest.getEmployeeFirstName());
            employeeObject.setEmployeeLastName(employeeRequest.getEmployeeLastName());
            employeeObject.setEmployeeGender(employeeRequest.getEmployeeGender());
            employeeObject.setEmployeePassword(employeeRequest.getEmployeePassword());
            employeeObject.setEmpProfilePhotoUrl(employeeRequest.getEmpProfilePhotoUrl());
            return employeeRepository.save(employeeObject).getEmployeeId();
        }
        else {
            throw new Exception("Employee not found");
        }
    }

    public List<Project> getAllMatchingProject(Long employeeId) {
        List<Project> allMatchedProject = new ArrayList<>();
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            Set<EmployeeSkills> employeeSkills = employee.getEmployeeSkills();
            Map<Long, EmployeeSkills> employeeSkillMap = new HashMap<>();
            for(EmployeeSkills nextEmployeeSkill : employeeSkills) {
                employeeSkillMap.put(nextEmployeeSkill.getSkill().getSkillId(), nextEmployeeSkill);
            }
            List<Project> projects = projectRepository.findAll();
            for(Project project : projects) {
                int totalPrimarySkill = 0;
                int matchPrimarySkillCount = 0;
                Set<ProjectSkills> projectSkills = project.getProjectSkills();
                for (ProjectSkills nextProjectSkill : projectSkills) {
                    if (nextProjectSkill.isMandatorySkill()) {
                        totalPrimarySkill+=1;
                    }
                    if (employeeSkillMap.containsKey(nextProjectSkill.getSkill().getSkillId())) {
                        EmployeeSkills employeeSkill = employeeSkillMap.get(nextProjectSkill.getSkill().getSkillId());
                        if (nextProjectSkill.getKnowledgeLevel().equals(employeeSkill.getKnowledgeLevel())
                        && nextProjectSkill.isMandatorySkill() == employeeSkill.getIsPrimarySkill()) {
                            matchPrimarySkillCount+=1;
                        }
                    }
                }
                if (projectSkills.size() !=0 && totalPrimarySkill > 0) {
                    double matchPrimarySkillPercentage = (matchPrimarySkillCount / totalPrimarySkill) * 100;
                    if (matchPrimarySkillPercentage >= PRIMARY_PROJECT_MATCHING_PERCENTAGE_THRESHOLD) {
                        allMatchedProject.add(project);
                    }
                }
            }
        }
        else {
            throw new RuntimeException("Employee Not Found");
        }
        return allMatchedProject;
    }
}
