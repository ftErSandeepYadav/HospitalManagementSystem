package com.codingshuttle.youtube.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@ToString
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String email;
    private String gender ;
    private String bloodGroup;

    @OneToOne
    @JoinColumn(name = "insaurance_id", referencedColumnName = "id")  // owner side of the relationship
    private Insaurance insaurance;

}
