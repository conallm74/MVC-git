package com.project.roku.controller;

import com.project.roku.entity.Patient;
import com.project.roku.services.PatientRepoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/patientsList")
public class PrescriptionController {
    private PatientRepoService patientService;

    public PrescriptionController(PatientRepoService thePatientService){
        this.patientService = thePatientService;
    }

    // get the patient from the database

    @GetMapping("patient")
    public String patientList(Model theModel){
        List<Patient> thePatients = patientService.findAll();
            theModel.addAttribute("patients", thePatients);
            return "prescription-management/patient-management";
    }
}
