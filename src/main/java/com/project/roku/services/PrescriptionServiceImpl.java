package com.project.roku.services;

import com.project.roku.DTO.PrescriptionDTO;
import com.project.roku.dao.PatientRepository;
import com.project.roku.dao.PrescriptionRepo;
import com.project.roku.entity.Employee;
import com.project.roku.entity.Patient;
import com.project.roku.medical_entities.Prescription;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionServiceImpl implements PrescriptionRepoService{

    private PrescriptionRepo prescriptionRepo;

    // model mapper instance
    private ModelMapper modelMapper;

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
            throw new RuntimeException("Couldn't find prescription by that prescription by Id" + theId );
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


    // mapping for DAO

    @Autowired
    public PrescriptionServiceImpl(PrescriptionRepo prescriptionRepo, ModelMapper theModelMapper){
        this.prescriptionRepo = prescriptionRepo;
        this.modelMapper = theModelMapper;
    }

    public PrescriptionDTO convertPrescriptionToDTO(Prescription prescription) {
        return modelMapper.map(prescription, PrescriptionDTO.class);
    }

    public Prescription convertDTOToPrescription(PrescriptionDTO dto) {
        return modelMapper.map(dto, Prescription.class);
    }
}
