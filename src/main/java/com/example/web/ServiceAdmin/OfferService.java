package com.example.web.ServiceAdmin;

import com.example.web.RepositoryAdmin.OfferRepository;
import com.example.web.Service.ICrudService;
import com.example.web.model.Offer;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OfferService implements ICrudService<Offer,Long> {
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
