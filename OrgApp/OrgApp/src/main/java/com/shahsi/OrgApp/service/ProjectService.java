package com.shahsi.OrgApp.service;

import com.shahsi.OrgApp.dto.ProjectDto;
import com.shahsi.OrgApp.entity.Organization;
import com.shahsi.OrgApp.entity.Project;
import com.shahsi.OrgApp.mapper.Emapper;
import com.shahsi.OrgApp.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProjectService {
    private  final ProjectRepository repo;
    private final Emapper mapper;


    public ProjectDto createProject( ProjectDto projectDto)
    {
        Project p = mapper.map(projectDto, Project.class);
        Project saved = repo.save(p);
        return mapper.map(saved, ProjectDto.class);
    }
    public ResponseEntity<String> deleteProject(String  projectId)
    {
        Project project= repo.findByProjectId(projectId);
        if(Objects.nonNull(project))
        {
            repo.delete(project);
        }
        return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
                .body("***********Deleted "+ project.getProjectName()+"Successfully************");

    }

    public List<ProjectDto> getProjects() {
        return repo.findAll()
                .stream()
                .map(p -> mapper.map(p, ProjectDto.class))
                .collect(Collectors.toList());
    }
}
