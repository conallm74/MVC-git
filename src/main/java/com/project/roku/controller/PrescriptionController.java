package com.project.roku.controller;

import com.project.roku.entity.Patient;
import com.project.roku.medical_entities.Prescription;
import com.project.roku.services.patient_services.PatientRepoService;
import com.project.roku.services.pharmacy_services.PharmaRepoService;
import com.project.roku.services.pharmacy_services.PharmaRepoServiceImpl;
import com.project.roku.services.prescription_services.PrescriptionRepoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    PharmaRepoServiceImpl serviceImpl;

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
        List<Object[]> pharmacyNames = serviceImpl.findAllPharmacies();
        theModel.addAttribute("pharmacies", pharmacyNames);




        // send over to our form
        return "prescriptions/prescription-form";
    }

    // save the new prescription
    @PostMapping("/prescribePrescription")
    public String prescribePrescription(@ModelAttribute("prescription") Prescription thePrescription,
                                        @RequestParam(value="pharmacyRecipientId") int pharmacyRecipientId){


        // Retrieve the selected pharmacy
        Integer selectedPharmacy = serviceImpl.findRecipientId(pharmacyRecipientId);

        // Set the pharmacyRecipientId in the Prescription object
        thePrescription.setPharmacyRecipientId(selectedPharmacy);

        /*

        // Retrieve the selected pharmacy recipientId
        Integer selectedRecipientId = pharmacyRepoService.findRecipientId(pharmacyRecipientId);

        // Create an instance of Pharmacy using the selectedRecipientId
        Pharmacy selectedPharmacy = new Pharmacy();
        thePrescription.setPharmacyRecipientId(selectedPharmacy);

        // Set the pharmacyRecipientId in the Prescription object
        thePrescription.setPharmacyRecipientId(selectedPharmacy);

         */
        // Retrieve the selected pharmacy details by its recipient ID
        // Retrieve the pharmacy recipient ID
        // thePrescription.setPharmacyRecipientId(pharmacyRecipientId);



        /*
        // Retrieve the selected pharmacy
        Pharmacy selectedPharmacy = (Pharmacy) pharmacyRepoService.findAllPharmacies();

        thePrescription.setPharmacyRecipientId(selectedPharmacy);

         */
        // Set the pharmacyRecipientId in the Prescription object
        // thePrescription.setPharmacyRecipientId(pharmacyRecipientId);

        // convert the prescription to the DTo

        // convert the pharmacyName?

        // Prescription newPrescription = thePrescription.convertDTOToPrescription();
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
