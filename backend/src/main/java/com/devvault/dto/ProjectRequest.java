package com.devvault.dto;
import com.devvault.entity.ProjectStatus;
import jakarta.validation.constraints.NotBlank;
public record ProjectRequest(@NotBlank String name,String description,ProjectStatus status) {}
