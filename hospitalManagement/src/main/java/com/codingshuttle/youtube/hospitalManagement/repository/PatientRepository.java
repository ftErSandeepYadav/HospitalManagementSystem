package com.codingshuttle.youtube.hospitalManagement.repository;

import com.codingshuttle.youtube.hospitalManagement.dto.GenderCountResponseDTO;
import com.codingshuttle.youtube.hospitalManagement.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);

    Patient findByDateOfBirth(LocalDate dateOfBirth);

    List<Patient> findByNameContainingOrderByIdDesc(String name);

//    @Query("SELECT p FROM Patient p WHERE p.bloodGroup = ?1")
//    List<Patient> findByBloodGroup(@Param("bloodGroup") String bloodGroup);

    @Query("SELECT p FROM Patient p WHERE p.dateOfBirth > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);


    // projection will not work with native query it will only work with JPQL
    @Query("SELECT new com.codingshuttle.youtube.hospitalManagement.dto.GenderCountResponseDTO(p.gender, COUNT(p)) " +
            "FROM Patient p GROUP BY p.gender")
    List<GenderCountResponseDTO> countEachGender();


    // Wring a native query to fetch all patients ( SQL query)
    @Query(value = "SELECT * FROM patient", nativeQuery = true)
    Page<Patient> findAllPatients(Pageable pageable) ;

    // Update the name of a patient with a given id
    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name WHERE p.id = :id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

}
