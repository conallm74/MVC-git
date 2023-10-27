package com.project.roku.medical_entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name="prescription")
public class Prescription {

    @Id
    @Column(name="prescription_id")
    private int prescriptionId;

    @Column(name="patient_first_name")
    private String patientFirstName;

    @Column(name="patient_last_name")
    private String patientLastName;

    @Column(name="medication_name")
    private String medicationName;

    @Column(name="prescription_date")
    private java.sql.Date prescriptionDate;

    @Column(name="dosage")
    private String dosage;

    @Column(name="prescribing_doctor")
    private String prescribingDoctor;

    // constructors
    public Prescription(){}

    public Prescription(int prescriptionId, String patientFirstName, String patientLastName, String medicationName, Date prescriptionDate, String dosage, String prescribingDoctor) {
        this.prescriptionId = prescriptionId;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.medicationName = medicationName;
        this.prescriptionDate = prescriptionDate;
        this.dosage = dosage;
        this.prescribingDoctor = prescribingDoctor;
    }


    // getters and setters


    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }


    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
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

    // to string


    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionId=" + prescriptionId +
                ", patientFirstName='" + patientFirstName + '\'' +
                ", patientLastName='" + patientLastName + '\'' +
                ", medicationName='" + medicationName + '\'' +
                ", prescriptionDate=" + prescriptionDate +
                ", dosage='" + dosage + '\'' +
                ", prescribingDoctor='" + prescribingDoctor + '\'' +
                '}';
    }
}
