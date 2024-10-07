package com.example.car.dto;

import com.example.car.model.Transition;
import com.example.car.model.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {
    private String id;
    private String Name;
    private String quantity;
    private String model;
    private Transition transition;
    private String color;
    private Float price;
    private Type type;
}

