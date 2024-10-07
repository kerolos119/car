package com.example.car.repository;

import com.example.car.document.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car,String > {
}
