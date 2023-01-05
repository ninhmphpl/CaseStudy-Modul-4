package com.example.web.model;

import com.example.web.model.customer.City;
import com.example.web.model.customer.Education;
import com.example.web.model.customer.ExpWork;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birth;
    @ManyToOne
    private Education education;
    @ManyToOne
    private ExpWork expWork;
    private String phoneNumber;
    @ManyToOne
    private Gender gender;
    @OneToOne
    private User user;
    @ManyToMany
    private List<Offer> offer;
    @ManyToOne
    private City city;

}
