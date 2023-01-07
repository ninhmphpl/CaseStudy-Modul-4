package com.example.web.model.customer;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "exp_works")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
