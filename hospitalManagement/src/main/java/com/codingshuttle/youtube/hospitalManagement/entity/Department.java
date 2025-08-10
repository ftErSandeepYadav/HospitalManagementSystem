package com.codingshuttle.youtube.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String name;

    @OneToOne
    @JoinColumn(name = "head_doctor_id", referencedColumnName = "id")  // owner side of the relationship
    private Doctor headDoctor;

    @ManyToMany
    private Set<Doctor> doctors = new HashSet<>();

}
