package com.project.roku.dao;

import com.project.roku.medical_entities.Prescription;
import com.project.roku.medical_entities.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepo extends JpaRepository<Recipient, Integer> {
}
