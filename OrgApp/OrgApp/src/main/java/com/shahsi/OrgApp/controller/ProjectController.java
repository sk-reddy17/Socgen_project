package com.shahsi.OrgApp.controller;

import com.shahsi.OrgApp.dto.ProjectDto;
import com.shahsi.OrgApp.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("project")
public class ProjectController {

    private final ProjectService service;
    @GetMapping("/home")
    public String DoNothing()
    {
        return "Yes !  I am Working";
    }
    @GetMapping
    public List<ProjectDto> getProjects()
    {
        return service.getProjects();
    }

    @PostMapping
    public ProjectDto createDto(@RequestBody ProjectDto projectDto)
    {
        return service.createProject(projectDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable("id") String projectId)
    {
        return service.deleteProject(projectId);
    }
}
