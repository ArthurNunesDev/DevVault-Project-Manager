package com.devvault.dto;

import com.devvault.entity.TaskPriority;
import com.devvault.entity.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record TaskRequest(
        @NotBlank @Size(max = 160) String title,
        @Size(max = 1000) String description,
        TaskPriority priority,
        TaskStatus status,
        LocalDate dueDate
) {}
