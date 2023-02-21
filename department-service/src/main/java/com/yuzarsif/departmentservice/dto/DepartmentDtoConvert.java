package com.yuzarsif.departmentservice.dto;

import com.yuzarsif.departmentservice.model.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentDtoConvert {

    public DepartmentDto convert(Department from) {
        return new DepartmentDto(
                from.getId(),
                from.getDepartmentName(),
                from.getDepartmentDescription(),
                from.getDepartmentCode());
    }
}
