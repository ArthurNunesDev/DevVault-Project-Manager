package com.devvault.dto;
import com.devvault.entity.ProjectStatus;
import java.time.LocalDateTime;
public record ProjectResponse(Long id,String name,String description,ProjectStatus status,LocalDateTime createdAt,LocalDateTime updatedAt,long taskCount) {}
