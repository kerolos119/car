package com.example.car.service;

import com.example.car.document.Sales;
import com.example.car.dto.PageResult;
import com.example.car.dto.SalesDto;
import com.example.car.mapper.SalesMapper;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Builder
public class SalesServices {


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
        dto.setCreatedAt(String.valueOf(LocalDateTime.now()));
//        dto.setCreatedAt();
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

    public PageResult search(LocalDate date, String carId, Pageable pageable) {
        Query query= new Query();

        if (date != null){
            LocalDateTime from = LocalDateTime.of(date, LocalTime.MIN);
            LocalDateTime to = LocalDateTime.of(date, LocalTime.MAX);
            query.addCriteria(Criteria.where("date").is("1"));}
        if (carId != null)
            query.addCriteria(Criteria.where("carId").is("1"));
//        return template.find(query,Sales.class).stream().map(sales -> {
//            return mapper.toDto(sales);
//        }).collect(Collectors.toList());
        List<SalesDto> salesDtos = template.find(query.with(pageable),Sales.class).stream().map(sales -> {
            return mapper.toDto(sales);
        }).collect(Collectors.toList());
        Long count= template.count(query,Sales.class);
        return PageResult.builder().item(salesDt).count(count).build();
    }
}
