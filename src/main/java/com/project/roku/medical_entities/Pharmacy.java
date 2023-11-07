package com.project.roku.medical_entities;

import jakarta.persistence.*;

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

    // constructors

    public Pharmacy(String pharmacyName, String pharmacyAddress) {
        this.pharmacyName = pharmacyName;
        this.pharmacyAddress = pharmacyAddress;
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

    // to string

    @Override
    public String toString() {
        return "Pharmacy{" +
                "pharmacyId=" + pharmacyId +
                ", pharmacyName='" + pharmacyName + '\'' +
                ", pharmacyAddress='" + pharmacyAddress + '\'' +
                '}';
    }
}
