package com.devvault.service;

import com.devvault.dto.TaskRequest;
import com.devvault.dto.TaskResponse;
import com.devvault.entity.Project;
import com.devvault.entity.Task;
import com.devvault.entity.TaskPriority;
import com.devvault.entity.TaskStatus;
import com.devvault.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final ProjectService projectService;

    public TaskService(TaskRepository repository, ProjectService projectService) {
        this.repository = repository;
        this.projectService = projectService;
    }

    public List<TaskResponse> findByProject(Long projectId) {
        projectService.getEntity(projectId);
        return repository.findByProjectIdOrderByCreatedAtDesc(projectId)
                .stream().map(this::toResponse).toList();
    }

    public TaskResponse create(Long projectId, TaskRequest request) {
        Project project = projectService.getEntity(projectId);

        Task task = new Task(
                request.title(),
                request.description(),
                request.priority() == null ? TaskPriority.MEDIUM : request.priority(),
                request.status() == null ? TaskStatus.TODO : request.status(),
                request.dueDate(),
                project
        );

        return toResponse(repository.save(task));
    }

    public TaskResponse update(Long id, TaskRequest request) {
        Task task = getEntity(id);
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setPriority(request.priority() == null ? TaskPriority.MEDIUM : request.priority());
        task.setStatus(request.status() == null ? TaskStatus.TODO : request.status());
        task.setDueDate(request.dueDate());
        return toResponse(repository.save(task));
    }

    public void delete(Long id) {
        repository.delete(getEntity(id));
    }

    public Task getEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada."));
    }

    private TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.getStatus(),
                task.getDueDate(),
                task.getCreatedAt(),
                task.getProject().getId()
        );
    }
}
