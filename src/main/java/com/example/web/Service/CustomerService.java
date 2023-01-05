package com.example.web.Service;

import com.example.web.model.Customer;
import com.example.web.model.customer.DataChoice;
import com.example.web.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerService implements ICrudService<Customer, Long> {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EducationRepository educationRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    GenderRepository genderRepository;
    @Autowired
    ExpWorkRepository expWorkRepository;

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
    }

    public DataChoice findDataChoice(Long id){
        return new DataChoice(cityRepository.findAll(), educationRepository.findAll(), genderRepository.findAll(), expWorkRepository.findAll() ,customerRepository.findById(id).get());
    }


}
