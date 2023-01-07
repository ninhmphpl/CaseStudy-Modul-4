package com.example.web.model.customer;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "citys")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
