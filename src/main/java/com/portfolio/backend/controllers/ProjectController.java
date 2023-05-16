package com.portfolio.backend.controllers;

import com.portfolio.backend.models.ProjectModel;
import com.portfolio.backend.services.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {
    @Autowired
    IProjectService projectService;

    @GetMapping("")
    public List<ProjectModel> getAllProjects(){
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectModel> getProjectById(@PathVariable(value = "id") Long id){
        ProjectModel projectById = projectService.findById(id);
        if(projectById != null){
            return ResponseEntity.ok().body(projectById);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<ProjectModel> createProject(@RequestBody ProjectModel project){
        projectService.save(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectModel> updateProject(@PathVariable(value = "id") Long id, @RequestBody ProjectModel project){
        projectService.update(id, project);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(project);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable(value = "id") Long id){
        projectService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
