package com.yuzarsif.employeeservice.service;

import com.yuzarsif.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:51945", value = "department-service")
public interface APIClient {

    @GetMapping("v1/department/{departmentCode}")
    DepartmentDto getDepartment(@PathVariable String departmentCode);
}
