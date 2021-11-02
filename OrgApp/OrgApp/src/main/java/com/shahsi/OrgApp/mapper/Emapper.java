package com.shahsi.OrgApp.mapper;

import com.shahsi.OrgApp.dto.EmployeeDto;
import com.shahsi.OrgApp.dto.OrganizationDto;
import com.shahsi.OrgApp.dto.ProjectDto;
import com.shahsi.OrgApp.entity.Employee;
import com.shahsi.OrgApp.entity.Organization;
import com.shahsi.OrgApp.entity.Project;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class Emapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.registerClassMap(factory.classMap(Employee.class, EmployeeDto.class)
                .fieldAToB("employeeId", "id")
                .byDefault());
        factory.registerClassMap(factory.classMap(Project.class, ProjectDto.class)
                .fieldAToB("projectId", "id")
                .byDefault());
        factory.registerClassMap(factory.classMap(Organization.class, OrganizationDto.class)
                .fieldAToB("orgId", "id")
                .byDefault());


    }
}
