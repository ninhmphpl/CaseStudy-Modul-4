package com.example.web.service;

import com.example.web.model.Customer;
import com.example.web.model.Offer;
import com.example.web.model.OfferCustomerStatus;
import com.example.web.model.User;
import com.example.web.model.customer.CustomerRender;
import com.example.web.repository.CustomerRepository;
import com.example.web.repository.OfferCustomerStatusRepository;
import com.example.web.repository.OfferRepository;
import com.example.web.repository.customer.CityRepository;
import com.example.web.repository.customer.EducationRepository;
import com.example.web.repository.customer.ExpWorkRepository;
import com.example.web.repository.customer.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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
    UserService userService;
    @Autowired
    OfferService offerService;

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

    public CustomerRender render(User user) {
        Customer customer = customerRepository.findCustomerByUser(user);
        return new CustomerRender(cityRepository.findAll(), educationRepository.findAll(), genderRepository.findAll(), expWorkRepository.findAll(), customer);
    }

    public ResponseEntity<?> apply(Offer offer) {
        //420: Offer không tôn tại trong database
        if(!offerRepository.existsById(offer.getId())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = userService.getUserLogging();
        if (user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Customer customer = customerRepository.findCustomerByUser(user);
        if(customer == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<OfferCustomerStatus> list =customer.getOfferStatus();
        for(OfferCustomerStatus status : list){
            Offer offerExist = status.getOffer();
            if (Objects.equals(offer.getId(), offerExist.getId())){
                return new ResponseEntity<>(HttpStatus.IM_USED);
            }
        }
        OfferCustomerStatus offerCustomerStatus= new OfferCustomerStatus(null, offer,customer,false);
        OfferCustomerStatus status = offerCustomerStatusRepository.save(offerCustomerStatus);
        return new ResponseEntity<>(status, HttpStatus.OK);

    }

}
