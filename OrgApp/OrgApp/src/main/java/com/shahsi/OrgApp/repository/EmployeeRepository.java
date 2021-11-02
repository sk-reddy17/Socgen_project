package com.shahsi.OrgApp.repository;

import com.shahsi.OrgApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByEmployeeId(String employeeId);
}
