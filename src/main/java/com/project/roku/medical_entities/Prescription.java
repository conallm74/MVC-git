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

}
