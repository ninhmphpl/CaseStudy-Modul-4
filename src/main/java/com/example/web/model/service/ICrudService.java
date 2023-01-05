package com.example.web.model.service;

import java.util.List;

public interface ICrudService <E,ID>{
    List<E>findAll();
    E findById (ID id);



}
