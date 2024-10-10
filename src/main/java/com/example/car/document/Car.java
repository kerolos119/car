package com.example.car.document;

import com.example.car.dto.CarDto;
import com.example.car.model.Energy;
import com.example.car.model.Transition;
import com.example.car.model.Type;
import com.example.car.repository.CarRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    @Id
    private String id;
    private String name;
    private String quantity;
    private String model;
    private Transition transition;
    private String color;
    private Float price;
    private Energy energy;
    private Type type;
}
