package com.example.web.model.offer;

import com.example.web.model.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CountAmountOffer {
    private int amount;
    private Company company;

}
