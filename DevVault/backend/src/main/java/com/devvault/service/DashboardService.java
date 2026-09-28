package com.devvault.service;

import com.devvault.dto.DashboardResponse;
import com.devvault.entity.ProjectStatus;
import com.devvault.entity.TaskStatus;
import com.devvault.repository.ProjectRepository;
import com.devvault.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public DashboardService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    public DashboardResponse getDashboard() {
        return new DashboardResponse(
                projectRepository.count(),
                projectRepository.countByStatus(ProjectStatus.PLANNED),
                projectRepository.countByStatus(ProjectStatus.IN_PROGRESS),
                projectRepository.countByStatus(ProjectStatus.COMPLETED),
                taskRepository.count(),
                taskRepository.countByStatus(TaskStatus.TODO),
                taskRepository.countByStatus(TaskStatus.IN_PROGRESS),
                taskRepository.countByStatus(TaskStatus.DONE)
        );
    }
}
