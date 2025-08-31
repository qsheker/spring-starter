package com.example.demo.repository.mappers;

public interface Mapper<F,T> {
    T mapTo(F clazz);
}
