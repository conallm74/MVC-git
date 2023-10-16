package com.project.roku.rest;
// this is to use the EmployeeDAO

// import com.project.roku.dao.EmployeeDao;
import com.project.roku.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    // define field for employee DAO
    private EmployeeDao employeeDao;

    // inject employee DAO
    public EmployeeRestController(EmployeeDao theEmployeeDao){
        this.employeeDao = theEmployeeDao;
    }
    // expose "/employees" and return a list of them
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDao.finalAll();
    }
}

 */
