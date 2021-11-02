package com.shahsi.OrgApp.controller;

import com.shahsi.OrgApp.dto.EmployeeDto;
import com.shahsi.OrgApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/home")
    public String DoNothing()
    {
        return "Yes !  I am Working";
    }
    @GetMapping
    public List<EmployeeDto> getAll()
    {
        return service.getAll();
    }

    @PostMapping
    public EmployeeDto createUser(@RequestBody EmployeeDto u)
    {
        return service.createUser(u);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String userId)
    {
        return service.deleteUser(userId);

    }
    @GetMapping ("/id/{id}")
    public EmployeeDto findUser(@PathVariable("id") String userId)
    {
        return service.findUser(userId);
    }


}

