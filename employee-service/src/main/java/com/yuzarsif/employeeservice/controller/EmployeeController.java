package com.yuzarsif.employeeservice.controller;

import com.yuzarsif.employeeservice.dto.APIResponseDto;
import com.yuzarsif.employeeservice.dto.EmployeeDto;
import com.yuzarsif.employeeservice.service.ımpl.EmployeeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    private final EmployeeServiceImpl service;

    public EmployeeController(EmployeeServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(service.createEmployee(employeeDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEmployeeById(id));
    }
}
