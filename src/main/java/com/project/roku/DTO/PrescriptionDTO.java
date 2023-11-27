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


    /*

    public PrescriptionDTO(){}
    // Create a PrescriptionDTO and populate it with data from the entities
    public void populateFromEntities(Prescription thePrescription, Patient thePatient) {
        this.patientFirstName = thePatient.getPatientFirstName();
        this.patientLastName = thePatient.getPatientLastName();
        this.patientAddress = thePatient.getAddress();
        this.prescriptionId = thePrescription.getPrescriptionId();
        this.prescriptionDate = thePrescription.getPrescriptionDate();
        this.medicationName = thePrescription.getMedicationName();
        this.dosage = thePrescription.getDosage();
        this.prescribingDoctor = thePrescription.getPrescribingDoctor();
    }

    public Prescription convertDTOToPrescription() {
        Prescription prescription = new Prescription();
        prescription.setMedicationName(this.medicationName);
        prescription.setPrescriptionDate(this.prescriptionDate);
        prescription.setDosage(this.dosage);
        prescription.setPrescribingDoctor(this.prescribingDoctor);

        // Set any other fields as needed
        return prescription;
    }

     */
}
