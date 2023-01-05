package com.example.web.controller.ControllerCompany;

import com.example.web.Service.company.ICompanyService;
import com.example.web.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    @Autowired
    ICompanyService companyService;

    @GetMapping
    public List<Company> showCompany(){
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> showUpdate(@PathVariable Long id){
        return new ResponseEntity<>(companyService.findById(id).get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company>update(@RequestBody Company company){
        return new ResponseEntity<>(companyService.save(company),HttpStatus.OK);
    }
}
