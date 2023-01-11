package com.example.web.service;

import com.example.web.model.Customer;
import com.example.web.model.Offer;
import com.example.web.model.OfferCustomerStatus;
import com.example.web.model.User;
import com.example.web.model.admin.Status;
import com.example.web.model.customer.CustomerRender;
import com.example.web.repository.CustomerRepository;
import com.example.web.repository.OfferCustomerStatusRepository;
import com.example.web.repository.OfferRepository;
import com.example.web.repository.customer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
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
    private UserService userService;
    @Autowired
    OfferCustomerStatusRepository offerCustomerStatusRepository;
    @Autowired
    private OfferRepository offerRepository;

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


    public CustomerRender render(User user){
        Customer customer = customerRepository.findCustomerByUser(user);
        return new CustomerRender(cityRepository.findAll(), educationRepository.findAll(), genderRepository.findAll(), expWorkRepository.findAll() ,customer);
    }

    public OfferCustomerStatus apply(Long id){
        if(!offerRepository.existsById(id)){
            System.out.println("offer not exist");
            return null;
        }
        Offer offer = new Offer();
        offer.setId(id);
        Customer customer = customerRepository.findCustomerByUser(userService.getUserLogging());
        if(customer == null){
            System.out.println("customer null");
            return null;
        }
        List<OfferCustomerStatus> listOffer = customer.getOfferStatus();
        for(OfferCustomerStatus oStatus: listOffer){
            if (oStatus.getOffer().getId().equals(id)){
                System.out.println("offer has aplyed");
                return null;
            }
        }
        return offerCustomerStatusRepository.save(new OfferCustomerStatus(null, offer,customer,new Status(3L, null)));
    }



}
