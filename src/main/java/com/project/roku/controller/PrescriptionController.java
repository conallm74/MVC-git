package com.project.roku.controller;

import com.project.roku.DTO.PrescriptionDTO;
import com.project.roku.entity.Patient;
import com.project.roku.medical_entities.Prescription;
import com.project.roku.services.PatientRepoService;
import com.project.roku.services.PrescriptionRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
@Controller
@RequestMapping("/prescriptions")
public class PrescriptionController {

    // injection countries for medication list
   // @Value("${meds}")
   // private List<String> meds;

    private PatientRepoService patientService;

    // injecting prescription service
    private PrescriptionRepoService prescriptionService;


    @Autowired
    public PrescriptionController(
            PatientRepoService patientService,
            PrescriptionRepoService prescriptionService
    ) {
        this.patientService = patientService;
        this.prescriptionService = prescriptionService;
    }


    // show the form with the pre-populated patient information.
    @GetMapping("/showPresForm")
    public String showPresForm(@RequestParam(value = "patientId") int theId, Model theModel) {
        // find the patient by the Id.
        Patient thePatient = patientService.findById(theId);
        // create model attribute to bind the data from to
        // set the data to the DAO
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        prescriptionDTO.setPatientFirstName(thePatient.getPatientFirstName());
        prescriptionDTO.setPatientLastName(thePatient.getPatientLastName());
        prescriptionDTO.setPatientAddress(thePatient.getAddress());
        prescriptionDTO.setPatientId(thePatient.getPatientId());

        // add the DTO to the model
        theModel.addAttribute("prescriptionDTO", prescriptionDTO);

        // send over to our form
        return "prescriptions/prescription-form";
    }





    // save the new prescription
    @PostMapping("/prescribePrescription")
    public String prescribePrescription(@ModelAttribute("prescriptionDTO") PrescriptionDTO thePrescriptionDTO){
        log.info("Prescribe prescription method called.");
        // Convert the PrescriptionDTO back into a Prescription entity
        Prescription newPrescription = thePrescriptionDTO.convertDTOToPrescription();

        // Save the new Prescription entity in the database
        prescriptionService.save(newPrescription);
        return "patients/patient-list";
    }


}
