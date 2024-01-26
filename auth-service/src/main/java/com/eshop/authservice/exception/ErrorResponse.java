package com.eshop.authservice.exception;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class ErrorResponse {
    private Date timestamp;
    private String message;
    private String details;
}
