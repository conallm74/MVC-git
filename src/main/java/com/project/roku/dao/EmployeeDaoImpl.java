package com.project.roku.dao;

import com.project.roku.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    // define field for entity manager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDaoImpl(EntityManager theEntityManager){
        this. entityManager = theEntityManager;
    }

    @Override
    public List<Employee> finalAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee", Employee.class);

        // execute query and get results list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }
}
