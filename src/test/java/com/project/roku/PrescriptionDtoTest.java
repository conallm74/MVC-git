package com.project.roku;


import com.project.roku.DTO.PrescriptionDTO;
import com.project.roku.controller.PrescriptionController;
import com.project.roku.entity.Patient;
import com.project.roku.medical_entities.Prescription;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PrescriptionController.class)
@AutoConfigureMockMvc
@SpringBootTest
public class PrescriptionDtoTest {

    private static MockHttpServletRequest request;
    
    @Autowired
    private MockMvc mockMvc;

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


    @Test
    public void testSendPrescription() throws Exception {
        // make sample prescription and patient
        Prescription prescription = new Prescription();
        prescription.setDosage("Four a day");
        prescription.setPrescribingDoctor("Mike");
        prescription.setMedicationName("Ibuprofene");
        prescription.setPrescriptionId(1);

        // sample patient
        Patient patient = new Patient();
        patient.setPatientFirstName("Harry");
        patient.setPatientLastName("Potter");
        patient.setPatientAddress("Godricks Hollow");

        ModelAndView modelAndView = MockMvc.perform(post("/prescriptions/prescribePrescription/sendPrescription")
                .flashAttr("prescription", prescription)
                .flashAttr("patient", patient)
                .accept((MediaType) status().is3xxRedirection())
                .secure().getModelAndView());


    }


    /*
     ModelAndView modelAndView = mockMvc.perform(post("/yourMappingPath/sendPrescription")
                .flashAttr("prescription", prescription)
                .flashAttr("patient", patient))
                .andExpect(status().is3xxRedirection()) // Assuming you're redirecting
                .andReturn().getModelAndView();

        // Retrieve the PrescriptionDTO from the ModelAndView
        PrescriptionDTO prescriptionDTO = (PrescriptionDTO) modelAndView.getModel().get("prescriptionDTO");

     */

}
