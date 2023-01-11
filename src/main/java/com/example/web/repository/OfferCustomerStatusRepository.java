package com.example.web.repository;

import com.example.web.model.Offer;
import com.example.web.model.OfferCustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferCustomerStatusRepository extends JpaRepository<OfferCustomerStatus,Long> {
    List<OfferCustomerStatus> findByOffer(Offer offer);
}
