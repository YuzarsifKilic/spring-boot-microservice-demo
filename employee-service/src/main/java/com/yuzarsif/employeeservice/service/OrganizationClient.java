package com.yuzarsif.employeeservice.service;

import com.yuzarsif.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8083", value = "organization-service")
public interface OrganizationClient {

    @GetMapping("v1/organization/{organizationCode}")
    ResponseEntity<OrganizationDto> getOrganization(@PathVariable String organizationCode);
}
