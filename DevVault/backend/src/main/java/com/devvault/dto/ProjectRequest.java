package com.devvault.dto;

import com.devvault.entity.ProjectStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProjectRequest(
        @NotBlank @Size(max = 120) String name,
        @Size(max = 1000) String description,
        ProjectStatus status,
        String githubUrl,
        String demoUrl
) {}
