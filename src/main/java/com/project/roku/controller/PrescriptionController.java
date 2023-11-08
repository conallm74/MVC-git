package com.project.roku.controller;

import com.project.roku.DTO.PrescriptionDTO;
import com.project.roku.dao.PharmacyRepo;
import com.project.roku.entity.Patient;
import com.project.roku.medical_entities.Pharmacy;
import com.project.roku.medical_entities.Prescription;
import com.project.roku.services.PatientRepoService;
import com.project.roku.services.PharmaRepoService;
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

    private PharmaRepoService pharmacyRepoService;



    @Autowired
    public PrescriptionController(
            PatientRepoService patientService,
            PrescriptionRepoService prescriptionService,
            PharmaRepoService pharmacyRepoService
    ) {
        this.pharmacyRepoService = pharmacyRepoService;
        this.patientService = patientService;
        this.prescriptionService = prescriptionService;
    }


    // show the form with the pre-populated patient information.
    @GetMapping("/showPresForm")
    public String showPresForm(@RequestParam(value = "patientId") int theId, Model theModel) {
        // find the patient by the Id.
        Patient thePatient = patientService.findById(theId);

        // add the patient to the model
        theModel.addAttribute("patient", thePatient);

        // add the prescription
        Prescription thePrescription = new Prescription();
        theModel.addAttribute("prescription", thePrescription);

        // retrieving the pharmacies for the drop-down menu
        List<String> pharmacies = pharmacyRepoService.findAllPharmacies();
        theModel.addAttribute("pharmacies", pharmacies);


        // send over to our form
        return "prescriptions/prescription-form";
    }

    // save the new prescription
    @PostMapping("/prescribePrescription")
    public String prescribePrescription(@ModelAttribute("prescription") Prescription thePrescription){

        // Prescription newPrescription = thePrescriptionDTO.convertDTOToPrescription();
        // Save the new Prescription entity in the database
        prescriptionService.save(thePrescription);
        return "redirect:patients/patient-list";
    }

    /*
    Get Mapping for the drop-down menu
     */
    // @GetMapping("/showDropDown")
    // public String









}
