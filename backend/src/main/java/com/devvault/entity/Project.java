package com.devvault.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="projects")
public class Project {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(nullable=false) private String name;
    @Column(length=2000) private String description;
    @Enumerated(EnumType.STRING) @Column(nullable=false) private ProjectStatus status=ProjectStatus.PLANNED;
    @Column(nullable=false) private LocalDateTime createdAt;
    @Column(nullable=false) private LocalDateTime updatedAt;
    @OneToMany(mappedBy="project", cascade=CascadeType.ALL, orphanRemoval=true) private List<Task> tasks=new ArrayList<>();
    @PrePersist void prePersist(){createdAt=LocalDateTime.now();updatedAt=createdAt;}
    @PreUpdate void preUpdate(){updatedAt=LocalDateTime.now();}
    public Long getId(){return id;} public String getName(){return name;} public void setName(String v){name=v;}
    public String getDescription(){return description;} public void setDescription(String v){description=v;}
    public ProjectStatus getStatus(){return status;} public void setStatus(ProjectStatus v){status=v;}
    public LocalDateTime getCreatedAt(){return createdAt;} public LocalDateTime getUpdatedAt(){return updatedAt;}
    public List<Task> getTasks(){return tasks;}
}
