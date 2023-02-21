package com.yuzarsif.organizationservice.mapper;

import com.yuzarsif.organizationservice.dto.OrganizationDto;
import com.yuzarsif.organizationservice.model.Organization;

public class OrganizationMapper {

    public static OrganizationDto mapToOrganizationDto(Organization from) {
        return new OrganizationDto(
                from.getId(),
                from.getOrganizationName(),
                from.getOrganizationDescription(),
                from.getOrganizationCode(),
                from.getCreatedDate());
    }

    public static Organization mapToOrganization(OrganizationDto from) {
        return new Organization(
                from.getId(),
                from.getOrganizationName(),
                from.getOrganizationDescription(),
                from.getOrganizationCode(),
                from.getCreatedDate());
    }
}
