package com.amolfasale.dao;

import com.amolfasale.entity.Customer;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;
 
public class CustomerDAO extends BasicDAO<Customer, String> {   
 
    public CustomerDAO(Morphia morphia, Mongo mongo, String dbName) {       
        super(mongo, morphia, dbName);   
    }
 
}