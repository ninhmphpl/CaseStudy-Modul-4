package com.example.web.controller.company;

import com.example.web.model.Company;
import com.example.web.service.company.CompanyService;
import com.example.web.service.company.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/companies")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping
    public List<Company> showCompany(){
        return companyService.findAll();
    }

//    @GetMapping()
//    public ResponseEntity<Company> showUpdate(@PathVariable Long id){
//        return new ResponseEntity<>(companyService.findById(id).get(), HttpStatus.OK);
//    }

    @PutMapping
    public ResponseEntity<Company>update(@RequestBody Company company){
        Company company1= companyService.findCompanyByEmail("dhghd@gmail");
        company.setId(company1.getId());
        return new ResponseEntity<>(companyService.save(company),HttpStatus.OK);
    }
}
