package com.eshop.authservice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ServiceExceptionHandler extends RuntimeException {

    private HttpStatus status;
    private String message;

    public ServiceExceptionHandler(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ServiceExceptionHandler(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }
}
