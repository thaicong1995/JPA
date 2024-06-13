package com.example.SpingJPATest.Common;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface GenericRepository<T, ID> {
    T findById(ID id);
    List<T> findAll();
    void save(T entity);
    void update(T entity);
    void deleteById(ID id);
}