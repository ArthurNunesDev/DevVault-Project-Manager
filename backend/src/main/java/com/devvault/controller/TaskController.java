package com.devvault.controller;
import com.devvault.dto.*; import com.devvault.service.TaskService; import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/tasks") @CrossOrigin(origins="http://localhost:5173")
public class TaskController {
 private final TaskService service; public TaskController(TaskService s){service=s;}
 @GetMapping public List<TaskResponse> all(){return service.all();}
 @GetMapping("/{id}") public TaskResponse get(@PathVariable Long id){return service.get(id);}
 @PostMapping public ResponseEntity<TaskResponse> create(@Valid @RequestBody TaskRequest r){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(r));}
 @PutMapping("/{id}") public TaskResponse update(@PathVariable Long id,@Valid @RequestBody TaskRequest r){return service.update(id,r);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){service.delete(id);}
}