package com.yuzarsif.employeeservice.mapper;

import com.yuzarsif.employeeservice.dto.EmployeeDto;
import com.yuzarsif.employeeservice.model.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee from) {
        return new EmployeeDto(
                from.getId(),
                from.getFirstName(),
                from.getLastName(),
                from.getEmail(),
                from.getDepartmentCode(),
                from.getOrganizationCode());
    }

    public static Employee mapToEmployee(EmployeeDto from) {
        return new Employee(
                from.getId(),
                from.getFirstName(),
                from.getLastName(),
                from.getEmail(),
                from.getDepartmentCode(),
                from.getOrganizationCode());
    }
}
