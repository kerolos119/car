package com.example.car.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> customException(CustomException ex){
        ExceptionResponse response = new ExceptionResponse(ex.getMessage(),
                ex.getStatus(),
                ex.getStatus().value());
        return new ResponseEntity<ExceptionResponse>(response,
                ex.getStatus());
    }
}
