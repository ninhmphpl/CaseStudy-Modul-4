package com.example.web.model.customer;

import com.example.web.model.Customer;
import com.example.web.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DataChoice {
    private List<City> city;
    private List<Education> education;
    private List<Gender> gender;
    private List<ExpWork> expWorks;
    private Customer customer;

}
