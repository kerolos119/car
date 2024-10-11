package com.example.car.controller;

import com.example.car.document.Sales;
import com.example.car.dto.SalesDto;

import com.example.car.service.SalesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

import java.util.List;

@Controller
@RequestMapping("/sale")
public class SalesController {
    @Autowired
    private SalesServices services;
    @PostMapping
    public Sales create(@RequestBody SalesDto dto){
        return services.create(dto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        services.delete(id);
    }
    @GetMapping
    public List<SalesDto> search(
            @RequestParam(required = false) LocalTime date,
            @RequestParam(required = false) String carId)
    {
        return services.search(date,carId);

    }
}
