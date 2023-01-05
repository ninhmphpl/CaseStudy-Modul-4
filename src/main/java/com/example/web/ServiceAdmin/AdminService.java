package com.example.web.ServiceAdmin;

import com.example.web.RepositoryAdmin.IAdminRepository;
import com.example.web.model.Company;
import com.example.web.model.User;
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
