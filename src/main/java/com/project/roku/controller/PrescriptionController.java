package com.project.roku.controller;

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
    public PrescriptionController(PrescriptionRepoService thePrescriptionService){
        this.prescriptionService = thePrescriptionService;
    }

    @Autowired
    public PrescriptionController(PatientRepoService thePatientService){
        this.patientService = thePatientService;
    }

    @GetMapping("/showPresForm")
    public String showPresForm(@RequestParam(value="patientId") int theId, Model theModel){
        // create model attribute to bind the data from to
        Patient thePatient = patientService.findById(theId);

        // set the patient in the model to prepopulate the model/form
        theModel.addAttribute("patient", thePatient);

        // adding the drop-down meds to the model
        // theModel.addAttribute("medications", meds);

        // send over to our form
        return "prescriptions/prescription-form";
    }

    @GetMapping("/prescribePrescription")
    public String prescribePrescription(Model theModel){
        Prescription thePrescription = new Prescription();

        theModel.addAttribute("prescription", theModel);
        return "prescriptions/prescription-form";
    }
}
