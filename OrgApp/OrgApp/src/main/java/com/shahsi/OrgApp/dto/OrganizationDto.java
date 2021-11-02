package com.shahsi.OrgApp.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class OrganizationDto {
    private String id;
    private String orgName;
    private List<ProjectDto> projects;
}
/*


{
  "orgName": "Google",
  "projects":[
  "projectName":"Pixelphone",
         "budget":100000,
         "employees":[
            {
               "name":"emp1",
               "salary":10
            },
            {
               "name":"emp2",
               "salary":1000
            }


         ]
  ]
  }






 */
