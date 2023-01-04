package com.example.web.model;

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
    @Column(name = "id")
    private Long id;
    @Column(name = "birth")
    private LocalDate birth;
    @Column(name = "education")
    private String education;
    @Column(name = "exp_work")
    private String expWord;
    @JoinColumn(name = "user")
    @OneToOne
    private User user;
    @ManyToMany
    private List<Offer> offer;

}
