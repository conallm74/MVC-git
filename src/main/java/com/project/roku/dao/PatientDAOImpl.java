package com.project.roku.dao;

import com.project.roku.entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

public class PatientDAOImpl implements PatientDAO{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Patient findPatientName(String firstName, String lastName) {
        try{
            String query = "SELECT * FROM patients WHERE FirstName = ? AND LastName = ?\n";
            return entityManager.createQuery(query, Patient.class)
                    .setParameter("FirstName", firstName)
                    .setParameter("LastName", lastName)
                    .getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }
}
