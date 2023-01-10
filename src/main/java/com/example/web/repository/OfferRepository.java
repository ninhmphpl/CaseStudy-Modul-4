package com.example.web.repository;

import com.example.web.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OfferRepository extends JpaRepository<Offer,Long > {
    List<Offer> findAllByCareerContaining(String career);
    List<Offer> findAllByNameContaining (String name);
    @Query(value = "select offers.* from offers join companies on (offers.company_id = companies.id) and (companies.name like :name)", nativeQuery = true)
    List<Offer> findAlloffercompanynam(String name);
    List<Offer> findAllByCityNameContaining(String city);
    @Modifying
    @Query(value = "delete from offers_skill where offer_id = :offer_id ;", nativeQuery = true)
    void deleteAllSkill(Long offer_id);
    @Modifying
    @Query(value = "insert into offers_skill(offer_id, skill_id) values (:offer_id,:skill_id);", nativeQuery = true)
    void insertIntoSkill(Long offer_id, Long skill_id);


}
