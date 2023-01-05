package com.example.web.Service.company;

import com.example.web.model.Company;
import com.example.web.repository.ICompanyRepository;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CompanyService implements ICompanyService {

@Autowired
    ICompanyRepository companyRepository;
    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }
    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }





    @Override
    public Company save(Long id) {
        return null;
    }

    @Override
    public Optional<Company> findById(Long id) {
        return Optional.empty();
    }



    @Override
    public void delete(Long id) {

    }
}
