package com.devvault.service;
import com.devvault.dto.*; import com.devvault.entity.*; import com.devvault.repository.*; import org.springframework.stereotype.Service; import java.util.*;
@Service
public class ProjectService {
 private final ProjectRepository repo; private final TaskRepository tasks;
 public ProjectService(ProjectRepository repo,TaskRepository tasks){this.repo=repo;this.tasks=tasks;}
 public List<ProjectResponse> all(){return repo.findAll().stream().map(this::map).toList();}
 public ProjectResponse get(Long id){return map(repo.findById(id).orElseThrow(()->new NoSuchElementException("Projeto não encontrado.")));}
 public ProjectResponse create(ProjectRequest r){Project p=new Project();apply(p,r);return map(repo.save(p));}
 public ProjectResponse update(Long id,ProjectRequest r){Project p=repo.findById(id).orElseThrow(()->new NoSuchElementException("Projeto não encontrado."));apply(p,r);return map(repo.save(p));}
 public void delete(Long id){if(!repo.existsById(id))throw new NoSuchElementException("Projeto não encontrado.");repo.deleteById(id);}
 private void apply(Project p,ProjectRequest r){p.setName(r.name());p.setDescription(r.description());p.setStatus(r.status()==null?ProjectStatus.PLANNED:r.status());}
 private ProjectResponse map(Project p){return new ProjectResponse(p.getId(),p.getName(),p.getDescription(),p.getStatus(),p.getCreatedAt(),p.getUpdatedAt(),tasks.countByProjectId(p.getId()));}
}
