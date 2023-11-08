package com.project.roku.dao;

import com.project.roku.entity.Employee;
import com.project.roku.medical_entities.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacyRepo extends JpaRepository<Pharmacy, Integer> {
    @Query(value = "SELECT pharmacy_name FROM pharmacies", nativeQuery = true)
    public List<String> findAllPharmacies();
}


