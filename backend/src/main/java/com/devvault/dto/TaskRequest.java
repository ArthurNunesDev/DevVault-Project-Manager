package com.devvault.dto;
import com.devvault.entity.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
public record TaskRequest(@NotBlank String title,String description,TaskStatus status,TaskPriority priority,LocalDate dueDate,Long projectId) {}
