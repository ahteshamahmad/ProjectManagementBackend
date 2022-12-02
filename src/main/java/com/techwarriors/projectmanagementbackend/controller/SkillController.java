package com.techwarriors.projectmanagementbackend.controller;

import com.techwarriors.projectmanagementbackend.api.request.ProjectRequest;
import com.techwarriors.projectmanagementbackend.api.request.SkillRequest;
import com.techwarriors.projectmanagementbackend.api.response.GenericAPIResponse;
import com.techwarriors.projectmanagementbackend.api.response.SkillResponse;
import com.techwarriors.projectmanagementbackend.model.Skill;
import com.techwarriors.projectmanagementbackend.service.ProjectService;
import com.techwarriors.projectmanagementbackend.service.SkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkillController {
    private final SkillService skillService;
    public SkillController(SkillService skillService){
        this.skillService=skillService;
    }
    @PostMapping("/skill")
    public ResponseEntity<GenericAPIResponse> createSkill(@RequestBody SkillRequest skillRequest) {
        GenericAPIResponse<SkillResponse> response = new GenericAPIResponse<>();
        try {
            Long createdSkillId = skillService.createSkill(skillRequest);
            response.setMessage("skill is created successfully");
            SkillResponse skillResponse = new SkillResponse();
            skillResponse.setSkillId(createdSkillId);
            skillResponse.setSkillName(skillRequest.getSkillName());
            response.setData(skillResponse);
            return ResponseEntity.ok(response);
        } catch (Exception exception) {
            System.out.println(exception);
            response.setMessage("Something went wrong, Please try again later!");
            return ResponseEntity.status(500).body(response);
        }
    }

    @GetMapping("/skill")
    public ResponseEntity<GenericAPIResponse> getAllSkills() {
        GenericAPIResponse<List<Skill>> response = new GenericAPIResponse<>();
        try {
            List<Skill> allSkills = skillService.getAllSkills();
            response.setMessage("All Skills fetched successfully");
            response.setData(allSkills);
            return ResponseEntity.ok(response);
        } catch (Exception exception) {
            System.out.println(exception);
            response.setMessage("Something went wrong, Please try again later!");
            return ResponseEntity.status(500).body(response);
        }
    }
}
