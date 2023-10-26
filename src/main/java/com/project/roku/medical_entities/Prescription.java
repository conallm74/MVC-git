package com.project.roku.medical_entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table(name="prescription")
public class Prescription {

    @Id
    @Column(name="prescription_id")
    private int prescriptionId;

    @Column(name="patient_id")
    private int patientId;

    @Column(name="medication_id")
    private int medicationId;

    @Column(name="prescription_date")
    private int prescriptionDate;

    @Column(name="dosage")
    private String dosage;

    @Column(name="prescribing_doctor")
    private int prescribingDoctor;

    // constructors
    public Prescription(){}

    public Prescription(int prescriptionId, int patientId, int medicationId, int prescriptionDate, String dosage, int prescribingDoctor) {
        this.prescriptionId = prescriptionId;
        this.patientId = patientId;
        this.medicationId = medicationId;
        this.prescriptionDate = prescriptionDate;
        this.dosage = dosage;
        this.prescribingDoctor = prescribingDoctor;
    }

    // getters and setter


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

    public int getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(int medicationId) {
        this.medicationId = medicationId;
    }

    public int getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(int prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public int getPrescribingDoctor() {
        return prescribingDoctor;
    }

    public void setPrescribingDoctor(int prescribingDoctor) {
        this.prescribingDoctor = prescribingDoctor;
    }

    // to string
    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionId=" + prescriptionId +
                ", patientId=" + patientId +
                ", medicationId=" + medicationId +
                ", prescriptionDate=" + prescriptionDate +
                ", dosage='" + dosage + '\'' +
                ", prescribingDoctor=" + prescribingDoctor +
                '}';
    }
}
