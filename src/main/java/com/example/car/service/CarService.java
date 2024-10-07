package com.example.car.service;

import com.example.car.document.Car;
import com.example.car.dto.CarDto;
import com.example.car.model.Transition;
import com.example.car.model.Type;
import com.example.car.repository.CarRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Builder
public class CarService {
    @Autowired
    private CarRepository repository;
    public Car create(CarDto dto) {
        return repository.save(new Car());
    }

    public void update(String id, CarDto dto) {
        Car oldcar= new Car(getById(id));
        oldcar.setName(dto.getName());
        oldcar.setColor(dto.getColor());
        oldcar.setPrice(dto.getPrice());
        oldcar.setModel(dto.getModel());
        oldcar.setQuantity(dto.getQuantity());

    }
    public CarDto getById(String id) {
        Optional<Car> entity= repository.findById(id);
        return CarDto.builder().build();
    }

    public List<CarDto> search(String name, String model, Transition transition, Type type, Float price) {
        return List<CarDto> repository.findBy(name,model,transition,price);
    }
}
