package com.yuzarsif.employeeservice.service.ımpl;

import com.yuzarsif.employeeservice.dto.APIResponseDto;
import com.yuzarsif.employeeservice.dto.DepartmentDto;
import com.yuzarsif.employeeservice.dto.EmployeeDto;
import com.yuzarsif.employeeservice.dto.OrganizationDto;
import com.yuzarsif.employeeservice.exception.EmployeeNotFoundException;
import com.yuzarsif.employeeservice.mapper.EmployeeMapper;
import com.yuzarsif.employeeservice.model.Employee;
import com.yuzarsif.employeeservice.repository.EmployeeRepository;
import com.yuzarsif.employeeservice.service.APIClient;
import com.yuzarsif.employeeservice.service.EmployeeService;
import com.yuzarsif.employeeservice.service.OrganizationClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final APIClient apiClient;
    private final OrganizationClient organizationClient;

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee = repository.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    public APIResponseDto getEmployeeById(Long id) {
        Employee employee = repository
                .findById(id)
                .orElseThrow(
                        () -> new EmployeeNotFoundException("Employee could not found by id : " + id));

        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        OrganizationDto organizationDto = organizationClient.getOrganization(employee.getOrganizationCode()).getBody();

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto(employeeDto, departmentDto, organizationDto);

        return apiResponseDto;
    }
}
