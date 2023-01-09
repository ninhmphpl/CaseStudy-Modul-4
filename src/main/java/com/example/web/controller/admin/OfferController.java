package com.example.web.controller.admin;

import com.example.web.model.Offer;
import com.example.web.service.admin.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/admOffer")
public class OfferController {
    @Autowired
    OfferService adminService;
    @GetMapping
    public ResponseEntity<List<Offer>> findAll(){
       return new ResponseEntity<>(adminService.findAll() , HttpStatus.OK);
    }

}

