package com.amolfasale.dao;

import java.util.Iterator;
import java.util.regex.Pattern;


import com.amolfasale.entity.Person;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.emul.org.bson.types.ObjectId;
import com.mongodb.Mongo;

public class PersonDAO extends BasicDAO<Person, ObjectId> {

	public PersonDAO(Mongo mongo, Morphia morphia, String dbName) {
		super(mongo, morphia, dbName);		
	}

	public Iterator<Person> findByFname(String fname){
		Pattern regExp = Pattern.compile(fname + ".*", Pattern.CASE_INSENSITIVE);      
		return ds.find(entityClazz).filter("fname", regExp).iterator(); 
	}  
}