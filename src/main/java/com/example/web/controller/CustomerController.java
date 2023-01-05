package com.example.web.controller;

import com.example.web.Service.CustomerService;
import com.example.web.model.Customer;
import com.example.web.model.customer.DataChoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    CustomerService service;
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Customer customer = service.findById(id).get();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @GetMapping("/data")
    public ResponseEntity<DataChoice> findDataChoice(){
        DataChoice dataChoice = service.findDataChoice(1L);
        return new ResponseEntity<>(dataChoice, HttpStatus.OK);
    }
}
