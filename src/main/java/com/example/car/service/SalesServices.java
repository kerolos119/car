package com.example.car.service;

import com.example.car.document.Car;
import com.example.car.document.Sales;
import com.example.car.dto.SalesDto;
import com.example.car.repository.SalesReposatory;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Builder
public class SalesServices {
    @Autowired
    private SalesReposatory reposatory;
    public Car create(SalesDto dto) {
        return reposatory.save(new Sales(dto));
    }

    public void delete(String id) {
        reposatory.delete(id);
    }

    public List<SalesDto> getBySearch(Date date) {

    }

    public List<SalesDto> search(Date date) {
        return List<Sales> reposatory.findOne( Date date);
    }
}
