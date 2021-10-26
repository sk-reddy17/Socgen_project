package com.shashi.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.shashi.employee.model.Employee;
import com.shashi.employee.service.EmployeeService;
import java.util.*;

@RequestMapping("employee")
@RestController

public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	
	
	@GetMapping
	public List<Employee> getall()
	{
		return service.getall();
	}
	
	@PostMapping("/new")
	public void newEmployee(@RequestBody Employee e)
	{
		service.newEmployee(e);
	}
	
	@PutMapping("/update/{id}")
	public void  updateEmployee(@PathVariable int id, @RequestBody Employee e)
	{
		service.updateEmployee(id, e);
		 
	}
	@DeleteMapping("/del/{id}")
	public void DelEmployee(@PathVariable int id)
	{
		service.DelEmployee(id);
	}
	
	@GetMapping("/by/c/{city}")
	public List<Employee> getByCity(@PathVariable String city)
	{
		return service.searchByCity(city);
	}
	@GetMapping("/by/s/{state}")
	public List<Employee> getByState(@PathVariable String state)
	{
		return service.searchByState(state);
	}
 
	
	
}
