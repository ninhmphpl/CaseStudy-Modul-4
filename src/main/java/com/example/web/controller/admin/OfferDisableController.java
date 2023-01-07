package com.example.web.controller.admin;

import com.example.web.model.Offer;
import com.example.web.model.User;
import com.example.web.model.admin.Status;
import com.example.web.repository.OfferRepository;
import com.example.web.service.admin.OfferDisableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("offerDisable")
@CrossOrigin("*")
public class OfferDisableController {
    @Autowired
    OfferDisableService offerDisableService;
    @Autowired
    OfferRepository offerRepository;
    @PutMapping("/{id}/{status}")
    public ResponseEntity<?> activeBlockUser(@PathVariable Long id, @PathVariable Long status) {
        Offer offer = offerRepository.findById(id).get();
        offer.setStatus(new Status(status , null));
        offerRepository.save(offer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
