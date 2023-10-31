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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
        // create model attribute to bind the data from to
        Patient thePatient = patientService.findById(theId);


        // set the data to the DAO
        // Create a PrescriptionDTO and populate it with data from the entities
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        prescriptionDTO.setPatientFirstName(thePatient.getPatientFirstName());
        prescriptionDTO.setPatientLastName(thePatient.getPatientLastName());
        prescriptionDTO.setPatientAddress(thePatient.getPatientAddress());

        prescriptionDTO.setPatientId(prescriptionDTO.getPatientId());
        prescriptionDTO.setPrescriptionId(prescriptionDTO.getPrescriptionId());
        prescriptionDTO.setPrescriptionDate(prescriptionDTO.getPrescriptionDate());
        prescriptionDTO.setMedicationName(prescriptionDTO.getMedicationName());
        prescriptionDTO.setDosage(prescriptionDTO.getMedicationName());
        prescriptionDTO.setPrescribingDoctor(prescriptionDTO.getPrescribingDoctor());

        theModel.addAttribute("prescriptionDTO", prescriptionDTO);

        // set the patient in the model to prepopulate the model/form
        // theModel.addAttribute("patient", thePatient);

        // adding the drop-down meds to the model
        // theModel.addAttribute("medications", meds);

        // send over to our form
        return "prescriptions/prescription-form";
    }




    /*
    @GetMapping("/prescribePrescription")
    public String prescribePrescription(Model theModel){
        Prescription thePrescription = new Prescription();

        theModel.addAttribute("prescriptionDTO", theModel);
        return "prescriptions/prescription-form";
    }

     */
}
