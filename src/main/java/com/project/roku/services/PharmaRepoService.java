package com.project.roku.services;

import com.project.roku.medical_entities.Pharmacy;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PharmaRepoService {

    List<Pharmacy> findAll();

    Pharmacy findById(int theId);

    Pharmacy save(Pharmacy theUser);

    void deleteById(int theId);

    List<String> findAllPharmacies();

    /*
    @Query(value="SELECT pharmacy_name FROM pharmacies)", nativeQuery = true)
    public List<Pharmacy> findAllPharmacies();

     */


    /*
     @Query(value="SELECT * FROM employees WHERE employee_id IN (SELECT DISTINCT(manager_id) FROM employees)", nativeQuery=true)
    public List<Employee> findAllManagers();
     */
}
