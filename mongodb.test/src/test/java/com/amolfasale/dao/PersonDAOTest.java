package com.amolfasale.dao;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.academy.util.MongoUtil;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amolfasale.dao.PersonDAO;
import com.amolfasale.entity.Person;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

public class PersonDAOTest {
	private final static Logger logger = LoggerFactory
			.getLogger(PersonDAOTest.class);

	private Mongo mongo;
	private Morphia morphia;
	private PersonDAO personDao;
	private final String dbname = "peopledb";

	@Before
	public void initiate() {
		mongo = MongoUtil.getMongo();
		morphia = new Morphia();
		morphia.map(Person.class);
		personDao = new PersonDAO(mongo, morphia, dbname);
	}

	@Test
	public void test() {
		long counter = personDao.count();
		logger.debug("The count is [" + counter + "]");

		Person p = new Person();
		p.setFname("Amol");
		personDao.save(p);

		long newCounter = personDao.count();
		logger.debug("The new count is [" + newCounter + "]");

		assertTrue((counter + 1) == newCounter);
		
		Iterator<Person> iteratorPerson = personDao.findByFname("Am");            
		int personCounter = 0 ;                                                    
		while(iteratorPerson.hasNext()){                                           
			personCounter ++;                                                      
			logger.debug("["+personCounter+"]" + iteratorPerson.next().getFname());
		}        
	}
}
