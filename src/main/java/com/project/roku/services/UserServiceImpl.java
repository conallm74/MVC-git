package com.project.roku.services;

import com.project.roku.dao.RoleDao;
import com.project.roku.dao.UsersDao;
import com.project.roku.entities.Role;
import com.project.roku.entities.Users;
import com.project.roku.user.TheNewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class UserServiceImpl implements UserService{

    private UsersDao usersDao;

    private RoleDao roleDao;

    private BCryptPasswordEncoder passwordEncoder;

    // conts
    @Autowired
    public UserServiceImpl(UsersDao usersDao, RoleDao roleDao, BCryptPasswordEncoder passwordEncoder) {
        this.usersDao = usersDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Users findByUserName(String userName){
        // check the database if the user already exists
        return usersDao.findByUserName(userName);
    }

    @Override
    public void save(TheNewUser userName) {
        Users user = new Users();

        // assign user details to the new user object
        user.setUserName(userName.getUserName());
        user.setPassword(passwordEncoder.encode(userName.getPassword()));
        user.setFirstName(userName.getFirstName());
        user.setLastName(userName.getLastName());
        user.setEmail(user.getEmail());

        // give user default role of employee
        user.setRoles(Arrays.asList(roleDao.findByRoleName("ROLE_EMPLOYEE")));

        // save into the database
        usersDao.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersDao.findByUserName(username);

        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        Collection<SimpleGrantedAuthority> authorities = mapRolesToAuthorities(user.getRoles());
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                authorities);
        }

    private Collection<SimpleGrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role tempRole : roles) {
            SimpleGrantedAuthority tempAuthority = new SimpleGrantedAuthority(tempRole.getName());
            authorities.add(tempAuthority);
        }

        return authorities;
    }
}

