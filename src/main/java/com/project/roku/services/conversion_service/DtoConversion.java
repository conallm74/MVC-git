package com.project.roku.services.conversion_service;

import com.project.roku.DTO.PrescriptionDTO;
import com.project.roku.entity.Patient;
import com.project.roku.medical_entities.Prescription;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtoConversion {

    @Autowired
    private ModelMapper modelMapper;


    public PrescriptionDTO mapToDTO(Prescription prescription, Patient patient){
        PrescriptionDTO dto = modelMapper.map(prescription, PrescriptionDTO.class);
        modelMapper.map(patient, PrescriptionDTO.class);

        return dto;
    }

}
