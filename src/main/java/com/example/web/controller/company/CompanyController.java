package com.example.web.controller.company;

import com.example.web.model.Company;
import com.example.web.model.OfferCustomerStatus;
import com.example.web.service.CompanyService;
import com.example.web.service.UserService;
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

    @Autowired
    UserService userService;
    @GetMapping
    public ResponseEntity<Company> findDataCompany() {
        Company company = companyService.findByUser(userService.getUserLogging());
        company.setId(company.getId());
        return new ResponseEntity<>(companyService.save(company), HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Company> update(@RequestBody Company company) {
        Company company2 = companyService.addCompany(company);
        return new ResponseEntity<>(company2, HttpStatus.OK);
    }
    @GetMapping("/company-apply")
    public ResponseEntity<?>companyApplyOffer(){
        return new ResponseEntity<>(companyService.showOfferCompany(), HttpStatus.OK);
    }
    @GetMapping("/offer/{id}")
    public ResponseEntity<?> getOfferByCompany(@PathVariable Long id){
        return new ResponseEntity<>(companyService.showCustomerByOffer(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/{status}")
    public ResponseEntity<?> changeStatus(@PathVariable Long id,@PathVariable Long status){
        OfferCustomerStatus offerCustomerStatus = companyService.saveStatusOffer(id, status);
        if (offerCustomerStatus != null){
            return new ResponseEntity<>(offerCustomerStatus, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
