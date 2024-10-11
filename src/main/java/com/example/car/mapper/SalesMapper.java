package com.example.car.mapper;

import com.example.car.document.Sales;
import com.example.car.dto.SalesDto;

public abstract class SalesMapper extends AbstractMapper<SalesDto, Sales> {
    public SalesMapper(Class<SalesDto> salesDtoClass, Class<Sales> salesClass) {
        super(salesDtoClass, salesClass);
    }
}
