package com.shashi.employee.service;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shashi.employee.Repo.EmployeeRepo;
import com.shashi.employee.model.Employee;

@Service
public class ImplEmployeeService implements EmployeeService {
	
	@Autowired
	private EmployeeRepo reposi;
	
	@Override
	public Employee newEmployee(Employee e) {
		return reposi.save(e);
	}

	@Override
    public List<Employee> getEmployee(String name)
    {
		return reposi.findByNameIgnoreCase(name);
    }
	@Override
    public Employee updateEmployee(int id, Employee e)
    {
		Employee ep = reposi.findById(id).get();
		ep.setName(e.getName());
        ep.setSalary( e.getSalary());
        ep.setState(e.getState());
        ep.setCity(e.getCity());

        return reposi.save(ep);
    }
	@Override
    public ResponseEntity<String> DelEmployee(Integer id)
    {
		reposi.deleteById(id);
        return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
                .body("***********Deleted Sucessfully************"); 
    }

	@Override
    public List<Employee> getall(){
		return reposi.findAll();
	}

	@Override
	public List<Employee> searchByCity(String city) {
		List<Employee> elist =reposi.findAllByCity(city);
		elist = elist.stream().filter(s->s.getCity().equals(city)).collect(Collectors.toList());
		
		return elist;
	}

	@Override
	public List<Employee> searchByState(String state) {
		
		List<Employee> elist =reposi.findAllByState(state);
		elist = elist.stream().filter(s->s.getCity().equals(state)).collect(Collectors.toList());
		
		return elist;
	}


	

}
