package com.example.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String career;
    private String description;
    private String address;
    private String phoneNumber;
//    @JoinColumn(name = "user")
    @OneToOne
    private User user;
    private String phoneNumber;
    private String career;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Offer> offer;

}
