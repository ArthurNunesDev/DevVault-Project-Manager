package com.devvault.dto;

import com.devvault.entity.TaskPriority;
import com.devvault.entity.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TaskResponse(
        Long id,
        String title,
        String description,
        TaskPriority priority,
        TaskStatus status,
        LocalDate dueDate,
        LocalDateTime createdAt,
        Long projectId
) {}
