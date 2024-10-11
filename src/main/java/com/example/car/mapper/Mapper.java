package com.example.car.mapper;

public interface Mapper <T, E>{
    public T toDto (E entity);

    T dto(E entity);

    public E toEntity(T dto);
    public E updaToEntity (T dto , E entity);
}
