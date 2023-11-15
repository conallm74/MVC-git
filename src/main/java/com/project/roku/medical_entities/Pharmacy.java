package com.project.roku.medical_entities;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Entity
@Table(name="pharmacies")
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pharmacy_id")
    private int pharmacyId;

    @Column(name="pharmacy_name")
    private String pharmacyName;

    @Column(name="pharmacy_address")
    private String pharmacyAddress;

    @Column(name="pharmacy_recipient_id")
    private int pharmacyRecipientId;
    // constructors


    public Pharmacy(int pharmacyId, String pharmacyName, String pharmacyAddress, int pharmacyRecipientId) {
        this.pharmacyId = pharmacyId;
        this.pharmacyName = pharmacyName;
        this.pharmacyAddress = pharmacyAddress;
        this.pharmacyRecipientId = pharmacyRecipientId;
    }

    public Pharmacy(){}

    public Pharmacy(String pharmacyName) {
    }

    // getters and setters

    public int getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getPharmacyAddress() {
        return pharmacyAddress;
    }

    public void setPharmacyAddress(String pharmacyAddress) {
        this.pharmacyAddress = pharmacyAddress;
    }

    public int getPharmacyRecipientId() {
        return pharmacyRecipientId;
    }

    public void setPharmacyRecipientId(int pharmacyRecipientId) {
        this.pharmacyRecipientId = pharmacyRecipientId;
    }


    // to string

    @Override
    public String toString() {
        return "Pharmacy{" +
                "pharmacyId=" + pharmacyId +
                ", pharmacyName='" + pharmacyName + '\'' +
                ", pharmacyAddress='" + pharmacyAddress + '\'' +
                ", pharmacyRecipientId=" + pharmacyRecipientId +
                '}';
    }
}
