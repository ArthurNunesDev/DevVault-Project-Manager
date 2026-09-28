package com.devvault.service;

import com.devvault.dto.ProjectRequest;
import com.devvault.dto.ProjectResponse;
import com.devvault.entity.Project;
import com.devvault.entity.ProjectStatus;
import com.devvault.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public List<ProjectResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public ProjectResponse findById(Long id) {
        return toResponse(getEntity(id));
    }

    public ProjectResponse create(ProjectRequest request) {
        Project project = new Project(
                request.name(),
                request.description(),
                request.status() == null ? ProjectStatus.PLANNED : request.status(),
                request.githubUrl(),
                request.demoUrl()
        );
        return toResponse(repository.save(project));
    }

    public ProjectResponse update(Long id, ProjectRequest request) {
        Project project = getEntity(id);
        project.setName(request.name());
        project.setDescription(request.description());
        project.setStatus(request.status() == null ? ProjectStatus.PLANNED : request.status());
        project.setGithubUrl(request.githubUrl());
        project.setDemoUrl(request.demoUrl());
        return toResponse(repository.save(project));
    }

    public void delete(Long id) {
        repository.delete(getEntity(id));
    }

    public Project getEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Projeto não encontrado."));
    }

    private ProjectResponse toResponse(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getStatus(),
                project.getGithubUrl(),
                project.getDemoUrl(),
                project.getCreatedAt(),
                project.getTasks().size()
        );
    }
}
