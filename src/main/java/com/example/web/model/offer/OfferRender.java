package com.example.web.model.offer;

import com.example.web.model.Offer;
import com.example.web.model.Skill;
import com.example.web.model.customer.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class OfferRender {
    private List<City> cities;
    private List<Career> careers;
    private List<Skill> skills;
    private Offer offer;
}
