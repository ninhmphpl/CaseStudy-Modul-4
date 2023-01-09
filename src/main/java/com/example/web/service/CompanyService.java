package com.example.web.service;

import com.example.web.model.Company;
import com.example.web.model.User;
import com.example.web.repository.company.CompanyRepository;
import com.example.web.repository.UserRepository;
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

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

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
    public Company findCompanyByEmail(String email){
        User user= userRepository.findUsersByEmail(email);
        return companyRepository.findByUser(user);
    }
    public Company findByUser(User user){
        return  companyRepository.findByUser(user);
    }
    public Company addCompany(Company company){
        Company company1 = findByUser(userService.getUserLogging());
        company1.setName(company.getName());
        company1.setCareer(company.getCareer());
        company1.setDescription(company.getDescription());
        company1.setAddress(company.getAddress());
        company1.setPhoneNumber(company.getPhoneNumber());
        return companyRepository.save(company1);
    }


}
