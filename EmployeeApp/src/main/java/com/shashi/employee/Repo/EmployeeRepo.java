package com.shashi.employee.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.shashi.employee.model.Employee;



public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	List<Employee> findByNameIgnoreCase(String name);

}
