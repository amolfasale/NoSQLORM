package com.amolfasale.util;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.amolfasale.dao.CustomerDAO;
import com.amolfasale.entity.Account;
import com.amolfasale.entity.Address;
import com.amolfasale.entity.Customer;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.QueryResults;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * A MongoDB and Morphia Example
 *
 */
public class Example {

	public static void main( String[] args ) throws UnknownHostException, MongoException {

		String dbName = new String("MyDB");
		Mongo mongo = new Mongo();
		Morphia morphia = new Morphia();
		Datastore datastore = morphia.createDatastore(mongo, dbName);      

		morphia.mapPackage("com.amolfasale.entity");

		Address address = new Address();
		address.setNumber("101");
		address.setStreet("Kalyni nagar");
		address.setTown("Pune");
		address.setPostcode("411014"); 

		Account account = new Account();
		account.setName("Personal Account");

		List<Account> accounts = new ArrayList<Account>();
		accounts.add(account); 

		Customer customer = new Customer();
		customer.setAddress(address);
		customer.setName("Mr Fello Customer");
		customer.setAccounts(accounts);

		Key<Customer> savedCustomer = datastore.save(customer);   
		System.out.println(savedCustomer.getId());


		CustomerDAO customerDAO = new CustomerDAO(morphia, mongo, dbName);
		customerDAO.save(customer);

		Query<Customer> query = datastore.createQuery(Customer.class);
		query.and(       
				query.criteria("accounts.name").equal("Personal Account"),     
				query.criteria("address.number").equal("81"),       
				query.criteria("name").contains("Bank")
				);      

		QueryResults<Customer> retrievedCustomers =  customerDAO.find(query);  

		for (Customer retrievedCustomer : retrievedCustomers) {
			System.out.println(retrievedCustomer.getName());   
			System.out.println(retrievedCustomer.getAddress().getPostcode());   
			System.out.println(retrievedCustomer.getAccounts().get(0).getName());
			customerDAO.delete(retrievedCustomer);
		} 
	}
}