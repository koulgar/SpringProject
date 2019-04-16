package com.springdemo.dao;

import com.springdemo.entity.Customer;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImp implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //create a query
        Query<Customer> query = currentSession.createQuery("from Customer order by lastName",Customer.class);
        //execute query and get result list
        List<Customer> customers = query.getResultList();
        //return results
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class,id);
        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId",id);
        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomer(String searchName) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = null;
        // only search by name if theSearchName is not empty
        if (searchName != null && searchName.trim().length() > 0) {
            // search for firstName or lastName ... case insensitive
            query=currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName order by lastName", Customer.class);
            query.setParameter("theName", "%" + searchName.toLowerCase() + "%");
        } else {
            // searchName is empty ... so just get all customers
            query =currentSession.createQuery("from Customer order by lastName", Customer.class);
        }
        // execute query and get result list
        List<Customer> customers = query.getResultList();

        // return the results
        return customers;
    }

    @Override
    public List<Customer> findAndReplace(String findName, String replaceName) {
        Session session = sessionFactory.getCurrentSession();
        Query query=null;
        if(findName!=null && findName.trim().length()>0){
            session.createQuery("update Customer set email = REPLACE(email,:oldName,:newName)")
                    .setParameter("oldName",findName).setParameter("newName",replaceName).executeUpdate();
        }
        query = session.createQuery("from Customer", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }
}
