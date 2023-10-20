package com.project.roku.controller;

import com.project.roku.entity.Employee;
import com.project.roku.entity.Patient;
import com.project.roku.services.PatientRepoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PrescriptionController {
    private PatientRepoService patientService;

    public PrescriptionController(PatientRepoService thePatientService){
        this.patientService = thePatientService;
    }

    // get patients from the database
/*
    @GetMapping("patientList")
    public String patientList(Model theModel){
        List<Patient> thePatients = patientService.findAll();

        theModel.addAttribute("patients", thePatients);

        return ""
    }



    // get the employees from the database
    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List<Employee> theEmployees = employeeService.findAll();

        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }
     */
}
