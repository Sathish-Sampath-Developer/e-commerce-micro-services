package com.eshop.authservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // Service exception
    @ExceptionHandler(ServiceExceptionHandler.class)
    public ResponseEntity<ErrorResponse> handleAPIException(ServiceExceptionHandler exception,
                                                            WebRequest webRequest) {
        ErrorResponse errorDetails = new ErrorResponse(new Date(), exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    // global exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception exception,
                                                               WebRequest webRequest) {
        ErrorResponse errorDetails = new ErrorResponse(new Date(), exception.getMessage(),
                webRequest.getDescription(false));

        System.out.println("----->");
        return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

