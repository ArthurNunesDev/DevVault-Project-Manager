package com.devvault.controller;
import com.devvault.dto.DashboardResponse; import com.devvault.service.DashboardService; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/dashboard")
public class DashboardController { private final DashboardService service; public DashboardController(DashboardService s){service=s;} @GetMapping public DashboardResponse get(){return service.get();} }