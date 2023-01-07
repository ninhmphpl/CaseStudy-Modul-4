package com.example.web.controller;

import com.example.web.model.Offer;
import com.example.web.repository.OfferRepository;
import com.example.web.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/search")
    public ResponseEntity<List<Offer>> findSearch(@RequestParam("search") String search){
        return new ResponseEntity<>(offerService.findAllByName(search) , HttpStatus.OK);
    }

}

