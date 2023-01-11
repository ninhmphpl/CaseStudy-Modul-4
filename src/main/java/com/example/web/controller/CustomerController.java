package com.example.web.controller;

import com.example.web.model.Company;
import com.example.web.model.OfferCustomerStatus;
import com.example.web.repository.OfferCustomerStatusRepository;
import com.example.web.repository.company.CompanyRepository;
import com.example.web.service.CustomerService;
import com.example.web.model.Customer;
import com.example.web.model.User;
import com.example.web.model.customer.CustomerRender;
import com.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    UserService userService;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private OfferCustomerStatusRepository offerCustomerStatusRepository;

    @GetMapping
    public ResponseEntity<CustomerRender> findDataChoice(){
        User user = userService.getUserLogging();
        CustomerRender customerRender = customerService.render(user);
        return new ResponseEntity<>(customerRender, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> save(@RequestBody Customer customer){
        User user = userService.getUserLogging();
        customerService.saveInfoCustomer(customer, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/apply/{id}")
    public ResponseEntity<?> apply(@PathVariable Long id){
        OfferCustomerStatus offerCustomerStatus = customerService.apply(id);
        if(offerCustomerStatus == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(offerCustomerStatus, HttpStatus.OK);
    }
    @GetMapping("/list-offer")
    public ResponseEntity<?> listOffer(){
        Customer customer = customerService.findByUser(userService.getUserLogging());
        if (customer == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customer.getOfferStatus(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOffer(@PathVariable Long id){
        if(!offerCustomerStatusRepository.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        offerCustomerStatusRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
