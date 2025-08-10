package com.codingshuttle.youtube.hospitalManagement.service;

import com.codingshuttle.youtube.hospitalManagement.entity.Insaurance;
import com.codingshuttle.youtube.hospitalManagement.entity.Patient;
import com.codingshuttle.youtube.hospitalManagement.repository.InsauranceRepository;
import com.codingshuttle.youtube.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsauranceService {
    @Autowired
    private final InsauranceRepository insauranceRepository ;

    @Autowired
    private final PatientRepository patientRepository ;

    @Transactional
    public Patient assignInsauranceToPatient(Insaurance insaurance, Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patient.setInsaurance(insaurance);
        insaurance.setPatient(patient);
        return patient ;
    }

}
