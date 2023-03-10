package com.example.web.model;

import com.example.web.model.admin.Status;
import com.example.web.model.customer.City;
import com.example.web.model.offer.Career;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "offers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Career career;
    private String description;
    private LocalDate endDate;
    @ManyToOne
    private City city;
    private int amount;
    private int workExperience;
    @ManyToMany
    private Set<Skill> skill;
    @ManyToOne
    private Status status;
    @ManyToOne
    private Company company;
    @JsonIgnore
    @OneToMany(mappedBy = "offer")
    private List<OfferCustomerStatus> offerStatus;
}
