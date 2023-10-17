package com.project.roku.dao;

import com.project.roku.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<User, Integer> {

    // methods finaAll, findById, save, and deleteById are included automatically by JpaRepo

}
