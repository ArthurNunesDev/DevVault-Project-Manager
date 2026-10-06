package com.devvault.dto;
import com.devvault.entity.*;
import java.time.*;
public record TaskResponse(Long id,String title,String description,TaskStatus status,TaskPriority priority,LocalDate dueDate,Long projectId,LocalDateTime createdAt,LocalDateTime updatedAt) {}
