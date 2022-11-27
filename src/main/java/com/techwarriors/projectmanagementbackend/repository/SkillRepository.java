package com.techwarriors.projectmanagementbackend.repository;

import com.techwarriors.projectmanagementbackend.model.Project;
import com.techwarriors.projectmanagementbackend.model.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository<Skill,Long> {
}
