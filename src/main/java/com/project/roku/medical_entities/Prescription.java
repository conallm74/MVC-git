package com.project.roku.medical_entities;

import com.project.roku.DTO.PrescriptionDTO;
import com.project.roku.dao.PrescriptionRepo;
import com.project.roku.services.PrescriptionServiceImpl;
import jakarta.persistence.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name="prescription")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prescription_id")
    private int prescriptionId;

    @Column(name="patient_id")
    private int patientId;

    @Column(name="medication_name")
    private String medicationName;

    @Column(name="prescription_date")
    private java.sql.Date prescriptionDate;

    @Column(name="dosage")
    private String dosage;

    @Column(name="prescribing_doctor")
    private String prescribingDoctor;

    @Column(name="fk_pharmacy_recipient")
    private String pharmacyRecipientId;

    // constructors
    public Prescription(){}

    public Prescription(int prescriptionId, int patientId, String medicationName, Date prescriptionDate, String dosage, String prescribingDoctor, String pharmacyRecipientId) {
        this.prescriptionId = prescriptionId;
        this.patientId = patientId;
        this.medicationName = medicationName;
        this.prescriptionDate = prescriptionDate;
        this.dosage = dosage;
        this.prescribingDoctor = prescribingDoctor;
        this.pharmacyRecipientId = pharmacyRecipientId;
    }

    /*
    // mapping to DTO

    Prescription convertDTOToPrescription(PrescriptionDTO dto){
        Prescription prescription = new Prescription(
                dto.getPrescriptionId(),
                dto.getPatientId(),
                dto.getMedicationName(),
                dto.getPrescriptionDate(),
                dto.getPrescribingDoctor(),
                dto.getDosage()
        ); return prescription;
    }

     */
    // getters and setters

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public Date getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(Date prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getPrescribingDoctor() {
        return prescribingDoctor;
    }

    public void setPrescribingDoctor(String prescribingDoctor) {
        this.prescribingDoctor = prescribingDoctor;
    }

    public String getPharmacyRecipientId() {
        return pharmacyRecipientId;
    }

    public void setPharmacyRecipientId(String pharmacyRecipientId) {
        this.pharmacyRecipientId = pharmacyRecipientId;
    }


    // to string


    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionId=" + prescriptionId +
                ", patientId=" + patientId +
                ", medicationName='" + medicationName + '\'' +
                ", prescriptionDate=" + prescriptionDate +
                ", dosage='" + dosage + '\'' +
                ", prescribingDoctor='" + prescribingDoctor + '\'' +
                ", pharmacyRecipientId='" + pharmacyRecipientId + '\'' +
                '}';
    }
}
