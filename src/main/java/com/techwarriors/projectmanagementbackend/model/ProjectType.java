package com.techwarriors.projectmanagementbackend.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name="project_type")
public class ProjectType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_type_id")
    private Long projectTypeId;
    @Column(name="project_type_name")
    private String projectTypeName;

    @OneToMany(mappedBy = "projectType")
    private Set<Project> projects;

    public Long getProjectTypeId() {
        return projectTypeId;
    }

    public void setProjectTypeId(Long projectTypeId) {
        this.projectTypeId = projectTypeId;
    }

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
