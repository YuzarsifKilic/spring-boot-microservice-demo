package com.yuzarsif.departmentservice.controller;

import com.yuzarsif.departmentservice.dto.DepartmentDto;
import com.yuzarsif.departmentservice.service.DepartmentService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/save")
    public ResponseEntity<DepartmentDto> save(@RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.ok(departmentService.saveDepartment(departmentDto));
    }

    @GetMapping("/{departmentCode}")
    public DepartmentDto getDepartment(@PathVariable String departmentCode) {
        return departmentService.getDepartmentByCode(departmentCode);

    }
}