package com.example.car.exceptions;

import jakarta.validation.valueextraction.ValueExtractor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends RuntimeException{
    private String massege;
    private HttpStatus status;
    private Integer code;



}
