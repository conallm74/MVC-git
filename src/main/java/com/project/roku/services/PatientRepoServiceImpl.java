package com.project.roku.services;

import com.project.roku.dao.PatientRepository;
import com.project.roku.entity.Employee;
import com.project.roku.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PatientRepoServiceImpl implements PatientRepoService {


    private PatientRepository patientRepository;

    @Autowired
    public PatientRepoServiceImpl(PatientRepository thePatientRepository){
        patientRepository = thePatientRepository;
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findById(int theId) {
        Optional<Patient> result = patientRepository.findById(theId);

        Patient thePatient = null;
        if (result.isPresent()){
            thePatient = result.get();
        }
        else {
            throw new RuntimeException("Couldn't find patient by that ID");
        }
        return thePatient;
    }


    @Override
    public Patient save(Patient thePatient) {
        return patientRepository.save(thePatient);
    }


    @Override
    public void deleteById(int theId) {
        patientRepository.deleteById(theId);
    }
}
