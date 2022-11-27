package com.techwarriors.projectmanagementbackend.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name="skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="skill_id")
    private Long skillId;
    @Column(name="skill_name")
    private String skillName;

    @OneToMany(mappedBy = "skill")
    private Set<EmployeeSkills> employeeSkillsSet;

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Set<EmployeeSkills> getEmployeeSkillsSet() {
        return employeeSkillsSet;
    }

    public void setEmployeeSkillsSet(Set<EmployeeSkills> employeeSkillsSet) {
        this.employeeSkillsSet = employeeSkillsSet;
    }


}
