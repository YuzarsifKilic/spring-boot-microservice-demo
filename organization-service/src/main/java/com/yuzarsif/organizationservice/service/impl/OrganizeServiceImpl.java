package com.yuzarsif.organizationservice.service.impl;

import com.yuzarsif.organizationservice.dto.OrganizationDto;
import com.yuzarsif.organizationservice.exception.OrganizeNotFoundException;
import com.yuzarsif.organizationservice.mapper.OrganizationMapper;
import com.yuzarsif.organizationservice.model.Organization;
import com.yuzarsif.organizationservice.repository.OrganizationRepository;
import com.yuzarsif.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrganizeServiceImpl implements OrganizationService {

    private final OrganizationRepository repository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization = repository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = repository
                .findByOrganizationCode(organizationCode)
                .orElseThrow(
                        () -> new OrganizeNotFoundException("Organization could not found by organization code : " + organizationCode) );
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
