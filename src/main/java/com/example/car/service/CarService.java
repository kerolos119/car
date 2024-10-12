package com.example.car.service;

import com.example.car.document.Car;
import com.example.car.dto.CarDto;
import com.example.car.mapper.CarMapper;
import com.example.car.model.Transition;
import com.example.car.model.Type;
import com.example.car.repository.CarRepository;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class CarService {
    @Autowired
    private CarRepository repository;
    @Autowired
    MongoTemplate template;
    @Autowired
    CarMapper mapper;

    public  String create(CarDto dto) {
        Query query =new Query();
        query.addCriteria(Criteria.where("name").is(dto.getName()));
        if (template.exists(query,Car.class))
            throw new RuntimeException("car is already exist");
       return template.save(mapper.toEntity(dto)).getId();
    }

    public void update(String id, CarDto dto) {
        Query query =new Query();
        query.addCriteria(Criteria.where("name").is(dto.getName()));
        query.addCriteria(Criteria.where("_id").is(id));
        if (template.exists(query,Car.class))
            throw new RuntimeException("car is already exist");
        query=new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Car car = template.findOne(query,Car.class);

        template.save(mapper.updaToEntity(dto,car));
    }

    public CarDto getById(String id) {
        Query query =new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mapper.toDto(template.findOne(query,Car.class)) ;
    }

    public List<CarDto> search(String name, String model, Transition transition, Type type, Float price) {
        Query query = new Query();
        if (name != null)
            query.addCriteria(Criteria.where("name").regex("1"));
        if (model != null)
            query.addCriteria(Criteria.where("model").regex("1"));
        if (transition != null)
            query.addCriteria(Criteria.where("transition").is("1"));
       if (type != null)
           query.addCriteria(Criteria.where("type").is("1"));
        if (price != null)
            query.addCriteria(Criteria.where("price").in("1"));
       return template.find(query,Car.class).stream().map(car -> {
           return mapper.toDto(car);
       }).collect(Collectors.toList());
    }
}
