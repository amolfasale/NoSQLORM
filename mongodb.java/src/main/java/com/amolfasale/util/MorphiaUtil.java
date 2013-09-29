package com.amolfasale.util;

import java.net.UnknownHostException;
//import java.util.Arrays;

import com.mongodb.DB;
import com.mongodb.MongoClient;
//import com.mongodb.ServerAddress;

public class MorphiaUtil {
	/*public Datastore getDatastore(String dbName){
		return new Morphia().map(User.class).map(Document.class).createDatastore(mongoClient, dbName, "adminMyDB", "password".toCharArray()); 
	} */
	public DB getDatabase(String dbName) {
		DB database = null;
		try{
			// client without additional server parameters
			MongoClient mongoClient0 = new MongoClient(); 
			// client with the server host 
			//MongoClient mongoClient1 = new MongoClient( "localhost" ); 
			// client with server host and port 
			//MongoClient mongoClient2 = new MongoClient( "localhost" , 27017 ); 
			// client that makes it possible to connect a replica set 
			/*MongoClient mongoClient3 = new MongoClient( 
					Arrays.asList(new ServerAddress("localhost", 27017), 
							new ServerAddress("localhost", 27018), 
							new ServerAddress("localhost", 27019)));*/ 
			// select a database 
			database = mongoClient0.getDB( "myDatabase" );
			
		}catch(UnknownHostException me){
			me.printStackTrace();
		}
		return database;
	}
}
