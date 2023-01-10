package com.example.web.service;

import com.example.web.model.Company;
import com.example.web.model.Offer;
import com.example.web.model.Skill;
import com.example.web.model.offer.CountAmountOffer;
import com.example.web.model.offer.OfferRender;
import com.example.web.repository.OfferRepository;
import com.example.web.repository.company.CompanyRepository;
import com.example.web.repository.customer.CityRepository;
import com.example.web.repository.offer.CareerRepository;
import com.example.web.repository.offer.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class OfferService implements ICrudService<Offer,Long>{
    @Autowired
    OfferRepository offerRepository;
    @Autowired
    CareerRepository careerRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    SkillRepository skillRepository;
    @Autowired
    CompanyRepository companyRepository;


    @Override
    public List<Offer> findAll() {
        List<Offer> hi = offerRepository.findAll();
        return hi;
    }
    @Override
    public Optional<Offer> findById(Long id) {
        return offerRepository.findById(id);
    }

    @Override
    public Offer save(Offer offer) {
//        Set<Skill> skillSet = offer.getSkill();
//        offer.setSkill(null);
        Offer offer1 = offerRepository.save(offer);
//        offerRepository.deleteAllSkill(offer1.getId());
//        for(Skill skill : skillSet){
//            offerRepository.insertIntoSkill(offer1.getId(),  skill.getId());
//        }
        return offer1;
    }

    @Override
    public void delete(Long id) {
        offerRepository.deleteById(id);
    }

    public OfferRender render(Offer offer){
        return new OfferRender(cityRepository.findAll(),
                careerRepository.findAll(), skillRepository.findAll(),
                offer);
    }
    public List<Offer> findAllByName(String name){
        return offerRepository.findAllByNameContaining(name);
    }
    public List<Offer> findAllByCityName(String city){
        return offerRepository.findAllByCityNameContaining(city);
    }
    public List<Offer> findAllByCompany(String name){
        return offerRepository.findAlloffercompanynam("%"+name+"%");
    }

    public List<CountAmountOffer> sortAmountOfferCompany(){
        List<CountAmountOffer> list = new ArrayList<>();
        List<Company> companies = companyRepository.findAll();
        for (Company company: companies) {
            int amount = 0;
            List<Offer> offers = company.getOffer();
            for(Offer offer: offers){
                amount += offer.getAmount();
            }
            list.add(new CountAmountOffer(amount, company));
        }
        list.sort(Comparator.comparing(CountAmountOffer::getAmount));

        return list;
    }



}
