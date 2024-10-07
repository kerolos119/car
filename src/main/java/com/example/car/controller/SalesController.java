package com.example.car.controller;

import com.example.car.document.Car;
import com.example.car.document.Sales;
import com.example.car.dto.CarDto;
import com.example.car.dto.SalesDto;
import com.example.car.model.Transition;
import com.example.car.model.Type;
import com.example.car.service.SalesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/sale")
public class SalesController {
    @Autowired
    private SalesServices services;
    @PostMapping
    public Car create(@RequestBody SalesDto dto){
        return services.create(dto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        services.delete(id);
    }
    @GetMapping("{/id}")
    public List<SalesDto> search(@RequestParam(required = false) Date date)
    {
        return services.search(date);

    }
}
