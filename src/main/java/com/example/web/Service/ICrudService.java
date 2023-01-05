package com.example.web.Service;

import com.sun.xml.bind.v2.model.core.ID;

import java.util.Optional;

public interface ICrudService <T,D>{
    Optional<T> findById(ID id);

    T save(T t);

    void delete(ID id);
}
