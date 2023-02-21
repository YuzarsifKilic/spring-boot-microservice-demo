package com.yuzarsif.employeeservice.repository;

import com.yuzarsif.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
