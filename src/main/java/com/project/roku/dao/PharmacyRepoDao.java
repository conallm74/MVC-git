package com.project.roku.dao;

import com.project.roku.medical_entities.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacyRepoDao extends JpaRepository<Pharmacy, Integer> {

    @Query(value = "SELECT pharmacy_name, pharmacy_recipient_id FROM pharmacies", nativeQuery = true)
    List<Object[]> findAllPharmacyNames();

    /*
    @Modifying
    @Query(value = "SELECT * FROM pharmacies", nativeQuery = true)
    public List<Pharmacy> findAllPharmacyNames();

     */
}


