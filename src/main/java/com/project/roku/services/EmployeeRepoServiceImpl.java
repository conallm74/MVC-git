package com.project.roku.services;

import com.project.roku.dao.EmployeeRepository;
import com.project.roku.entity.Employee;
import com.project.roku.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeRepoServiceImpl implements EmployeeRepoService {

    private EmployeeRepository employeeRepository;

    @Autowired // because we're making use of injection
    public EmployeeRepoServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee findById(int theId){
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theUser = null;
        if (result.isPresent()){
            theUser = result.get();
        }
        else {
            // we couldn't find employee by Id
            throw new RuntimeException("Couldn't find employee by-" + theId + "Id");
        }
        return theUser;
    }

    // no need for @Transactional as JpaRepo provides it out of the box 
    @Override
    public Employee save(Employee theUser) {

        // need to add a safety feature in which if no data is entered there is an error.
        return employeeRepository.save(theUser);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
