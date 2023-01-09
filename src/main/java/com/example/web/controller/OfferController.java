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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/admOffer")
public class OfferController {
    @Autowired
    OfferService offerService;
    @Autowired
    private
    OfferRepository offerRepository;

    @GetMapping
    public ResponseEntity<List<Offer>> findAll(){
       return new ResponseEntity<>(offerService.findAll() , HttpStatus.OK);
    }
    @Autowired
    OfferRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Offer> findById(@PathVariable Long id){
        return new ResponseEntity<>(offerService.findById(id).get(),HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Offer>> findSearch(@RequestParam("search") String search){
        return new ResponseEntity<>(offerService.findAllByName(search) , HttpStatus.OK);
    }
    @GetMapping("/searchCity")
    public ResponseEntity<List<Offer>> findSearchCity(@RequestParam("searchCity") String searchCity){
        return new ResponseEntity<>(offerService.findAllByCityName(searchCity) , HttpStatus.OK);
    }
}


