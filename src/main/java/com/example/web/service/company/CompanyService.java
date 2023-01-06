package com.example.web.service.company;

import com.example.web.model.Company;
import com.example.web.model.User;
import com.example.web.repository.company.ICompanyRepository;
import com.example.web.repository.customer.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements ICompanyService{
   @Autowired
    ICompanyRepository companyRepository;
   @Autowired
    UserRepository userRepository;
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
    public Company findCompanyByEmail(String email){
        User user= userRepository.findUsersByEmail(email);
        return companyRepository.findByUser(user);
    }
}
