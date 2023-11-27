package com.project.roku.DTO;


import com.project.roku.entity.Patient;
import com.project.roku.medical_entities.Prescription;
import lombok.Data;

// creating a DTO for data transfer and for easier data entry

@Data
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
}
