package com.devvault.dto;

import com.devvault.entity.ProjectStatus;

import java.time.LocalDateTime;

public record ProjectResponse(
        Long id,
        String name,
        String description,
        ProjectStatus status,
        String githubUrl,
        String demoUrl,
        LocalDateTime createdAt,
        long taskCount
) {}
