package com.project.roku.dao;

import com.project.roku.entity.Employee;
import com.project.roku.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
