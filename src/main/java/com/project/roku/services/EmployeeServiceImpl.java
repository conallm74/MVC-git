package com.project.roku.services;

import com.project.roku.dao.EmployeeRepository;
import com.project.roku.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired // because we're making use of injection
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee findById(int theId){
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;
        if (result.isPresent()){
            theEmployee = result.get();
        }
        else {
            // we couldn't find employee by Id
            throw new RuntimeException("Couldn't find employee by-" + theId + "Id");
        }
        return theEmployee;
    }

    // no need for @Transactional as JpaRepo provides it out of the box 
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }


}
