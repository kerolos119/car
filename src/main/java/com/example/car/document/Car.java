package com.example.car.document;

import com.example.car.dto.CarDto;
import com.example.car.model.Energy;
import com.example.car.model.Transition;
import com.example.car.model.Type;
import com.example.car.repository.CarRepository;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty
    private String id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String quantity;
    @NotEmpty
    private String model;
    @NotEmpty
    private Transition transition;
    @NotEmpty
    private String color;
    @NotEmpty
    private Float price;
    @NotEmpty
    private Energy energy;
    @NotEmpty
    private Type type;
}
