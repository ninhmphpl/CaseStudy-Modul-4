package com.example.web.controller;

import com.example.web.model.Offer;
import com.example.web.model.Skill;
import com.example.web.model.customer.City;
import com.example.web.repository.OfferRepository;
import com.example.web.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/admOffer")
public class OfferController {
    @Autowired
    OfferService offerService;
    @GetMapping
    public ResponseEntity<List<Offer>> findAll(){
       return new ResponseEntity<>(offerService.findAll() , HttpStatus.OK);
    }
    @Autowired
    OfferRepository repository;
    @PostMapping
    public ResponseEntity<?>abc(){
        List<Offer> offers = repository.findAllBySkillContaining(new Skill(1L, null));
        System.out.println(offers);
        return new ResponseEntity<>("abc", HttpStatus.OK);
    }
}

