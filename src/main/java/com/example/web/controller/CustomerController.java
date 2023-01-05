package com.example.web.controller;

import com.example.web.Service.CustomerService;
import com.example.web.model.Customer;
<<<<<<< HEAD
import com.example.web.model.User;
import com.example.web.model.customer.CustomerRender;
import com.example.web.repository.customer.UserRepository;
=======
import com.example.web.model.customer.DataChoice;
>>>>>>> origin/ninh
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
    UserRepository userRepository;
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Customer customer = customerService.findById(id).get();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @GetMapping("/data")
    public ResponseEntity<CustomerRender> findDataChoice(){
        User user = userRepository.findUsersByEmail("ninhmp@gmail.com");
        CustomerRender customerRender = customerService.render(user);
        return new ResponseEntity<>(customerRender, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> save(@RequestBody Customer customer){
        User user = userRepository.findUsersByEmail("ninhmp@gmail.com");
        customerService.saveInfoCustomer(customer, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
