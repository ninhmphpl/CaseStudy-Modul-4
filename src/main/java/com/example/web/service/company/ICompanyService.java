package com.example.web.service.company;

import com.example.web.model.Company;
import com.example.web.service.ICrudService;

import java.util.List;
import java.util.Optional;

public interface ICompanyService extends ICrudService<Company, Long> {
    List<Company> findAll();

    Company save(Long id);

    Optional<Company> findById(Long id);
}
