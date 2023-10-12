package com.project.roku.entities;

import jakarta.persistence.*;

@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    public Role(){
    }

    /*
    Getters and setters
     */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /*
    to string
     */

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
