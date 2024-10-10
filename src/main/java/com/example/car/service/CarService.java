package com.example.car.service;

import com.example.car.document.Car;
import com.example.car.dto.CarDto;
import com.example.car.model.Transition;
import com.example.car.model.Type;
import com.example.car.repository.CarRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Builder
public class CarService {
    @Autowired
    private CarRepository repository;
    @Autowired
    MongoTemplate template;

    public String create(Car car) {
       return template.save(car).getId();
    }

    public void update(String id, Car car) {
        Query query =new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        template.save(car);
    }

    public Car getById(String id) {
        Query query =new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return template.findOne(query,Car.class);
    }

    public List<Car> search(String name, String model, Transition transition, Type type, Float price) {
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
       return template.find(query,Car.class);
    }
}
