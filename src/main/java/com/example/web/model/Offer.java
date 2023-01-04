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
    @Column(name = "id")
    private Long id;
    @Column(name = "career")
    private String career;
    @Column(name = "description")
    private String description;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "city")
    private String city;
    @Column(name = "amount")
    private int amount;
    @Column(name = "work_experience")
    private int workExperience;
    @JoinColumn(name = "skill")
    @OneToMany
    private List<Skill> skill;




}
