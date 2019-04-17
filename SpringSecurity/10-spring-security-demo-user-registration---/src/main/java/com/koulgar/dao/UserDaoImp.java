package com.koulgar.dao;

import com.koulgar.entitiy.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findByUserName(String userName) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // now retrieve/read from database using username
        Query<User> theQuery = currentSession.createQuery("from User where username=:uName", User.class);
        theQuery.setParameter("uName", userName);
        User theUser = null;
        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }
        return theUser;
    }

    @Override
    public void save(User theUser) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // create the user
        currentSession.saveOrUpdate(theUser);
    }
}

