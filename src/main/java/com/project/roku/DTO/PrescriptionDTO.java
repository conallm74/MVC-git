package com.project.roku.DTO;


import lombok.Data;
import org.springframework.stereotype.Component;

// creating a DTO for data transfer and for easier data entry

@Data
@Component
public class PrescriptionDTO {

    // fields from Prescription
    private int prescriptionId;

    private String medicationName;

    private java.sql.Date prescriptionDate;

    private String prescribingDoctor;

    private String dosage;

    // fields from Patient

    private String patientFirstName;

    private String patientLastName;

    private String patientAddress;

}
