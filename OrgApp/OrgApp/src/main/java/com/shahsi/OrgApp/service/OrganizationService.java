package com.shahsi.OrgApp.service;

import com.shahsi.OrgApp.dto.OrganizationDto;
import com.shahsi.OrgApp.entity.Organization;
import com.shahsi.OrgApp.mapper.Emapper;
import com.shahsi.OrgApp.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrganizationService {

    private final OrganizationRepository repos;
    private  final Emapper mapper;

    public List<OrganizationDto> getOrg()
    {
        return repos
            .findAll()
            .stream()
            .map(o -> mapper.map(o, OrganizationDto.class))
                .collect(Collectors.toList());
    }

    public OrganizationDto createOrg(OrganizationDto organizationDto)
    {
        Organization org = mapper.map(organizationDto, Organization.class);
        Organization saved = repos.save(org);
        return mapper.map(saved, OrganizationDto.class);
    }
    public int calc(String orgId)

    {
        int revenue = 0;
        Organization org = repos.findByOrgId(orgId);
        for(int i = 0; i < org.getProjects().size(); i++) {
            revenue += org.getProjects().get(i).getBudget();
        }
        return revenue;
    }
    public int calc1(String orgId)

    {
        int empcost = 0;
        Organization org = repos.findByOrgId(orgId);
        for(int i = 0; i < org.getProjects().size();i++)
        {
            for(int j = 0; j< org.getProjects().get(i).getEmployees().size(); j++)
            {
                empcost += org.getProjects().get(i).getEmployees().get(j).getSalary();
            }
        }
        empcost += 0.01*empcost;
        //return "EmployeeCost for a proect BUDGET = " + empcost;
        return empcost;
    }
    public String status(String orgId)
    {
        Organization org = repos.findByOrgId(orgId);
        int revenue = calc(orgId);
        int budget = calc1(orgId);
        String print = "The total revenue of the Company "+ org.getOrgName() + " = " +revenue + "\n"
                 + "The total profit of the Company = " + (revenue - budget);
        return print;
    }

}
