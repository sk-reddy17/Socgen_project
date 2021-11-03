package com.shahsi.OrgApp.controller;

import com.shahsi.OrgApp.dto.OrganizationDto;
import com.shahsi.OrgApp.entity.Organization;
import com.shahsi.OrgApp.mapper.Emapper;
import com.shahsi.OrgApp.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("org")
public class OrganizationController {

    private  final OrganizationService service;
    private final Emapper mapper;

    @GetMapping("/home")
    public String DoNothing()
    {
        return "Yes !  I am Working";
    }
    @PostMapping
    public OrganizationDto createOrg(@RequestBody OrganizationDto organizationDto)
    {
        return service.createOrg(organizationDto);
    }

    @GetMapping
    public List<OrganizationDto> getOrg()
    {
        return service.getOrg();
    }

    @GetMapping("/revenue/{id}")
    public int calc(@PathVariable("id") String orgId)
    {
        return service.calc(orgId);
    }
    @GetMapping("/empcost/{id}")
    public int calc1(@PathVariable("id") String orgId)
    {
        return service.calc1(orgId);
    }
    @GetMapping("/status/{id}")
    public String status(@PathVariable("id") String orgId)
    {
        return  service.status(orgId);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delOrg(@PathVariable("id") String orgId)
    {
        return service.deleteOrg(orgId);
    }










}
