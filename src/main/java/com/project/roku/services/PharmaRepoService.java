package com.project.roku.services;

import com.project.roku.medical_entities.Pharmacy;

import java.util.List;

public interface PharmaRepoService {

    List<Pharmacy> findAll();

    Pharmacy findById(int theId);

    Pharmacy save(Pharmacy theUser);

    void deleteById(int theId);

    List<Pharmacy> findAllPharmacies();

}
