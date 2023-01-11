package com.example.web.model;

import com.example.web.model.customer.City;
import com.example.web.model.customer.Education;
import com.example.web.model.customer.ExpWork;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
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
    @JoinColumn(unique = true)
    private User user;
    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<OfferCustomerStatus> offerStatus;
    @ManyToOne
    private City city;

}
