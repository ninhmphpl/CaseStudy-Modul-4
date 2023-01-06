package com.example.web.service.admin;

import com.example.web.repository.admin.IAdminRepository;
import com.example.web.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminService {
    @Autowired
    IAdminRepository iAdminRepository;
    public List<Company> findAll(){
        return iAdminRepository.findAll();
    }
    public Company save(Company company) {
        return iAdminRepository.save(company);
    }
    public void delete(Long id){
        iAdminRepository.deleteById(id);
    }
    public Company findById(Long id){
        return iAdminRepository.findById(id).get();
    }
    public List<Company> findAllName(String name){
        return iAdminRepository.findAllByNameContaining(name);
    }
}
