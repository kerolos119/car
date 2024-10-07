package com.example.car.document;

import com.example.car.model.Transition;
import com.example.car.model.Type;
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
    private String Name;
    private String quantity;
    private String model;
    private Transition transition;
    private String color;
    private Float price;
    private Type type;
}
