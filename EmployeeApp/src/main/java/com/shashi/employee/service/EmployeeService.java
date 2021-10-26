package com.shashi.employee.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.shashi.employee.model.Employee;

public interface EmployeeService {
	Employee newEmployee(Employee e);

    List<Employee> getEmployee(String name);

    Employee updateEmployee(int id, Employee e);

    ResponseEntity<String> DelEmployee(Integer id);

    List<Employee> searchByCity(String city);

    List<Employee> searchByState(String state);

    List<Employee> getall();

}
