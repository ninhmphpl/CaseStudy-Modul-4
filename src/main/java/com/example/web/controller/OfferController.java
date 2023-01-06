package com.example.web.controller;
import com.example.web.model.Offer;
import com.example.web.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin("*")
@RequestMapping("/offer")
public class OfferController {
    @Autowired
    OfferService offerService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Offer> offers = offerService.findAll();
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        Optional<Offer> offer = offerService.findById(id);
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Offer offer) {
        return new ResponseEntity<>(offerService.save(offer), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Offer offer) {
        offer.setId(id);
        return new ResponseEntity<>(offerService.save(offer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        offerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
