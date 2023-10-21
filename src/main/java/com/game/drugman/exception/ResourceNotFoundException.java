package com.game.drugman.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVesionUID = 1l;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
