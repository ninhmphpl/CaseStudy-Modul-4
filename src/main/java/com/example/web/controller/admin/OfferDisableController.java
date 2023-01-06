package com.example.web.controller.admin;

import com.example.web.model.Offer;
import com.example.web.model.admin.Status;
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
    @PutMapping("/id={id}&status={status}")
    public ResponseEntity<Offer> activeBlockOffer(@PathVariable Long id, @PathVariable Status status) {
        Optional<Offer> offerOptional = offerDisableService.findById(id);
        if (!offerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        offerDisableService.activeBlockOffer(id, status);
        return new ResponseEntity<>(offerDisableService.save(offerOptional.get()), HttpStatus.OK);
    }
}
