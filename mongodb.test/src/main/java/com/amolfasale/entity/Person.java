package com.amolfasale.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.emul.org.bson.types.ObjectId;

@Entity
public class Person {
	@Id private ObjectId id;
	private String fname;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
}
