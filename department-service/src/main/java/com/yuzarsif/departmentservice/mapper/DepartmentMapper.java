package com.yuzarsif.departmentservice.mapper;

import com.yuzarsif.departmentservice.dto.DepartmentDto;
import com.yuzarsif.departmentservice.model.Department;

public class DepartmentMapper {

    public static DepartmentDto mapToDepartmentDto(Department from) {
        return new DepartmentDto(
                from.getId(),
                from.getDepartmentName(),
                from.getDepartmentDescription(),
                from.getDepartmentCode());
    }

    public static Department mapToDepartment(DepartmentDto from) {
        return new Department(
                from.getId(),
                from.getDepartmentName(),
                from.getDepartmentDescription(),
                from.getDepartmentCode());
    }
}
