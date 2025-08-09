package com.codingshuttle.youtube.hospitalManagement;

import com.codingshuttle.youtube.hospitalManagement.dto.GenderCountResponseDTO;
import com.codingshuttle.youtube.hospitalManagement.entity.Patient;
import com.codingshuttle.youtube.hospitalManagement.repository.PatientRepository;
import com.codingshuttle.youtube.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatientRepository(){
        List<Patient> patientList = patientRepository.findAll() ;
        System.out.println(patientList);
    }

    @Test
    public void testTransactionalMethods(){
//        Patient patient = patientService.getPatientById(1L);
//        System.out.println(patient);
//        List<Patient> patientList = patientRepository.findAllPatients();
//        System.out.println(patientList);
//
//        List<GenderCountResponseDTO> genderList = patientRepository.countEachGender() ;
//        System.out.println(genderList);
//        for(GenderCountResponseDTO patient : genderList) {
//            System.out.println(patient);
//        }
//        for(Object[] objects : genderList){
//            System.out.println(objects[0] + " : " + objects[1]);
//        }
//        int rowCount = patientRepository.updateNameWithId("Sandeep Yadav", 1L);
//        System.out.println(1 + " row(s) updated.");

        Page<Patient> patientPage = patientRepository.findAllPatients(PageRequest.of(0, 25, Sort.by("name"))) ;
        System.out.println("Total Pages: " + patientPage.getTotalPages());
        System.out.println("Total Elements: " + patientPage.getTotalElements());
        for(Patient patient: patientPage){
            System.out.println(patient);
        }

    }

    @Test
    public void testFindByUsername(){
        Patient patient = patientRepository.findByName("Sandeep");
        System.out.println(patient);
    }

}
