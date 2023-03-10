package com.example.web.controller;

import com.example.web.model.Company;
import com.example.web.model.Offer;
import com.example.web.model.User;
import com.example.web.model.admin.Status;
import com.example.web.model.offer.OfferRender;
import com.example.web.repository.OfferRepository;
import com.example.web.repository.customer.CityRepository;
import com.example.web.repository.offer.CareerRepository;
import com.example.web.repository.offer.SkillRepository;
import com.example.web.service.CompanyService;
import com.example.web.service.OfferService;
import com.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@CrossOrigin("*")
@RequestMapping("/crud-offer")

public class CrudOfferCompany {
    @Autowired
    OfferService offerServices;
    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;


    @GetMapping("/offer-name")
    public ResponseEntity<?> getData() {
        OfferRender offerRenders = offerServices.render(null);
        return new ResponseEntity<>(offerRenders, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Offer offer) {
        User user = userService.getUserLogging();
        Company company = companyService.findByUser(user);
        offer.setCompany(company);
        offer.setStatus(new Status(3L,null));
        offer.setEndDate(LocalDate.now().plusDays(5));
        offerServices.save(offer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> renderUpdate(@PathVariable Long id){
        Offer offer = offerServices.findById(id).get();
        OfferRender offerRender = offerServices.render(offer);
        return new ResponseEntity<>(offerRender, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?>update(@RequestBody Offer offer){
        User user = userService.getUserLogging();
        Company company = companyService.findByUser(user);
        offer.setCompany(company);
        offerServices.save(offer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


