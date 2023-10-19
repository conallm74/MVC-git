package com.project.roku.services;

import com.project.roku.entity.Employee;
import com.project.roku.entity.User;

import java.util.List;

public interface EmployeeRepoService {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theUser);

    void deleteById(int theId);
}
