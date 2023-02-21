package com.yuzarsif.employeeservice.service;

import com.yuzarsif.employeeservice.dto.APIResponseDto;
import com.yuzarsif.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long id);
}
