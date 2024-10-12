package com.example.car.service;

import com.example.car.document.Car;
import com.example.car.document.Sales;
import com.example.car.dto.SalesDto;
import com.example.car.mapper.SalesMapper;
import com.example.car.repository.SalesReposatory;
import lombok.Builder;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.*;

@Service
@Builder
public class SalesServices {
    @Autowired
    private SalesReposatory reposatory;

    @Autowired
    CarService service;

    @Autowired
    MongoTemplate template;

    @Autowired
    SalesMapper mapper;

    public String create(SalesDto dto) {
        Query query =new Query();
        query.addCriteria(Criteria.where("_id").is(dto.getId()));
        if (template.exists(query,Sales.class))
            throw new RuntimeException("car is order exist");
       return template.save(mapper.toEntity(dto)).getId();
    }

    public void delete(String id) {
        Query query =new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        template.remove(query,Sales.class);
    }

//    public List<SalesDto> getBySearch(LocalDate date) {
//        LocalDateTime from = LocalDateTime.of(date, LocalTime.MIN);
//        LocalDateTime to = LocalDateTime.of(date, LocalTime.MAX);
//    }

    public List<SalesDto> search(LocalDate date,String carId) {
        Query query= new Query();

        if (date != null){
            LocalDateTime from = LocalDateTime.of(date, LocalTime.MIN);
            LocalDateTime to = LocalDateTime.of(date, LocalTime.MAX);
            query.addCriteria(Criteria.where("date").is("1"));}
        if (carId != null)
            query.addCriteria(Criteria.where("carId").is("1"));
        return template.find(query,Sales.class).stream().map(sales -> {
            return mapper.toDto(sales);
        }).collect(Collectors.toList());
    }
}
