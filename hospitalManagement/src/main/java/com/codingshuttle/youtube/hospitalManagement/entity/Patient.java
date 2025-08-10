package com.codingshuttle.youtube.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String email;
    private String gender ;
    private String bloodGroup;

    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)  // cascade types to propagate changes
    @JoinColumn(name = "insaurance_id", referencedColumnName = "id")  // owner side of the relationship
    private Insaurance insaurance;

    @OneToMany(mappedBy = "patient", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    @ToString.Exclude
    private List<Appointment> appointments = new ArrayList<>();

}
