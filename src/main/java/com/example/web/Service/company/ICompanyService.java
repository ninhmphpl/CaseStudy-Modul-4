package com.example.web.Service.company;

import com.example.web.Service.ICrudService;
import com.example.web.model.Company;

import java.util.List;

public interface ICompanyService extends ICrudService<Company,Long> {

    List<Company>findAll();

    Company save(Long id);
}
