package com.devvault.controller;
import com.devvault.dto.*; import com.devvault.service.ProjectService; import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/projects") @CrossOrigin(origins="http://localhost:5173")
public class ProjectController {
 private final ProjectService service; public ProjectController(ProjectService s){service=s;}
 @GetMapping public List<ProjectResponse> all(){return service.all();}
 @GetMapping("/{id}") public ProjectResponse get(@PathVariable Long id){return service.get(id);}
 @PostMapping public ResponseEntity<ProjectResponse> create(@Valid @RequestBody ProjectRequest r){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(r));}
 @PutMapping("/{id}") public ProjectResponse update(@PathVariable Long id,@Valid @RequestBody ProjectRequest r){return service.update(id,r);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){service.delete(id);}
}
