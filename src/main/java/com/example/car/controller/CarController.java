package com.example.car.controller;

import com.example.car.document.Car;
import com.example.car.dto.CarDto;
import com.example.car.model.Transition;
import com.example.car.model.Type;
import com.example.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
     private CarService service;
    @PostMapping
    public String create(@RequestBody Car car)
    {
        return service.create(car);
    }
    @PutMapping("{/id}")
    public void update(@PathVariable String id, @RequestBody Car car)
    {
        service.update(id, car);
    }
    @GetMapping("{/id}")
    public Car getById(@PathVariable String id)
    {
       return service.getById(id);
    }
    @GetMapping
    public List<Car> search(
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String model,
                               @RequestParam(required = false) Transition transition,
                               @RequestParam(required = false) Type type,
                               @RequestParam(required = false) Float price)
    {
        return service.search(name,model,transition,type,price);

    }
}
