package com.example.web.service;

import com.example.web.model.Offer;
import com.example.web.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;
@Service
public class OfferService implements ICrudService<Offer,Long>{
    @Autowired
    OfferRepository offerRepository;
    @Override

    public List<Offer> findAll() {
        return offerRepository.findAll();
    }

    @Override
    public Optional<Offer> findById(Long id) {
        return offerRepository.findById(id);
    }

    @Override
    public Offer save(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public void delete(Long id) {
        offerRepository.deleteById(id);
    }
}
