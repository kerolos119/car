package com.example.car.repository;

import com.example.car.document.Sales;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalesReposatory extends MongoRepository<Sales, String> {
}
