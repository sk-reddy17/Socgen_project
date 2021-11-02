package com.shahsi.OrgApp.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProjectDto {
    private String id;
    private String projectName;
    private int budget;
    private List<EmployeeDto> employees;

}
