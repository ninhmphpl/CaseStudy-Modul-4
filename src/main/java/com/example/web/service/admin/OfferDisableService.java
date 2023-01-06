package com.example.web.service.admin;

import com.example.web.repository.admin.UserRepository;
import com.example.web.model.Offer;
import com.example.web.model.User;
import com.example.web.model.admin.Status;
import com.example.web.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OfferDisableService implements ICrudService<Offer , Long> {
    @Autowired
    UserRepository userRepository;
    public void activeBlockOffer(Long id, Status status) {

        User user = userRepository.findById(id).get();
        user.setStatus(status);
    }

    @Override
    public Optional<Offer> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Offer save(Offer offer) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
