package com.devvault.dto;
public record DashboardResponse(long totalProjects,long plannedProjects,long inProgressProjects,long completedProjects,long totalTasks,long todoTasks,long inProgressTasks,long doneTasks) {}
