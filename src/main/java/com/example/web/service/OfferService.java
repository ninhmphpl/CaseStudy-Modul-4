package com.example.web.service;

import com.example.web.model.Offer;
import com.example.web.model.offer.OfferRender;
import com.example.web.repository.OfferRepository;
import com.example.web.repository.customer.CityRepository;
import com.example.web.repository.offer.CareerRepository;
import com.example.web.repository.offer.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OfferService implements ICrudService<Offer,Long>{
    @Autowired
    OfferRepository offerRepository;
    @Autowired
    CareerRepository careerRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    SkillRepository skillRepository;


    @Override
    public List<Offer> findAll() {
        List<Offer> h = offerRepository.findAll();
        return h;
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

    public OfferRender render(Long id){
        return new OfferRender(cityRepository.findAll(),
                careerRepository.findAll(), skillRepository.findAll(),
                offerRepository.findById(id).get());
    }
    public List<Offer> findAllByName(String name){
        return offerRepository.findAllByNameContaining(name);
    }
}
