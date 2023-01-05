package com.example.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "offers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String career;
    private String description;
    private LocalDate endDate;
    private String city;
    private int amount;
    private int workExperience;
//    @JoinColumn(name = "skill")
    @OneToMany
    private List<Skill> skill;
    private String status;




}
