package com.example.web.service;

import com.example.web.model.Company;
import com.example.web.model.User;
import com.example.web.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class CompanyService implements ICrudService<Company,Long> {
    @Autowired
    CompanyRepository companyRepository;
    @Override
    public List<Company> findAll() {
        List<Company> h=companyRepository.findAll();
        return h;
    }
    public Company findByUser(User user){
        return companyRepository.findByUser(user);
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void delete(Long id) {
        companyRepository.deleteById(id);

    }
}
