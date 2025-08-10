package com.codingshuttle.youtube.hospitalManagement.service;

import com.codingshuttle.youtube.hospitalManagement.entity.Appointment;
import com.codingshuttle.youtube.hospitalManagement.entity.Doctor;
import com.codingshuttle.youtube.hospitalManagement.entity.Patient;
import com.codingshuttle.youtube.hospitalManagement.repository.AppointmentRepository;
import com.codingshuttle.youtube.hospitalManagement.repository.DoctorRepository;
import com.codingshuttle.youtube.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    @Autowired private final AppointmentRepository appointmentRepository ;
    @Autowired private final PatientRepository patientRepository ;
    @Autowired private final DoctorRepository doctorRepository ;

    @Transactional
    public Appointment createAppointment(Appointment appointment, Long doctorId, Long patientId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow() ;
        Patient patient = patientRepository.findById(patientId).orElseThrow() ;

        if(appointment.getId() != null ) throw new RuntimeException("Appointment already exists with id: " + appointment.getId());

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        patient.getAppointments().add(appointment) ;  // just to maintain bidirectional mapping

        appointmentRepository.save(appointment);

        return appointment ;
    }

}
