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
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "user")
    @OneToOne
    private User user;
    @Column(name = "career")
    private String career;
    @Column(name = "description")
    private String description;
    @OneToMany
    private List<Offer> offer;

}
