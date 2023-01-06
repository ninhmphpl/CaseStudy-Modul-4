package com.example.web.repository.admin;

import com.example.web.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OfferRepository extends JpaRepository<Offer,Long > {
    List<Offer> findAllByCareerContaining(String career);
}
