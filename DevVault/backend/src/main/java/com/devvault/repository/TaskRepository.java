package com.devvault.repository;

import com.devvault.entity.Task;
import com.devvault.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProjectIdOrderByCreatedAtDesc(Long projectId);
    long countByStatus(TaskStatus status);
}
