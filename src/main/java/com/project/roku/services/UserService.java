package com.project.roku.services;

import com.project.roku.entities.Users;
import com.project.roku.user.TheNewUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public Users findByUserName(String userName);

    void Save(TheNewUser userName);
}
