package com.devvault.service;
import com.devvault.dto.*; import com.devvault.entity.*; import com.devvault.repository.*; import org.springframework.stereotype.Service; import java.util.*;
@Service
public class TaskService {
 private final TaskRepository repo; private final ProjectRepository projects;
 public TaskService(TaskRepository repo,ProjectRepository projects){this.repo=repo;this.projects=projects;}
 public List<TaskResponse> all(){return repo.findAll().stream().map(this::map).toList();}
 public TaskResponse get(Long id){return map(repo.findById(id).orElseThrow(()->new NoSuchElementException("Tarefa não encontrada.")));}
 public TaskResponse create(TaskRequest r){Task t=new Task();apply(t,r);return map(repo.save(t));}
 public TaskResponse update(Long id,TaskRequest r){Task t=repo.findById(id).orElseThrow(()->new NoSuchElementException("Tarefa não encontrada."));apply(t,r);return map(repo.save(t));}
 public void delete(Long id){if(!repo.existsById(id))throw new NoSuchElementException("Tarefa não encontrada.");repo.deleteById(id);}
 private void apply(Task t,TaskRequest r){t.setTitle(r.title());t.setDescription(r.description());t.setStatus(r.status()==null?TaskStatus.TODO:r.status());t.setPriority(r.priority()==null?TaskPriority.MEDIUM:r.priority());t.setDueDate(r.dueDate());t.setProject(projects.findById(r.projectId()).orElseThrow(()->new NoSuchElementException("Projeto não encontrado.")));}
 private TaskResponse map(Task t){return new TaskResponse(t.getId(),t.getTitle(),t.getDescription(),t.getStatus(),t.getPriority(),t.getDueDate(),t.getProject().getId(),t.getCreatedAt(),t.getUpdatedAt());}
}
