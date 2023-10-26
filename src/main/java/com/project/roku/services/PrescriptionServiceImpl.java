package com.project.roku.services;

import com.project.roku.dao.PatientRepository;
import com.project.roku.dao.PrescriptionRepo;
import com.project.roku.entity.Employee;
import com.project.roku.entity.Patient;
import com.project.roku.medical_entities.Prescription;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PrescriptionServiceImpl implements PrescriptionRepoService{

    private PrescriptionRepo prescriptionRepo;

    @Autowired
    public PrescriptionServiceImpl(PrescriptionRepo thePrescriptionRepo){
        prescriptionRepo = thePrescriptionRepo;
    }


    @Override
    public List<Prescription> findAll() {
        return prescriptionRepo.findAll();
    }

    @Override
    public Prescription findById(int theId) {
        Optional<Prescription> result = prescriptionRepo.findById(theId);

        Prescription thePrescription = null;
        if (result.isPresent()){
            thePrescription = result.get();
        }
        else {
            throw new RuntimeException("Couldn't find patient by that prescrption by Id" + theId );
        }
        return thePrescription;
    }

    @Override
    public Prescription save(Prescription thePrescription) {
        return prescriptionRepo.save(thePrescription);
    }

    @Override
    public void deleteById(int theId) {
        prescriptionRepo.deleteById(theId);
    }

}
