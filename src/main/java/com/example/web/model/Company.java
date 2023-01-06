package com.example.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
@Data
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

    @OneToMany
    private List<Offer> offer;

}
