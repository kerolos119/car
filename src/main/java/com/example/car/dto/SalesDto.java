package com.example.car.dto;

import com.example.car.model.Auitable;
import com.example.car.model.Transition;
import com.example.car.model.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalesDto  extends Auitable {
    private String id;
    private LocalDate date;
    private String carId;

}
