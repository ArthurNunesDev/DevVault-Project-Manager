package com.devvault.repository;

import com.devvault.entity.Project;
import com.devvault.entity.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    long countByStatus(ProjectStatus status);
}
