package com.project.roku.services;

import com.project.roku.entity.User;

import java.util.List;

public interface EmployeeRepoService {
    List<User> findAll();

    User findById(int theId);

    User save(User theUser);

    void deleteById(int theId);
}
