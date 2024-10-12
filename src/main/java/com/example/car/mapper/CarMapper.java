package com.example.car.mapper;

import com.example.car.document.Car;
import com.example.car.dto.CarDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public  class CarMapper extends AbstractMapper<CarDto, Car> {
    public CarMapper() {
        super(CarDto.class, Car.class);
    }


    @Override
    public Car updaToEntity(@NotNull CarDto dto, Car entity) {
        if (dto.getColor() !=null && dto.getColor().isEmpty())
            entity.setColor(dto.getColor());
        if (dto.getModel() != null && dto.getModel().isEmpty())
            entity.setModel(dto.getModel());
        if (dto.getPrice() != null && dto.getPrice().equals(dto))
            entity.setPrice(dto.getPrice());
        if (dto.getQuantity() != null && dto.getQuantity().isEmpty())
            entity.setQuantity(dto.getQuantity());
        return entity;
    }
}
