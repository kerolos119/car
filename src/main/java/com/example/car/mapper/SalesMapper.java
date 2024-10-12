package com.example.car.mapper;

import com.example.car.document.Sales;
import com.example.car.dto.SalesDto;
import org.springframework.stereotype.Component;

@Component
public  class SalesMapper extends AbstractMapper<SalesDto, Sales> {
    public SalesMapper() {
        super(SalesDto.class, Sales.class);
    }

    @Override
    public Sales updaToEntity(SalesDto dto, Sales entity) {
        return entity;
    }
}
