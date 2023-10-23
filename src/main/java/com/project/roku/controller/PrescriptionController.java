package com.project.roku.controller;

import com.project.roku.entity.Patient;
import com.project.roku.services.PatientRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/prescriptions")
public class PrescriptionController {

    private PatientRepoService patientService;

    @Autowired
    public PrescriptionController(PatientRepoService thePatientService){
        this.patientService = thePatientService;
    }

    @GetMapping("/showPresForm")
    public String showPresForm(@RequestParam("patientId") int theId Model theModel){
        // create model attribute to bind the data from to
        Patient thePatient = patientS

        theModel.addAttribute("patient", thePatient);
        return "prescriptions/prescription-form";
    }


    /*
       @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){
        // get the employee from the service
        Employee theEmployee = employeeService.findById(theId);

        // set the employee in the model to prepopulate the model/form
        theModel.addAttribute("employee", theEmployee);
        // send over to our form

        return "employees/employee-form";
    }
     */

}
