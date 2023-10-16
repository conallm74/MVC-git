package com.project.roku.controller;

import com.project.roku.entity.Employee;
import com.project.roku.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeservice;

    // make consructors for injectin

    // public EmployeeController(){}

    public EmployeeController(EmployeeService theEmployeeservice) {
        this.employeeservice = theEmployeeservice;
    }

    // get the employees from the database

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List<Employee> employees = employeeservice.findAll();

        theModel.addAttribute("employees-", employees);

        return "list-employees";
    }
}
