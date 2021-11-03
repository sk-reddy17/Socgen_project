package com.shahsi.OrgApp.repository;

import com.shahsi.OrgApp.entity.Organization;
import com.shahsi.OrgApp.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
    Project findByProjectId(String projectId);
}
