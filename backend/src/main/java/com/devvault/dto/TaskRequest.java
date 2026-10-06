package com.devvault.dto;

import com.devvault.entity.TaskPriority;
import com.devvault.entity.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TaskRequest(
        @NotBlank String title,
        String description,
        TaskStatus status,
        TaskPriority priority,
        LocalDate dueDate,
        @NotNull Long projectId
) {}
