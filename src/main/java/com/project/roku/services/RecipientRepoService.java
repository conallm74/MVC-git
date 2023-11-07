package com.project.roku.services;

import com.project.roku.entity.Employee;
import com.project.roku.medical_entities.Recipient;

import java.util.List;

public interface RecipientRepoService {
    List<Recipient> findAll();

    Recipient findById(int theId);

    Recipient save(Recipient theUser);

    void deleteById(int theId);
}
