package com.project.roku.services;

import com.project.roku.dao.RecipientRepo;
import com.project.roku.medical_entities.Recipient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RecipientServiceImpl implements RecipientRepoService{

    private RecipientRepo recipientRepo;

    @Autowired
    public RecipientServiceImpl(RecipientRepo theRecipientRepo){
        recipientRepo = theRecipientRepo;
    }

    @Override
    public List<Recipient> findAll() {
        return recipientRepo.findAll();
    }

    @Override
    public Recipient findById(int theId) {
        Optional<Recipient> result = recipientRepo.findById(theId);
        Recipient theUser = null;
        if (result.isPresent()){
            theUser = result.get();
        }
        else {
            throw new RuntimeException("Couldn't find that recipient");
        }
        return theUser;
    }

    @Override
    public Recipient save(Recipient theUser) {
        return recipientRepo.save(theUser);
    }

    @Override
    public void deleteById(int theId) {
        recipientRepo.deleteById(theId);
    }
}
