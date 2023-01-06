package com.example.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
//    @JoinColumn(name = "user")
    @OneToOne
    private User user;
    private String career;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Offer> offer;

}
