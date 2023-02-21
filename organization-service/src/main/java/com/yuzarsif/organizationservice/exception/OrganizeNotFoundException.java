package com.yuzarsif.organizationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrganizeNotFoundException extends RuntimeException {

    public OrganizeNotFoundException(String message) {
        super(message);
    }
}
