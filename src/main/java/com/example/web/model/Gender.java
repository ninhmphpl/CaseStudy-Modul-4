package com.example.web.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "genders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
}
