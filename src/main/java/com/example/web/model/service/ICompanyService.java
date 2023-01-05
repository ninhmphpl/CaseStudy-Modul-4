package com.example.web.model.service;

import com.example.web.model.Company;

import java.util.List;

public interface ICompanyService extends ICrudService<Company,Long> {
    public List<Company>findAll();
    public Company save(Company company);
}
