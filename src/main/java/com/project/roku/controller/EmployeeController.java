package com.project.roku.controller;

import com.project.roku.entity.User;
import com.project.roku.services.EmployeeRepoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeRepoService employeeservice;

    // make consructors for injectin

    // public EmployeeController(){}

    public EmployeeController(EmployeeRepoService theEmployeeservice) {
        this.employeeservice = theEmployeeservice;
    }

    // get the employees from the database
    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List<User> users = employeeservice.findAll();

        theModel.addAttribute("employees", users);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        // create the model attribute to bind the form data
        User theUser = new User();

        theModel.addAttribute("employee", theUser);
        // Thymeleaf template will acceess this data (employee) for binding the form data
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") User theUser){
        // save the employee
        employeeservice.save(theUser);
        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }
}










