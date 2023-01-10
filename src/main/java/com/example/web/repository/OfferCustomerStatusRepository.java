package com.example.web.repository;

import com.example.web.model.OfferCustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferCustomerStatusRepository extends JpaRepository<OfferCustomerStatus, Long> {

}
