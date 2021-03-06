package com.amolfasale.entity;

import java.util.List;
import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
 
@Entity
public class Customer extends BaseEntity {
 
    private String name;
    private List<Account> accounts;
    @Embedded
    private Address address;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public List<Account> getAccounts() {
        return accounts;
    }
 
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
 
    public Address getAddress() {
        return address;
    }
 
    public void setAddress(Address address) {
        this.address = address;
    }
}