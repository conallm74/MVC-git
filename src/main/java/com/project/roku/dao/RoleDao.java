package com.project.roku.dao;

import com.project.roku.entities.Role;

public interface RoleDao {
    public Role findByRoleName(String theRoleName);
}
