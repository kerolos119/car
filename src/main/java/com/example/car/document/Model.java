package com.example.car.document;

import com.example.car.model.Auitable;
import com.example.car.model.Energy;
import com.example.car.model.Transition;
import com.example.car.model.Type;
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
public class Model extends Auitable {
    @Id
    @NotEmpty
    private String id;
    @NotEmpty
    private String name;
    @NotEmpty
    private Type type;
    @NotEmpty
    private Energy energy;
    @NotEmpty
    private Transition transition;
}
