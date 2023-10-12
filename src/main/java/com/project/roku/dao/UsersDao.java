package com.project.roku.dao;

import com.project.roku.entities.Users;

public interface UsersDao {
    Users findByUserName(String userName);

    void save(Users theUser);
}
