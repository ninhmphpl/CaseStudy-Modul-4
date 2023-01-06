package com.example.web.service.admin;

import com.example.web.repository.OfferRepository;
import com.example.web.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OfferService {
    @Autowired
    OfferRepository iAdminRepository;

    public List<Offer> findAll() {

        return iAdminRepository.findAll();
    }

    public Offer save(Offer offer) {
        return iAdminRepository.save(offer);
    }

    public void delete(Long id) {
        iAdminRepository.deleteById(id);
    }

    public Offer findById(Long id) {
        return iAdminRepository.findById(id).get();
    }

    public List<Offer> findAllByCareer(String career) {
        return iAdminRepository.findAllByCareerContaining(career);
    }
    public Long count() {
        return iAdminRepository.count();
    }
}
