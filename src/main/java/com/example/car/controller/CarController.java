package com.example.car.controller;

import com.example.car.document.Car;
import com.example.car.dto.CarDto;
import com.example.car.dto.PageResult;
import com.example.car.model.Transition;
import com.example.car.model.Type;
import com.example.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.domain.Sort.*;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
     private CarService service;
    @PostMapping
    public String create(@RequestBody CarDto dto)
    {
        return service.create(dto);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody CarDto dto)
    {
        service.update(id, dto);
    }
    @GetMapping("/{id}")
    public CarDto getById(@PathVariable String id)
    {
        return service.getById(id);

    }

    @GetMapping("/search")
    public PageResult search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Transition transition,
            @RequestParam(required = false) Type type,
            @RequestParam(required = false) Float price,
            @RequestHeader(required = false,defaultValue = "0") Integer page ,
            @RequestHeader(required = false,defaultValue = "10") Integer size
    )
    {
        Pageable pageable= PageRequest.of(page,size, Sort.by(Sort.Direction.DESC,"name"));

        return service.search(name,model,transition,type,price,pageable);

    }
}
