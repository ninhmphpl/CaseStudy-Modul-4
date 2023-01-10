package com.example.web.controller;

import com.example.web.model.Company;
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

}
