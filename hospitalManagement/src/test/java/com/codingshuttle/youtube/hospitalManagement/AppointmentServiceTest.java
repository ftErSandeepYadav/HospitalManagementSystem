package com.codingshuttle.youtube.hospitalManagement;

import com.codingshuttle.youtube.hospitalManagement.entity.Appointment;
import com.codingshuttle.youtube.hospitalManagement.entity.Doctor;
import com.codingshuttle.youtube.hospitalManagement.entity.Patient;
import com.codingshuttle.youtube.hospitalManagement.repository.DoctorRepository;
import com.codingshuttle.youtube.hospitalManagement.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppointmentServiceTest {

    @Autowired private AppointmentService appointmentService;
    @Autowired private DoctorRepository doctorRepository ;

    @Test
    public void testCreateAppointment() {

        Appointment appointment = Appointment.builder()
                .appointmentDateTime(java.time.LocalDateTime.now())
                .reasonForVisit("Routine Checkup")
                .build();

        Appointment newAppointment = appointmentService.createAppointment(appointment, 1L, 1L);

        System.out.println("new appointment : " + appointment);
        System.out.println("Test for createAppointment method in AppointmentService");
    }

}
