package com.example.web.service;

import java.util.Optional;

public interface ICrudService <T,ID>{
    Optional<T> findById(ID id);

    T save(T t);

    void delete(ID id);
}
