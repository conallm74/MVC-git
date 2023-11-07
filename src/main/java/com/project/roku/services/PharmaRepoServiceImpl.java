package com.project.roku.services;

import com.project.roku.dao.PharmacyRepo;
import com.project.roku.medical_entities.Pharmacy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PharmaRepoServiceImpl implements PharmaRepoService{

    private PharmacyRepo pharmacyRepo;

    @Autowired
    public PharmaRepoServiceImpl(PharmacyRepo thePharmacyRepo){
        pharmacyRepo = thePharmacyRepo;
    }

    @Override
    public List<Pharmacy> findAll() {
        return pharmacyRepo.findAll();
    }

    @Override
    public Pharmacy findById(int theId) {
        Optional<Pharmacy> result = pharmacyRepo.findById(theId);

        Pharmacy theUser = null;
        if (result.isPresent()){
            theUser = result.get();
        }
        else {
            throw new RuntimeException("Couldn't find that Pharmacy by:" + theId + "Id");
        }
        return theUser;
    }

    @Override
    public Pharmacy save(Pharmacy theUser) {
        return pharmacyRepo.save(theUser);
    }

    @Override
    public void deleteById(int theId) {
        pharmacyRepo.deleteById(theId);
    }

    /*
    @Override
    public List<Pharmacy> findAllPharmacies() {
        return pharmacyRepo.findAllPharmacies();
    }

     */
}