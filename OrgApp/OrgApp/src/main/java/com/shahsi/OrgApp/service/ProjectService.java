package com.shahsi.OrgApp.service;

import com.shahsi.OrgApp.dto.ProjectDto;
import com.shahsi.OrgApp.entity.Project;
import com.shahsi.OrgApp.mapper.Emapper;
import com.shahsi.OrgApp.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}
