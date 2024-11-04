package com.example.car.controller;

import com.example.car.document.Sales;
import com.example.car.dto.PageResult;
import com.example.car.dto.SalesDto;

import com.example.car.service.SalesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

import java.util.List;

@Controller
@RequestMapping("/sale")
public class SalesController {
    @Autowired
    private SalesServices services;
    @PostMapping
    public String create(@RequestBody SalesDto dto){
        return services.create(dto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        services.delete(id);
    }
    @GetMapping
    public PageResult search(
            @RequestParam(required = false) LocalDate date,
            @RequestParam(required = false) String carId,
            @RequestHeader(required = false,defaultValue = "0") Integer page ,
            @RequestHeader(required = false,defaultValue = "10") Integer size
            ){
        Pageable pageable= PageRequest.of(page,size, Sort.by(Sort.Direction.DESC,"name"));
        return services.search(date,carId,pageable);

    }
}
