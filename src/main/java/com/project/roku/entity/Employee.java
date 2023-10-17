package com.project.roku.entity;

import com.project.roku.services.EmployeeService;
import jakarta.persistence.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class Employee {
    // define fields
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="username")
    private String userName;


    // define constructors
    public Employee(){
    }

    public Employee(String userName) {
        this.userName = userName;
    }
    public Employee(int id){
        this.id = id;
    }
    // getters setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // to string method

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
