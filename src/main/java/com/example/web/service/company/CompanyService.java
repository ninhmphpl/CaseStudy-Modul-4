package com.example.web.service.company;

import com.example.web.model.Company;
import com.example.web.repository.company.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements ICompanyService{
   @Autowired
    ICompanyRepository companyRepository;
    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company save(Long id) {
        return null;
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
    public void delete(Long aLong) {

    }
}
