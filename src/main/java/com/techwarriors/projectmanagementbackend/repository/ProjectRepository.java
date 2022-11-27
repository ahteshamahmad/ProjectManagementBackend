package com.techwarriors.projectmanagementbackend.repository;

import com.techwarriors.projectmanagementbackend.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {
}
