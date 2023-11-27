package com.project.roku;


import com.project.roku.DTO.PrescriptionDTO;
import com.project.roku.entity.Patient;
import com.project.roku.medical_entities.Prescription;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PrescriptionDtoTest {

    @Autowired
    public PrescriptionDTO dto;


    @Test
    public void testDTOCreation(){
        // create instance
        Prescription prescription = new Prescription();

        // set the values
        prescription.setPrescriptionId(11);
        //prescription.setPrescriptionDate(Date.valueOf(LocalDate.now()));
        prescription.setMedicationName("ibuprofene");
        prescription.setPrescribingDoctor("Mike");
        prescription.setDosage("4 a day");

        Patient patient = new Patient();
        patient.setPatientFirstName("Harry");
        patient.setPatientLastName("Potter");
        patient.setPatientAddress("Godricks Hollow");

        // create instance of DTO
        PrescriptionDTO dto = new PrescriptionDTO();

        // set values
        dto.setPrescriptionId(prescription.getPrescriptionId());
        //dto.setPrescriptionDate(prescription.getPrescriptionDate());
        dto.setMedicationName(prescription.getMedicationName());
        dto.setPrescribingDoctor(prescription.getPrescribingDoctor());
        dto.setDosage(prescription.getDosage());
        dto.setPatientFirstName(patient.getPatientFirstName());
        dto.setPatientLastName(patient.getPatientLastName());
        dto.setPatientAddress(patient.getPatientAddress());



        // assert equals
        assertEquals(11, dto.getPrescriptionId());
        //assertEquals(1985, dto.getPrescriptionDate());
        assertEquals("ibuprofene", dto.getMedicationName());
        assertEquals("Mike", dto.getPrescribingDoctor());
        assertEquals("4 a day", dto.getDosage());
        assertEquals("Harry", dto.getPatientFirstName());
        assertEquals("Potter", dto.getPatientLastName());
        assertEquals("Godricks Hollow", dto.getPatientAddress());


    }

}
