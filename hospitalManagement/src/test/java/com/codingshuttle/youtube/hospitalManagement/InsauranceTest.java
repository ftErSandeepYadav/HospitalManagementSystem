package com.codingshuttle.youtube.hospitalManagement;

import com.codingshuttle.youtube.hospitalManagement.entity.Insaurance;
import com.codingshuttle.youtube.hospitalManagement.entity.Patient;
import com.codingshuttle.youtube.hospitalManagement.service.InsauranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InsauranceTest {

    @Autowired
    private InsauranceService insauranceService;

    @Test
    public void testInsaurance() {
        Insaurance insaurance = Insaurance.builder()
                .provider("HealthCare Inc.")
                .policyNumber("HC1423456")
                .validUntil(java.time.LocalDateTime.now().plusYears(1))
                .build();

        System.out.println("Insaurance created: " + insaurance);
        Patient patient = insauranceService.assignInsauranceToPatient(insaurance, 1L);
        System.out.println("Insaurance after assignment to patient : " + insaurance);
        System.out.println(patient);
    }

    @Test
    public void testDisAssociateInsauranceFromPatient() {
        testInsaurance();
        Patient patient = insauranceService.disAssociateInsauranceFromPatient(1L);
        System.out.println("Patient after disassociating insaurance: " + patient);
    }
}
