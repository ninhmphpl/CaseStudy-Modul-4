package com.example.web.model;

import lombok.*;

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
    private LocalDate birth;
    private String education;
    private String expWord;
//    @JoinColumn(name = "user")
    @OneToOne
    private User user;
    @ManyToMany
    private List<Offer> offer;

}
