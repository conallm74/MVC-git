package com.project.roku.entity;


import com.project.roku.DTO.PrescriptionDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="patients")
public class Patient {

    // define fields
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="patient_id")
    private int patientId;

    @Column(name="first_name")
    private String patientFirstName;

    @Column(name="last_name")
    private String patientLastName;

    @Column(name="email")
    private String patientEmail;

    @Column(name="address")
    private String patientAddress;



    public Patient(String firstName, String lastName, String patientEmail, String patientAddress) {
        this.patientFirstName = firstName;
        this.patientLastName = lastName;
        this.patientEmail = patientEmail;
        this.patientAddress = patientAddress;
    }

    // mapping for DTO


    /*
    public Patient(String patientFirstName, String patientLastName, String patientAddress) {
    }

    Patient convertDTOToPatient(PrescriptionDTO dto){
        Patient patient = new Patient(
                dto.getPatientFirstName(),
                dto.getPatientLastName(),
                dto.getPatientAddress()
        ); return patient;
    }

     */

    // getters and setters

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
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

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getEmail() {
        return patientEmail;
    }

    public void setEmail(String email) {
        this.patientEmail = email;
    }

    public String getAddress() {
        return patientEmail;
    }

    public void setAddress(String address) {
        this.patientEmail = address;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    // to string

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientFirstName='" + patientFirstName + '\'' +
                ", patientLastName='" + patientLastName + '\'' +
                ", patientEmail='" + patientEmail + '\'' +
                ", patientAddress='" + patientAddress + '\'' +
                '}';
    }
}
