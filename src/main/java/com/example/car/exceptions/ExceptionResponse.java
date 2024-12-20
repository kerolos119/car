package com.example.car.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ExceptionResponse {
    private String massege;
    private HttpStatus status;
    private Integer code;
}
