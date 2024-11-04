package com.example.car.document;

import com.example.car.dto.SalesDto;
import com.example.car.model.Auitable;
import com.example.car.model.Transition;
import com.example.car.model.Type;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sales extends Auitable {
    @Id
    @NotEmpty
    private String id;
    @NotEmpty
    private LocalDateTime date;
    @NotEmpty
    private String carId;
}
