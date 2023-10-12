package com.project.roku.dao;

import com.project.roku.entities.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDaoImpl implements UsersDao{
    private EntityManager entityManager;

    public UsersDaoImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public Users findByUserName(String theUserName){
        // retrieve/read from the database using their username
        TypedQuery<Users> theQuery = entityManager.createQuery("from User where userName=:uName", Users.class);
        theQuery.setParameter("uName", theUserName);

        Users theUser = null;
        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e){
            theUser = null;
        }
        return theUser;
    }

    @Override
    @Transactional
    public void save(Users theUser){
        entityManager.merge(theUser);
    }

}
