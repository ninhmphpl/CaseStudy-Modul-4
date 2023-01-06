package com.example.web.Service;

import com.sun.xml.bind.v2.model.core.ID;

import java.util.List;
import java.util.Optional;

public interface ICrudService <T,Long>{
    List<T> findAll();
    Optional<T> findById(Long id);

    T save(T t);

    void delete(Long id);
}
