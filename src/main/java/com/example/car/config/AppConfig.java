package com.example.car.config;

import lombok.Builder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Builder
    public ModelMapper modelMapper(ModelMapper modelMapper){
        return modelMapper;
    }
}
