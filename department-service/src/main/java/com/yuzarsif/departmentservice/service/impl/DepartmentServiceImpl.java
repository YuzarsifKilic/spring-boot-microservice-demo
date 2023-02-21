package com.yuzarsif.departmentservice.service.impl;

import com.yuzarsif.departmentservice.dto.DepartmentDto;
import com.yuzarsif.departmentservice.dto.DepartmentDtoConvert;
import com.yuzarsif.departmentservice.exception.DepartmentNotFoundException;
import com.yuzarsif.departmentservice.mapper.DepartmentMapper;
import com.yuzarsif.departmentservice.model.Department;
import com.yuzarsif.departmentservice.repository.DepartmentRepository;
import com.yuzarsif.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository
                .findByDepartmentCode(code)
                .orElseThrow(
                        () ->new DepartmentNotFoundException("Department could not found by code : " + code));

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);
        return departmentDto;
    }
}
