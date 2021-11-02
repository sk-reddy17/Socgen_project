package com.shahsi.OrgApp.controller;

import com.shahsi.OrgApp.dto.ProjectDto;
import com.shahsi.OrgApp.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public ProjectDto createDto(@RequestBody ProjectDto projectDto)
    {
        return service.createProject(projectDto);
    }
}
