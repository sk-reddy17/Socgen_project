package com.shahsi.OrgApp.service;

import com.shahsi.OrgApp.dto.EmployeeDto;
import com.shahsi.OrgApp.entity.Employee;
import com.shahsi.OrgApp.mapper.Emapper;
import com.shahsi.OrgApp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository repo;
    private  final Emapper mapper;

    public List<EmployeeDto> getAll()
    {
        return repo
                .findAll()
                .stream()
                .map(s-> mapper.map(s, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public EmployeeDto createUser(EmployeeDto employeeDto)
    {
        Employee u = mapper.map(employeeDto, Employee.class);
        Employee created = repo.save(u);
        return mapper.map(created, EmployeeDto.class);


    }

    public ResponseEntity<String> deleteUser(String  employeeId)
    {
        Employee u = repo.findByEmployeeId(employeeId);
        if(Objects.nonNull(u))
        {
            repo.delete(u);
        }
        return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
                .body("***********Deleted Successfully************");

    }

    public EmployeeDto findUser(String userId)
    {
        Employee u = repo.findByEmployeeId(userId);
        EmployeeDto found = mapper.map(u, EmployeeDto.class);
        return found;
    }



}
