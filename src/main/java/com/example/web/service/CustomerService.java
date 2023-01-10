package com.example.web.service;

import com.example.web.model.Customer;
import com.example.web.model.Offer;
import com.example.web.model.OfferCustomerStatus;
import com.example.web.model.User;
import com.example.web.model.customer.CustomerRender;
import com.example.web.repository.CustomerRepository;
import com.example.web.repository.OfferCustomerStatusRepository;
import com.example.web.repository.customer.CityRepository;
import com.example.web.repository.customer.EducationRepository;
import com.example.web.repository.customer.ExpWorkRepository;
import com.example.web.repository.customer.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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
    @Autowired
    UserService userService;
    @Autowired
    OfferService offerService;

    @Autowired
    OfferCustomerStatusRepository offerCustomerStatusRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
    public Customer saveInfoCustomer(Customer customer, User user){
        Customer customers = customerRepository.findCustomerByUser(user);

        customers.setBirth(customer.getBirth());
        customers.setCity(customer.getCity());
        customers.setEducation(customer.getEducation());
        customers.setExpWork(customer.getExpWork());
        customers.setName(customer.getName());
        customers.setPhoneNumber(customer.getPhoneNumber());
        customers.setGender(customer.getGender());
        return customerRepository.save(customers);
    }


    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public CustomerRender render(User user) {
        Customer customer = customerRepository.findCustomerByUser(user);
        return new CustomerRender(cityRepository.findAll(), educationRepository.findAll(), genderRepository.findAll(), expWorkRepository.findAll(), customer);
    }

    public ResponseEntity<?> apply(Offer offer) {
        User user = userService.getUserLogging();
        if (user == null){
            return new ResponseEntity<>(HttpStatus.valueOf(415));
        }
        Customer customer = customerRepository.findCustomerByUser(user);
        if(customer == null){
            return new ResponseEntity<>(HttpStatus.valueOf(416));
        }
        OfferCustomerStatus offerCustomerStatus= new OfferCustomerStatus(null, offer,customer,false);
        OfferCustomerStatus status = offerCustomerStatusRepository.save(offerCustomerStatus);
        return new ResponseEntity<>(status, HttpStatus.OK);

    }

}
